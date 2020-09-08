package com.nana.studyjavarepo.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaFile {

    public JavaFile() {
    }

    /**
     * 创建文件/文件夹
     *
     * @param fileName 文件路径+文件名
     */
    public void createFile(String fileName) {
        //String filePath="AppData"+File.separator+fileName;
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建文件夹
     *
     * @param path 文件路径
     */
    public void createDirectory(String path) {
        File file = new File(path);
        file.mkdir();
    }


    /**
     * 递归的查找某个文件下的文件
     *
     * @param file 待查找文件
     */
    public void printFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    printFile(files[i]);
                }
            }
        } else {
            System.out.println(file);
        }
    }

    /**
     * @param path
     * @return
     */
    public boolean isFile(String path) {
        File file = new File(path);
        boolean flag = file.isFile();
        return flag;
    }


    /**
     * 删除文件及空文件夹
     *
     * @param path 文件路径+文件名
     * @return
     */
    public boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    /**
     * 获得某个路径下的所有文件，包括隐藏文件
     *
     * @param path
     * @return
     */
    public String[] getChild(String path) {
        File f = new File(path);
        File[] files = f.listFiles();
        String[] paths = null;
        if (files != null && files.length > 0) {
            paths = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                paths[i] = files[i].getPath();

            }
        }


        return paths;
    }

    /**
     * 递归删除文件及子文件
     *
     * @param path
     * @return
     */
    public boolean remove(String path) {
        // 判断文件是否存在
        // 判断是否是文件
        if (isFile(path)) {
            return deleteFile(path);
        } else {
            String[] paths = getChild(path);
            if (paths != null && paths.length > 0) {
                for (int i = 0; i < paths.length; i++) {
                    return remove(paths[i]);
                }
            }
            // 删除空目录
            return deleteFile(path);
        }

    }

    public static void main(String[] args) {
        JavaFile javaFile = new JavaFile();
        String path = System.getProperty("user.dir") + "/src/main/java/com/nana/studyjavarepo/test";
        String[] childs = javaFile.getChild(path);
        javaFile.remove(path);
        System.out.println(childs);
    }

}
