package com.hr.system.payroll.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hr.system.payroll.bean.TaxCalculateAccessBean;
import com.hr.system.payroll.service.TaxCalculatorService;

@Controller
public class TaxCalulatorControllerCmd {

	@Autowired
	TaxCalculatorService taxCalculatorService;

	

	@RequestMapping(value = "admin/payroll/taxCalculator", method = RequestMethod.GET)
	public String taxCalculator() {
		return "admin/payroll/taxCalculator";

	}
	
	@RequestMapping(value = "admin/payroll/calculateTax", method = RequestMethod.GET)
	public ModelAndView  calculateTax(@ModelAttribute TaxCalculateAccessBean tax, Model model) {
		ModelAndView modelAndView = new ModelAndView();    
        model.addAttribute("tax", tax);
		HashMap<String, Double> taxAmount=taxCalculatorService.calculateTax(tax);
		System.out.println("newTaxAmount "+taxAmount.get("newTaxAmount"));
		System.out.println("oldTaxAmount"+taxAmount.get("oldTaxAmount"));
		
		modelAndView.setViewName("admin/payroll/viewTax");        
		modelAndView.addObject("taxAmount", taxAmount);      
		return modelAndView;    


	}
}
