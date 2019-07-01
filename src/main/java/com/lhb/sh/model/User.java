package com.lhb.sh.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private String email;

    private Date emailVerifiedAt;

    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;
}