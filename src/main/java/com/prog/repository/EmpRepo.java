package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Employee;

@Repository
public interface EmpRepo  extends JpaRepository<Employee, Integer>{

}

//This code defines a Spring Data JPA repository interface for the Employee entity,
//which extends the JpaRepository interface to provide CRUD operations for the Employee entity.
//The @Repository annotation indicates that it is a Spring bean.