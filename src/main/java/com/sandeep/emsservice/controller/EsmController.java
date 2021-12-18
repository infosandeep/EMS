package com.sandeep.emsservice.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sandeep.emsservice.entity.Employee;
import com.sandeep.emsservice.login.LoginForm;
import com.sandeep.emsservice.services.EmsServices;

@Controller
public class EsmController {

	@Autowired
	EmsServices emss;
	
	
	@GetMapping("/")
	public String demo(Model m) {
		List<Employee> emp = emss.getAllList();
		m.addAttribute("emp" , emp);
		return "index";
	}	

	
	@GetMapping("/admin")
	public String admin(Model m) {
		List<Employee> emp = emss.getAllList();
		m.addAttribute("emp", emp);
		return "admin";
	}
	
	

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
		

	@PostMapping("/register")
	public String saveEmp(@ModelAttribute Employee emp,HttpSession session) {
		emss.save(emp);
	 session.setAttribute("msg", "Employee added successfully");	
		return "redirect:/admin";
			
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id ,Model m) {
		Employee emp = emss.getEmpById(id);
		m.addAttribute("emp",emp);
		return "edit";
	}
	
	

	@PostMapping("edit/update")
	public String updateEmp(@ModelAttribute Employee emp) {
		emss.save(emp);
		return ("redirect:/admin");
	}
		
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id ) {
		
		emss.deleteEmp(id);
		return ("redirect:/admin");
	
		
	}
	
	@GetMapping("/adminlogin")
	public String getlogin() {
		return "adminlogin";
	}
	
	@PostMapping("/admin")

	public String login(@ModelAttribute (name ="LoginForm")LoginForm loginForm, Model model) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();

		
		  if ("sandy".equals(username) && "sandy".equals(password)) {
			  return ("redirect:/admin");
		  
		  } model.addAttribute("InvalidCredentials", true);
		 
		return "adminlogin";
	}
	
	
	

	

}
