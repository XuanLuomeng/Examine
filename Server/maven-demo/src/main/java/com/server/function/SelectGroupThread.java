package com.server.function;

import com.server.sql.SelectGroup;
import com.common.Groups;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;

/*
 * 开启线程：查询组别
 * 结果：返回所有组别序号和组别名
 * */
public class SelectGroupThread implements Runnable{
    private Socket s;

    public SelectGroupThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            SelectGroup se = new SelectGroup();
            //传输数据
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            Groups group;
            //迭代器获取组别信息
            Iterator<Groups> it = se.getInformation().iterator();
            while(it.hasNext()) {
                group = it.next();
                bwServer.write(group.getId()+"\t");
                bwServer.write(group.getGroupName());
                bwServer.newLine();
                bwServer.flush();
            }
            bwServer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
