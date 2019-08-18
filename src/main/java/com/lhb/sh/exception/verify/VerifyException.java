package com.lhb.sh.exception.verify;

import com.lhb.sh.exception.BaseException;
import com.lhb.sh.util.enums.VerifyStaEnum;

public class VerifyException extends BaseException {

    public VerifyException(String message) {
        super(message);
    }

    public VerifyException(int code, String message) {
        super(code, message);
    }

    public VerifyException(VerifyStaEnum verifyStaEnum)
    {
        super(verifyStaEnum.getCode(),verifyStaEnum.getInfo());
    }
}
