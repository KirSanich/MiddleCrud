package com.example.middlecrud.service;

import com.example.middlecrud.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(Long id);
    void deleteUser(Long id);
    User updateUser(User user);

}