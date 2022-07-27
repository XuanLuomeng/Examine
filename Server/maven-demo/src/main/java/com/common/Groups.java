package com.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Groups implements Serializable {
    //保证兼容性
    private static final long serialVersionUID = 1L;
    //编号
    private int id;
    //组别名
    private String groupName;
}
