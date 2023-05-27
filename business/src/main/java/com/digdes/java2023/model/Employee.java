package com.digdes.java2023.model;

import com.digdes.java2023.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private UUID id;
    private String lastName;
    private String firstName;
    private String surName;
    private String account;
    private String email;
    private EmployeeStatus status;
}
