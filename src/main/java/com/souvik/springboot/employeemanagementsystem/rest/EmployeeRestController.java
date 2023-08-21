package com.souvik.springboot.employeemanagementsystem.rest;

import com.souvik.springboot.employeemanagementsystem.dao.EmployeeDAO;
import com.souvik.springboot.employeemanagementsystem.entity.Employee;
import com.souvik.springboot.employeemanagementsystem.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employee_id}")
    public Employee getEmployee(@PathVariable Long employee_id) {

        Employee employee =  employeeService.find(employee_id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + employee_id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employee_id}")
    public String deleteEmployee(@PathVariable Long employee_id) {
        Employee employee = employeeService.find(employee_id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found - " + employee_id);
        }

        employeeService.delete(employee_id);

        return "Deleted Employee with id - " + employee_id;
    }
}
