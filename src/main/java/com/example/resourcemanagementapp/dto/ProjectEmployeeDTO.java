package com.example.resourcemanagementapp.dto;

import com.example.resourcemanagementapp.model.Employee;

import java.util.List;

public class ProjectEmployeeDTO {

    private String projectName;

    private String clientName;

    private List<Employee> employees;

    public ProjectEmployeeDTO(String projectName, String clientName, List<Employee> employees) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.employees = employees;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
