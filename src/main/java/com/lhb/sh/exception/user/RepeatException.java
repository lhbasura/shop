package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;

public class RepeatException extends UserException {

    private static final long serialVersionUID = 1L;

    public RepeatException(int code, String message) {
        super(code, message);
    }

    public RepeatException(String message) {
        super(message);
    }


    public RepeatException(AccountStaEnum registerRepeat) {
        super(registerRepeat);
    }
}
