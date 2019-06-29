package com.lhb.sh.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {
    public static String encode(String username,String password)
    {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(4);
        return encoder.encode(username+"|"+password);
    }

}
