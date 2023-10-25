package com.example.demo.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee>{

	 List<Employee> findAllByOrderByIdAsc();
	
}
