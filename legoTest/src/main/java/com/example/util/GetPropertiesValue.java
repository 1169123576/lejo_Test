package com.example.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetPropertiesValue {


    /**
     * ApiList.properties解析文件，提取ApiPath的值
     */
    public static String getApiByPath(String apiPath) {
        String assetByFundType = null;
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        try {
            InputStream inputStream = com.example.util.GetPropertiesValue.class.getClassLoader().getResourceAsStream("ApiList.properties");
            properties.load(inputStream);
            // 获取key对应的value值，截取?后面的值
            assetByFundType = properties.getProperty(apiPath)
                    .substring(properties.getProperty(apiPath).lastIndexOf("?") + 1);
            System.out.println("GetAssetByFundType: " + assetByFundType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return assetByFundType;
    }
    /*提取sign加密的盐*/
    public static String getSecretKey(){
        String secretKey=null;
        Properties properties = new Properties();
        try {
            InputStream inputStream = com.example.util.GetPropertiesValue.class.getClassLoader().getResourceAsStream("SecretKey.properties");
            properties.load(inputStream);
            // 获取key对应的value值
            secretKey = properties.getProperty("SecretKey");
            System.out.println("secretKey: " + secretKey);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return secretKey;
    }
}
