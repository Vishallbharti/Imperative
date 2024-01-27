package spring.imperative.com.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double salary;
	private String email;
	private String address;
	@Column(name = "mobile", length = 10)
	private String mobile;
	@Column(name = "adhar", length = 12)
	private String adhar;
	private String pan;
	private Date birthDate;
	private String employeeId;
	private String department;
	private String designation;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, Double salary, String email, String address, String mobile, String adhar,
			String pan, Date birthDate, String employeeId, String department, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.adhar = adhar;
		this.pan = pan;
		this.birthDate = birthDate;
		this.employeeId = employeeId;
		this.department = department;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + ", address="
				+ address + ", mobile=" + mobile + ", adhar=" + adhar + ", pan=" + pan + ", birthDate=" + birthDate
				+ ", employeeId=" + employeeId + ", department=" + department + ", designation=" + designation + "]";
	}
	
	

}
