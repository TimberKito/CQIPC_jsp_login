package cn.timber.mysql;

import java.sql.*;

public class Mysql {

    //JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://1111:3306/javawebcn?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "wq2333323456";

    public void mysqlHK (String username , String ipaddr , String loginTime) {

        Connection conn = null;
        Statement stmt = null;
        Statement statement = null;
        try {
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);

            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;


            //�������
            String sql1 = "insert into javawebcn.javaweblogincn values ('"+username+"','"+ipaddr+"','"+loginTime+"');";
            statement = conn.createStatement();
            statement.executeUpdate(sql1);


            sql = "SELECT * FROM javawebcn.javaweblogincn";
            ResultSet rs = stmt.executeQuery(sql);
            //ResultSet rs1 = stmt.executeQuery(sql);//�������ݶ���


            while (rs.next()) {
                // ͨ���ֶμ���
                String id = rs.getString("username");
                String name = rs.getString("ip");
                String time = rs.getString("timedate");

                // �������
                System.out.print("ip: " + id);
                System.out.print(", �û���: " + name);
                System.out.print(", �ύʱ��: " + time);
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // ���� JDBC ����
            se.printStackTrace();
        } catch (Exception e) {
            // ���� Class.forName ����
            e.printStackTrace();
        } finally {
            // �ر���Դ
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// ʲô������
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

}
