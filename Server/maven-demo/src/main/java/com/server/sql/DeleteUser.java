package com.server.sql;

import com.tools.Allocation;

import java.sql.PreparedStatement;
/*
* sql：删除人员
* 现实删除是否成功
* */
public class DeleteUser {
    public int connt;

    public DeleteUser(String name) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "DELETE \n" +
                "FROM\n" +
                "\tcontacts \n" +
                "WHERE\n" +
                "\t`name` = ?;";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, name);
        //执行sql
        connt = pstmt.executeUpdate();
        //处理结束
        System.out.println(connt);
        //释放资源
        pstmt.close();
        a.getConn().close();
    }
}
