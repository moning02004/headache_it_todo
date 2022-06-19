package com.headacheIT.todoList.Repositories;

import com.headacheIT.todoList.Models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
