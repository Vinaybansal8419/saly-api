package com.opstree.microservice.salary.service;

import com.opstree.microservice.salary.model.Employee;
import com.opstree.microservice.salary.repository.EmployeeRepository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Service for managing salary-related operations.
 */
@Service
@EnableCassandraRepositories(basePackages = {
        "com.opstree.microservice.salary"
})
public class SpringDataSalaryService {

    /**
     * Repository for accessing employee salary data.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Retrieves all employee salaries.
     * @return a list of all employee salaries.
     */
    public List<Employee> getAllEmployeeSalary() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieves a specific employee salary by ID.
     * @param id the ID of the employee salary to retrieve.
     * @return the employee salary corresponding to the given ID.
     */
    @Cacheable("salary-search-id")
    public Employee getEmployeeSalary(final String id) {
        return employeeRepository.findByIdAsString(id);
    }
    /**
     * Saves an employee salary.
     * @param employee the employee salary to save.
     * @return the saved employee salary.
     */
    public Employee saveSalary(final Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
