package com.lhb.sh.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8637628296175218837L;
    private Integer id;

    @NotNull
    private String username;

    @Email(message = "invalid mail")
    @NotNull
    private String email;

    private Date emailVerifiedAt;

    @Size(min = 6, message = "password must longer then 6 character")
    @NotNull
    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;

    public boolean isVerified() {
        return emailVerifiedAt != null;
    }

}