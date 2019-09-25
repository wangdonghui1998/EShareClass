package com.es.plailing.util.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

/**
 * 
    * @ClassName: UrlUtil
    * @Description: TODO(BASE64�ļ��ܽ���)
    * @author ����ϼ
    * @date 2018��12��12��
    *
 */
public class UrlUtil {

	private static final String KEY = "plailing";
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);

	/**
	 * 
	    * @Title: enCryptAndEncode
	    * @Description: TODO(���ܺ���)
	    * @param @param content(��������)
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	public static String enCryptAndEncode(String content) {
		try {
			byte[] sourceBytes = enCryptAndEncode(content, KEY);
			return Base64.encodeBase64URLSafeString(sourceBytes);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return content;
		}
	}
	
	/**
	 * 
	    * @Title: enCryptAndEncode
	    * @Description: TODO(���ܺ���)
	    * @param @param content(��������)
	    * @param @param strKey(��Կ)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return byte[]    ��������
	    * @throws
	 */
	public static byte[] enCryptAndEncode(String content, String strKey) throws Exception {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

		SecretKey desKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, desKey);
		return cipher.doFinal(content.getBytes("UTF-8"));
	}

	/**
	 * 
	    * @Title: deCryptAndDecode
	    * @Description: TODO(���ܺ���)
	    * @param @param content(���ܹ����ַ���)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return String    ��������
	    * @throws
	 */
	public static String deCryptAndDecode(String content) throws Exception {
		byte[] targetBytes = Base64.decodeBase64(content);
		return deCryptAndDecode(targetBytes, KEY);
	}

	/**
	 * 
	    * @Title: deCryptAndDecode
	    * @Description: TODO(���ܺ���)
	    * @param @param src(���ܹ��Ķ������ַ�����)
	    * @param @param strKey
	    * @param @return
	    * @param @throws Exception    ����
	    * @return String    ��������
	    * @throws
	 */
	public static String deCryptAndDecode(byte[] src, String strKey) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128, new SecureRandom(strKey.getBytes()));

		SecretKey desKey = keyGenerator.generateKey();
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, desKey);
		byte[] cByte = cipher.doFinal(src);
		return new String(cByte, "UTF-8");
	}

}
