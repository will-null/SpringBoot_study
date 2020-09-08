package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //根据id查用户信息
    User findById();
}
