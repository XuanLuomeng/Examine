package com.tools;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * 工具类：客服端信息反馈
 * */
public class Feedback {
    private OutputStream oswServer;
    private String information;

    public Feedback(OutputStream oswServer, String information) throws IOException {
        this.oswServer = oswServer;
        this.information = information;
        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(oswServer));
        bwServer.write(information);
        bwServer.newLine();
        bwServer.flush();
        bwServer.close();
    }
}
