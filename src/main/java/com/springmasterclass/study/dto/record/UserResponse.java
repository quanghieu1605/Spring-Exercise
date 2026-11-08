package com.springmasterclass.study.dto.record;

public record UserResponse(
        String id,
        String name,
        String address,
        String phone,
        String email,
        String username) {

}
