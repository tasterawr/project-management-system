package com.digdes.java2023.model;

import com.digdes.java2023.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
