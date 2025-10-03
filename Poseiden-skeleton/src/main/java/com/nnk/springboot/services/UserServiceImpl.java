package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {

        this.userRepo = userRepo;
    }

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
        userRepo.deleteById(id);
    }
}
