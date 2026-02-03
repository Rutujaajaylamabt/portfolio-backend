package com.portfolio.portfolio_backend.controller;

import com.portfolio.portfolio_backend.entity.Project;
import com.portfolio.portfolio_backend.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // ✅ THIS WAS MISSING
@RequestMapping("/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @RequestBody Project project
    ) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
