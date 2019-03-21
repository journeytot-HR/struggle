package com.stylefeng.guns.jwt;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.model.ContactUs;
import com.stylefeng.guns.rest.modular.auth.converter.BaseTransferEntity;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;

/**
 * jwt测试
 *
 * @author fengshuonan
 * @date 2017-08-21 16:34
 */
public class DecryptTest {

    public static void main(String[] args) {
    	//1.auth接口返回
        String randomKey = "prpbx0";
        //2.业务数据对象构建
        ContactUs simpleObject = new ContactUs();
        simpleObject.setName("hrRR");
        simpleObject.setEmail("96317");
        simpleObject.setMessage("1个亿");
        simpleObject.setTel("15361038896");
        //3.数据对象json字符串化
        String jsonString = JSON.toJSONString(simpleObject);
        //4.进行base64编码
        String encode = new Base64SecurityAction().doAction(jsonString);
        //5.生成验签 md5 配合 auth返回的 randomKey
        String md5 = MD5Util.encrypt(encode + randomKey);
        //6.构建请求数据对象{"object" : "","sign":""}
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        //6.1object
        baseTransferEntity.setObject(encode);
        //6.2sign
        baseTransferEntity.setSign(md5);
        //7.请求数据json字符串化
        System.out.println(JSON.toJSONString(baseTransferEntity));
        //8.放入请求body，发起请求
    }
}
