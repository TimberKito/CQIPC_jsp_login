package cn.timber.mysql;

import java.sql.*;

public class Mysql {

    //JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://1111:3306/javawebcn?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "wq2333323456";

    public void mysqlHK (String username , String ipaddr , String loginTime) {

        Connection conn = null;
        Statement stmt = null;
        Statement statement = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;


            //添加数据
            String sql1 = "insert into javawebcn.javaweblogincn values ('"+username+"','"+ipaddr+"','"+loginTime+"');";
            statement = conn.createStatement();
            statement.executeUpdate(sql1);


            sql = "SELECT * FROM javawebcn.javaweblogincn";
            ResultSet rs = stmt.executeQuery(sql);
            //ResultSet rs1 = stmt.executeQuery(sql);//创建数据对象


            while (rs.next()) {
                // 通过字段检索
                String id = rs.getString("username");
                String name = rs.getString("ip");
                String time = rs.getString("timedate");

                // 输出数据
                System.out.print("ip: " + id);
                System.out.print(", 用户名: " + name);
                System.out.print(", 提交时间: " + time);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

}
