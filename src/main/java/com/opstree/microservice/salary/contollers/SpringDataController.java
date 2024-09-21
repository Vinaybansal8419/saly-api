package com.opstree.microservice.salary.service;

import com.opstree.microservice.salary.model.Employee;
import com.opstree.microservice.salary.repository.SpringDataSalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling salary-related operations.
 */
@Service
@RequiredArgsConstructor
public class SpringDataSalaryService {

    /**
     * Repository for accessing salary data.
     */
    private final SpringDataSalaryRepository springDataSalaryRepository;

    /**
     * Saves a new employee salary record.
     * @param employee The employee object to be saved
     * @return The saved employee object
     */
    public Employee saveSalary(final Employee employee) {
        return springDataSalaryRepository.save(employee);
    }

    /**
     * Retrieves all employee salary records.
     * @return A list of all employee salary records
     */
    public List<Employee> getAllSalaries() {
        return springDataSalaryRepository.findAll();
    }

    /**
     * Retrieves an employee salary record by ID.
     * @param id The ID of the employee
     * @return An Optional containing the employee if found,
              or empty if not found.
     */
    public Optional<Employee> getSalaryById(final Long id) {
        return springDataSalaryRepository.findById(id);
    }

    // Additional methods can be added as needed...
}
