package com.server.function;

import com.server.sql.UpdateGroup;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;

/*
 * 开启线程：修改组别
 * 返回是否修改成功
 * */
public class UpdateGroupThread implements Runnable {
    private Socket s;
    private String newGroupName;
    private String oldGroupName;

    public UpdateGroupThread(Socket s, String oldGroupName, String newGroupName) {
        this.s = s;
        this.newGroupName = newGroupName;
        this.oldGroupName = oldGroupName;
    }

    public void run() {
        try {
            //接收数据
            UpdateGroup in = new UpdateGroup(oldGroupName, newGroupName);
            //反馈数据
            Feedback fb = new Feedback(s.getOutputStream(),"修改成功");
        } catch (Exception e) {
            try {
                //反馈数据
                Feedback fb = new Feedback(s.getOutputStream(),"修改失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
