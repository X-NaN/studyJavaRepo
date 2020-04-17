package com.nana.studyjavarepo.database.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/04  16:53
 * Description:
 * Modified By:
 */
public class JdbcUtilSimple {
    private static String url = "jdbc:mysql://127.0.0.1:3306/daily_report";
    private static String username = "root";
    private static String password = "1234";

    private JdbcUtilSimple() {
    }

    public static Connection getConn() throws SQLException {
        //1.加载数据库驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
