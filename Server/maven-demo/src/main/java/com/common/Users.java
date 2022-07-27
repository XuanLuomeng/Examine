package com.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    //保证兼容性
    private static final long serialVersionUID = 1L;
    //姓名
    private String name;
    //手机号码
    private String telephoneNumber;
    //电子邮箱
    private String email;
    //地址
    private String address;
    //组别编号
    private String groupName;
}
