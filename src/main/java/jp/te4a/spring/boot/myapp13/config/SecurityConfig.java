package jp.te4a.spring.boot.myapp13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
	
	
	public void configure(WebSecurity web)throws Exception{
		web.ignoring().requestMatchers("/webjars/**","/css/**");
	}
	@Autowired
	Pbkdf2PasswordEncoder passwordEncoder;
	@Bean
	PasswordEncoder passwordEncoder() {
		return passwordEncoder;
	}
	
	protected void configure(HttpSecurity http)throws Exception{
		http
		.authorizeRequests()
		.requestMatchers("/loginForm").permitAll()
		.requestMatchers("/users").permitAll()
		.requestMatchers("/users/create").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/login")
		.loginPage("/loginForm")
		.failureUrl("/loginForm?error")
		.defaultSuccessUrl("/books",true)
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout()
		.logoutSuccessUrl("/loginForm");
	}
}
