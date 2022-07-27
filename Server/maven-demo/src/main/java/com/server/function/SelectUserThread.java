package com.server.function;

import com.common.Message;
import com.server.sql.SelectUser;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;

/*
 * 开启线程：查询人员
 * 结果：返回查询人员的有关信息
 * */
public class SelectUserThread implements Runnable {
    private Socket s;
    private String name;

    public SelectUserThread(Socket s, String name) {
        this.s = s;
        this.name = name;
    }

    public void run() {
        try {
            //接收数据
            SelectUser se = new SelectUser(name);
            //封装输出流对象,传输数据
            Message message = new Message();
            message.setUser(se.getUser());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (Exception e) {
            try {
                //反馈数据
                Feedback fb = new Feedback(s.getOutputStream(),"查无此人");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
