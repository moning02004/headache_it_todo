package com.headacheIT.todoList.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListResponse implements ResponseModel {
    private Iterable<Todo> data;
    private int count;
}
