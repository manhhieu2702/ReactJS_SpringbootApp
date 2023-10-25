package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	/*----------------Declare-----------*/
	@Autowired
	 private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	/* ----------------Request------------ */
	
	
	 // get all employees
	@GetMapping("/employees")
	public List<Employee> getAllemployee(){
		return employeeService.getAllemployee();
	}
    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createNewemployee(employee);
    }
    
    
    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity < Employee > getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok(employee);
    }
    
    
    // update employee rest api

    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployeeResult = employeeService.updateEmployeeById(id,employee);
        return ResponseEntity.ok(updatedEmployeeResult);
    }
    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployeeByID(id);
    }
    //search dynamic jpa specification employee rest api
    @PostMapping("/employees/searchJPAspecification")
    public Page<Employee> searchEmployees(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.searchEmployees(employeeDTO);
    }
}
