package com.headacheIT.todoList.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todo")
public class Todo implements ResponseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "edited_at")
    private LocalDateTime editedAt;

    @Column(name = "user_id")
    private int userId;

    private int status;
}
