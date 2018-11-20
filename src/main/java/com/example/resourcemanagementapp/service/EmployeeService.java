package com.example.resourcemanagementapp.service;

import com.example.resourcemanagementapp.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee createEmployee(Employee employee);



    public Employee updateEmployee(Long employeeId, Employee employeeRequest);

    public ResponseEntity<?> deleteEmployee(Long employeeId);


}
