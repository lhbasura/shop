package com.lhb.sh.exception.verify;

import com.lhb.sh.util.enums.VerifyStaEnum;

public class ExpiredException extends VerifyException {
    public ExpiredException(String message) {
        super(message);
    }

    public ExpiredException(int code, String message) {
        super(code, message);
    }

    public ExpiredException(VerifyStaEnum verifyStaEnum) {
        super(verifyStaEnum);
    }
}
