package com.sample;

import java.security.Key;
import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

class Checksum_kotak {
	static String skey = null;
	static Key key = null;

	public static void main(String[] args) {

		// skey = args[0];
		// System.out.println("key: " + skey);

		// skey =
		// "7A0D7DE6B5B0503A8044402B9653AB202887DD233378B9F3B4E72A71544B7AC0";

		byte[] digest;

		// String value = args[1];
		String value = "<RequestXml></TxnRefno>1231231231</TxnRefNo></RequestXml>";
		try {
			digest = SHA256(value);
			System.out.println("digest: " + digest);
			byte[] checkSumval1 = generateChecksum();
			String skey = Base64.encodeBase64String(checkSumval1);
			System.out.println(skey);
			byte[] encData = encrypt(hexStringToByteArray(skey), digest);
			String checkSumval = Base64.encodeBase64String(encData);
			System.out.println(checkSumval);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] generateChecksum() throws Exception {
		/*
		 * byte[] digest; String
		 * value="<RequestXml></TxnRefno>1231231231</TxnRefNo></RequestXml>";
		 * digest = SHA256(value); MessageDigest localMessageDigest =
		 * MessageDigest.getInstance("SHA-256"); byte[] digest1 =
		 * localMessageDigest.digest(); return digest1;
		 */
		/*
		 * key = KeyGenerator.getInstance("AES").generateKey();
		 * KeyGenerator.getInstance("AES").getProvider(); byte[] keyBytes =
		 * key.getEncoded();
		 */
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator key = KeyGenerator.getInstance("AES", "BC");
		key.init(256); // for example
		SecretKey secretKey = key.generateKey();
		byte[] keyBytes = secretKey.getEncoded();
		// SecretKey key1 = key.generateKey();
		// byte[] keyBytes = key.getEncoded();
		return keyBytes;
	}

	public static byte[] SHA256(String paramString) throws Exception {
		MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
		localMessageDigest.update(paramString.getBytes("UTF-8"));
		byte[] digest = localMessageDigest.digest();
		return digest;
	}

	public static byte[] encrypt(byte[] key, byte[] data) throws Exception {
		System.out.println(">>>>>>>>>KEY::" + key.length);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
		byte[] iv = new byte[32];
		// System.out.println("number of IV bytes is "+iv.length()+" "+iv);
		System.out.println(">>>>>>>>>iv::" + iv);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		System.out.println(">>>>>>>>>iv::" + ivSpec);
		Cipher acipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		acipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
		byte[] arrayOfByte1 = acipher.doFinal(data);
		return arrayOfByte1;
	}

	public static byte[] hexStringToByteArray(String s) {
		System.out.println(s);
		System.out.println(s.length());
		byte[] b = new byte[s.length() / 2];
		System.out.println(b);
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
}