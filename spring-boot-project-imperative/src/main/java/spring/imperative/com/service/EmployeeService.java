package spring.imperative.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.imperative.com.model.Employee;
import spring.imperative.com.model.User;
import spring.imperative.com.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		return this.employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int employeeId) {
		return this.employeeRepository.findById(employeeId);
	}
	
	public Employee getEmployeeByEmployeeId(String employeeId) {
		return this.employeeRepository.findByEmployeeId(employeeId);
	}
	
	public Employee addEmployee(Employee employee) throws Exception {
		if (this.employeeRepository.existsByEmail(employee.getEmail())) {
			throw new Exception("User is already exist!");
		} else {
			return this.employeeRepository.save(employee);
		}
		
	}

}
