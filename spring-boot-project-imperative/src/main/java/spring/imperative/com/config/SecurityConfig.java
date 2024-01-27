package spring.imperative.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import spring.imperative.com.service.UserInfoDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public UserInfoDetailsService userDetailsService() {
//		UserDetails admin = User.withUsername("vishal21")
//				.password(encoder.encode("Vishal@21"))
//				.roles("ADMIN")
//				.build();
//
//		UserDetails user = User.withUsername("faim21")
//				.password(encoder.encode("Faim@21"))
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
		
		return new UserInfoDetailsService();
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/employee/employeeId/**").permitAll()
				.requestMatchers("/api/v1/**").permitAll()
				.requestMatchers("/employee/**").authenticated()
	            .requestMatchers("/users/**").authenticated()
	            
	        )
		.httpBasic(Customizer.withDefaults())
//		.formLogin(Customizer.withDefaults())
        .build();
	} 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

}
