package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.JobTitle;


public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
