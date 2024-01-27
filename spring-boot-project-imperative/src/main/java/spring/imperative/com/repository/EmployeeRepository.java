package spring.imperative.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.imperative.com.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public boolean existsByEmail(String email);
	
	public Employee findByEmployeeId(String employeeId);
	
}
