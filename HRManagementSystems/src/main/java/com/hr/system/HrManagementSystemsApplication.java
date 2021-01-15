package com.hr.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HrManagementSystemsApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HrManagementSystemsApplication.class, args);
		System.out.println("**************Start HRMS************");
	}
	
	public HrManagementSystemsApplication() {
	    super();
	    setRegisterErrorPageFilter(false); // <- this one
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(HrManagementSystemsApplication.class);
	}


}
