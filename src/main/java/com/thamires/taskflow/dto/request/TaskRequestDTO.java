package com.thamires.taskflow.dto.request;

import java.time.LocalDate;

import com.thamires.taskflow.enums.TaskPriority;

public record TaskRequestDTO (
    String title,
    String description,
    TaskPriority priority,
    LocalDate dueDate

){

}
    
