package com.headacheIT.todoList.Services;

import com.headacheIT.todoList.Models.Todo;
import com.headacheIT.todoList.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodoList() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodoById(int id) {
        return todoRepository.findById(id);
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }
}
