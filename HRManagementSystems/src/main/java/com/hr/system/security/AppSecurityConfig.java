package com.hr.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hr.system.config.EmployeePrincipalDetailsService;
import com.hr.system.config.JwtAuthenticationFilter;
import com.hr.system.config.JwtAuthorizationFilter;
import com.hr.system.employee.repository.EmployeeRepository;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private EmployeePrincipalDetailsService userPrincipalDetailsService;

	@Autowired
	private EmployeeRepository userRepository;

	public AppSecurityConfig(EmployeePrincipalDetailsService userPrincipalDetailsService,
			EmployeeRepository userRepository) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// remove csrf and state in session because in jwt we do not need them
				.csrf().disable()

				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// add jwt filters (1. authentication, 2. authorization)
				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository)).authorizeRequests()
				.antMatchers("/index", "/login","/**").permitAll()
				// configure access rules
				//.antMatchers(HttpMethod.POST, "/login").permitAll()
				//.antMatchers("/admin/employee/*").hasRole("MANAGER")
				//.antMatchers("/admin/attendance/*").hasRole("ADMIN")
				//.anyRequest().authenticated()
				
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.and()
				.rememberMe().tokenValiditySeconds(2592000).key("mySecret!").rememberMeParameter("checkRememberMe")
				.and()
				.exceptionHandling().accessDeniedPage("/error");;
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
