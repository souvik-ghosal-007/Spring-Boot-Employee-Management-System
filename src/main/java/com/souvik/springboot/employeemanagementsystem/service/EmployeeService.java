package com.souvik.springboot.employeemanagementsystem.service;

import com.souvik.springboot.employeemanagementsystem.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void delete(Long id);
}
