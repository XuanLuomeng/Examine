package com.web.networkProcessing;

import com.web.servlet.*;
import com.web.servlet.info.NotFoundFile;
import com.web.xml.XmlAnalysis;

import java.io.*;
import java.net.Socket;

/*
 * 处理请求和响应
 * */
public class Processor {

    public Processor(InputStream is, OutputStream os, Socket s) throws Exception {
        //获取请求协议
        Request request = new Request(is, s);
        //获取响应协议
        Response response = new Response(os, request);
        //启动解析器
        XmlAnalysis xa = new XmlAnalysis();
        String url = request.getUrl();
        try {
            //利用反射创建对象
            Servlet servlet = (Servlet) Class.forName(xa.getServlet().get(url)).getConstructor().newInstance();
            servlet.service(request, response);
        } catch (NullPointerException e) {
            //当输入的url从xa的map中无法找到对应的键会出空指针异常，此时将推送404给浏览器
            new NotFoundFile(response);
        }
    }
}
