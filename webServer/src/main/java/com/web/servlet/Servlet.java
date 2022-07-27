package com.web.servlet;

import com.web.networkProcessing.Request;
import com.web.networkProcessing.Response;

public interface Servlet {
    void service(Request request, Response response);
}
