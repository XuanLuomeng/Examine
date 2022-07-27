package com.server.function;

import com.common.Users;
import com.server.sql.UpdateUser;
import com.tools.Feedback;

import java.io.*;
import java.net.Socket;
/*
 * 开启线程：修改人员
 * 返回是否修改成功
 * */
public class UpdateUserThread implements Runnable{
    private Socket s;
    private Users user;
    private String oldName;

    public UpdateUserThread(Socket s,String oldName,Users user) {
        this.s = s;
        this.oldName = oldName;
        this.user = user;
    }

    public void run() {
        try {
            //接收数据
            UpdateUser in = new UpdateUser(oldName, user.getName(), user.getTelephoneNumber(), user.getEmail(),
                    user.getAddress(), user.getGroupName());
            //反馈数据
            Feedback fb = new Feedback(s.getOutputStream(),"修改成功");
        } catch (Exception e) {
            try {
                //反馈数据
                Feedback fb = new Feedback(s.getOutputStream(),"修改成功");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}
