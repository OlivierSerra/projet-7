package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    User update(User user);
    void deleteById(Integer id);
}
