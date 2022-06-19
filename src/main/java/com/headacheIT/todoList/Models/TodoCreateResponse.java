package com.headacheIT.todoList.Models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoCreateResponse implements ResponseModel {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime registeredAt;

    private int userId;
}
