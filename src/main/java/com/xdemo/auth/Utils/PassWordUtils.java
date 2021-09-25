package com.xdemo.auth.Utils;

public class PassWordUtils {

    public static String encryptMD5(String password){
        return Md5Utils.MD5(password);
    }

    public static Boolean checkPassword(String pwd, String password){
        pwd = Md5Utils.MD5(pwd);
        return pwd.equals(password);
    }
    public static void main(String[] args){
        String a = encryptMD5("aaa");
        System.out.println(a);
        System.out.println(checkPassword("aaa", a));
    }
}
