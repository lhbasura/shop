package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;

public class NonuniquenessException extends UserException {


    public NonuniquenessException(String message) {
        super(message);
    }

    public NonuniquenessException(int code, String message) {
        super(code, message);
    }

    public NonuniquenessException(AccountStaEnum accountStaEnum) {
        super(accountStaEnum);
    }
}
