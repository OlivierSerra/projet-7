package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
