package com.thamires.taskflow.controller;

import com.thamires.taskflow.dto.request.TaskRequestDTO;
import com.thamires.taskflow.dto.response.TaskResponseDTO;
import com.thamires.taskflow.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO requestDTO) {
        TaskResponseDTO response = taskService.createTask(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    
}
