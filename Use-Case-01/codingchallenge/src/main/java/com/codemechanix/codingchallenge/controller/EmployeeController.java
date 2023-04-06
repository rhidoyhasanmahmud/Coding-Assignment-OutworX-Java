package com.codemechanix.codingchallenge.controller;

import com.codemechanix.codingchallenge.model.Employee;
import com.codemechanix.codingchallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Department does not exist", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployeeLastName(@PathVariable("id") Long id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployeeLastName(id, employee.getLastName());
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
