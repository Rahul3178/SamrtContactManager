package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
	/*
	 * Step:1->here we have to declare bean of userDetailsService interface and
	 * return userDetails Service impl class object
	 * 
	 * Step:2-> declare second bean for password encryption /
	 * BcryptPasswordEncoder() Step:3-> declare 3rd bean for
	 * DaoAuthenticationProvider
	 * 
	 * 
	 * Note we can use those bean anywhere in this project with the help of
	 * autowiring Now these beans are present inside of IOC container
	 */
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		// provide details to USerDetails service class and password encoders
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());

		return daoAuthenticationProvider;

	}

	// configure method now we override methods for configuration.

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * provide authentication provider which type of authentication we are using
		 * like dao or in memory
		 */
		auth.authenticationProvider(authenticationProvider());

	}

	/*
	 * Routing i.e which user uses which url or not
	 * http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); this
	 * specifies those admin url only access by user which have user role= ADMIN
	 * antMatchers("/**").permitAll()-> on those link all user have permit
	 * antMatchers("/user/**").hasRole("USER")-> only those user which have user
	 * role= USER and().formLogin()-> we need form based loggin service
	 * and().csrf().disable()-> here we are disabling security (by default)
	 * formLogin().loginPage("/login")-> here we customize login page we provide our
	 * build login page url which tell spring to use our page not by default
	 * loginPage("/login").
	 * loginProcessingUrl("/dologin")
	 * .defaultSuccessUrl("/user/index")
	 * .failureUrl("login-fail")
	 * 
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
				.antMatchers("/**").permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/dologin")
				.defaultSuccessUrl("/user/index")		
				.and().csrf().disable();

	}

}
