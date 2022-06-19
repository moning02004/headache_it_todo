package com.headacheIT.todoList.Repositories;

import com.headacheIT.todoList.Models.HeadacheUser;
import org.springframework.data.repository.CrudRepository;

public interface HeadacheUserRepository extends CrudRepository<HeadacheUser, Integer> {
}
