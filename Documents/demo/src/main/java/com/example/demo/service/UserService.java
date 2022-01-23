package com.example.demo.service;

import com.example.demo.dto.UserRes;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserRes> fetchUsersByDepartmentId(final Long departmentId) {

        return userRepository.fetchUserByDepartmentId(departmentId)
                             .stream()
                             .map(UserMapper.INSTANCE::toUserRes)
                             .collect(Collectors.toList());
    }
}
