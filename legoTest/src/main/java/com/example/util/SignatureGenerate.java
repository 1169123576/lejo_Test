package com.example.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SignatureGenerate {
    /*生成sign*/
    public static String getSigntureMain(String stringA) {
        String signture=null;
        stringA=GetPropertiesValue.getApiByPath(stringA);
        if(stringA.indexOf("&")==-1){
            signture= stringA+"&"+"Nonce="+getRandom()+"&"+geTimestamp()+"&"+"SecretKey="+GetPropertiesValue.getSecretKey();
            signture= DigestUtils.md5DigestAsHex(signture.getBytes()).toUpperCase();
            System.out.println("&小于1时："+signture);
        }else {
            String[]  stringAlist=stringA.split("&");
            List<String> list = (List<String>) Arrays.asList(stringAlist);
            Collections.sort(list);
            stringA= String.join(",",list).replaceAll(",","&");
            //System.out.println("stringA："+stringA);
            signture= stringA+"&"+"Nonce="+getRandom()+"&"+geTimestamp()+"&"+"SecretKey="+GetPropertiesValue.getSecretKey();
            signture= DigestUtils.md5DigestAsHex(signture.getBytes()).toUpperCase();
            System.out.println("&大于1时："+signture);
        }
        return signture;
    }
    /*获取当前时间戳，以毫秒为基数*/
    public static String geTimestamp() {
        String timestamp=String.valueOf(System.currentTimeMillis());
        return timestamp;
    }
    /*获取Nonce，为随机数*/
    public static String getRandom() {
        Random r = new Random(1);
        String random=String.valueOf(r.nextInt(1000));
        return random;
    }
}
   /* public static void main(String[] args) {
        String signture=null;
        String stringA=GetPropertiesValue.getAssetByFundType();
        //String stringA="dealMarket=BTC/USDT&contractType=0&levelNum=20&entrustNum=1&entrustPrice=1000&tradeDirect=0&tradeType=0";
        if(stringA.indexOf("&")==-1){
            signture= stringA+"&"+"Nonce="+getRandom()+"&"+geTimestamp()+"&"+"SecretKey="+getSecretKey();
            signture= DigestUtils.md5DigestAsHex(signture.getBytes()).toUpperCase();
            System.out.println("&小于1时："+signture);
        }else {
            String[]  stringAlist=stringA.split("&");
            List<String> list = (List<String>) Arrays.asList(stringAlist);
            Collections.sort(list);
            stringA= String.join(",",list).replaceAll(",","&");
            System.out.println("stringA："+stringA);
            signture= stringA+"&"+"Nonce="+getRandom()+"&"+geTimestamp()+"&"+"SecretKey="+getSecretKey();
            signture= DigestUtils.md5DigestAsHex(signture.getBytes()).toUpperCase();
            System.out.println("&大于1时："+signture);
        }
          int i;
            for (i = 0; i <= stringAlist.length; i++) {
            }
            int j;
            for (j = 0; j <= stringAlist.length; j++) {
                System.out.println(list);
            }}*/


