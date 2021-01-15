package com.hr.system.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hr.system.employee.bean.EmployeeAccessBean;

public class EmployeePrincipal implements UserDetails {
	
	private EmployeeAccessBean employee;
	
	public EmployeePrincipal(EmployeeAccessBean employee) {
		super();
		this.employee=employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of permissions (name)
		/*
		 * this.employee.getPermissionList().forEach(p -> { GrantedAuthority authority =
		 * new SimpleGrantedAuthority(p); authorities.add(authority); });
		 */

        // Extract list of roles (ROLE_name)
        this.employee.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });

        return authorities;
    }

	@Override
	public String getPassword() {
		return employee.getLogonPassword();
	}

	@Override
	public String getUsername() {
		return employee.getLogonId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
