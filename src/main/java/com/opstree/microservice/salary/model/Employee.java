package com.opstree.microservice.salary.model;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Represents an employee's salary details.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("employee_salary")
public class Employee implements Serializable {

    /**
     * The unique identifier of the employee.
     */
    @Id
    @PrimaryKey
    @Column("id")
    private String id;

    /**
     * The name of the employee.
     */
    @Column("name")
    private String name;

    /**
     * The salary of the employee.
     */
    @Column("salary")
    private Float salary;

    /**
     * The process date for the employee's salary.
     */
    @Column("process_date")
    private String processDate;

    /**
     * The status of the employee.
     */
    @Column("status")
    private String status;

    /**
     * Returns the unique identifier of the employee.
     *
     * @return the id of the employee
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the salary of the employee.
     *
     * @return the salary of the employee
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * Returns the process date for the employee's salary.
     *
     * @return the process date
     */
    public String getProcessDate() {
        return processDate;
    }

    /**
     * Returns the status of the employee.
     *
     * @return the status of the employee
     */
    public String getStatus() {
        return status;
    }
}
