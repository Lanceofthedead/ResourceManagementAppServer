package com.example.resourcemanagementapp.service;

import com.example.resourcemanagementapp.dto.ProjectEmployeeDTO;
import com.example.resourcemanagementapp.model.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    List<Project> projectList();

    public Project getProjectById(Long projectId);

    public Project createProject(Project address);

    public Project updateProject(Long projectId, Project projectRequest);

    public ResponseEntity<?> deleteProject(Long projectId);

    List<ProjectEmployeeDTO> getAllProjectEmployee();

    public ProjectEmployeeDTO getProjectEmployee(Long projectId);
}
