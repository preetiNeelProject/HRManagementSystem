package com.hr.system.payroll.bean;


import javax.persistence.Column;
import javax.validation.constraints.Min;


/*
 *	@Author
 *	Preeti Rani 
*/

public class TaxCalculateAccessBean {

	
	@Column(name = "TaxCalId")
	private Long taxId;

	@Column(name = "AgeGroup")
	private String ageGroup;

	@Column(name = "interestIncome")
	@Min(value = 0)
	private double interestIncome;

	@Column(name = "occupiedPropertyInterest")
	private double occupiedPropertyInterest;
	
	@Column(name = "taxableSalary")
	private double taxableSalary;

	@Column(name = "rentalPropertyIncome")
	private double rentalPropertyIncome;

	@Column(name = "exemptIncome")
	private double exemptIncome;
	
	@Column(name = "otherIncome")
	private double otherIncome;

	@Column(name = "interestLoan")
	private double interestLoan;

	@Column(name = "section80C")
	private double section80C;
	
	@Column(name = "section80D")
	private double section80D;

	@Column(name = "section80E")
	private double section80E;

	@Column(name = "section80CCD")
	private double section80CCD;
	
	@Column(name = "section80TTA")
	private double section80TTA;

	@Column(name = "section80G")
	private double section80G;

	@Column(name = "section80EEA")
	private double section80EEA;

	public Long getTaxId() {
		return taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public double getInterestIncome() {
		return interestIncome;
	}

	public void setInterestIncome(double interestIncome) {
		this.interestIncome = interestIncome;
	}

	public double getOccupiedPropertyInterest() {
		return occupiedPropertyInterest;
	}

	public void setOccupiedPropertyInterest(double occupiedPropertyInterest) {
		this.occupiedPropertyInterest = occupiedPropertyInterest;
	}

	public double getTaxableSalary() {
		return taxableSalary;
	}

	public void setTaxableSalary(double taxableSalary) {
		this.taxableSalary = taxableSalary;
	}

	public double getRentalPropertyIncome() {
		return rentalPropertyIncome;
	}

	public void setRentalPropertyIncome(double rentalPropertyIncome) {
		this.rentalPropertyIncome = rentalPropertyIncome;
	}

	public double getExemptIncome() {
		return exemptIncome;
	}

	public void setExemptIncome(double exemptIncome) {
		this.exemptIncome = exemptIncome;
	}

	public double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public double getInterestLoan() {
		return interestLoan;
	}

	public void setInterestLoan(double interestLoan) {
		this.interestLoan = interestLoan;
	}

	public double getSection80C() {
		return section80C;
	}

	public void setSection80C(double section80c) {
		section80C = section80c;
	}

	public double getSection80D() {
		return section80D;
	}

	public void setSection80D(double section80d) {
		section80D = section80d;
	}

	public double getSection80E() {
		return section80E;
	}

	public void setSection80E(double section80e) {
		section80E = section80e;
	}

	public double getSection80CCD() {
		return section80CCD;
	}

	public void setSection80CCD(double section80ccd) {
		section80CCD = section80ccd;
	}

	public double getSection80TTA() {
		return section80TTA;
	}

	public void setSection80TTA(double section80tta) {
		section80TTA = section80tta;
	}

	public double getSection80G() {
		return section80G;
	}

	public void setSection80G(double section80g) {
		section80G = section80g;
	}

	public double getSection80EEA() {
		return section80EEA;
	}

	public void setSection80EEA(double section80eea) {
		section80EEA = section80eea;
	}

	
}
