package com.hr.system.employee.bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "document")
public class DocumentAccessBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DocumentId", nullable = false, unique = true)
	private Long documentId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "documentTypeId", referencedColumnName = "documentTypeId")
	private DocumentTypeAccessBean documentTypeAccessBean;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "Title")
	private String title;

	@Column(name = "Type")
	private String type;

	@Column(name = "Description")
	private String description;

	@Column(name = "FileName")
	private String fileName;

	@Column(name = "FileSize")
	private String fileSize;


	@Column(name = "fileValue")
	@Lob
	private Blob fileValue;

	@Column(name = "FileLocation")
	private String fileLocation;

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public DocumentTypeAccessBean getDocumentTypeAccessBean() {
		return documentTypeAccessBean;
	}

	public void setDocumentTypeAccessBean(DocumentTypeAccessBean documentTypeAccessBean) {
		this.documentTypeAccessBean = documentTypeAccessBean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getFileValue() {
		return fileValue;
	}

	public void setFileValue(Blob fileValue) {
		this.fileValue = fileValue;
	}

}
