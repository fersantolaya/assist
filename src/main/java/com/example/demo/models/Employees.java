package com.example.demo.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployees;

    @Column(nullable = false, length = 11)
    private String employeeRut;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "fk_job")
    private JobTitle fkJobTitle;
    
    @ManyToOne
    @JoinColumn(name = "fk_contract")
    private TypeContract fkTypeContract;
    
    

	public JobTitle getFkJobTitle() {
		return fkJobTitle;
	}

	public void setFkJobTitle(JobTitle fkJobTitle) {
		this.fkJobTitle = fkJobTitle;
	}

	public TypeContract getFkTypeContract() {
		return fkTypeContract;
	}

	public void setFkTypeContract(TypeContract fkTypeContract) {
		this.fkTypeContract = fkTypeContract;
	}

	public Integer getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(final Integer idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getEmployeeRut() {
        return employeeRut;
    }

    public void setEmployeeRut(final String employeeRut) {
        this.employeeRut = employeeRut;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
