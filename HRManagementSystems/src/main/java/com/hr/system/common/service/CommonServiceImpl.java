package com.hr.system.common.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hr.system.attendance.bean.AttendanceAccessBean;
import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.attendance.repository.AttendanceRepository;
import com.hr.system.attendance.repository.TimesheetRepository;
import com.hr.system.common.files.FileUtils;
import com.hr.system.common.files.Keys;
import com.hr.system.common.files.Utils;
import com.hr.system.company.bean.JobTitleAccessBean;
import com.hr.system.company.bean.NotificationAccessBean;
import com.hr.system.company.repository.JobTitleRepository;
import com.hr.system.company.repository.NotificationRepository;
import com.hr.system.employee.bean.AccountDetailsAccessBean;
import com.hr.system.employee.bean.AddressAccessBean;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.AccountDetailsRepository;
import com.hr.system.employee.repository.AddressRepository;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.employee.repository.WorkLocationRepository;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.controller.CTCCalulatorControllerCmd;
import com.hr.system.payroll.repository.EmployeeCTCRepository;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	EmployeeCTCRepository employeeCTCRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	TimesheetRepository timesheetRepository;

	@Autowired
	JobTitleRepository jobTitleRepository;

	@Autowired
	WorkLocationRepository workLocationRepository;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	AttendanceRepository attendanceRepository;

	@Autowired
	CTCCalulatorControllerCmd cmd;

	@Autowired
	CommonServiceImpl commonServiceImpl;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Utils utils;

	@Autowired
	private Keys keys;

	@Transactional
	public void savePreviousSalary(Optional<EmployeeCTCAccessBean> empSalary) {

		String historyQuery = "Insert into ctchistory(EmployeeId,Name,JoiningDate,IncrementDate,AnnualBasicSalary,AnnualFlexibleBenifits,AnnualRefSalary"
				+ ",PF,HRA,CONVEY,ESI,Gratuity,CTC,newCtc,Comments) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		entityManager.createNativeQuery(historyQuery).setParameter(1, empSalary.get().getEmployeeId())
				.setParameter(2, empSalary.get().getName()).setParameter(3, empSalary.get().getJoiningDate())
				.setParameter(4, empSalary.get().getIncrementDate())
				.setParameter(5, empSalary.get().getAnnualBasicSalary())
				.setParameter(6, empSalary.get().getAnnualFlexibleBenifits())
				.setParameter(7, empSalary.get().getAnnualRefSalary()).setParameter(8, empSalary.get().getPf())
				.setParameter(9, empSalary.get().getHra()).setParameter(10, empSalary.get().getConvey())
				.setParameter(11, empSalary.get().getEsi()).setParameter(12, empSalary.get().getGratuity())
				.setParameter(13, empSalary.get().getcTC()).setParameter(14, empSalary.get().getNewCtc())
				.setParameter(15, empSalary.get().getComments()).executeUpdate();
	}

	public String uploadFiles(MultipartFile csv, String type, Long timesheetId) throws IOException {
		String flage = "Success";

		String[] csvHeader = utils.getHeader(type);
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(csv.getBytes())));
		String line = "";
		int countLine = 0;
		boolean invalidLine = false;
		StringBuffer errors = new StringBuffer("Errors: \n");
		List<Integer> lines = new ArrayList<Integer>();
		outer: while ((line = csvReader.readLine()) != null) {
			if (csvHeader == null) {
				break;
			}
			String[] data = line.split(",");
			invalidLine = false;
			if (data.length != csvHeader.length) {
				if (countLine == 0) {
					flage = "Failed";
					errors.append("\tInvalid Csv Header!\n");
					break outer;
				} else {
					flage = "";
					errors.append("\tInvalid Line No.:" + countLine + ".\n");
					lines.add(countLine);
					invalidLine = true;
				}
			} else {
				if (countLine == 0) {
					for (int i = 0; i < csvHeader.length; i++) {
						if (!csvHeader[i].trim().equalsIgnoreCase(data[i].trim())) {
							System.out.println("----------null haeder3-------------");
							flage = "Failed";
							errors.append("\tInvalid Header " + data[i].trim() + ". It should be as "
									+ csvHeader[i].trim() + ".\n");
							invalidLine = true;
						}
					}
					if (invalidLine)
						break outer;
				} else {
					if (!invalidLine) {
						for (int i = 0; i < data.length; i++) {
							if (data[i].trim().length() == 0) {
								flage = "";
								errors.append("\tLine No.:" + countLine + " contain empty entries.\n");
								invalidLine = true;
								lines.add(countLine);
								break;
							} else if (data[i].trim().indexOf(",") != -1)
								data[i] = data[i].trim().replace("@", ",");
						}

						if (!invalidLine) {
							boolean duplicateFlage = false;
							if (type.equals("timesheet")) {
								uploadTimesheet(data, timesheetId);
							} else if (type.equals("employeeList"))
								/* uploadEmployeeList(data); */
								if (duplicateFlage)
									errors.append("\tDuplicate entry for line no.:" + countLine + ".\n");
							if (invalidLine) {
								flage = "";
								errors.append("\tPdf File not found for line no.:" + countLine + ".\n");
								lines.add(countLine);
							}
						}
					}
				}
			}
			countLine++;
		}
		return flage;
	}

	private void uploadTimesheet(String[] data, Long timeSheetId) {

		TimesheetAccessBean ts = new TimesheetAccessBean();

		System.out.println("======================");
		/* if (timeSheetId != null) */
		// ts.setTimeSheetId(Long.valueOf(data[0]));
		ts.setEmployeeId(Long.valueOf(data[1]));
		ts.setProjectId(Long.valueOf(data[2]));
		ts.setManagerId(Long.valueOf(data[3]));

		System.out.println(data[4]);

		// System.out.println(Date.valueOf(data[4]));
		String[] splitdate = data[4].split("-");
		String date = splitdate[2] + "-" + splitdate[1] + "-" + splitdate[0];

		ts.setDate(date);

		ts.setDay(data[5]);
		ts.setCheckIn(data[6]);
		ts.setCheckOut(data[7]);
		ts.setRawTime(data[8]);// ???????
		ts.setRoundTime(data[9]);
		ts.setStatus(data[10]);
		ts.setHolidayId(Long.valueOf(data[11]));

		timesheetRepository.save(ts);

	}

	@Override
	public boolean addNotification(NotificationAccessBean notificationAccessBean) {
		notificationRepository.save(notificationAccessBean);
		return true;
	}

	/*
	 * private void uploadEmployeeList(String[] data) {
	 * 
	 * EmployeeAccessBean employee=new EmployeeAccessBean();
	 * employee.setEmployeeId(Long.valueOf(data[1]));
	 * employee.setProjectId(Long.valueOf(data[2]));
	 * employee.setManagerId(Long.valueOf(data[3])); employee.setDate(data[4]);
	 * employee.setDay(data[5]); employee.setCheckIn(data[6]);
	 * employee.setCheckOut(data[7]); employee.setRawTime(data[8]);// ???????
	 * employee.setRoundTime(data[9]); employee.setStatus(data[10]);
	 * employee.setLeaveId(Long.valueOf(data[11]));
	 * employee.setHolidayId(Long.valueOf(data[12]));
	 * 
	 * timesheetRepository.save(ts);
	 * 
	 * }
	 */

	@Transactional
	public void salarySlip(Long employeeCTCID, Long month, HttpServletRequest request, HttpServletResponse response) {

		EmployeeCTCAccessBean employeeCTCAccessBean = employeeCTCRepository.getOne(employeeCTCID);

		FileOutputStream file = null;
		Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.RED);
		Font blackFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
		System.out.println("100");

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					keys.getTimesheetDownloadLocation() + employeeCTCAccessBean.getName() + "_Salary-Slip" + ".pdf"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		document.open();

		try {
			file = new FileOutputStream(
					new File(keys.getTimesheetDownloadLocation() + employeeCTCAccessBean.getName() + ".pdf"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Image image1 = null;
		try {
			System.out.println(request.getServletContext().getRealPath("\\") + "\\staticResources\\images\\logo.png");
			image1 = Image
					.getInstance(request.getServletContext().getRealPath("\\") + "\\staticResources\\images\\logo.png");
		} catch (BadElementException e4) {
			e4.printStackTrace();
		} catch (MalformedURLException e4) {
			e4.printStackTrace();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		image1.setAlignment(Element.ALIGN_CENTER);
		image1.scaleAbsolute(520, 100);
		// Add to document
		try {
			document.add(image1);
		} catch (DocumentException e3) {
			e3.printStackTrace();
		}

		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 3);
		// Lets write a big header
		preface.add(new Paragraph("NEEL DATA PRO IT SOLUTIONS PVT LTD", catFont));
		addEmptyLine(preface, 0);
		preface.add(
				new Paragraph("LOGIX OFFICE TOWER UNIT 804,FLOOR 8  SECTOR 32 NOIDA ,PIN CODE 201301 U.P", subFont));

		addEmptyLine(preface, 0);

		preface.add(new Paragraph("MONTHLY SALARY SLIP", blackFont));

		addEmptyLine(preface, 2);

		// Creating a table
		float[] pointColumnWidths = { 200F, 200F, 200F, 200F };

		PdfPTable table = new PdfPTable(pointColumnWidths);

		EmployeeAccessBean employeeAccessBean = employeeRepository
				.findByEmployeeId(employeeCTCAccessBean.getEmployeeId());
		AddressAccessBean addressAccessBean = addressRepository.findByEmployeeAccessBean(employeeAccessBean);
		JobTitleAccessBean jobTitleAccessBean = jobTitleRepository.findByJobTitleId(addressAccessBean.getJobTitleId());
		AccountDetailsAccessBean accountDetailsAccessBean = accountDetailsRepository
				.findByEmployeeAccessBean(employeeAccessBean);

		if (month != 0) {
			String m = String.format("%02d", month);
			Query query = entityManager.createNativeQuery("SELECT COUNT(date) FROM timesheet WHERE " + m
					+ "= SUBSTRING(Date,6,2) AND employeeId=" + employeeCTCAccessBean.getEmployeeId() + ";");
			int count = ((Number) query.getSingleResult()).intValue();
			EmployeeCTCAccessBean data = cmd.monthlySalaryCalculate(employeeCTCAccessBean.getcTC(), count,
					accountDetailsAccessBean.isPf(), accountDetailsAccessBean.isEsi());
			Long deducations = data.getcTC() - data.getAnnualRefSalary();
			table = commonServiceImpl.createCell("EMP ID", subFont, table);
			table = commonServiceImpl.createCell(employeeAccessBean.getEmployeeCode(), subFont, table);
			table = commonServiceImpl.createCell("EMPLOYEE NAME", subFont, table);
			table = commonServiceImpl.createCell(addressAccessBean.getFirstName(), subFont, table);
			table = commonServiceImpl.createCell("DESIGNATION", subFont, table);
			table = commonServiceImpl.createCell(jobTitleAccessBean.getJobTitle(), subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("PF no.", subFont, table);
			table = commonServiceImpl.createCell("0", subFont, table);
			table = commonServiceImpl.createCell("HDFC Bank A/c no.", subFont, table);
			if (accountDetailsAccessBean.getAccountNumber() != null)
				table = commonServiceImpl.createCell(accountDetailsAccessBean.getAccountNumber().toString(), subFont,
						table);
			else
				table = commonServiceImpl.createCell("-", subFont, table);
			table = commonServiceImpl.createCell("CTC", subFont, table);
			table = commonServiceImpl.createCell(employeeCTCAccessBean.getcTC().toString(), subFont, table);
			table = commonServiceImpl.createCell("Date Of Joining", subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("Working Day in a month", subFont, table);
			table = commonServiceImpl.createCell("30", subFont, table);
			table = commonServiceImpl.createCell("Present day in a month", subFont, table);
			table = commonServiceImpl.createCell(Integer.toString(count), subFont, table);

			table = commonServiceImpl.createCell2("EARNING", smallBold, table);
			table = commonServiceImpl.createCell2("", smallBold, table);
			table = commonServiceImpl.createCell2("DEDUCTION", smallBold, table);
			table = commonServiceImpl.createCell2("", smallBold, table);
			table = commonServiceImpl.createCell1("Basic", smallBold, table);
			table = commonServiceImpl.createCell1(data.getAnnualBasicSalary().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("EPF", smallBold, table);
			table = commonServiceImpl.createCell1(data.getPf().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("HRA", smallBold, table);
			table = commonServiceImpl.createCell1(data.getHra().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("ESIC", smallBold, table);
			table = commonServiceImpl.createCell1(data.getEsi().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Transport allw.", smallBold, table);
			table = commonServiceImpl.createCell1(data.getConvey().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Tax on salary", smallBold, table);
			table = commonServiceImpl.createCell1("0", smallBold, table);
			table = commonServiceImpl.createCell1("Spl. Allow.", smallBold, table);
			table = commonServiceImpl.createCell1("--", smallBold, table);
			table = commonServiceImpl.createCell1("ESI", smallBold, table);
			table = commonServiceImpl.createCell1(data.getEsi().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Other's", smallBold, table);
			table = commonServiceImpl.createCell1(data.getGratuity().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Loan/advance", smallBold, table);
			table = commonServiceImpl.createCell1("0", smallBold, table);
			table = commonServiceImpl.createCell1("Total Gross Salary", smallBold, table);
			table = commonServiceImpl.createCell1(data.getcTC().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Total Deduction", smallBold, table);
			table = commonServiceImpl.createCell1(deducations.toString(), smallBold, table);
			table = commonServiceImpl.createCell1("", smallBold, table);
			table = commonServiceImpl.createCell1("", smallBold, table);
			table = commonServiceImpl.createCell2("Take home  salary", smallBold, table);
			table = commonServiceImpl.createCell2(data.getAnnualRefSalary().toString(), smallBold, table);

			try {
				document.add(preface);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}

			try {
				document.add(table);
			} catch (DocumentException e2) {
				e2.printStackTrace();
			}
		} else {
			Long deducations =employeeCTCAccessBean.getEsi()
					+ employeeCTCAccessBean.getPf();
			table = commonServiceImpl.createCell("EMP ID", subFont, table);
			table = commonServiceImpl.createCell(employeeAccessBean.getEmployeeCode(), subFont, table);
			table = commonServiceImpl.createCell("EMPLOYEE NAME", subFont, table);
			table = commonServiceImpl.createCell(addressAccessBean.getFirstName(), subFont, table);
			table = commonServiceImpl.createCell("DESIGNATION", subFont, table);
			table = commonServiceImpl.createCell(jobTitleAccessBean.getJobTitle(), subFont, table);
			table = commonServiceImpl.createCell("PF no.", subFont, table);
			table = commonServiceImpl.createCell("0", subFont, table);
			table = commonServiceImpl.createCell("HDFC Bank A/c no.", subFont, table);
			if (accountDetailsAccessBean.getAccountNumber() != null)
				table = commonServiceImpl.createCell(accountDetailsAccessBean.getAccountNumber().toString(), subFont,
						table);
			else
				table = commonServiceImpl.createCell("-", subFont, table);
			table = commonServiceImpl.createCell("CTC", subFont, table);
			table = commonServiceImpl.createCell(employeeCTCAccessBean.getcTC().toString(), subFont, table);
			table = commonServiceImpl.createCell("Date Of Joining", subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("", subFont, table);
			table = commonServiceImpl.createCell("Working Day in a month", subFont, table);
			table = commonServiceImpl.createCell("30", subFont, table);
			table = commonServiceImpl.createCell("Present day in a month", subFont, table);
			table = commonServiceImpl.createCell("30", subFont, table);

			table = commonServiceImpl.createCell2("EARNING", smallBold, table);
			table = commonServiceImpl.createCell2("", smallBold, table);
			table = commonServiceImpl.createCell2("DEDUCTION", smallBold, table);
			table = commonServiceImpl.createCell2("", smallBold, table);
			table = commonServiceImpl.createCell1("Basic", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getAnnualBasicSalary().toString(), smallBold,
					table);
			table = commonServiceImpl.createCell1("EPF", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getPf().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("HRA", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getHra().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("ESIC", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getEsi().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Transport allw.", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getConvey().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Tax on salary", smallBold, table);
			table = commonServiceImpl.createCell1("0", smallBold, table);
			table = commonServiceImpl.createCell1("Spl. Allow.", smallBold, table);
			table = commonServiceImpl.createCell1("--", smallBold, table);
			table = commonServiceImpl.createCell1("ESI", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getEsi().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Other's", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getAnnualFlexibleBenifits().toString(),
					smallBold, table);
			table = commonServiceImpl.createCell1("Loan/advance", smallBold, table);
			table = commonServiceImpl.createCell1("0", smallBold, table);
			table = commonServiceImpl.createCell1("Total Gross Salary", smallBold, table);
			table = commonServiceImpl.createCell1(employeeCTCAccessBean.getcTC().toString(), smallBold, table);
			table = commonServiceImpl.createCell1("Total Deduction", smallBold, table);
			table = commonServiceImpl.createCell1(deducations.toString(), smallBold, table);
			table = commonServiceImpl.createCell1("", smallBold, table);
			table = commonServiceImpl.createCell1("", smallBold, table);
			table = commonServiceImpl.createCell2("Take home  salary", smallBold, table);
			table = commonServiceImpl.createCell2(employeeCTCAccessBean.getAnnualRefSalary().toString(), smallBold,
					table);

			try {
				document.add(preface);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}

			try {
				document.add(table);
			} catch (DocumentException e2) {
				e2.printStackTrace();
			}

		}

		Paragraph preface2 = new Paragraph();
		preface2.add(new Paragraph("", blackFont));
		addEmptyLine(preface2, 1);

		Paragraph preface1 = new Paragraph();
		preface1.add(new Paragraph("Salary slip Systems generated signature not required", blackFont));
		addEmptyLine(preface1, 10);
		try {
			document.add(preface1);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		Image image2 = null;
		try {
			System.out.println(request.getServletContext().getRealPath("\\") + "\\staticResources\\images\\base.png");
			image2 = Image
					.getInstance(request.getServletContext().getRealPath("\\") + "\\staticResources\\images\\base.png");
		} catch (BadElementException e4) {
			e4.printStackTrace();
		} catch (MalformedURLException e4) {
			e4.printStackTrace();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		image2.setAlignment(Element.ALIGN_CENTER);
		image2.scaleAbsolute(470, 75);

		// Add to document
		try {
			document.add(image2);
		} catch (DocumentException e3) {
			e3.printStackTrace();
		}

		// Start a new page
		document.newPage();

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		document.close();

	}

	private void monthlySalaryCalculate(Long getcTC, int count) {
		// TODO Auto-generated method stub

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public PdfPTable createCell(String str, Font f, PdfPTable table) {

		PdfPCell cell = new PdfPCell(new Phrase(str, f));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		return table;

	}

	public PdfPTable createCell1(String str, Font f, PdfPTable table) {
		PdfPCell cell = new PdfPCell(new Phrase(str, f));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(cell);
		return table;

	}

	public PdfPTable createCell2(String str, Font f, PdfPTable table) {

		PdfPCell cell = new PdfPCell(new Phrase(str, f));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.addCell(cell);
		return table;

	}

}
