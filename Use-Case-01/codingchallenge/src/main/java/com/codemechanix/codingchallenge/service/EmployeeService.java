package com.codemechanix.codingchallenge.service;

import com.codemechanix.codingchallenge.model.Department;
import com.codemechanix.codingchallenge.model.Employee;
import com.codemechanix.codingchallenge.repo.DepartmentRepository;
import com.codemechanix.codingchallenge.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employee) throws NoSuchElementException {
        Department department = departmentRepository.findByDepartmentName(employee.getDepartment());
        if (department == null) {
            throw new NoSuchElementException("Department does not exist");
        }
        employee.setDepartment(department.getId().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeLastName(Long id, String lastname) throws NoSuchElementException {
        Employee employee = employeeRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employee.setLastName(lastname);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) throws NoSuchElementException {
        Employee employee = employeeRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
