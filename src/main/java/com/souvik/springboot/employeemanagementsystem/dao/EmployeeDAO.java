package com.souvik.springboot.employeemanagementsystem.dao;

import com.souvik.springboot.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee find(Long id);

    Employee save(Employee employee);

    void delete(Long id);
}
