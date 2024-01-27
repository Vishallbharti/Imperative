package spring.imperative.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.imperative.com.config.UserInfoDetails;
import spring.imperative.com.model.User;
import spring.imperative.com.repository.UserRepository;


@Service
public class UserInfoDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepository.findByUsername(username);
		return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found" + username));
		
	}

}
