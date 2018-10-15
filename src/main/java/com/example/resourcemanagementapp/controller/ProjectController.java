package com.example.resourcemanagementapp.controller;

import com.example.resourcemanagementapp.exception.ResourceNotFoundException;
import com.example.resourcemanagementapp.model.Project;
import com.example.resourcemanagementapp.repository.ProjectRepository;
import com.example.resourcemanagementapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {


    private ProjectService projectService;

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    //Get all projects by employee
    @GetMapping("/list")
    public List<Project> projectList(){
        return projectService.projectList();
    }


    // get a project
    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable(value = "projectId") Long projectId){
        return projectService.getProjectById(projectId);
    }


    //Create a project
    @PostMapping(value = "/add")
    public Project createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }


    // update a project
    @PutMapping("/update/{projectId}")
    public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project projectRequest){
        return projectService.updateProject(projectId, projectRequest);
    }


    //Delete a project
    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectService.deleteProject(projectId);
    }
}
