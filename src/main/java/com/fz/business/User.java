package com.fz.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;

    public User()
    {
        firstName = "";
        lastName = "";
        email = "";
    }
}
