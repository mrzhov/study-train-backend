package com.study.train.controller;

import com.study.train.beans.LoginBean;
import com.study.train.domain.Users;
import com.study.train.exceptions.ConflictException;
import com.study.train.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final UsersRepo usersRepo;

    @Autowired
    public AuthController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        List<Users> users = usersRepo.findAll();

        if (users.stream().anyMatch(userDb -> userDb.getUsername().equals(user.getUsername()))) {
            throw new ConflictException("Пользователь с таким именем уже существует");
        }

        return usersRepo.save(user);
    }

    @PostMapping("/login")
    public Users login(@RequestBody LoginBean body) {
        if (body == null || body.getUsername() == null || body.getPassword() == null) {
            throw new ConflictException("Логин и пароль - обязательные поля");
        }

        Users userFormDb = usersRepo.findByUsername(body.getUsername());

        if (userFormDb == null) {
            throw new ConflictException("Пользователь с таким именем не существует");
        }

        if (!Objects.equals(userFormDb.getPassword(), body.getPassword())) {
            throw new ConflictException("Неверный пароль");
        }

        return userFormDb;
    }
}
