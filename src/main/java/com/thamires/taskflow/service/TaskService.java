package com.thamires.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thamires.taskflow.dto.request.TaskRequestDTO;
import com.thamires.taskflow.dto.response.TaskResponseDTO;
import com.thamires.taskflow.entity.Task;
import com.thamires.taskflow.enums.TaskStatus;
import com.thamires.taskflow.repository.TaskRepository;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDTO createTask(TaskRequestDTO requestDTO)  {

        Task task = new Task();
        task.setTitle(requestDTO.title());
        task.setDescription(requestDTO.description());
        task.setPriority(requestDTO.priority());
        task.setDueDate(requestDTO.dueDate());
        task.setStatus(TaskStatus.PENDING);

        Task savedTask = taskRepository.save(task);

        return new TaskResponseDTO(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus(),
                savedTask.getPriority(),
                savedTask.getCreatedAt(),
                savedTask.getDueDate()
        );
     }
}
