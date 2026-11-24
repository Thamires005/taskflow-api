package com.thamires.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thamires.taskflow.dto.request.TaskRequestDTO;
import com.thamires.taskflow.dto.response.TaskResponseDTO;
import com.thamires.taskflow.entity.Task;
import com.thamires.taskflow.enums.TaskStatus;
import com.thamires.taskflow.repository.TaskRepository;
import com.thamires.taskflow.exception.TaskNotFoundException;
import java.util.List;

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

        return toResponseDTO(savedTask);

    }
    public List<TaskResponseDTO> findAllTasks() {  //lista todas as tarefas
        return taskRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .toList();
    }

    public TaskResponseDTO findTaskById(Long id) {  //busca uma tarefa por ID
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return toResponseDTO(task);
    }

    private TaskResponseDTO toResponseDTO(Task task) {  //método privado que faz a conversão Entidade -> DTO
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt(),
                task.getDueDate()
        );
    }
}
