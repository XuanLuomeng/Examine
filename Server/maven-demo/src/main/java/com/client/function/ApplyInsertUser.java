package com.client.function;

import com.common.Message;
import com.common.Users;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
* 进行TCP连接
* 填写新人员信息
* 等待服务器回应是否添加成功
* */
public class ApplyInsertUser {
    public ApplyInsertUser(Socket s) throws Exception {
        //创建输入
        Scanner sc = new Scanner(System.in);
        //数据来自于输入
        System.out.print("请输入你要添加的人员姓名：");
        String newName = sc.nextLine();
        System.out.print("请输入你要添加的人员电话号码：");
        String newTelephoneNumber = sc.nextLine();
        System.out.print("请输入你要添加的人员电子邮件：");
        String newEmail = sc.nextLine();
        System.out.print("请输入你要添加的人员地址：");
        String newAddress = sc.nextLine();
        System.out.print("请输入你要添加的人员组别：");
        String newGroupName = sc.nextLine();
        //封装输出流对象
        Message message = new Message();
        message.setNum("2");//选项服务标志
        Users us = new Users();
        us.setName(newName);//要添加的姓名
        us.setTelephoneNumber(newTelephoneNumber);//要添加的电话号码
        us.setEmail(newEmail);//要添加的电子邮件
        us.setAddress(newAddress);//要添加的地址
        us.setGroupName(newGroupName);//要添加的姓名
        message.setUser(us);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.writeObject(message);
        //自定义结束标记
        s.shutdownOutput();
        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(brClient);
        oos.close();
        brClient.close();
        s.close();
    }
}
