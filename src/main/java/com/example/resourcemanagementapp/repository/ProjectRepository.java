package com.example.resourcemanagementapp.repository;


import com.example.resourcemanagementapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
