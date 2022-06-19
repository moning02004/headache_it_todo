package com.headacheIT.todoList.Controllers;

import com.headacheIT.todoList.Models.ResponseModel;
import com.headacheIT.todoList.Models.Todo;
import com.headacheIT.todoList.Models.TodoInfoResponse;
import com.headacheIT.todoList.Models.TodoListResponse;
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
    public ResponseEntity<ResponseModel> getTodoList() {
        List<Todo> todo = (List<Todo>) todoService.getTodoList();
        TodoListResponse data = new TodoListResponse();
        data.setData(todo);
        data.setCount(todo.size());
        return ResponseEntity.ok(data);
    }

    // create todos
    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> createTodo(@RequestBody Todo form) {
        form.setRegisteredAt(LocalDateTime.now());
        form.setStatus(1);
        Todo todo = todoService.saveTodo(form);

        TodoInfoResponse responseModel = new TodoInfoResponse(todo);
        return ResponseEntity.ok(responseModel);
    }

    // get todo by id
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> getTodoInfo(@PathVariable int id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (todo.isPresent()) {
            TodoInfoResponse response = new TodoInfoResponse(todo.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // patch todo by id
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<ResponseModel> updateTodoInfo(@PathVariable int id, @RequestBody Todo form) {
        Optional<Todo> todo = todoService.getTodoById(id);
        if (todo.isPresent()) {
            if (form.getTitle() != null) todo.get().setTitle(form.getTitle());
            if (form.getDescription() != null) todo.get().setDescription(form.getDescription());
            if (form.getDueDate() != null) todo.get().setDueDate(form.getDueDate());
            todo.get().setEditedAt(LocalDateTime.now());
            Todo updatedTodo = todoService.saveTodo(todo.get());

            TodoInfoResponse response = new TodoInfoResponse(updatedTodo);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
