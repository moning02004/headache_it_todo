package com.headacheIT.todoList.Services;

import com.headacheIT.todoList.Models.Todo;
import com.headacheIT.todoList.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodoById(int id) {
        return todoRepository.findById(id);
    }
}
