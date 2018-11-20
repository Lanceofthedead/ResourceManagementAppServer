package com.example.resourcemanagementapp.service.impl;

import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Employee;
import com.example.resourcemanagementapp.repository.EmployeeRepository;
import com.example.resourcemanagementapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(@PathVariable(value = "employeeId") Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeId" + employeeId + " not Found"));
    }

    @Override
    public Employee createEmployee(@RequestBody Employee employee) {


        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employeeRequest) {
        employeeRequest.setId(employeeId);
        return employeeRepository.save(employeeRequest);
    }


    @Override
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employeeRepository.delete(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }

}