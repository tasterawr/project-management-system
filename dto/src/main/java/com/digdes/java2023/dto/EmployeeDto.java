package com.digdes.java2023.dto;

public class EmployeeDto {
    private String id;
    private String lastName;
    private String firstName;
    private String surName;
    private String account;
    private String email;
    private String status;

    public EmployeeDto() {
    }

    public EmployeeDto(String id, String lastName, String firstName, String surName, String account, String email, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.account = account;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
