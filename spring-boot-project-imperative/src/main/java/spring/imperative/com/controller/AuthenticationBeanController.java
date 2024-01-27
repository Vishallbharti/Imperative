package spring.imperative.com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.imperative.com.model.AuthenticationBean;
import spring.imperative.com.model.User;
import spring.imperative.com.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AuthenticationBeanController {

	
	@Autowired
	private UserService userService;
	
	    @GetMapping(path = "/basicauth/{username}")
	    public Optional<User> basicauth(@PathVariable String username) {
	    	return this.userService.getUser(username);
	        
	    }
}
