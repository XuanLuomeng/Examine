package com.web.networkProcessing;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * 请求协议
 */
public class Request {
    //请求方式
    private String method;
    //请求地址
    private String url;
    //请求内容
    private String requestInfo;
    //请求参数
    private String queryStr;
    //存储参数
    private Map<String, List<String>> paremterMap;
    //文件后缀
    private String fileExtensions;

    public Request(InputStream is, Socket s) {
        //获取HTTP协议请求内容
        try {
            requestInfo = "";
            byte[] buff = new byte[1024 * 1024];
            int len;
            if ((len = is.read(buff)) > 0) {
                this.requestInfo = new String(buff, 0, len);
                System.out.println(requestInfo);
            }
            //获取是get还是post请求
            String line = requestInfo.split("\\r\\n")[0];
            String[] arr = line.split("\\s");
            this.method = arr[0];
            //获取url
            this.url = decode(arr[1].split("/", 2)[1], "UTF-8");//转换编码集，解决中文乱码问题
            //获取文件后缀
            this.fileExtensions = url.substring(url.lastIndexOf('.') + 1);
            //获取参数
            queryId();
            //打印请求方式、地址与文件后缀，用以检测
            System.out.println("请求方式：" + method);
            System.out.println("地址：" + url);
            System.out.println("文件后缀:" + fileExtensions);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                s.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //获取请求参数
    private void queryId() {
        //从url中获取参数
        int queryIdx = url.indexOf("?");
        if (queryIdx > 0) {//表示存在参数
            String[] urlArray = url.split("\\?");
            url = urlArray[0];
            this.queryStr = urlArray[1];
        }
        //从请求体中获取参数
        if (method.equals("POST")) {
            String qStr = requestInfo.substring(requestInfo.lastIndexOf("\r\n")).trim();
            if (queryStr == null) {
                queryStr = qStr;
            } else {
                queryStr += "&" + qStr;
            }
        }
        //若post或get中均无参数，为防止queryStr空指针异常
        if (queryStr == null) {
            queryStr = "";
        } else {
            convertMap();//处理请求参数
        }
        //打印请求方式与地址，用以检测
        System.out.println(queryStr);
    }

    //处理请求参数
    private void convertMap() {
        paremterMap = new HashMap<>();
        //分割字符串“&”
        String[] keyValues = this.queryStr.split("&");
        for (String query : keyValues) {
            //分割“=”
            String[] kv = query.split("=");
            kv = Arrays.copyOf(kv, 2);//保证有一个键能对应一个值，防止参数=后面为空
            //获取key与value
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1], "UTF-8");//转换编码集，解决中文乱码问题
            //存储到map中
            if (!paremterMap.containsKey(key)) {//新key
                paremterMap.put(key, new ArrayList<>());
            }
            paremterMap.get(key).add(value);
        }
    }

    //处理中文乱码问题
    private String decode(String content, String enc) {
        try {
            return URLDecoder.decode(content, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "转义内容出错";
        }
    }

    //通过key来获取多个值
    public String[] getParemterValues(String key) {
        List<String> values = paremterMap.get(key);
        if (values == null || values.size() < 1) {
            return null;
        }
        return values.toArray(new String[0]);
    }

    //通过key来获取一个值
    public String getParemterValue(String key) {
        String[] value = getParemterValues(key);
        return (value == null) ? null : value[0];
    }

    //获取请求方式
    public String getMethod() {
        return method;
    }

    //获取请求url
    public String getUrl() {
        return url;
    }

    //获取文件后缀
    public String getFileExtensions() {
        return fileExtensions;
    }
}
