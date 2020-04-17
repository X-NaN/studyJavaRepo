package com.nana.studyjavarepo.url;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/20  10:37
 * Description:
 * Modified By:
 */
public class ProjPath {

    public void showPath() {

        // 获取 类加载的根路径classpath
        // 路径：/D:/WorkspaceIntellij/JavaStudy/StudyJava/out/production/JavaStudy/
        String path = this.getClass().getResource("/").getPath();
        System.out.println("类加载的根路径classpath:" + path);

        //获取 当前类所在的包路径
        //路径：/D:/WorkspaceIntellij/JavaStudy/StudyJava/out/production/JavaStudy/com/xnn/url/
        String path1 = this.getClass().getResource("").getPath();
        System.out.println("当前类所在的包路径:" + path1);

        //获取类加载的根路径classpath
        // file:/D:/WorkspaceIntellij/JavaStudy/StudyJava/out/production/JavaStudy/
        URL xmlPath = this.getClass().getClassLoader().getResource("");
        System.out.println("类加载的根路径classpath:" + xmlPath);

        //项目路径
        String projPath = System.getProperty("user.dir");
        System.out.println("项目路:1：" + projPath);

        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("项目路径2：" + courseFile);


        String jarPath = System.getProperty("java.class.path");
        System.out.println("jar包路径：" + jarPath);

    }

    public void readPropertiesByClass() {
        Properties prop = new Properties();
        InputStream input = null;
        // 获取类加载的根路径classpath
        //  /D:/WorkspaceIntellij/JavaStudy/StudyJava/out/production/JavaStudy/
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
        input = this.getClass().getResourceAsStream("/resources/jdbc.properties");
        try {
            prop.load(input);
            String driver = prop.getProperty("jdbc.driver");
            String url = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");

            System.out.println("drivers : " + driver);
            System.out.println("connectionURL : " + url);
            System.out.println("username : " + username);
            System.out.println("password : " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPropertiesByClassLoader() {
        Properties prop = new Properties();
        InputStream input = null;

        //获取类加载的根路径classpath
        // file:/D:/WorkspaceIntellij/JavaStudy/StudyJava/out/production/JavaStudy/
        URL xmlPath = this.getClass().getClassLoader().getResource("");
        input = this.getClass().getClassLoader().getResourceAsStream("resources/jdbc.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = prop.getProperty("jdbc.driver");
        String url = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");

        System.out.println("drivers : " + driver);
        System.out.println("connectionURL : " + url);
        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println(xmlPath);

    }

}
