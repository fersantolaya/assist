package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Employees;
import com.example.demo.services.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/")
	public List<Employees> list() {
		return empService.listAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employees> get(@PathVariable Integer id) {
		try {
			Employees empleado = empService.getEmployee(id);
			return new ResponseEntity<Employees>(empleado, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public void add(@RequestBody Employees emp) {
		empService.saveEmployee(emp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Employees emp, @PathVariable Integer id) {
		try {
			emp.setIdEmployees(id);
			empService.saveEmployee(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		empService.deleteEmployee(id);
	}

}
