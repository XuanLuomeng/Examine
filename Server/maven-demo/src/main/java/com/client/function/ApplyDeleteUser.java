package com.client.function;

import com.common.Message;
import com.common.Users;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ApplyDeleteUser {
    public ApplyDeleteUser(Socket s) throws IOException {
        //数据来自于输入
        System.out.print("请输入你要删除的人员姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        //封装输出流对象
        Message message = new Message();
        message.setNum("4");//选项一服务标志
        Users us = new Users();
        us.setName(name);//要删除的姓名
        message.setUser(us);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(message);
        //自定义结束标记
        s.shutdownOutput();
        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String user;
        while ((user = brClient.readLine()) != null) {
            System.out.println(user);
        }
        oos.close();
        brClient.close();
        s.close();
    }
}
