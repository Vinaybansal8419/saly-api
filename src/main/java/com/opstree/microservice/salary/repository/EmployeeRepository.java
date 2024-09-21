package com.opstree.microservice.salary.repository;

import com.opstree.microservice.salary.model.Employee;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

/**
 * This interface contains repositories for managing employee salary data.
 */
public interface EmployeeRepository
        extends CassandraRepository<Employee, UUID> {

    /**
     * Finds an employee by their ID as a string.
     *
     * @param id the ID of the employee as a string
     * @return the Employee object if found, otherwise null
     */
    @Query("SELECT * FROM employee_salary WHERE id = ?0")
    Employee findByIdAsString(String id);
}
