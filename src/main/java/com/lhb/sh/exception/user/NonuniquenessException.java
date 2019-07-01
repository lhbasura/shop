package com.lhb.sh.exception.user;

public class NonuniquenessException extends UserException {
    private static final long serialVersionUID = 1L;

    public NonuniquenessException(int code, String message) {
        super(code, message);
    }

    public NonuniquenessException(String message) {
        super(message);
    }


}
