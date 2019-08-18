package com.lhb.sh.exception.verify;

import com.lhb.sh.util.enums.VerifyStaEnum;

public class SignatureException extends VerifyException{

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(int code, String message) {
        super(code, message);
    }

    public SignatureException(VerifyStaEnum verifyStaEnum) {
        super(verifyStaEnum);
    }
}
