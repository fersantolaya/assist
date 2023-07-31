package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.JobTitle;
import com.example.demo.repositorys.JobTitleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobTitleService {
	
	@Autowired
	private JobTitleRepository jobRepository;
	
	  public List<JobTitle> listAllJobTitles() {
	        return jobRepository.findAll();
	    }

	    public void saveJobTitle(JobTitle emp) {
	    	jobRepository.save(emp);
	    }

	    public JobTitle getJobTitle(Integer id) {
	        return jobRepository.findById(id).get();
	    }

	    public void deleteJobTitle(Integer id) {
	    	jobRepository.deleteById(id);
	    }

}
