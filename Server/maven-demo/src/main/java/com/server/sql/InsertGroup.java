package com.server.sql;

import com.tools.Allocation;

import java.sql.PreparedStatement;

public class InsertGroup {
    public int count;

    public InsertGroup(String newGroupName) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "INSERT INTO `group` ( group_name )\n" +
                "VALUES\n" +
                "\t( ? );";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, newGroupName);
        //执行sql
        count = pstmt.executeUpdate();
        //处理结束
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        a.getConn().close();
    }
}
