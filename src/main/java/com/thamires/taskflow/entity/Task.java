package com.thamires.taskflow.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;

import jakarta.persistence.Table;
import jakarta.persistence.Id;

import com.thamires.taskflow.enums.TaskPriority;
import com.thamires.taskflow.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private TaskPriority priority;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

    //método gera createdAt automaticamente
    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

}