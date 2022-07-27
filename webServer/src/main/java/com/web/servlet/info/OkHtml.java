package com.web.servlet.info;

import com.web.networkProcessing.Request;
import com.web.networkProcessing.Response;

import java.io.*;
/*
* 传输html文件
* */
public class OkHtml {
    public OkHtml(String url, Request request, Response response){
        try {
            //sign用来区分是GET请求(1)还是POST请求(2)
            int sign;
            if (request.getMethod().equals("GET")) {
                sign = 1;
            } else {
                sign = 2;
            }
            //创建file利用文件是否存在来决定是发送404html还是打开存在的指定html
            File file = new File(url);
            if (file.exists()) {
                response.write(url, sign, 200);
            } else {
                new NotFoundFile(response);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
