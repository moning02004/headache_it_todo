package com.headacheIT.todoList.Services;

import com.headacheIT.todoList.Models.Todo;
import com.headacheIT.todoList.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> getTodoList() {
        return todoRepository.findAll();
    }
}
