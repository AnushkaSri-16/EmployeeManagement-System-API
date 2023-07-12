package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;

//this code defines a Spring MVC Controller for an Employee Management System,
//which maps incoming requests to the appropriate methods and interacts with
//the Service layer to perform the necessary business logic.



@Controller
//"@Controller" annotation on the EmpController class indicates that this class is a Spring MVC Controller
public class EmpController {
	//EmpController class is also annotated with "@Autowired" to inject the EmpService object, 
	//which is responsible for handling Employee data operations.

	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model m) {
		return findPaginated(0, m);
	}
	// "home" method maps to the root URL path ("/") and returns a paginated list of employees.

	@GetMapping("/add_emp")
	public String addEmpForm() {
		return "add_emp";
	}
	// "addEmpForm" method maps to the "/add_emp" URL path and returns the form to add a new employee.

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/";
	}
    // "empRegister" method maps to the "/register" URL path and adds a new employee to the database.

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	// "edit" method maps to the "/edit/{id}" URL path and returns the form to edit an existing employee.

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/";
	}
	//"updateEmp" method maps to the "/update" URL path and updates an existing employee.

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/";
	}
	//"deleteEmp" method maps to the "/delete/{id}" URL path and deletes an employee.

	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Employee> emplist = service.getEMpByPaginate(pageno, 2);
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "index";
	}
	// "findPaginated" method maps to the "/page/{pageno}" URL path and returns a paginated list of employees.

}

