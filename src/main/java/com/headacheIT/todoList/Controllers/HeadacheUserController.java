package com.headacheIT.todoList.Controllers;

import com.headacheIT.todoList.Models.HeadacheUser;
import com.headacheIT.todoList.Services.HeadacheUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class HeadacheUserController {
    @Autowired
    private HeadacheUserService headacheUserService;

    // 회원 정보
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<HeadacheUser> getUserInfo(@PathVariable int id) {
        Optional<HeadacheUser> user = headacheUserService.getUser(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // 회원 가입
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String registerUser(@RequestBody HeadacheUser form) {
        form.setRegisteredAt(LocalDateTime.now());
        HeadacheUser user = headacheUserService.saveUser(form);
        return user.getUsername();
    }

    // 회원 정보 수정
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public String updateUser(@PathVariable int id, @RequestBody HeadacheUser form) {
        Optional<HeadacheUser> user = headacheUserService.getUser(id);
        if (user.isPresent()) {
            if (form.getNickname() != null) user.get().setNickname(form.getNickname());
            if (form.getPassword() != null) user.get().setPassword(form.getPassword());
            headacheUserService.saveUser(user.get());
            return "성공";
        }
        return "사용자 정보가 없습니다.";
    }

    // 회원 삭제
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        Optional<HeadacheUser> user = headacheUserService.getUser(id);
        if (user.isPresent()) {
            headacheUserService.deleteUser(id);
            return "성공";
        }
        return "사용자 정보가 없습니다.";
    }
}
