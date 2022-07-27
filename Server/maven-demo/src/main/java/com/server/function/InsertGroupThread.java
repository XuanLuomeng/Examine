package com.server.function;

import com.server.sql.InsertGroup;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;
/*
 * 开启线程：添加组别
 * 返回是否添加成功
 * */
public class InsertGroupThread implements Runnable{
    private Socket s;
    private String gourpName;

    public InsertGroupThread(Socket s,String gourpName) {
        this.s = s;
        this.gourpName = gourpName;
    }

    public void run() {
        try {
            //接收数据
            InsertGroup in = new InsertGroup(gourpName);
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
