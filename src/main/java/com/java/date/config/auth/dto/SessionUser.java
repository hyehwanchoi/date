package com.java.date.config.auth.dto;

import java.io.Serializable;

import com.java.date.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
    private static final long serialVersionUID = -2461456096029403012L;
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}