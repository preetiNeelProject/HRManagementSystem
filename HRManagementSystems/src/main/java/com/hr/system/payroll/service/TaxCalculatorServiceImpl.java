package com.hr.system.payroll.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.hr.system.payroll.bean.TaxCalculateAccessBean;

@Service
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

	@Override
	public HashMap<String, Double> calculateTax(TaxCalculateAccessBean tax) {
		HashMap<String,Double> taxAmount = new HashMap<String,Double>();
		Double newTaxAmount = null;
		Double oldTaxAmount = null;
		String age=tax.getAgeGroup();
		// Age

		// New Income Tax slabs

		// ----------------Income--------------------//
		Double grossTotalSalary = tax.getTaxableSalary()+  tax.getRentalPropertyIncome() + tax.getOtherIncome() +tax.getInterestIncome();
		
		Double oldGrossTotalSalary=grossTotalSalary - tax.getExemptIncome();
		
		System.out.println(grossTotalSalary);
		// ----------------Deduction Limit--------------------//
		Double section80D=tax.getSection80D();
		if(section80D>75000) {
			section80D=75000d;
		}
		Double section80EEA=tax.getSection80EEA();
		if(section80EEA>200000) {
			section80EEA=200000d;
		}
		Double section80C=tax.getSection80C();
		if(section80C>150000) {
			section80C=150000d;
		}
		
		// ----------------Deduction--------------------//
		Double deductins = tax.getOccupiedPropertyInterest() + tax.getInterestLoan()
				+ section80C + tax.getSection80CCD() + section80D + tax.getSection80E()
				+ section80EEA + tax.getSection80G() + tax.getSection80TTA();
		System.out.println(deductins);

		if(oldGrossTotalSalary<deductins) {
			System.out.println("Error");
		}
		Double oldGrossTaxableIncome = oldGrossTotalSalary - deductins;
		Double newGrossTaxableIncome = grossTotalSalary;
		
		/*
		 * ----------------------------------------------------------------
		                        Age 60 & below
		  -----------------------------------------------------------------
		*/
		
		
		if (age.equals("NotSenior")) {
			
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (New Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (newGrossTaxableIncome <= 250000) {
				newTaxAmount = (double) 0;
			} else if (500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 250000) {
				newTaxAmount = 0 + (newGrossTaxableIncome - 22500) * 0.05;
				if (newTaxAmount <= 12500) {
					newTaxAmount = (double) 0;
				}
			} else if (750000 >= newGrossTaxableIncome && newGrossTaxableIncome > 500000) {
				newTaxAmount = 0 + 12500 + (newGrossTaxableIncome - 500000) * 0.1;
			} else if (1000000 >= newGrossTaxableIncome && newGrossTaxableIncome > 750000) {
				newTaxAmount = 0 + 12500 + 25000 + (newGrossTaxableIncome - 750000) * 0.15;
			} else if (1250000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1000000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + (newGrossTaxableIncome - 1000000) * 0.2;
			} else if (1500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1250000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + (newGrossTaxableIncome - 1250000) * 0.25;
			} else if (newGrossTaxableIncome > 1500000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + 62500 + (newGrossTaxableIncome - 1500000) * 0.3;
			}
			
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (old Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (oldGrossTaxableIncome <= 250000) {
				oldTaxAmount = (double) 0;
			} else if (500000 >= oldGrossTaxableIncome && oldGrossTaxableIncome > 250000) {
				oldTaxAmount = 0 + (oldGrossTaxableIncome - 22500) * 0.05;
				if (oldTaxAmount <= 12500) {
					oldTaxAmount = (double) 0;
				}
			} else if (1000000 >= oldGrossTaxableIncome && oldGrossTaxableIncome > 500000) {
				oldTaxAmount = 0 + 12500 + (oldGrossTaxableIncome - 500000) * 0.2;
			} else if (oldGrossTaxableIncome > 1000000) {
				oldTaxAmount = 0 + 12500 + 100000 + (oldGrossTaxableIncome - 1000000) * 0.3;
			} 
			
		} else if (age.equals("Senior")) {
			/*
			 * ----------------------------------------------------------------
			                        Age 60 - 80
			  ----------------------------------------------------------------
			*/
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (New Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (newGrossTaxableIncome <= 250000) {
				newTaxAmount = (double) 0;
			} else if (500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 250000) {
				newTaxAmount = 0 + (newGrossTaxableIncome - 22500) * 0.05;
				if (newTaxAmount <= 12500) {
					newTaxAmount = (double) 0;
				}
			} else if (750000 >= newGrossTaxableIncome && newGrossTaxableIncome > 500000) {
				newTaxAmount = 0 + 12500 + (newGrossTaxableIncome - 500000) * 0.1;
			} else if (1000000 >= newGrossTaxableIncome && newGrossTaxableIncome > 750000) {
				newTaxAmount = 0 + 12500 + 25000 + (newGrossTaxableIncome - 750000) * 0.15;
			} else if (1250000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1000000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + (newGrossTaxableIncome - 1000000) * 0.2;
			} else if (1500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1250000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + (newGrossTaxableIncome - 1250000) * 0.25;
			} else if (newGrossTaxableIncome > 1500000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + 62500 + (newGrossTaxableIncome - 1500000) * 0.3;
			}
			
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (old Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (oldGrossTaxableIncome <= 300000) {
				oldTaxAmount = (double) 0;
			} else if (500000 >= oldGrossTaxableIncome && oldGrossTaxableIncome > 300000) {
				oldTaxAmount = 0 + (oldGrossTaxableIncome - 300000) * 0.05;
			} else if (1000000 >= oldGrossTaxableIncome && oldGrossTaxableIncome > 500000) {
				oldTaxAmount = 0 + 10000 + (oldGrossTaxableIncome - 500000) * 0.2;
			} else if (oldGrossTaxableIncome > 1000000) {
				oldTaxAmount = 0 + 10000 + 100000 + (oldGrossTaxableIncome - 1000000) * 0.3;
			} 
			
		} else if (age.equals("SuperSenior")) {
			/*
			 * ----------------------------------------------------------------
			                        Age 80 & up
			  ----------------------------------------------------------------
			*/
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (New Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (newGrossTaxableIncome <= 250000) {
				newTaxAmount = (double) 0;
			} else if (500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 250000) {
				newTaxAmount = 0 + (newGrossTaxableIncome - 22500) * 0.05;
				if (newTaxAmount <= 12500) {
					newTaxAmount = (double) 0;
				}
			} else if (750000 >= newGrossTaxableIncome && newGrossTaxableIncome > 500000) {
				newTaxAmount = 0 + 12500 + (newGrossTaxableIncome - 500000) * 0.1;
			} else if (1000000 >= newGrossTaxableIncome && newGrossTaxableIncome > 750000) {
				newTaxAmount = 0 + 12500 + 25000 + (newGrossTaxableIncome - 750000) * 0.15;
			} else if (1250000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1000000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + (newGrossTaxableIncome - 1000000) * 0.2;
			} else if (1500000 >= newGrossTaxableIncome && newGrossTaxableIncome > 1250000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + (newGrossTaxableIncome - 1250000) * 0.25;
			} else if (newGrossTaxableIncome > 1500000) {
				newTaxAmount = 0 + 12500 + 25000 + 37500 + 50000 + 62500 + (newGrossTaxableIncome - 1500000) * 0.3;
			}
			
			/*
			 * ----------------------------------------------------------------
			                     Post-Budget (old Scheme)
                                       FY(2020-2021)
			  -----------------------------------------------------------------
			*/
			
			if (oldGrossTaxableIncome <= 500000) {
				oldTaxAmount = (double) 0;
			}  else if (1000000 >= oldGrossTaxableIncome && oldGrossTaxableIncome > 500000) {
				oldTaxAmount = 0 + (oldGrossTaxableIncome - 500000) * 0.2;
			} else if (oldGrossTaxableIncome > 1000000) {
				oldTaxAmount = 0 + 100000 + (oldGrossTaxableIncome - 1000000) * 0.3;
			} 
			
		}
		taxAmount.put("newTaxAmount", newTaxAmount);
		taxAmount.put("oldTaxAmount", oldTaxAmount);
		taxAmount.put("newGrossTaxableIncome", newGrossTaxableIncome);
		taxAmount.put("oldGrossTaxableIncome", oldGrossTaxableIncome);
		taxAmount.put("deductions", deductins);
		return taxAmount;
	}

}
