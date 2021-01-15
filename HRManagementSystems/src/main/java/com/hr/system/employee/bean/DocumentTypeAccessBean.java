package com.hr.system.employee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "documentType")
public class DocumentTypeAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DocumentTypeId", nullable = false, unique = true)
	private Long documentTypeId;

	@OneToOne(mappedBy = "documentTypeAccessBean")
	private DocumentAccessBean documentAccessBean;

	@Column(name = "DocumentName")
	private String documentName;

	@Column(name = "DocumentDes")
	private String documentDes;

	public Long getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(Long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public DocumentAccessBean getDocumentAccessBean() {
		return documentAccessBean;
	}

	public void setDocumentAccessBean(DocumentAccessBean documentAccessBean) {
		this.documentAccessBean = documentAccessBean;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentDes() {
		return documentDes;
	}

	public void setDocumentDes(String documentDes) {
		this.documentDes = documentDes;
	}

}
