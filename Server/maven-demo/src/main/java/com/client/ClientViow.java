package com.client;

import com.client.function.*;

import java.net.Socket;
import java.util.Scanner;

public class ClientViow {
    public ClientViow() throws Exception {
        int instructions;
        //创建客户端
        Socket s = new Socket("Luo-XuanWei", 10086);
        System.out.println("已连接上服务器……");
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("1.查询人员");
        System.out.println("2.添加人员");
        System.out.println("3.修改人员");
        System.out.println("4.删除人员");
        System.out.println("5.查看组别");
        System.out.println("6.添加组别");
        System.out.println("7.修改组别");
        System.out.println("其余数字:退出");
        System.out.println("------------------------");
        System.out.print("指令：");
        instructions = sc.nextInt();
        switch (instructions) {
            case 1:
                new ApplySelectUser(s);
                break;
            case 2:
                new ApplyInsertUser(s);
                break;
            case 3:
                new ApplyUpdateUser(s);
                break;
            case 4:
                new ApplyDeleteUser(s);
                break;
            case 5:
                new ApplySelectGroup(s);
                break;
            case 6:
                new ApplyInsertGroup(s);
                break;
            case 7:
                new ApplyUpdateGroup(s);
                break;
            default:
                System.exit(0);
        }
    }
}
