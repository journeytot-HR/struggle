package com.stylefeng.guns.shiro;

import org.springframework.util.Base64Utils;

import com.stylefeng.guns.core.shiro.ShiroKit;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Base64Test {

    /**
     * Shiro 记住密码采用的是AES加密，AES key length 需要是16位，该方法生成16位的key
     */
    public static void main(String[] args) {
    	
		/*
		 * String keyStr = "guns";
		 * 
		 * byte[] keys; try { keys = keyStr.getBytes("UTF-8");
		 * System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keys, 16))); }
		 * catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
    	String newMd5 = ShiroKit.md5("scg2019", "j3cs9");
    	System.out.println(newMd5);
        
    }

}