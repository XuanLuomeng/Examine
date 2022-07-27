package com.client.function;

import com.common.Message;
import com.common.Users;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
* 进行TCP连接
* 并输入姓名查询
* */
public class ApplySelectUser {
    public ApplySelectUser(Socket s) throws IOException, ClassNotFoundException {
        //数据来自于输入
        System.out.print("请输入你要查找的人员姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        //封装输出流对象
        Message message = new Message();
        message.setNum("1");//选项一服务标志
        Users us = new Users();
        us.setName(name);//要查询的姓名
        message.setUser(us);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(message);
        //自定义结束标记
        s.shutdownOutput();
        //接收反馈
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        //获取包装的对象
        Message mess = (Message) ois.readObject();
        System.out.println("------------------------");
        System.out.println("姓名："+mess.getUser().getName());
        System.out.println("电话号码："+mess.getUser().getTelephoneNumber());
        System.out.println("电子邮件："+mess.getUser().getEmail());
        System.out.println("地址："+mess.getUser().getAddress());
        System.out.println("组名："+mess.getUser().getGroupName());
        oos.close();
        ois.close();
        s.close();
    }
}
