package com.workspace.aton_internship.user.repository;


import com.workspace.aton_internship.user.model.User;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final MultiValuedMap<Long, User> userByAccounts = new ArrayListValuedHashMap<>();
    private final MultiValuedMap<String, User> userByName = new ArrayListValuedHashMap<>();
    private final MultiValuedMap<Double, User> userByValue = new ArrayListValuedHashMap<>();


    @Override
    public User save(User user) {
        userByAccounts.put(user.getAccount(), user);
        userByName.put(user.getName(), user);
        userByValue.put(user.getValue(), user);
        return user;
    }

    @Override
    public User change(User from, User to) {
        if(to.getAccount() != null)
            to.setAccount(from.getAccount());
        if(to.getName() != null)
            to.setName(from.getName());
        if(to.getValue() != null)
            to.setValue(from.getValue());

        remove(from);
        return save(to);
    }

    @Override
    public void remove(User user) {
        userByAccounts.removeMapping(user.getAccount(), user);
        userByName.removeMapping(user.getName(), user);
        userByValue.removeMapping(user.getValue(), user);
    }

    @Override
    public Collection<User> findByVariable(Long account) {
        return userByAccounts.get(account);
    }

    @Override
    public Collection<User> findByVariable(String name) {
        return userByName.get(name);
    }

    @Override
    public Collection<User> findByVariable(Double value) {
        return userByValue.get(value);
    }

}
