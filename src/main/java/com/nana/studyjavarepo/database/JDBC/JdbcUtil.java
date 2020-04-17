package com.nana.studyjavarepo.database.JDBC;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/04  16:24
 * Description:
 * Modified By:
 */
public class JdbcUtil {
    private static DriverManagerDataSource dataSource = null;

    static {
        dataSource = new DriverManagerDataSource();
        Properties prop = new Properties();
        try {
            //读取属性文件src目录下
            prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("resources/jdbc.properties"));
            String url = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");
            String initialSizeStr = prop.getProperty("jdbc.initialSize");
            int initialSize = Integer.parseInt(initialSizeStr);
            String maxActiveStr = prop.getProperty("jdbc.maxActive");
            int maxActive = Integer.parseInt(maxActiveStr);
            String maxWaitStr = prop.getProperty("jdbc.maxWait");
            int maxWait = Integer.parseInt(maxWaitStr);
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
//            dataSource.setInitialSize(initialSize);
//            dataSource.setMaxActive(maxActive);
//            dataSource.setMaxWait(maxWait);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
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
