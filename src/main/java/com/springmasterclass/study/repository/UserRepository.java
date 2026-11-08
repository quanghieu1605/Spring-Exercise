package com.springmasterclass.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmasterclass.study.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    void deleteById(String id);
}
