package com.lhb.sh.exception.user;

import com.lhb.sh.exception.BaseException;
import com.lhb.sh.util.enums.AccountStaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends BaseException {


    public UserException(String message) {
        super(message);
    }

    public UserException(int code, String message) {
        super(code, message);
    }
    public UserException(AccountStaEnum accountStaEnum) {
        super(accountStaEnum.getCode(), accountStaEnum.getInfo());
    }
}
