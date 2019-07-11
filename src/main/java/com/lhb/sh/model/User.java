package com.lhb.sh.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;


@Data
public class User implements Serializable {
    private Integer id;

    @Length(min = 10, message = "your username is too short")
    private String username;

    @Email
    private String email;

    private Date emailVerifiedAt;

    @Length(min = 6)
    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;
}