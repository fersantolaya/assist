package com.example.demo.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employees;


public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
