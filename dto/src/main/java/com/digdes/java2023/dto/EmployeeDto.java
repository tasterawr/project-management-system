package com.digdes.java2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String id;
    private String lastName;
    private String firstName;
    private String surName;
    private String account;
    private String email;
    private String status;
}
