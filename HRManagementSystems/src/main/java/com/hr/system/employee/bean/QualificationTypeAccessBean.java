package com.hr.system.employee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "QUALIFICATIONTYPE")
public class QualificationTypeAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUALITYPE_ID", nullable = false, unique = true)
	private Long qualiTypeId;

	@Column(name = "QUALITITLE")
	private String qualiTitle;

	@Column(name = "QUALIDESC")
	private String qualiDesc;

	public Long getQualiTypeId() {
		return qualiTypeId;
	}

	public void setQualiTypeId(Long qualiTypeId) {
		this.qualiTypeId = qualiTypeId;
	}

	public String getQualiTitle() {
		return qualiTitle;
	}

	public void setQualiTitle(String qualiTitle) {
		this.qualiTitle = qualiTitle;
	}

	public String getQualiDesc() {
		return qualiDesc;
	}

	public void setQualiDesc(String qualiDesc) {
		this.qualiDesc = qualiDesc;
	}

}
