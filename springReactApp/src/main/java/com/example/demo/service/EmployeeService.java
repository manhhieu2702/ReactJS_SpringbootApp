package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.reponsitory.EmployeeRepo;

import jakarta.persistence.criteria.Predicate;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public EmployeeRepo getEmployeeRepo() {
		return employeeRepo;
	}

	public void setEmployeeRepo(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> getAllemployee(){
		return employeeRepo.findAllByOrderByIdAsc();
	}
	public Employee createNewemployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Optional<Employee> findEmployeeById(Long id) {
		
		return employeeRepo.findById(id);
	}
	public Employee updateEmployeeById(Long id, Employee newEmployees) {
		 return employeeRepo.findById(id)
	                .map(employee -> {
	                	employee.setName(newEmployees.getName());
	                	employee.setAddress(newEmployees.getAddress());
	                	employee.setEmail(newEmployees.getEmail());
	                	employee.setAge(newEmployees.getAge());
	                	employee.setPhone(newEmployees.getPhone());
	                	employee.setDepartment(newEmployees.getDepartment());
	                	employee.setJoinDate(newEmployees.getJoinDate());
	                    return employeeRepo.saveAndFlush(employee);
	                }).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public String deleteEmployeeByID(Long id){
        if(!employeeRepo.existsById(id)){
            throw new ResourceNotFoundException(id);
        }else {
        employeeRepo.deleteById(id);
        return "User with id "+id+" has been deleted success.";
        }
    }
	
	
	 public Page<Employee> searchEmployees(EmployeeDTO employeeDTO) {
	        PageRequest pageRequest = PageRequest.of(employeeDTO.getPageNum(), employeeDTO.getPageSize());
	        Specification<Employee> specification = (root, query, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();

	            if (employeeDTO.getStartDate() != null && employeeDTO.getEndDate() != null) {
	                predicates.add(criteriaBuilder.between(root.get("joinDate"), employeeDTO.getStartDate(), employeeDTO.getEndDate()));
	            }

	            if (employeeDTO.getName() != null) {
	                predicates.add(criteriaBuilder.like(root.get("name"), "%" +employeeDTO.getName() +"%"));
	            }

	            if (employeeDTO.getEmail() != null) {
	                predicates.add(criteriaBuilder.equal(root.get("email"), employeeDTO.getEmail()));
	            }

	            if (employeeDTO.getAddress() != null) {
	                predicates.add(criteriaBuilder.equal(root.get("address"), employeeDTO.getAddress()));
	            }

	            if (employeeDTO.getAge() != 0) {
	                predicates.add(criteriaBuilder.equal(root.get("age"), employeeDTO.getAge()));
	            }

	            if (employeeDTO.getPhone() != null) {
	                predicates.add(criteriaBuilder.equal(root.get("phone"), employeeDTO.getPhone()));
	            }

	            if (employeeDTO.getDepartment() != null) {
	                predicates.add(criteriaBuilder.equal(root.get("department"), employeeDTO.getDepartment()));
	            }

	            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	        };

	        return employeeRepo.findAll(specification, pageRequest);
	    }

}
