package com.souvik.springboot.employeemanagementsystem.dao;

import com.souvik.springboot.employeemanagementsystem.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employees = entityManager.createQuery("FROM Employee", Employee.class);

        return employees.getResultList();
    }

    @Override
    public Employee find(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.merge(employee);

        return employee;
    }

    @Override
    public void delete(Long id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
