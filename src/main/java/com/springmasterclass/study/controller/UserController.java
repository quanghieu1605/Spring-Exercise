package com.springmasterclass.study.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springmasterclass.study.common.ApiResponse;
import com.springmasterclass.study.common.BaseController;
import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.response.UserRp;
import com.springmasterclass.study.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping
    public ApiResponse<List<UserRp>> showListUsers() {
        return createSuccessResponse(userService.index());
    }

    @PostMapping
    public ApiResponse<String> creatNewUser(@Valid @RequestBody UserRequest userRq) {
        userService.create(userRq);
        return createSuccessResponse("Create a new user successfull");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody UserRequest userRq) {
        userService.update(id, userRq);
        return new ResponseEntity<>("Update user successfull", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return new ResponseEntity<>("Delete a user succesfully", HttpStatus.OK);
    }

}
