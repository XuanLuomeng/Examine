package com.server.function;

import com.server.sql.DeleteUser;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;
/*
 * 开启线程：删除人员
 * 结果：返回删除是否成功
 * */
public class DeleteUserThread implements Runnable{
    private Socket s;
    private String name;

    public DeleteUserThread(Socket s,String name) {
        this.s = s;
        this.name = name;
    }

    public void run() {
        try {
            //接收数据
            DeleteUser de = new DeleteUser(name);
            //反馈数据
            Feedback fb = new Feedback(s.getOutputStream(),"删除成功");
        } catch (Exception e) {
            try {
                //反馈数据
                Feedback fb = new Feedback(s.getOutputStream(),"删除失败（可能没有此用户……）");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
