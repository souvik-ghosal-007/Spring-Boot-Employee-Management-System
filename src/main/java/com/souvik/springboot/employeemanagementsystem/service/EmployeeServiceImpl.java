package com.souvik.springboot.employeemanagementsystem.service;

import com.souvik.springboot.employeemanagementsystem.dao.EmployeeDAO;
import com.souvik.springboot.employeemanagementsystem.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee find(Long id) {
        return employeeDAO.find(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        employeeDAO.delete(id);
    }
}
