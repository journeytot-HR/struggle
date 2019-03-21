package com.stylefeng.guns.rest.modular.auth.util;

import java.security.MessageDigest;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class MD5 {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static String MD5EncodeGB2312(String origin) throws Exception {
		String resultString = origin;
		MessageDigest md = MessageDigest.getInstance("MD5");
		resultString = byteArrayToHexString(md.digest(resultString.getBytes("GB2312")));

		return resultString;
	}

	public static String MD5EncodeGBK(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("GBK")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static String MD5EncodeUTF8(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static String SHA1EncodeUTF8(String origin, String key) {
		String resultString = null;
		try {
			resultString = Base64.encode(new String(origin + "&key" + key).getBytes("UTF-8"));
			MessageDigest md = MessageDigest.getInstance("SHA1");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		System.out.println(MD5.SHA1EncodeUTF8("123456", "jfajskhfkhsd"));;
	}

}