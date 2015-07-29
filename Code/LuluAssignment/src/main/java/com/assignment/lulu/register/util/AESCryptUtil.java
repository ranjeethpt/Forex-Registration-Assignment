package com.assignment.lulu.register.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.assignment.lulu.constant.ForexConstant;
import com.assignment.lulu.register.exception.ForexException;

/**
 * For password encryption and decryption
 * @author ranjeethpt
 * @see 29/07/2015
 */
public class AESCryptUtil {
	private static final String ALGORITHM = "AES";
	private static final String KEY = "1Hbfh667adfDEJ78";
	
	/**
	 * To encrypt the password as per the KEY.
	 * @param value to be encrypted.
	 * @return encrypted string.
	 * @throws Exception
	 */
	public static String encrypt(String value) throws ForexException {
		Key key = generateKey();
		String encryptedValue64 = null;
		try{
		Cipher cipher = Cipher.getInstance(AESCryptUtil.ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
		encryptedValue64 = new BASE64Encoder()
				.encode(encryptedByteValue);
		}catch(Exception e){
			throw new ForexException(e, 1031, ForexConstant.ERROR_1031);
		}
		return encryptedValue64;

	}

	/**
	 * For decryption.
	 * @param value to be decrypted
	 * @return decrypted String
	 * @throws Exception
	 */
	public static String decrypt(String value) throws ForexException {
		Key key = generateKey();
		Cipher cipher;
		String decryptedValue = null;
		try {
			cipher = Cipher.getInstance(AESCryptUtil.ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
			byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
			decryptedValue = new String(decryptedByteValue, "utf-8");
		}catch (Exception e) {
			throw new ForexException(e, 1030, ForexConstant.ERROR_1030);
		}
		return decryptedValue;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private static Key generateKey(){
		Key key = new SecretKeySpec(AESCryptUtil.KEY.getBytes(),
				AESCryptUtil.ALGORITHM);
		return key;
	}
}
