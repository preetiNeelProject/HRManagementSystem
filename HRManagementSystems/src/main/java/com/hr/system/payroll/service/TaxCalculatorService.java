package com.hr.system.payroll.service;

import java.util.HashMap;

import com.hr.system.payroll.bean.TaxCalculateAccessBean;

public interface TaxCalculatorService {

	HashMap<String, Double> calculateTax(TaxCalculateAccessBean tax);


	
}
