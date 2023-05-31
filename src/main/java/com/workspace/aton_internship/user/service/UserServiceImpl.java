package com.workspace.aton_internship.user.service;


import com.workspace.aton_internship.user.model.User;
import com.workspace.aton_internship.user.repository.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepositoryImpl userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User change(User from, User to) {
        return userRepository.change(from, to);
    }

    @Override
    public void remove(User user) {
        userRepository.remove(user);
    }

    @Override
    public Collection<User> findByAccount(Long account) {
        return userRepository.findByVariable(account);
    }

    @Override
    public Collection<User> findByName(String name) {
        return userRepository.findByVariable(name);
    }

    @Override
    public Collection<User> findByValue(Double value) {
        return userRepository.findByVariable(value);
    }
}
