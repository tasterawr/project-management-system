package com.digdes.java2023.model;

import com.digdes.java2023.enums.TeamRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private UUID id;
    private Project project;
    private Map<TeamRole, Employee> members;
}
