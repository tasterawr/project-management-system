package com.digdes.java2023.model;

import java.util.Map;
import java.util.UUID;

public class Team {
    private UUID id;
    private Project project;
    private Map<TeamRole, Employee> members;

    public Team() {
    }

    public Team(UUID id, Project project, Map<TeamRole, Employee> members) {
        this.id = id;
        this.project = project;
        this.members = members;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Map<TeamRole, Employee> getMembers() {
        return members;
    }

    public void setMembers(Map<TeamRole, Employee> members) {
        this.members = members;
    }
}
