package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends Exception {
    private static final long serialVersionUID = 1L;

    protected int code;
    protected String message;

    public UserException(String message) {
        super(message);
        this.message = message;
    }

    public UserException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public UserException(AccountStaEnum accountStaEnum) {
        this(accountStaEnum.getCode(), accountStaEnum.getInfo());
    }
}
