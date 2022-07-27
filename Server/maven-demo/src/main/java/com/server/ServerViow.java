package com.server;

import com.common.Message;
import com.server.function.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerViow {
    public ServerViow() throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(10086);
        while (true) {
            //监听客户连接，返回一个Socket对象
            System.out.println("启动服务器……");
            System.out.println("等待客户连接……");
            Socket s = ss.accept();
            System.out.println("客户端"+s.getLocalAddress()+"已连接到服务器");
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            //获取包装的对象
            Message message = (Message) ois.readObject();
            switch (message.getNum()) {
                case "1":
                    //线程，查询用户的姓名
                    new Thread(new SelectUserThread(s, message.getUser().getName())).start();
                    break;
                case "2":
                    //线程，添加用户的所有信息
                    new Thread(new InsertUserThread(s, message.getUser())).start();
                    break;
                case "3":
                    //线程，需要修改信息的姓名以及所有新信息
                    new Thread(new UpdateUserThread(s, message.getOldName(), message.getUser())).start();
                    break;
                case "4":
                    //线程，需要删除信息的姓名
                    new Thread(new DeleteUserThread(s, message.getUser().getName())).start();
                    break;
                case "5":
                    //线程（仅仅是查询所有组别，量少所有没有任何参数，单纯把所有组别序号以及姓名的信息传输给客户端）
                    new Thread(new SelectGroupThread(s)).start();
                    break;
                case "6":
                    //线程，新的组别名
                    new Thread(new InsertGroupThread(s,message.getGroup().getGroupName())).start();
                    break;
                default:
                    //线程，旧组别名，新组别名（非法输入在客户端就已经解决，所以这边直接用default搞定第七序号服务）
                    new Thread(new UpdateGroupThread(s,message.getOldGroupName(),message.getGroup().getGroupName())).start();
            }
        }
    }
}
