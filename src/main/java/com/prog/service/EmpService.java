package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.repository.EmpRepo;

//This code defines a Spring service class EmpService which provides methods to perform CRUD
//(Create, Read, Update, Delete) operations on Employee objects.
//The service class interacts with the database through the repository layer (EmpRepo) 
//to persist and retrieve Employee data.



@Service
//@Service indicates that this class is a Spring-managed service bean.
public class EmpService {

	@Autowired
	private EmpRepo repo;
	//It is autowired with the EmpRepo bean, which provides the methods to interact with the database.

	public void addEmp(Employee e) {
		repo.save(e);
	}
	// This method takes an Employee object as input and saves it to the database using the repo.save(e) method.

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	//This method retrieves all Employee objects from the database using the repo.
	//findAll() method and returns them as a list.

	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	//This method retrieves an Employee object from the database with the given ID using the 
	//repo.findById(id) method. If the object exists, it is returned. Otherwise, it returns null.

	public void deleteEMp(int id) {
		repo.deleteById(id);
	}
	//This method deletes the Employee object with the given ID from the database using the repo.deleteById(id) method.

	public Page<Employee> getEMpByPaginate(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return repo.findAll(p);
	}
	//This method returns a paginated list of Employee objects from the database based on the 
	//given current page and page size. It creates a Pageable object and uses it to fetch a page of Employee 
	//objects using the repo.findAll(p) method. The returned Page object contains page-related information 
	//such as total pages and total items.

}