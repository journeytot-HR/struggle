package com.stylefeng.guns.rest.modular.auth.security.impl;

import com.stylefeng.guns.rest.modular.auth.security.DataSecurityAction;

import java.io.UnsupportedEncodingException;

import org.springframework.util.Base64Utils;

/**
 * 对数据进行base64编码的方式
 *
 * @author fengshuonan
 * @date 2017-09-18 20:43
 */
public class Base64SecurityAction implements DataSecurityAction {

    @Override
    public String doAction(String beProtected) {
    	String res = "";
        try {
        	res = Base64Utils.encodeToString(beProtected.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
    }

    @Override
    public String unlock(String securityCode) {
        byte[] bytes = Base64Utils.decodeFromString(securityCode);
        return new String(bytes);
    }
}
