package jp.te4a.spring.boot.myapp13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("/webjars/**","/css/**");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(authz -> authz
		.requestMatchers("/loginForm").permitAll()
		.requestMatchers("/users").permitAll()
		.requestMatchers("/users/create").permitAll()
		.anyRequest().authenticated()
	).formLogin(login -> login
		.loginProcessingUrl("/login")
		.loginPage("/loginForm")
		.failureUrl("/loginForm?error")
		.defaultSuccessUrl("/books",true)
		.usernameParameter("username").passwordParameter("password")
	).logout(logout -> logout
		.logoutSuccessUrl("/loginForm")
		);
		return http.build();
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder("", 16, 310000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
	}
}