package com.server.sql;

import com.common.Groups;
import com.tools.Allocation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectGroup {
    List<Groups> lines;

    public List<Groups> getInformation() {
        return lines;
    }

    public SelectGroup() throws Exception {
        //加载配置文件,获取连接池对象,获取数据库连接
        Allocation a = new Allocation();
        //定义sql
        String sql = "SELECT\n" +
                "\tid,\n" +
                "\tgroup_name \n" +
                "FROM\n" +
                "\t`group`;";
        //获取pstmt对象
        PreparedStatement pstmt = a.getConn().prepareStatement(sql);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //处理结束
        lines = new ArrayList<>();
        while (rs.next()){
            Groups group = new Groups();
            //获取数据并封装Groups对象
            int id = rs.getInt("id");
            String groupName = rs.getString("group_name");
            group.setId(id);
            group.setGroupName(groupName);
            //集合装载
            lines.add(group);
        }
        //释放资源
        rs.close();
        pstmt.close();
        a.getConn().close();
    }
}
