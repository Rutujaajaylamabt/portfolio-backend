package com.portfolio.portfolio_backend.service;

import com.portfolio.portfolio_backend.entity.Project;
import com.portfolio.portfolio_backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // UPDATE
    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        existingProject.setTitle(updatedProject.getTitle());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setTechStack(updatedProject.getTechStack());
        existingProject.setGithubUrl(updatedProject.getGithubUrl());

        return projectRepository.save(existingProject);
    }

    // DELETE
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
