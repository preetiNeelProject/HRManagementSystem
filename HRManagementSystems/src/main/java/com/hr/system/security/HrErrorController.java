package com.hr.system.security;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HrErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView handleError(HttpServletRequest request) {
		System.out.println("Error page request:" + request);
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		System.out.println("Error page status:" + status);
		ModelAndView errorPage = new ModelAndView("error");
		System.out.println("Error page errorPage:" + errorPage);
		String errorMsg = "";

		if (status != null) {
			System.out.println("Error page errorPage:" + status);
			Integer statusCode = Integer.valueOf(status.toString());
			System.out.println("Error page statusCode:" + statusCode);
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				System.out.println("Error page statusCode loop:" + statusCode);
				errorMsg = "Http Error Code: 400. Bad Request";
				errorPage.addObject("errorMsg", errorMsg);
				return errorPage;
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				errorMsg = "Http Error Code: 500. Internal Server Error";
				errorPage.addObject("errorMsg", errorMsg);
				return errorPage;
			} else {
				errorMsg = "Sorry! Data is not available in my database";
				errorPage.addObject("errorMsg", errorMsg);
				return errorPage;
			}

		}
		return errorPage;
	}

}
