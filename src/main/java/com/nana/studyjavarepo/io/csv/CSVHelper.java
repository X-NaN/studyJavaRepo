package com.nana.studyjavarepo.io.csv;

import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/13  09:49
 * Description:
 * Modified By:
 */
public class CSVHelper {

    /**
     * 读取CSV文件
     *
     * @param filePath 文件路径（包括文件名）
     * @param hasTitle 是否有标题行
     * @return
     */
    public static List<List<String>> readCSV(String filePath, boolean hasTitle) {
        List<List<String>> data = new ArrayList<>();
        String line = null;
        try {
            //BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
            if (hasTitle) {
                //第一行信息，为标题信息
                line = bufferedReader.readLine();
                String[] items = line.split(",");
                data.add(Arrays.asList(items));
                System.out.println("标题行：" + line);
            }

            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                i++;
                //数据行
                String[] items = line.split(",");
                data.add(Arrays.asList(items));
                System.out.println("第" + i + "行：" + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * 写CSV文件
     *
     * @param data     数据
     * @param filePath 文件路径
     * @param fileName 文件名
     * @param hasTitle 是否有标题行
     */
    public static void writeCSV(List<List<String>> data, String filePath, String fileName, boolean hasTitle) {
        File csvFile = new File(filePath + "/" + fileName);
        BufferedWriter bufferedWriter = null;
        String line = null;
        try {
            // bufferedWriter=new BufferedWriter(new FileWriter(csvFile,true));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "utf-8"));
            for (int i = 0; i < data.size(); i++) {
                line = null;
                if (hasTitle) {
                    line = getLine(data.get(i));
                }
                System.out.println(line.toString());
                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取一行数据的csv格式的字符串
     *
     * @param items
     * @return
     */
    private static String getLine(List<String> items) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            line.append(items.get(i));
            if (i < (items.size() - 1)) {
                line.append(",");
            }
        }
        return line.toString();
    }

    /**
     * 处理包含逗号，或者双引号的字段
     *
     * @param str 待处理的字符串
     * @return
     */
    public static String handlerStr(String str) {
        //csv格式如果有逗号，整体用双引号括起来；如果里面还有双引号就替换成两个双引号，这样导出来的格式就不会有问题了
        String temp = str;
        //如果有逗号
        if (str.contains(",")) {
            //如果还有双引号，先将双引号转义，避免两边加了双引号后转义错误
            if (str.contains("\"")) {
                temp = str.replace("\"", "\"\"");
            }
            //在将逗号转义
            temp = "\"" + temp + "\"";
        }
        return temp;
    }

}
