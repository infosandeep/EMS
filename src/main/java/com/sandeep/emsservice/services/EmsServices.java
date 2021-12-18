package com.sandeep.emsservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sandeep.emsservice.entity.Employee;
import com.sandeep.emsservice.repository.EmsRepository;

@Service
public class EmsServices {

	@Autowired
	EmsRepository rep;

	public List<Employee> getAllList() {
		return rep.findAll();

	}

	public void save(Employee emp) {
		rep.save(emp);
	}

	public Employee getEmpById(int id) {
		Optional<Employee> e = rep.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEmp(int id) {
		rep.deleteById(id);
	}

}
