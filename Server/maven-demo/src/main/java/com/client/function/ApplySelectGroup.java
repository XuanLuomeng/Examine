package com.client.function;

import com.common.Message;

import java.io.*;
import java.net.Socket;
/*
 * 进行TCP连接
 * 并输入组别查询
 * */
public class ApplySelectGroup {
    public ApplySelectGroup(Socket s) throws IOException {
        //封装输出流对象
        Message message = new Message();
        message.setNum("5");//选项服务标志
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
