package com.lhb.sh.exception.user;

import com.lhb.sh.util.enums.AccountStaEnum;

public class NullValueException extends UserException
{
    private static final long serialVersionUID = 1L;

    public NullValueException(int code, String message)
    {
        super(code, message);
    }

    public NullValueException(String message)
    {
        super(message);
    }

    public NullValueException(AccountStaEnum nameNull) {
        super(nameNull);
    }
}
