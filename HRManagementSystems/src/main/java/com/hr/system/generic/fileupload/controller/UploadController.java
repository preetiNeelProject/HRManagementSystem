package com.hr.system.generic.fileupload.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hr.system.employee.bean.DocumentAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.DocumentRepository;
import com.hr.system.employee.repository.EmployeeRepository;

@Controller
public class UploadController {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "F://temp//";

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

	@RequestMapping(value = "company/savefile", method = RequestMethod.POST, produces = "multipart/form-data")
	public @ResponseBody boolean uploadFile(@RequestParam MultipartFile file, HttpSession session) throws IOException {

		String filename = file.getOriginalFilename();
		DocumentAccessBean docAB = new DocumentAccessBean();
		// docAB.setFileValue(file.getBytes());
		docAB.setFileName(filename);
		EmployeeAccessBean accessBean = employeeRepository.findByEmployeeId(20l);
		docAB.setEmployeeAccessBean(accessBean);
		documentRepository.save(docAB);

		return true;
	}

	/*
	 * @RequestMapping(value = "company/uploadFile", method = RequestMethod.POST,
	 * produces = "multipart/form-data") public @ResponseBody boolean
	 * uploadFile(@ModelAttribute Document accessBean) throws IOException {
	 * 
	 * EmployeeAccessBean employeeAccessBean =
	 * employeeRepository.findByEmployeeId(20L); DocumentAccessBean docAB = new
	 * DocumentAccessBean(); MultipartFile[] multipartFile =
	 * accessBean.getMultipartFile();
	 * docAB.setEmployeeAccessBean(employeeAccessBean);
	 * docAB.setFileValue(multipartFile[0].getBytes());
	 * docAB.setFileName(multipartFile[0].getName());
	 * docAB.setFileSize(String.valueOf(multipartFile[0].getSize()));
	 * docAB.setDescription(accessBean.getDescription());
	 * docAB.setTitle(accessBean.getTitle()); docAB.setType(accessBean.getType());
	 * 
	 * documentRepository.save(docAB);
	 * 
	 * return true; }
	 */

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView upload(@RequestParam MultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("upload-success", "filename", path + "/" + filename);
	}

}