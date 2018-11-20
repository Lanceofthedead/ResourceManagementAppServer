package com.example.resourcemanagementapp.dto;

import com.example.resourcemanagementapp.model.Employee;

import java.util.List;

public class PositionEmployeeDTO {
    private String jobTitle;

    private List<Employee> employees;

    public PositionEmployeeDTO(String jobTitle, List<Employee> employees) {
        this.jobTitle = jobTitle;
        this.employees = employees;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
