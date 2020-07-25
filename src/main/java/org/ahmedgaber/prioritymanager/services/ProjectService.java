package org.ahmedgaber.prioritymanager.services;


import org.ahmedgaber.prioritymanager.domain.Project;
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
        return projectRepository.save(project);

    }

}
