package com.workspace.aton_internship.user.service;

import com.workspace.aton_internship.user.model.User;

import java.util.Collection;

public interface UserService {

    User create(User user);

    User change(User from, User to);

    void remove(User user);

    Collection<User> findByAccount(Long account);

    Collection<User> findByName(String name);

    Collection<User> findByValue(Double value);
}
