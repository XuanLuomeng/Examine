package com.server.sql;

import com.tools.Allocation;

import java.sql.PreparedStatement;

public class UpdateGroup {
    public int count;

    public UpdateGroup(String oldGroupName,String newGroupName) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "UPDATE `group` \n" +
                "SET group_name = ? \n" +
                "WHERE\n" +
                "\tgroup_name = ?;";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, newGroupName);
        pstmt.setString(2, oldGroupName);
        //执行sql
        count = pstmt.executeUpdate();
        //处理结束
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        a.getConn().close();
    }
}
