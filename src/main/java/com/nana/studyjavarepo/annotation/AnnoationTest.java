package com.nana.studyjavarepo.annotation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试注解
 *
 * @author xingnana
 * @create 2020-04-17
 */
public class AnnoationTest {

    /**
     * 获取某个路径下的所有文件
     *
     * @param path
     * @param files
     */
    public static void getFiles(String path, List<File> files) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                files.add(file);
            } else {
                List<String> paths = new ArrayList<>();
                File[] listFile = file.listFiles();
                for (int i = 0; i < listFile.length; i++) {
                    paths.add(listFile[i].getPath());
                }

                for (String filePath : paths) {
                    getFiles(filePath, files);
                }


            }
        }
    }

    public void showClassPath() {

        File file = new File(this.getClass().getResource("/").getPath());
        System.out.println(file.getPath());

        // 第三种：  file:XXX/target/classes/
        System.out.println(this.getClass().getClassLoader().getResource(""));

    }


    public static void main(String[] args) {
//        /Users/conanmu/Documents/github/javaproj/studyJavaRepo/src/main/java/com/nana/studyjavarepo/annotation
        AnnoationTest annoationTest = new AnnoationTest();
        annoationTest.showClassPath();
        String rootPath = System.getProperty("user.dir") + "/src/main/java/com/nana/studyjavarepo/annotation";
        File currentFile = new File(rootPath);
        List<File> files = new ArrayList<>();

        try {
//            System.out.println(currentFile.getCanonicalPath());
            rootPath = currentFile.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getFiles(rootPath, files);

        for (File file : files) {

        }

        Map employeeInfo = EmployInfoUtil.getEmployeeInfo(Employ.class);
        System.out.println(employeeInfo);
    }
}
