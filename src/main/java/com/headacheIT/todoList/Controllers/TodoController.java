package com.headacheIT.todoList.Controllers;

import com.headacheIT.todoList.Models.*;
import com.headacheIT.todoList.Services.HeadacheUserService;
import com.headacheIT.todoList.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    // list todos
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getTodoInfo() {
        List<Todo> todo = (List<Todo>) todoService.getTodoList();
        TodoListResponse data = new TodoListResponse();
        data.setData(todo);
        data.setCount(todo.size());
        return ResponseEntity.ok(data);
    }

    // create todos
    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createTodoInfo(@RequestBody Todo form) {
        form.setRegisteredAt(LocalDateTime.now());
        form.setStatus(1);
        Todo todo = todoService.saveTodo(form);

        TodoCreateResponse responseModel = new TodoCreateResponse();
        responseModel.setTitle(todo.getTitle());
        responseModel.setDescription(todo.getDescription());
        responseModel.setRegisteredAt(todo.getRegisteredAt());
        responseModel.setDueDate(todo.getDueDate());
        responseModel.setUserId(todo.getUserId());
        return ResponseEntity.ok(responseModel);
    }
}
