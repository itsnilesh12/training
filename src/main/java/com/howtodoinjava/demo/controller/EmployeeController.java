package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.dao.CustomerRepository;
import com.howtodoinjava.demo.model.Customer;
import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {

	
	
	@Autowired
	private CustomerRepository custRepo;
	
	static List<Employee> employeesList = new ArrayList<Employee>();

	
	static{
		
		
		employeesList.add(new Employee("1","John","Doe","johndoe@gmail.com"));
		employeesList.add(new Employee("2","Rob","Smith","robsmith@gmail.com"));
		employeesList.add(new Employee("3","Bill","Wi","billwi@gmail.com"));
		
	}
	
	@GetMapping("/customer")
    public List<Customer> getCustomer() 
    {
		return custRepo.findAll();
		//return employeesList;
    }
	
	
	@PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) 
    {
		custRepo.addCustomer(customer.getName(),customer.getEmail());
		//return "201";
		//return employeesList;
    }
	
	
	@GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable(value="id")String employeeId) 
    {
		Employee employee1 = findByCodeIsIn(employeesList,employeeId);
	
		//Employee employee = employeesList.get(Integer.parseInt(employeeId));
		return employee1;
    }
	
	@PostMapping("/employees")
	public Boolean newEmployee(@RequestBody Employee newEmployee) {
		if(employeesList.add(newEmployee)){
			return true;
		} else{
			return false;
		}
	}
	
	public Employee findByCodeIsIn(Collection<Employee> employeesList, String employeeId) {
	    return employeesList.stream().filter(employee ->  employee.getId().equals(employeeId)).findAny().orElse(null);
	}
	
	@DeleteMapping("/employees/{id}")
    public Boolean deleteEmployee(@PathVariable(value="id")String employeeId) 
    {
		//Employee employee1 = findByCodeIsIn(employeesList,employeeId);
		//Employee employee = employeesList.get(Integer.parseInt(employeeId));
		Employee employeeToBeDeleted =findByCodeIsIn(employeesList,employeeId);
		if(employeesList.remove(employeeToBeDeleted))
			return true;
		else
			return false;
    }


}
