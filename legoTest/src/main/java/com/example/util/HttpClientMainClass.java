package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
public class HttpClientMainClass {
    /**
     * 向指定的URL发送POST方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
     * @return 远程资源的响应结果
     */

    /**
     * @return 登录态唯一标识
     * @param accounToken 设置的全局变量，先请求登录接口获取token
     * @return token,nonce,sign供后面所有需要签名的请求头方法调用
     */

    private static String accounToken = null;

    /**
     * @ 不带自定义请求头的post请求
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            //  打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //  设置通用的请求属性
            conn.setRequestProperty("ContentType", "application/json");
            //  发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //  获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //  发送请求参数
            out.print(param);
            //  flush输出流的缓冲
            out.flush();
            //  定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // 读取请求头信息，取出token
            Map<String, ?> headers = conn.getHeaderFields();
            Set<String> keys = headers.keySet();
            String val = null;
            Map<String, String> map = new HashMap<String, String>();
            for (String key : keys) {
                val = conn.getHeaderField(key);
                map.put(key, val);
            }
            // System.out.println("map:" + map);
            accounToken = map.get("token");
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 带token,nonce,sign请求头的post请求
     */
    public static String sendOrderPost(String url, String param, String apiPathValue) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            //  打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //  指定报文头【Content-type】、【sign】、【nonce】、【timestamp】
            conn.setRequestProperty("token", accounToken);
            conn.setRequestProperty("ContentType", "application/json");
            conn.setRequestProperty("nonce", SignatureGenerate.getRandom());
            System.out.println("x_api_signature: " + SignatureGenerate.getSigntureMain(apiPathValue));
            conn.setRequestProperty("sign", SignatureGenerate.getSigntureMain(apiPathValue));
            //  发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //  获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //  发送请求参数
            out.print(param);
            //  flush输出流的缓冲
            out.flush();
            //  定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 带token,nonce,sign请求头，请求参数以json类型上传
     *
     * @throws JSONException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static <ClientProtocolException> String sendJsonBodyPost(String url, JSONObject jsonImage, JSONObject jsonVideo, String title,
                                                                    String apiPathValue) throws JSONException, IOException {
        String body = "";
        // 创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("video_request", jsonVideo);
        jsonObject.put("image_request", jsonImage);
        jsonObject.put("title", title);
        // 装填参数
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        // 设置参数到请求对象中
        httpPost.setEntity(s);
        // 设置header信息
        // 指定报文头【Content-type】、【sign】、【nonce】、【timestamp】
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("nonce", SignatureGenerate.getRandom());
        httpPost.setHeader("timestamp",SignatureGenerate.geTimestamp());
        httpPost.setHeader("token", accounToken);
        httpPost.setHeader("sign", SignatureGenerate.getSigntureMain(apiPathValue));
        System.out.println("x_api_signature: " + SignatureGenerate.getSigntureMain(apiPathValue));
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        // 获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            // 按指定编码转换结果实体为String类型, encoding
            body = EntityUtils.toString(entity);
        }
        EntityUtils.consume(entity);
        // 释放链接
        response.close();
        return body;
    }
}