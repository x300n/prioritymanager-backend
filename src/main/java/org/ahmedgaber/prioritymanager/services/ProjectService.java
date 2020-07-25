package org.ahmedgaber.prioritymanager.services;


import org.ahmedgaber.prioritymanager.domain.Project;
import org.ahmedgaber.prioritymanager.exceptions.ProjectException;
import org.ahmedgaber.prioritymanager.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectException("Project ID '" + project.getProjectIdentifier().toUpperCase()+ "' already exists");
        }
    }

}
