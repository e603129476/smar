package com.huaxun.smart.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public Map encryptPassword(String account,String pass) {
		Map password=new HashMap();
		String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName, pass, ByteSource.Util.bytes(account+salt), hashIterations).toHex();
		password.put("salt",salt);
		password.put("password",newPassword);
		return password;
	}
}
