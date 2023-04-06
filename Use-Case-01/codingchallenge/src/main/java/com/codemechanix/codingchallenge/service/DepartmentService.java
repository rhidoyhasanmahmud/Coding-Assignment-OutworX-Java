package com.codemechanix.codingchallenge.service;

import com.codemechanix.codingchallenge.model.Department;
import com.codemechanix.codingchallenge.model.Employee;
import com.codemechanix.codingchallenge.repo.DepartmentRepository;
import com.codemechanix.codingchallenge.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department createDepartment(Department department) throws DuplicateKeyException {
        if (departmentRepository.findByDepartmentName(department.getDepartmentName()) != null) {
            throw new DuplicateKeyException("Department name already exists");
        }
        return departmentRepository.save(department);
    }

    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        return employeeRepository.findByDepartment(departmentName);
    }

    public void deleteDepartmentById(int departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        employeeRepository.deleteByDepartment(department.getDepartmentName());
        departmentRepository.deleteById(departmentId);
    }

    public void addEmployeesToDepartment(int departmentId, List<Employee> employees) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        employees.forEach(employee -> employee.setDepartment(department.getDepartmentName()));
        employeeRepository.saveAll(employees);
    }
}
