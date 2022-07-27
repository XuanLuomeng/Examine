package com.web.server;

import com.web.networkProcessing.Processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 开启线程
 * */
public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    public void run() {
        //尝试获取输入输出流对象
        try (InputStream is = s.getInputStream()) {
            try (OutputStream os = s.getOutputStream()) {
                Processor processor = new Processor(is, os, s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            //处理完服务后(或服务器出问题)关闭线程
            try {
                s.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
