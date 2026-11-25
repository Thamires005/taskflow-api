package com.thamires.taskflow.dto.request;

import com.thamires.taskflow.enums.TaskPriority;
import com.thamires.taskflow.enums.TaskStatus;
import java.time.LocalDate;


public record TaskUpdateRequestDTO (
    String title,
    String description,
    TaskStatus status,
    TaskPriority priority,
    LocalDate dueDate
) {

}
