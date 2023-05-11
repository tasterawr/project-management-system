package com.digdes.java2023.model;

import java.io.Serializable;
import java.util.UUID;

public class Employee implements Serializable {
    private UUID id;
    private String lastName;
    private String firstName;
    private String surName;
    private String account;
    private String email;
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(UUID id, String lastName, String firstName, String surName, String account, String email, EmployeeStatus status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
        this.account = account;
        this.email = email;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
