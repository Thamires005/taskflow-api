package com.thamires.taskflow.controller;

import com.thamires.taskflow.dto.request.TaskRequestDTO;
import com.thamires.taskflow.dto.request.TaskUpdateRequestDTO;
import com.thamires.taskflow.dto.response.TaskResponseDTO;
import com.thamires.taskflow.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }  

    //PUT : atualizar
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(
            @PathVariable Long id, 
            @RequestBody TaskUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(taskService.updateTask(id, requestDTO));

    }

    //DELETE : excluir
    @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
    }
}
