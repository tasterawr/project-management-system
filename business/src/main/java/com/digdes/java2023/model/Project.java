package com.digdes.java2023.model;

import java.util.UUID;

public class Project {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private ProjectStatus status;

    public Project() {

    }

    public Project(UUID id, String code, String name, String description, ProjectStatus status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
