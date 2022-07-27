package com.web.servlet;

import com.web.networkProcessing.Request;
import com.web.networkProcessing.Response;
import com.web.servlet.info.OkHtml;

/*
* 传输某列表
* */
public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        new OkHtml("src/main/java/com/web/page/login.html", request, response);
    }
}
