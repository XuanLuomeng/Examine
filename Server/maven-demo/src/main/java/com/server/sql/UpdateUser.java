package com.server.sql;

import com.tools.Allocation;

import java.sql.PreparedStatement;

/*
 * 修改人员的sql代码
 * */
public class UpdateUser {
    public int count;

    public UpdateUser(String oldName,String newName,String newTelephoneNumber,String newEmail
            ,String newAddress,String newGroupName) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "UPDATE contacts \n" +
                "SET `name` = ?,\n" +
                "telephone_number = ?,\n" +
                "email = ?,\n" +
                "address = ?,\n" +
                "group_id = ? \n" +
                "WHERE\n" +
                "\t`name` = ?;";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, newName);
        pstmt.setString(2, newTelephoneNumber);
        pstmt.setString(3, newEmail);
        pstmt.setString(4, newAddress);
        pstmt.setString(5, newGroupName);
        pstmt.setString(6, oldName);
        //执行sql
        count = pstmt.executeUpdate();
        //处理结束
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        a.getConn().close();
    }
}
