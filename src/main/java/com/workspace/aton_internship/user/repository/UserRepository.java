package com.workspace.aton_internship.user.repository;


import com.workspace.aton_internship.user.model.User;

import java.util.Collection;

public interface UserRepository {

    User save(User user);

    User change(User from, User to);

    void remove(User user);

    Collection<User> findByVariable(Long account);

    Collection<User> findByVariable(String name);

    Collection<User> findByVariable(Double value);
}
