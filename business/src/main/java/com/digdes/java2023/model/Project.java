package com.digdes.java2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private ProjectStatus status;
}
