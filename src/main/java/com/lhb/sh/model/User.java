package com.lhb.sh.model;

import java.util.Date;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    private Integer id;

    @NotNull
    private String username;

    @Email
    @NotNull
    private String email;

    private Date emailVerifiedAt;

    @Size(min = 6)
    @NotNull
    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;

    public boolean isVerified(){
        return emailVerifiedAt!=null;
    }

}