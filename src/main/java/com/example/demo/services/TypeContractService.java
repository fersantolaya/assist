package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TypeContract;
import com.example.demo.repositorys.TypeContractRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TypeContractService {
	
	@Autowired
    private TypeContractRepository contractRepository;
 
    public List<TypeContract> listAllTypeContracts() {
        return contractRepository.findAll();
    }

    public void saveTypeContract(TypeContract emp) {
    	contractRepository.save(emp);
    }

    public TypeContract getTypeContract(Integer id) {
        return contractRepository.findById(id).get();
    }

    public void deleteTypeContract(Integer id) {
    	contractRepository.deleteById(id);
    }

}
