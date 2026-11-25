package com.thamires.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thamires.taskflow.dto.request.TaskRequestDTO;
import com.thamires.taskflow.dto.request.TaskUpdateRequestDTO;
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
    public TaskResponseDTO findTaskById(Long id) {
        Task task = findEntityById(id);                              

        return toResponseDTO(task);
    }

    //atualiza uma tarefa existente
    public TaskResponseDTO updateTask(Long id, TaskUpdateRequestDTO requestDTO) {
        Task task = findEntityById(id);

        task.setTitle(requestDTO.title());
        task.setDescription(requestDTO.description());
        task.setStatus(requestDTO.status());
        task.setPriority(requestDTO.priority());
        task.setDueDate(requestDTO.dueDate());

        Task updatedTask = taskRepository.save(task);

        return toResponseDTO(updatedTask);
    }

    //exclui uma tarefa
    public void deleteTask(Long id){
        if(!taskRepository.existsById(id)){
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    private Task findEntityById(Long id) {  
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
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
