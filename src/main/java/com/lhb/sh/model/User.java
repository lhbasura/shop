package com.lhb.sh.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class User implements Serializable {
    private Integer id;

    @Size(min = 6, message = "your username is too short")
    private String username;

    @Email
    private String email;

    private Date emailVerifiedAt;

    @Size(min = 6)
    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;
}