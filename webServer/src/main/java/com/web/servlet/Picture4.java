package com.web.servlet;

import com.web.networkProcessing.Request;
import com.web.networkProcessing.Response;
import com.web.servlet.info.NotFoundFile;
import com.web.servlet.info.OkHtml;

import java.io.*;

public class Picture4 implements Servlet {
    public void service(Request request, Response response) {
        new OkHtml("src/main/java/com/web/page/HanFuSociety/素材照片/柔情.png", request, response);
    }
}
