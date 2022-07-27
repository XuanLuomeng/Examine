package com.web.servlet;

import com.web.networkProcessing.Request;
import com.web.networkProcessing.Response;
import com.web.servlet.info.OkHtml;

/*
* 传输汉服社html
* */
public class HanFuSocietyServlet implements Servlet {

    public void service(Request request, Response response) {
        new OkHtml("src/main/java/com/web/page/HanFuSociety/HanFuSociety.html", request, response);
    }
}
