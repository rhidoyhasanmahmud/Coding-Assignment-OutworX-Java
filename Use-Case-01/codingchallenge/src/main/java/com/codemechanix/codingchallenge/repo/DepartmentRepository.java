package com.codemechanix.codingchallenge.repo;

import com.codemechanix.codingchallenge.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDepartmentName(String departmentName);
}
