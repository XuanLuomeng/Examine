package com.server.function;

import com.common.Users;
import com.server.sql.InsertUser;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;
/*
* 开启线程：添加人员
* 返回是否添加成功
* */
public class InsertUserThread implements Runnable{
    private Socket s;
    private Users user;

    public InsertUserThread(Socket s, Users user) {
        this.s = s;
        this.user = user;
    }

    public void run() {
        try {
            //接收数据
            InsertUser in = new InsertUser(user.getName(), user.getTelephoneNumber(),
                    user.getEmail(), user.getAddress(), user.getGroupName());
            //反馈数据
            Feedback fb = new Feedback(s.getOutputStream(),"添加成功");
        } catch (Exception e) {
            try {
                //反馈数据
                Feedback fb = new Feedback(s.getOutputStream(),"添加失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
