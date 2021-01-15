package com.hr.system.employee.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hr.system.payroll.bean.PayrollAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "address")
public class AddressAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressId", nullable = false, unique = true)
	private Long addressId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EmployeeId")
	private EmployeeAccessBean employeeAccessBean;

	@Column(name = "AddressType")
	private String addressType;

	@Column(name = "PersonTitle")
	private String personTitle;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "BusinessTitle")
	private String businessTitle;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Age")
	private String age;

	@Column(name = "Caste")
	private String caste;

	@Column(name = "Nationality")
	private String nationality;

	@Column(name = "MartialStatus")
	private String martialStatus;

	@Column(name = "Phone1")
	private String phone1;

	@Column(name = "Phone2")
	private String phone2;

	@Column(name = "Email1")
	private String email1;

	@Column(name = "Email2")
	private String email2;

	@Column(name = "Dob")
	private String dob;

	@Column(name = "Religion")
	private String religion;

	@Column(name = "BloodGroup")
	private String bloodGroup;

	@Column(name = "Address")
	private String address;

	@Column(name = "City")
	private String city;

	@Column(name = "StateId")
	private Long stateId;

	@Column(name = "CountryId")
	private Long countryId;

	@Column(name = "Pincode")
	private String pincode;

	@Column(name = "caddress")
	private String caddress;

	@Column(name = "ccity")
	private String ccity;

	@Column(name = "cstateId")
	private Long cstateId;

	@Column(name = "ccountryId")
	private Long ccountryId;

	@Column(name = "cpincode")
	private String cpincode;

	@Column(name = "LastCreate")
	private String lastCreate;

	@Column(name = "experience")
	private String experience;

	@Column(name = "ProbationPeriod")
	private String probationPeriod;

	@Column(name = "ctc")
	private String ctc;

	@Column(name = "EmployeeTypeId")
	private Long employeeTypeId;

	@Column(name = "WorkLocationId")
	private Long workLocationId;

	@Column(name = "JobTitleId")
	private Long jobTitleId;

	@ManyToOne
	@JoinColumn(name = "payrollId")
	private PayrollAccessBean payrollAccessBean;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(String personTitle) {
		this.personTitle = personTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessTitle() {
		return businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCcity() {
		return ccity;
	}

	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	public Long getCstateId() {
		return cstateId;
	}

	public void setCstateId(Long cstateId) {
		this.cstateId = cstateId;
	}

	public Long getCcountryId() {
		return ccountryId;
	}

	public void setCcountryId(Long ccountryId) {
		this.ccountryId = ccountryId;
	}

	public String getCpincode() {
		return cpincode;
	}

	public void setCpincode(String cpincode) {
		this.cpincode = cpincode;
	}

	public EmployeeAccessBean getEmployeeAccessBean() {
		return employeeAccessBean;
	}

	public String getLastCreate() {
		return lastCreate;
	}

	public void setLastCreate(String lastCreate) {
		this.lastCreate = lastCreate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getProbationPeriod() {
		return probationPeriod;
	}

	public void setProbationPeriod(String probationPeriod) {
		this.probationPeriod = probationPeriod;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	/*
	 * public EmployeeAccessBean getEmployeeAccessBean() { return
	 * employeeAccessBean; }
	 */

	public void setEmployeeAccessBean(EmployeeAccessBean employeeAccessBean) {
		this.employeeAccessBean = employeeAccessBean;
	}

	public Long getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Long employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public Long getWorkLocationId() {
		return workLocationId;
	}

	public void setWorkLocationId(Long workLocationId) {
		this.workLocationId = workLocationId;
	}

	public Long getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(Long jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public PayrollAccessBean getPayrollAccessBean() {
		return payrollAccessBean;
	}

	public void setPayrollAccessBean(PayrollAccessBean payrollAccessBean) {
		this.payrollAccessBean = payrollAccessBean;
	}

}
