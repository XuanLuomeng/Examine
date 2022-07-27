package com.web.networkProcessing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/*
 * 响应协议
 * */
public class Response {
    private OutputStream os;//输出流
    private Request request;//暂时拿来获取文件后缀，后期再看看能不能优化代码结构

    public Response(OutputStream os, Request request) {
        this.os = os;
        this.request = request;
    }

    //sign用来区分是GET请求(1)还是POST请求(2),code区分是404还是200
    public void write(String url, int sign, int code) throws Exception {
        if (sign == 2) {
            //处理Post请求
            doPost(url, code);
        } else {
            //处理Get请求
            doGet(url, code);
        }
    }

    //当输出的是get请求传输html时进行以下操作
    private void html(String url, int code) throws IOException {
        //获取正文内容
        BufferedReader br = new BufferedReader(new FileReader(url));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            data.append(line);
        }
        //获取html内容长度字符串以及日期时间字符串
        int length = data.toString().getBytes(StandardCharsets.UTF_8).length;
        String date = "Date:Sat, " + new Date() + "\r\n";
        String cleng = "Content-Length: " + length + "\r\n";
        //开始输出内容
        //区分404还是200
        if (code == 200) {
            os.write("HTTP/1.1 200 OK\r\n".getBytes(StandardCharsets.UTF_8));
        } else if (code == 404) {
            os.write("HTTP/1.1 404 NOT FOUND\r\n".getBytes(StandardCharsets.UTF_8));
        }
        os.write("Connection: keep-alive\r\n".getBytes(StandardCharsets.UTF_8));
        os.write("Content-Type: text/html;charset=UTF-8\r\n".getBytes(StandardCharsets.UTF_8));
        os.write(date.getBytes(StandardCharsets.UTF_8));
        os.write(cleng.getBytes(StandardCharsets.UTF_8));
        os.write("Access-Control-Allow-Origin:*\r\n".getBytes(StandardCharsets.UTF_8));
        os.write("\r\n".getBytes(StandardCharsets.UTF_8));
        //正文内容
        os.write(data.toString().getBytes(StandardCharsets.UTF_8));
        os.flush();
        br.close();
    }

    //当请求的是get请求的图片时进行一下输出操作
    private void picture(String url, int code) throws IOException {
        //获取文件内容长度
        int length = 0;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(url));
        byte[] by = new byte[1024];
        int len;
        while ((len = bis.read(by)) != -1) {
            length += len;
        }
        bis.close();
        //获取文件内容长度字符串以及日期时间字符串
        String date = "Date:Sat, " + new Date() + "\r\n";
        String cleng = "Content-Length: " + length + "\r\n";
        //开始输出内容
        //区分404还是200
        if (code == 200) {
            os.write("HTTP/1.1 200 OK\r\n".getBytes(StandardCharsets.UTF_8));
        } else if (code == 404) {
            os.write("HTTP/1.1 404 NOT FOUND\r\n".getBytes(StandardCharsets.UTF_8));
        }
        os.write("Connection: keep-alive\r\n".getBytes(StandardCharsets.UTF_8));
        //根据图片类型不同输出不同的Content-Type
        if (request.getFileExtensions().equals("jpg")) {
            os.write("Content-Type: image/jpg;charset=UTF-8\r\n".getBytes(StandardCharsets.UTF_8));
        } else if (request.getFileExtensions().equals("png")) {
            os.write("Content-Type: image/png;charset=UTF-8\r\n".getBytes(StandardCharsets.UTF_8));
        }
        os.write(date.getBytes(StandardCharsets.UTF_8));
        os.write(cleng.getBytes(StandardCharsets.UTF_8));
        os.write("Access-Control-Allow-Origin:*\r\n".getBytes(StandardCharsets.UTF_8));
        os.write("\r\n".getBytes(StandardCharsets.UTF_8));
        //输出正文
        BufferedInputStream biss = new BufferedInputStream(new FileInputStream(url));
        byte[] byt = new byte[1024];
        int lens;
        while ((lens = biss.read(byt)) != -1) {
            os.write(byt, 0, lens);
        }
        biss.close();
        os.flush();
    }

    //Get请求
    private void doGet(String url, int code) throws IOException {
        if (request.getFileExtensions().equals("jpg")) {
            picture(url, code);
        } else if (request.getFileExtensions().equals("png")) {
            picture(url, code);
        } else {
            html(url, code);
        }
    }

    //Post请求
    private void doPost(String url, int code) throws IOException {
        //获取正文内容
        BufferedReader br = new BufferedReader(new FileReader(url));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            data.append(line);
        }
        //获取html内容长度字符串以及日期时间字符串
        int length = data.toString().getBytes(StandardCharsets.UTF_8).length;
        String date = "Date:Sat, " + new Date() + "\r\n";
        String cleng = "Content-Length: " + length + "\r\n";
        //开始输出内容
        //区分404还是200
        if (code == 200) {
            os.write("HTTP/1.1 200 OK\r\n".getBytes(StandardCharsets.UTF_8));
        } else if (code == 404) {
            os.write("HTTP/1.1 404 NOT FOUND\r\n".getBytes(StandardCharsets.UTF_8));
        }
        os.write("Connection: keep-alive\r\n".getBytes(StandardCharsets.UTF_8));
        os.write("Content-Type:multipart/form-data;\r\n".getBytes(StandardCharsets.UTF_8));
        os.write(date.getBytes(StandardCharsets.UTF_8));
        os.write(cleng.getBytes(StandardCharsets.UTF_8));
        os.write("Access-Control-Allow-Origin:*\r\n".getBytes(StandardCharsets.UTF_8));
        os.write("\r\n".getBytes(StandardCharsets.UTF_8));
        //输出正文内容
        os.write(data.toString().getBytes(StandardCharsets.UTF_8));
        os.flush();
    }
}
