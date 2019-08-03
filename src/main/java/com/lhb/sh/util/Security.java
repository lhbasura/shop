package com.lhb.sh.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {
    static BCryptPasswordEncoder encoder;

    static {
        encoder = new BCryptPasswordEncoder(4);
    }

    public static String compact(String username, String password) {
        return username + "|" + password;
    }

    public static String encode(String username, String password) {
        return encoder.encode(compact(username, password));
    }

    public static boolean isMatch(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

}
