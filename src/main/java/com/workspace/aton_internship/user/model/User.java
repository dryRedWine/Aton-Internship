package com.workspace.aton_internship.user.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    @Positive
    private Long account;

    @NotBlank
    private String name;

    @PositiveOrZero
    private Double value;

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(account, user.account) && Objects.equals(name, user.name) && Objects.equals(value, user.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, name, value);
    }
}
