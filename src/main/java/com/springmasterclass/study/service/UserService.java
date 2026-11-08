package com.springmasterclass.study.service;

import java.util.List;

import com.springmasterclass.study.dto.record.UserRequest;

import com.springmasterclass.study.dto.response.UserRp;

public interface UserService {
    void create(UserRequest rq);


    void update(String id, UserRequest rq);

    List<UserRp> index();

    void delete(String id);

} 