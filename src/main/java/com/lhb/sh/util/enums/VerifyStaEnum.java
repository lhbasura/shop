package com.lhb.sh.util.enums;

public enum VerifyStaEnum {
    success(200, "success"),
    failed(403, "failed"),
    expired(401, "time out"),
    sigfault(403, "signature is fault");
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    private VerifyStaEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
