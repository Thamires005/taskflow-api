package com.thamires.taskflow.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.thamires.taskflow.enums.TaskPriority;
import com.thamires.taskflow.enums.TaskStatus;

public record TaskResponseDTO (
    Long id,
    String title,
    String description,
    TaskStatus status,
    TaskPriority priority,
    LocalDateTime createdAt,
    LocalDate dueDate
){

}

