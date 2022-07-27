package com.server.sql;

import com.tools.Allocation;

import java.sql.PreparedStatement;
/*
* 添加人员的sql代码
* */
public class InsertUser {
    public int count;

    public InsertUser(String name,String telephoneNumber,String email,String address,String groupName) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "INSERT INTO contacts ( `name`, telephone_number, email, address, group_id )\n" +
                "VALUES\n" +
                "\t( ?, ?, ?, ?, ? );";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, name);
        pstmt.setString(2, telephoneNumber);
        pstmt.setString(3, email);
        pstmt.setString(4, address);
        pstmt.setString(5, groupName);
        //执行sql
        count = pstmt.executeUpdate();
        //处理结束
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        a.getConn().close();
    }
}
