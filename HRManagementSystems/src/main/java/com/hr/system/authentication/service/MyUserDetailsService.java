package com.hr.system.authentication.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.system.config.EmployeePrincipal;
import com.hr.system.config.JwtTokenUtil;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeAccessBean employeeAccessBean = employeeRepository.findByLogonId(username);

		if (employeeAccessBean == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		return new EmployeePrincipal(employeeAccessBean);
	}

}
