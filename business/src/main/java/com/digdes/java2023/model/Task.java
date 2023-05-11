package com.digdes.java2023.model;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private String description;
    private Employee executor;
    private Integer requiredHours;
    private Date deadline;
    private TaskStatus status;
    private Employee author;
    private Date creationDate;
    private Date updateDate;

    public Task() {
    }

    public Task(UUID id, String name, String description, Employee executor, Integer requiredHours, Date deadline, TaskStatus status, Employee author, Date creationDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.executor = executor;
        this.requiredHours = requiredHours;
        this.deadline = deadline;
        this.status = status;
        this.author = author;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Employee getExecutor() {
        return executor;
    }

    public void setExecutor(Employee executor) {
        this.executor = executor;
    }

    public Integer getRequiredHours() {
        return requiredHours;
    }

    public void setRequiredHours(Integer requiredHours) {
        this.requiredHours = requiredHours;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
