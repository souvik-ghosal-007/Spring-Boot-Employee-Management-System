package com.souvik.springboot.employeemanagementsystem.dao;

import com.souvik.springboot.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
