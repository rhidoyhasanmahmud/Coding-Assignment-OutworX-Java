package com.codemechanix.codingchallenge.controller;

import com.codemechanix.codingchallenge.model.Department;
import com.codemechanix.codingchallenge.model.Employee;
import com.codemechanix.codingchallenge.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        try {
            Department createdDepartment = departmentService.createDepartment(department);
            return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{departmentName}/employees")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        return departmentService.getEmployeesByDepartmentName(departmentName);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartmentById(@PathVariable int departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    @PostMapping("/{departmentId}/employees")
    public void addEmployeesToDepartment(@PathVariable int departmentId, @RequestBody List<Employee> employees) {
        departmentService.addEmployeesToDepartment(departmentId, employees);
    }

}
