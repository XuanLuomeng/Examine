package com.web.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器开始
 * */
public class Server {

    public static void main(String[] args) throws IOException {
        //服务器端口
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("等待客户端连接……");
        while (true) {
            //接受线程
            Socket s = serverSocket.accept();
            System.out.println("客户端：" + s.getLocalAddress() + "请求服务器连接");
            System.out.println("线程：" + s.getRemoteSocketAddress() + "正在处理……");
            //开始线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
