package com.example.resourcemanagementapp.model;


import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="projectId")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;


    @Column(name = "client_name")
    private String clientName;


    @ManyToMany(mappedBy = "projects")
    @JsonIgnore
    private List<Employee> employees;



    public Project() {
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
