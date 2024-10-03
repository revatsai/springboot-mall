package com.revatsai.springbootmall.service;

import com.revatsai.springbootmall.dto.UserLoginRequest;
import com.revatsai.springbootmall.dto.UserRegisterRequest;
import com.revatsai.springbootmall.model.User;

public interface UserService {
    User login(UserLoginRequest userLoginRequest);

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
