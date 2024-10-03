package com.revatsai.springbootmall.dao;

import com.revatsai.springbootmall.dto.UserRegisterRequest;
import com.revatsai.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
