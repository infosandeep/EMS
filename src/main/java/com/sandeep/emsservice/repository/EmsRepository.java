package com.sandeep.emsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.emsservice.entity.Employee;

public interface EmsRepository extends JpaRepository<Employee, Integer>{

}
