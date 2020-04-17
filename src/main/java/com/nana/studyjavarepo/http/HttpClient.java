package com.nana.studyjavarepo.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IDEA
 * Author:Nana Xing
 * Date:2018/12/26  17:52
 * Description:java自带的HttpURLConnection实现http请求
 * Modified By:
 */
public class HttpClient {

    public static String doGet(String httpUrl) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader reader = null;
        String result = null;
        try {
            // 创建远程url连接对象
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();

            //设置请求的方式，默认是GET方式，参数大写
            connection.setRequestMethod("GET");
            // 设置连接服务器超时时间
            connection.setConnectTimeout(10000);
            // 设置读取远程返回数据的超时时间
            connection.setReadTimeout(6000);
            //发送请求
            connection.connect();
            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                //封装输入流，并指定字符集
                reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                //存放读取的数据
                StringBuffer buffer = new StringBuffer();
                String temp = null;
                while ((temp = reader.readLine()) != null) {
                    buffer.append(temp);
                    buffer.append("\r\n");
                }
                result = buffer.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //// 关闭远程连接
            connection.disconnect();
        }

        return result;
    }

    /**
     * @param httpUrl
     * @param param   请求参数是 name1=value1&name2=value2 的字符串形式
     * @return
     */
    public static String doPost(String httpUrl, String param) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader reader = null;
        String result = null;

        try {
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(6000);
            // 默认值为：false，是否打开输出流
            connection.setDoOutput(true);
            // 默认值为：true，当从远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);

            // 设置传入参数的格式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //设置鉴权信息
            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");

            //通过连接对象获取一个输出流
            outputStream = connection.getOutputStream();
            //写入参数
            outputStream.write(param.getBytes());

            if (connection.getResponseCode() == 200) {
                inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuffer buffer = new StringBuffer();
                String temp = null;

                while ((temp = reader.readLine()) != null) {
                    buffer.append(temp);
                    buffer.append("\r\n");
                }

                result = buffer.toString();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();
        }

        return result;
    }


}
