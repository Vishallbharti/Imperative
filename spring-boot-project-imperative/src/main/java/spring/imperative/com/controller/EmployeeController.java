package spring.imperative.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.imperative.com.model.Employee;
import spring.imperative.com.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/{employeeId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Employee getEmployeeById(@PathVariable String employeeId) {
		return this.employeeService.getEmployeeByEmployeeId(employeeId);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Employee> getAllEmployee(){
		return this.employeeService.getAllEmployee();
	}
	
	@PostMapping("/createEmployee")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Employee createEmployee(@RequestBody Employee employee) throws Exception {
		return this.employeeService.addEmployee(employee);
	}
	

}
