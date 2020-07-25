package org.ahmedgaber.prioritymanager.web;


import org.ahmedgaber.prioritymanager.domain.Project;
import org.ahmedgaber.prioritymanager.exceptions.MapValidationError;
import org.ahmedgaber.prioritymanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationError mapValidationError;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
        mapValidationError = new MapValidationError();
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = MapValidationError.getResponseEntity(result);
        if (errorMap != null) return errorMap;

        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
