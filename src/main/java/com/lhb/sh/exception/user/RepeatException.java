package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;

public class RepeatException extends UserException {

    public RepeatException(String message) {
        super(message);
    }

    public RepeatException(int code, String message) {
        super(code, message);
    }

    public RepeatException(AccountStaEnum accountStaEnum) {
        super(accountStaEnum);
    }
}
