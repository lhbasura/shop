package com.lhb.sh.exception;

import lombok.Data;

@Data
public class BaseException extends Exception{
    protected int code;
    protected String message;
    public BaseException(String message)
    {
        super(message);
    }
    public BaseException(int code,String message)
    {
        super(message);
        this.code=code;
        this.message=message;
    }
}
