/*package com.sample;

import java.io.BufferedReader;
//package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Hashtable;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.PEMReader;

//import sun.misc.BASE64Encoder;

public class YmlChecksum {
	public static void main(String[] args) {

		// Security.addProvider(new
		// org.bouncycastle.jce.provider.BouncyCastleProvider());
		// String responseXML =
		// "<RequestXml><TxnRefNo>99a46a9443</TxnRefNo><ProxyNumber>000000000252</ProxyNumber></RequestXml>";
		String responseXML = "<RequestXml></TxnRefno>1231231231</TxnRefNo></RequestXml>";
		System.out.println("Encrypt :" + responseXML);
		Hashtable<String, String> hash = encryptResponse(responseXML);

		String encResp = "RAYo8PsAs8OyNNV/0AOftHHikWKUEzboyMQqMAYKIp1U2FLQuQzdlcjXYqfOns8hxp5SKveQAudNQnJtUN3ZbBOAN/HXhbbstD6qKaGP/16KrmX1lgxAZEGkXHMnREZ6";
		String sessionKey = "Av9Gb+voGJ48TJmXH3LpdtkbVtglrlvQLCZCODg18tp+v1YgyrNKb4VueljFGBpsC6RM6M1mN1jL1i0S65yKZOLrGJB336y24KTfQWSu6vUJs9xuNPpRyHaLf37qQsICADAui2jCoXyI1H6l4RR8V1BhzQQTMOm/UbxjPi6/OVqmbQJQ6GtxZtOo2uX/BzmuQbirWHw+wdoOGMWRWrn/+bd14O+aP+ewzUPDqcAtgScCqz2F7Su80Qldc2LCdtxvvyTQo8BbN7uE+nihk5YDcj6X9Sz2w0VN1U2N2jKCG0eoeQjy68cX+/LH0xQRkCi5s6PV0SqaRsbDFsBgj5C3xQ==";
		// String otp=decrypt(encResp,sessionKey,String cid,NaradaRequest
		// naradaRequest);

	}

	public static java.util.Hashtable<String, String> encryptResponse(String responseXML) {
		String pubkey = "yal_pub.der";
		String privatekey = "airpay_sodexho.pem";
		String pkiProvider = "BC";
		String SYMETRICKEY_ALG = "AES/CBC/PKCS5Padding";
		String CIPHER_ALG = "RSA/ECB/PKCS1Padding";
		String KEYFACTORY_ALG = "RSA";
		String KEYGEN_ALG = "AES";
		int SYMETRIC_KEY_SIZE = 256;
		String msgRefNo = "lRzdi5ABu5xx" + "0000";
		String signatureAlg = "SHA1withRSA";

		java.util.Hashtable<String, String> response = new java.util.Hashtable<String, String>();

		try {
			byte[] sessionKey = generateSessionKey(KEYGEN_ALG, pkiProvider, SYMETRIC_KEY_SIZE);
			// System.out.println( "Generate Session Key :
			// "+hexString(sessionKey) );

			String encSessionKey = encryptSessionKey(sessionKey, pubkey, CIPHER_ALG, KEYFACTORY_ALG, pkiProvider);

			// System.out.println("[encryptResponse] Encrypted
			// SessionKey["+encSessionKey+"]"+" SessionKey length :
			// "+encSessionKey.length());

			String encResponse = encryptRequestWithSessionKey(sessionKey, SYMETRICKEY_ALG, pkiProvider,
					responseXML.getBytes(), msgRefNo);
			// System.out.println("[encryptResponse] Ecrypted Response
			// ["+encResponse+"]");

			// String
			// encResponsefromAirpayppk=encryptWithAirpaysPrivateKey(privatekey,pkiProvider,responseXML.getBytes(),KEYFACTORY_ALG);
			String encResponsefromAirpayppk = signRequest(privatekey, responseXML.getBytes(), pkiProvider,
					signatureAlg);

			// response.put("encResponse", encResponse);
			// response.put("encSessionKey", encSessionKey);

			// System.out.println("Encrypt Response :
			// "+response.get("encResponse"));
			// System.out.println("Session Key :
			// "+response.get("encSessionKey"));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised " + e.getMessage());
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised " + e.getMessage());
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised " + e.getMessage());
		}

		return response;
	}

	
	 * public static String decrypt(String encRequest,String
	 * encSessionKey,String cid,NaradaRequest naradaRequest){ String finalresp =
	 * null;
	 * 
	 * String pvtFileName = "E:\\Bank_keys\\giprivkey.pem"; String PKI_PROVIDER
	 * = "BC"; String SYMETRICKEY_ALG = "AES/CBC/PKCS5Padding"; String
	 * CIPHER_ALG = "RSA/ECB/PKCS1Padding";
	 * 
	 * try{ byte[] decSessionKey = decryptSessionKey(encSessionKey, pvtFileName,
	 * CIPHER_ALG, PKI_PROVIDER); byte[] decResponse =
	 * decryptResponseWithSessionKey(decSessionKey, SYMETRICKEY_ALG,
	 * PKI_PROVIDER, encRequest,naradaRequest.getRequestHeader().getMsgRefNo());
	 * finalresp = new String(decResponse); if(finalresp != null){
	 * System.out.println("Before Plain Request Xml is ::"+finalresp.length());
	 * } else{ System.out.println("Before Plain Request Xml is not decrypt"); }
	 * } catch (Exception e) { e.printStackTrace();
	 * System.out.println("Exception : "+e); } return finalresp; }
	 
	public static byte[] generateSessionKey(String keyGeneratorAlg, String pkiProvider, int symetricKeySize)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		// Security.addProvider(new
		// org.bouncycastle.jce.provider.BouncyCastleProvider());
		KeyGenerator kgen = KeyGenerator.getInstance(keyGeneratorAlg, pkiProvider);// this.getEncryptionStrategy());
		kgen.init(symetricKeySize);
		SecretKey key = kgen.generateKey();
		byte[] symmKey = key.getEncoded();
		return symmKey;
	}

	public static String encryptSessionKey(byte[] sessionKey, String pubKeyFileName, String cipherAlg,
			String keyFactoryAlg, String pkiProvider)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchProviderException, InvalidKeySpecException, IOException {
		byte[] encryptionByte = null;
		PublicKey pubKey = getPublicKey(pubKeyFileName, keyFactoryAlg, pkiProvider);
		Cipher encryptCipher = Cipher.getInstance(cipherAlg, pkiProvider);
		encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
		encryptionByte = encryptCipher.doFinal(sessionKey);

		// System.out.println("Before Encode : "+new String(encryptionByte));

		//return base64Encode(encryptionByte);
		return null;
	}

	public static PublicKey getPublicKey(String pubKeyFileName, String keyFactoryAlg, String pkiProvider)
			throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException {
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(getPUBKeyData(pubKeyFileName));
		KeyFactory keyFactory = KeyFactory.getInstance(keyFactoryAlg, pkiProvider);
		return keyFactory.generatePublic(publicKeySpec);
	}

	public static String base64Encode(byte[] binaryData) {
		return Base64.encodeBase64String(binaryData);
	}

	public static String hexString(byte[] b) {
		int len = b.length;
		StringBuilder sb = new StringBuilder(len * 2);
		for (int i = 0; i < len; i++) {
			char lo = Character.forDigit(b[i] & 0x0F, 16);
			char hi = Character.forDigit((b[i] >> 4) & 0x0F, 16);
			sb.append(hi);
			sb.append(lo);
		}
		return sb.toString();
	}

	private static byte[] getPUBKeyData(String pubKeyFileName) throws IOException {

		File pubKeyFile = new File(pubKeyFileName);
		FileInputStream pubKeyStream = new FileInputStream(pubKeyFile);
		byte[] pubKey = new byte[(int) pubKeyFile.length()];
		pubKeyStream.read(pubKey);
		if (pubKeyStream != null) {
			pubKeyStream.close();
			pubKeyStream = null;
		}
		return pubKey;
	}

	public static String encryptRequestWithSessionKey(byte[] sessionKey, String symetricKeyAlg, String pkiProvider,
			byte[] xmlRequestData, String msgRefNo)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
		SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, symetricKeyAlg);
		Cipher symmCipher = Cipher.getInstance(symetricKeyAlg, pkiProvider);
		symmCipher.init(Cipher.ENCRYPT_MODE, symmKeySpec, new IvParameterSpec(msgRefNo.getBytes()));
		byte[] encXMLPidData = symmCipher.doFinal(xmlRequestData);
		//return base64Encode(encXMLPidData);
		return null;
	}

	public static String signRequest(String pvtKeyFileName, byte[] dataToSign, String pkiProvider, String signatureAlg)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException,
			SignatureException {
		System.out.println("Signature" + pvtKeyFileName);
		PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
		System.out.println("Signature" + pvtKeyFileName);
		Signature signature = Signature.getInstance(signatureAlg, pkiProvider);
		signature.initSign(privateKey);

		signature.update(dataToSign);
		byte[] signatureBytes = signature.sign();
		System.out.println("Signature" + signatureBytes);
		//return base64Encode(signatureBytes);
		
		return null;

	}

	public static byte[] decryptSessionKey(String decrptedData, String pvtKeyFileName, String cipherAlg,
			String pkiProvider) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, IOException {

		byte[] decryptionByte = null;
		PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
		Cipher decryptCipher = Cipher.getInstance(cipherAlg, pkiProvider);
		decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

		System.out.println(new String(base64Decode(decrptedData)));

		decryptionByte = decryptCipher.doFinal(base64Decode(decrptedData));
		return decryptionByte;

	}

	public static byte[] decryptResponseWithSessionKey(byte[] sessionKey, String symetricKeyAlg, String pkiProvider,
			String encXML) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchProviderException {

		SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, symetricKeyAlg);
		Cipher symmCipher = Cipher.getInstance(symetricKeyAlg, pkiProvider);
		symmCipher.init(Cipher.DECRYPT_MODE, symmKeySpec);
		byte[] xmlData = symmCipher.doFinal(base64Decode(encXML));
		return xmlData;

	}

	public static byte[] base64Decode(String base64String) {
		return Base64.decodeBase64(base64String);
	}

	private static PrivateKey getPrivateKey(String pvtKeyFileName) throws IOException {
		System.out.println("Signature++" + pvtKeyFileName);
		FileReader pvtFileReader = getPVTKeyFile(new File(pvtKeyFileName));
		System.out.println("Signature@@@@@" + pvtFileReader);
		PEMReader pvtPemReader = getPvtPemReader(pvtFileReader);
		System.out.println("Signature%%%%%" + pvtPemReader);
		System.out.println("Signature2222%%%%%" + pvtPemReader.readObject());
		KeyPair keyPair = (KeyPair) pvtPemReader.readObject();
		System.out.println("keypair%%%%%" + keyPair);

		pvtPemReader.close();
		pvtFileReader.close();
		pvtPemReader = null;
		pvtFileReader = null;

		return keyPair.getPrivate();

	}

	private static FileReader getPVTKeyFile(File pvtFile) {
		System.out.println("inside%%%%%" + pvtFile);
		FileReader pvtFileReader = null;
		try {

			String keyPath = "airpay_sodexho.pem";
			BufferedReader br = new BufferedReader(new FileReader(keyPath));
			System.out.println("inside kkkkkkkkkkkkkkkk" + br);
			Security.addProvider(new BouncyCastleProvider());
			PEMParser pp = new PEMParser(br);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pvtFileReader = null;
		}

		return pvtFileReader;
	}

	private static PEMReader getPvtPemReader(Reader pvtFile) {
		System.out.println("Bhagyashree" + pvtFile);
		return new PEMReader(pvtFile);
	}
}*/