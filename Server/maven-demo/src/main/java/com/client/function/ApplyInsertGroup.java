package com.client.function;

import com.common.Groups;
import com.common.Message;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
 * 进行TCP连接
 * 填写新组别姓名
 * 等待服务器回应是否添加成功
 * */
public class ApplyInsertGroup {
    public ApplyInsertGroup(Socket s) throws IOException {
        //创建输入
        Scanner sc = new Scanner(System.in);
        //数据来自于输入
        System.out.print("请输入你要添加的新组别名：");
        String newGroupName = sc.nextLine();
        //封装输出流对象
        Message message = new Message();
        message.setNum("6");//选项服务标志
        Groups grou = new Groups();
        grou.setGroupName(newGroupName);
        message.setGroup(grou);
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
