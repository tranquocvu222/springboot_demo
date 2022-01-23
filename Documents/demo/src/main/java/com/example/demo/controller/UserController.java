package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> fetchUsers (@RequestParam(name ="department_id", defaultValue = "") Long departmentId) {
        return ResponseEntity.ok(userService.fetchUsersByDepartmentId(departmentId));
    }
}
