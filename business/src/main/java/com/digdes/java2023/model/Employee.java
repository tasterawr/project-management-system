package com.digdes.java2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {
    private UUID id;
    private String lastName;
    private String firstName;
    private String surName;
    private String account;
    private String email;
    private EmployeeStatus status;
}
