package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.models.TypeContract;
import com.example.demo.services.TypeContractService;


@CrossOrigin
@RestController
@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	TypeContractService contractService;

	@GetMapping("/")
	public List<TypeContract> list() {
		return contractService.listAllTypeContracts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TypeContract> get(@PathVariable Integer id) {
		try {
			TypeContract typeContract = contractService.getTypeContract(id);
			return new ResponseEntity<TypeContract>(typeContract, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<TypeContract>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public void add(@RequestBody TypeContract emp) {
		contractService.saveTypeContract(emp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody TypeContract emp, @PathVariable Integer id) {
		try {
			emp.setIdTypeContract(id);
			contractService.saveTypeContract(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		contractService.deleteTypeContract(id);
	}

}
