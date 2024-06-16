package com.workspace.aton_internship.user.controller;


import com.workspace.aton_internship.user.model.User;
import com.workspace.aton_internship.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/data/users")
public class UserController {

    public final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid User user) {
        log.info("Create new user account={}, name={}, value={}", user.getAccount(), user.getName(), user.getValue());
        return userService.create(user);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public User change(@RequestBody @Valid User from,
                       @RequestParam(name = "account", required = false) @Positive Long account,
                       @RequestParam(name = "name", required = false) @NotBlank String name,
                       @RequestParam(name = "value", required = false) @PositiveOrZero Double value) {
        log.info("Change user");
        return userService.change(from, new User(account, name, value));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void remove(@RequestBody @Valid User user) {
        log.info("Delete user account={}, name={}, value={}", user.getAccount(), user.getName(), user.getValue());
        userService.remove(user);
    }

    @GetMapping("/account/{account}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> findByVariable(@PathVariable @Positive Long account) {
        log.info("Find user by account={}", account);
        return userService.findByAccount(account);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> findByVariable(@PathVariable @NotBlank String name) {
        log.info("Find user by name={}", name);
        return userService.findByName(name);
    }

    @GetMapping("/value/{value}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> findByVariable(@PathVariable @PositiveOrZero Double value) {
        log.info("Find user by value={}", value);
        return userService.findByValue(value);
    }
}
