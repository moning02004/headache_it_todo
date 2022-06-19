package com.headacheIT.todoList.Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoInfoResponse implements ResponseModel {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime registeredAt;
    private LocalDateTime editedAt;

    private int userId;

    public TodoInfoResponse(Todo todo) {
        this.setTitle(todo.getTitle());
        this.setDescription(todo.getDescription());
        this.setDueDate(todo.getDueDate());
        this.setRegisteredAt(todo.getRegisteredAt());
        this.setUserId(todo.getUserId());
        this.setEditedAt(todo.getEditedAt());
    }
}
