package com.example.resourcemanagementapp.controller;

import com.example.resourcemanagementapp.model.Employee;
import com.example.resourcemanagementapp.repository.EmployeeRepository;
import com.example.resourcemanagementapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {


    EmployeeService employeeService;

    EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    // Get all employees
    @GetMapping("/list")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    // Get an employee
    @GetMapping(value = "/{employeeId}")
    public Employee getEmployeeById(@PathVariable(value = "employeeId") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // Create an employee
    @PostMapping(value = "/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }


    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employeeRequest){
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }


    // Delete an employee
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

  
}
