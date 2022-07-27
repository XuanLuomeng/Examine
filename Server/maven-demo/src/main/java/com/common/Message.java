package com.common;

import lombok.Data;

import java.io.Serializable;

/*
* 选择服务消息
* */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    //服务选择
    private String num;
    //旧名
    private String oldName;
    //用户
    private Users user;
    //组别
    private Groups group;
    //旧组名
    private String oldGroupName;
}
