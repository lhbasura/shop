/*Copyright ©  2017 Lyons. All rights reserved. */
package com.lhb.sh.util.enums;

/**
 * @Description: 用户常量
 * @ClassName: LoginstaEnum
 * @author: lyons<zhanglei>
 * @date: 2017年1月17日 下午4:25:04
 * @version: [1.0]
 */
public enum AccountStaEnum {
    disabled(2, "账户未启用"),  //状态码=2 : 启用
    unseller(3, "您不是卖家"),  //状态码=3 : 卖家
    success(200, "操作成功"),

    userNotFound(404, "用户不存在!"),
    nameNull(403, "用户名不能为空"),
    pswdNull(403, "密码不能为空"),
    failed(400, "用户名与密码不匹配"),
    repeat(205, " : 您早已登录啦"),

    registerRepeat(202, "该用户名已被注册"),
    registerExistence(202, "邮箱已被使用"),
    registerFailed(205, "注册失败，请重试");


    private int code;
    private String info;

    private AccountStaEnum(String info) {
        this.info = info;
    }

    private AccountStaEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

}
