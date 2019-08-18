package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;

public class NullValueException extends UserException {


    public NullValueException(String message) {
        super(message);
    }

    public NullValueException(int code, String message) {
        super(code, message);
    }

    public NullValueException(AccountStaEnum accountStaEnum) {
        super(accountStaEnum);
    }
}
