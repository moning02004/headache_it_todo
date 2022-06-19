package com.headacheIT.todoList.Services;

import com.headacheIT.todoList.Models.HeadacheUser;
import com.headacheIT.todoList.Repositories.HeadacheUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeadacheUserService {
    @Autowired
    private HeadacheUserRepository headacheUserRepository;

    public Optional<HeadacheUser> getUser(int id) {
        return headacheUserRepository.findById(id);
    }

    public HeadacheUser saveUser(HeadacheUser user) {
        user = headacheUserRepository.save(user);
        return user;
    }

    public void deleteUser(int id) {
        headacheUserRepository.deleteById(id);
    }
}
