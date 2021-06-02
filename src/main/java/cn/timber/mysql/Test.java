package cn.timber.mysql;

import java.sql.*;

public class Test {

    // MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/javaweb";

    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://8.210.116.98:3306/javaweb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "wqhWQH@123456";


    public static void main (String[] args) {

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


            //demo
            String sql1 = "insert into javaweb.javaweblogin values ('timber','1.1.1.1','2020-12-11 14:16:10');";//(192.168.22.143,hello,1989-01-29)
            statement = conn.createStatement();
            statement.executeUpdate(sql1);


            sql = "SELECT * FROM javaweblogin";
            ResultSet rs = stmt.executeQuery(sql);
            //ResultSet rs1 = stmt.executeQuery(sql);//�������ݶ���


            while (rs.next()) {
                // ͨ���ֶμ���
                String id = rs.getString("IP��ַ");
                String name = rs.getString("�û���");
                String time = rs.getString("�ύʱ��");

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
        System.out.println("Goodbye!");

    }

}
