package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;


@Entity
@Table(name="type_contract")
public class TypeContract {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeContract;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, name = "\"description\"", length = 200)
    private String description;

    public Integer getIdTypeContract() {
        return idTypeContract;
    }

    public void setIdTypeContract(final Integer idTypeContract) {
        this.idTypeContract = idTypeContract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
