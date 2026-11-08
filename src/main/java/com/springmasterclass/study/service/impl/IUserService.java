package com.springmasterclass.study.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.record.UserResponse;
import com.springmasterclass.study.dto.response.UserRp;
import com.springmasterclass.study.entity.User;
import com.springmasterclass.study.mapper.UserMapper;
import com.springmasterclass.study.repository.UserRepository;
import com.springmasterclass.study.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(UserRequest rq) {
        userRepository.save(mapToEntity(rq));

    }

    @Override
    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not exist!");
        }
        userRepository.delete(user.get());

    }

    @Override
    public List<UserRp> index() {
        List<User> list = userRepository.findAll();

        return list.stream().map(this::mapToResponse).toList();
    }

    @Override
    public void update(String id, UserRequest rq) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not exist!");
        }

        User userUpdate = user.get();
        userUpdate.setName(rq.name());
        userUpdate.setPhone(rq.phone());
        userUpdate.setEmail(rq.email());
        userUpdate.setPassword(rq.password());
        userUpdate.setUsername(rq.username());
        userRepository.save(userUpdate);

    }

    private User mapToEntity(UserRequest rq) {
        return User.builder()
                .name(rq.name())
                .address(rq.address())
                .email(rq.email())
                .password(rq.password())
                .username(rq.username())
                .phone(rq.phone())

                .build();
    }

    private UserRp mapToResponse(User user) {
        // UserRp userRp = modelMapper.map(user, UserRp.class);
        return UserRp.builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .username(user.getUsername())
                .phone(user.getPhone())
                .build();
    }

    private UserResponse mapToResponseOfMapstruct(User user) {
        return userMapper.toResponse(user);
    }

}
