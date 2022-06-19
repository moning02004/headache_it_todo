package com.headacheIT.todoList.Controllers;

import com.headacheIT.todoList.Models.HeadacheUser;
import com.headacheIT.todoList.Models.ResponseModel;
import com.headacheIT.todoList.Models.Todo;
import com.headacheIT.todoList.Models.TodoListResponse;
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
}
