package com.hr.system.employee.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "education")
public class EducationAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EducationalId", nullable = false, unique = true)
	private Long educationalId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId", nullable = false)
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "QUALITYPE_ID")
	private Long qualiTypeId;

	@Column(name = "CourseName")
	private String courseName;

	@Column(name = "CourseType")
	private String courseType;

	@Column(name = "Stream")
	private String stream;

	@Column(name = "CourseStartDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date courseStartDate;

	@Column(name = "CourseEndDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date courseEndDate;

	@Column(name = "CollegeName")
	private String collegeName;

	@Column(name = "UniversityName")
	private String universityName;

	public Long getEducationalId() {
		return educationalId;
	}

	public void setEducationalId(Long educationalId) {
		this.educationalId = educationalId;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Date getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Long getQualiTypeId() {
		return qualiTypeId;
	}

	public void setQualiTypeId(Long qualiTypeId) {
		this.qualiTypeId = qualiTypeId;
	}

}
