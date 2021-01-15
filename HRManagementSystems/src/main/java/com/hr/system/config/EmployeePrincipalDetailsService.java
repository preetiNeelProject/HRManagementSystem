package com.hr.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;


@Service
public class EmployeePrincipalDetailsService implements UserDetailsService {
	
	@Autowired
    private EmployeeRepository userRepository;

    public EmployeePrincipalDetailsService(EmployeeRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EmployeeAccessBean user = this.userRepository.findByLogonId(s);
        EmployeePrincipal userPrincipal = new EmployeePrincipal(user);

        return userPrincipal;
    }
}
