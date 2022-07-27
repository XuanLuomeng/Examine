package com.web.servlet.info;

import com.web.networkProcessing.Response;

/*
* 当找不到文件时返回404页面
* 有两种情况：1.服务器输入了无效url   2.与url有关的文件被删除
* */
public class NotFoundFile {
    public NotFoundFile(Response response) throws Exception {
        //当文件找不到时传输404FoundFile的html文件
        response.write("src/main/java/com/web/page/404.html", 1, 404);
    }
}
