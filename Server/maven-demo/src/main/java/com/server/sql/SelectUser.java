package com.server.sql;

import com.common.Users;
import com.tools.Allocation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * sql查询
 * */
public class SelectUser {
    private Users user = new Users();

    public Users getUser() {
        return user;
    }

    public SelectUser(String name) throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "select t1.`name`,t1.telephone_number,t1.email,t1.address," +
                "t2.group_name from contacts t1 left join `group` t2 on t1.group_id" +
                " = t2.id where `name` = ?;";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //设置参数
        pstmt.setString(1, name);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //处理结束
        rs.next();
        Users user = new Users();
        user.setName(rs.getString("name"));
        user.setTelephoneNumber(rs.getString("telephone_number"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setGroupName(rs.getString("group_name"));
        this.user = user;
        //释放资源
        rs.close();
        pstmt.close();
        a.getConn().close();
    }
}
