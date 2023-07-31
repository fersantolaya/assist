package com.example.demo.services;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employees;
import com.example.demo.repositorys.EmployeesRepository;

import java.util.List;


@Service
@Transactional
public class EmployeeService {

	
	 @Autowired
	    private EmployeesRepository EmpRepository;
	 
	    public List<Employees> listAllEmployees() {
	        return EmpRepository.findAll();
	    }

	    public void saveEmployee(Employees emp) {
	    	EmpRepository.save(emp);
	    }

	    public Employees getEmployee(Integer id) {
	        return EmpRepository.findById(id).get();
	    }

	    public void deleteEmployee(Integer id) {
	    	EmpRepository.deleteById(id);
	    }
}
