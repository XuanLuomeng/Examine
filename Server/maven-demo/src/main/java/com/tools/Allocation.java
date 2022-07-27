package com.tools;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Allocation {
    private Properties prop;
    private DataSource dataSource;
    private Connection conn;
    public Allocation() throws Exception {
        //加载配置文件
        prop = new Properties();
        prop.load(new FileInputStream("maven-demo/src/main/resources/druid.properties"));
        //获取连接池对象
        dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        conn = dataSource.getConnection();
    }

    public Connection getConn(){
        return conn;
    }
}
