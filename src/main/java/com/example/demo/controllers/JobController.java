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

import com.example.demo.models.JobTitle;
import com.example.demo.services.JobTitleService;


@CrossOrigin
@RestController
@RequestMapping("/typejob")
public class JobController {
	
	@Autowired
	JobTitleService jobService;

	@GetMapping("/")
	public List<JobTitle> list() {
		return jobService.listAllJobTitles();
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobTitle> get(@PathVariable Integer id) {
		try {
			JobTitle jobTitle = jobService.getJobTitle(id);
			return new ResponseEntity<JobTitle>(jobTitle, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<JobTitle>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public void add(@RequestBody JobTitle emp) {
		jobService.saveJobTitle(emp);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody JobTitle emp, @PathVariable Integer id) {
		try {
			emp.setIdJobTitle(id);
			jobService.saveJobTitle(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		jobService.deleteJobTitle(id);
	}


}
