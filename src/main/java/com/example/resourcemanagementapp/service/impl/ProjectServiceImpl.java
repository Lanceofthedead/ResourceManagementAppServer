package com.example.resourcemanagementapp.service.impl;

import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Project;
import com.example.resourcemanagementapp.repository.ProjectRepository;
import com.example.resourcemanagementapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> projectList() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(@PathVariable(value = "projectId") Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectId" + projectId + " not Found"));
    }

    @Override
    public Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project projectRequest) {
        projectRequest.setProjectId(projectId);
        return projectRepository.save(projectRequest);
    }

    @Override
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectRepository.findById(projectId).map(project -> {
            projectRepository.delete(project);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ProjectId " + projectId + " not found"));
    }
}
