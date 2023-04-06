package com.codemechanix.codingchallenge.repo;

import com.codemechanix.codingchallenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    void deleteByDepartment(String departmentName);

    List<Employee> findByDepartment(String departmentName);
}
