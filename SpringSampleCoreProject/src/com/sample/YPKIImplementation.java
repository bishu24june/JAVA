package com.sample;

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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;


public class YPKIImplementation{
	static
	{
		Security.addProvider(new BouncyCastleProvider());
	}
	public static String base64Encode(byte[] binaryData)
	{
		return Base64.encodeBase64String(binaryData);
	}
	public static byte[] base64Decode(String base64String)
	{
		return Base64.decodeBase64(base64String);
	}
	
	public static String signRequest(String pvtKeyFileName,byte[] dataToSign,String pkiProvider,String signatureAlg ) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
	{
		
		PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
		Signature signature = Signature.getInstance(signatureAlg, pkiProvider);
		signature.initSign(privateKey);
		
		signature.update(dataToSign);
		byte[] signatureBytes = signature.sign();
		
		return base64Encode(signatureBytes);
		
	}
	
	public static boolean verifyRequest(String pubKeyFileName,byte[] encryptedData,byte[] hashedRequest,String pkiProvider,String signatureAlg,String keyFactoryAlg) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException
	{
		boolean isVerified = false;
		
	    PublicKey pubKey = getPublicKey(pubKeyFileName, keyFactoryAlg, pkiProvider);

		Signature verifier = Signature.getInstance(signatureAlg, pkiProvider);
		verifier.initVerify(pubKey);
		verifier.update(hashedRequest);
		if (verifier.verify(encryptedData)) 
		{
			isVerified=true;
		} else 
		{ 
			isVerified=false;
		}
		
		return isVerified;
	} 
	
	public static byte[] getRequestHash(String dataToHash,String messageDgstAlg,String pkiProvider)
	{
		byte[] hashedRequest=null;
		
		try 
		{
			MessageDigest requestHash = MessageDigest.getInstance(messageDgstAlg, pkiProvider);
			hashedRequest = requestHash.digest(dataToHash.getBytes());
			
		} catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashedRequest;
	}
	
	private static FileReader getPVTKeyFile(File pvtFile)
	{
		FileReader pvtFileReader=null;
		try 
		{
			pvtFileReader = new FileReader(pvtFile);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			pvtFileReader=null;
		}
		
		return pvtFileReader;
	}
	private static byte[] getPUBKeyData(String pubKeyFileName) throws IOException{
	
		File pubKeyFile = new File(pubKeyFileName);
		FileInputStream pubKeyStream = new FileInputStream(pubKeyFile);
		byte[] pubKey = new byte[(int) pubKeyFile.length()];
		pubKeyStream.read(pubKey);
		if(pubKeyStream != null){
			pubKeyStream.close();
			pubKeyStream = null;
		}
		return pubKey;
	}
	
	public  static PublicKey getPublicKey(String pubKeyFileName,String keyFactoryAlg, String pkiProvider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException
	{
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(getPUBKeyData(pubKeyFileName));
	    KeyFactory keyFactory = KeyFactory.getInstance(keyFactoryAlg,pkiProvider);
	    return keyFactory.generatePublic(publicKeySpec);
	}
	
	private static PrivateKey getPrivateKey(String pvtKeyFileName) throws IOException
	{
		FileReader pvtFileReader = getPVTKeyFile(new File(pvtKeyFileName));
		PEMReader pvtPemReader = getPvtPemReader(pvtFileReader);
		KeyPair keyPair = (KeyPair) pvtPemReader.readObject();
		
		pvtPemReader.close();
		pvtFileReader.close();
		pvtPemReader=null;
		pvtFileReader=null;
		
		return keyPair.getPrivate();
		
	}
		
	public static String encrypt(String encrptedData,PublicKey pubKey,String cipherAlg,String pkiProvider) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException 
	{
	
		byte[] encryptionByte = null;
	    Cipher encryptCipher = Cipher.getInstance(cipherAlg,pkiProvider);
	    encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
	    encryptionByte = encryptCipher.doFinal(encrptedData.getBytes());
	    return base64Encode(encryptionByte);
	
	}

	public static byte[] decryptSessionKey(String decrptedData,String pvtKeyFileName,String cipherAlg,String pkiProvider) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, IOException 
	{
	    
		byte[] decryptionByte = null;
	    PrivateKey privateKey = getPrivateKey(pvtKeyFileName);
	    Cipher decryptCipher = Cipher.getInstance(cipherAlg,pkiProvider);
	    decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
	    
	    System.out.println( new String(base64Decode(decrptedData)) );
	    
	    decryptionByte = decryptCipher.doFinal(base64Decode(decrptedData));
	    return decryptionByte;
	    
	}
	public static byte[] decryptResponseWithSessionKey(byte[] sessionKey, String symetricKeyAlg,String pkiProvider,String encXML)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,IllegalBlockSizeException, BadPaddingException, NoSuchProviderException
	{
		
		SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, symetricKeyAlg);
		Cipher symmCipher = Cipher.getInstance(symetricKeyAlg, pkiProvider);
		symmCipher.init(Cipher.DECRYPT_MODE, symmKeySpec);
		byte[] xmlData = symmCipher.doFinal(base64Decode(encXML));
		return xmlData;
		
	}
	
	
	private static PEMReader getPvtPemReader(Reader pvtFile){
		return new PEMReader(pvtFile);
	}
	public static byte[] generateSessionKey(String keyGeneratorAlg,String pkiProvider,int symetricKeySize) throws NoSuchAlgorithmException, NoSuchProviderException{
		KeyGenerator kgen = KeyGenerator.getInstance(keyGeneratorAlg, pkiProvider);//this.getEncryptionStrategy());
		kgen.init(symetricKeySize);
		SecretKey key = kgen.generateKey();
		byte[] symmKey = key.getEncoded();
		return symmKey;
	}
	public static String encryptSessionKey(byte []sessionKey,String pubKeyFileName,String cipherAlg,String keyFactoryAlg, String pkiProvider) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidKeySpecException, IOException 
	{
	    byte[] encryptionByte = null;
	    PublicKey pubKey = getPublicKey(pubKeyFileName, keyFactoryAlg, pkiProvider);
	    Cipher encryptCipher = Cipher.getInstance(cipherAlg,pkiProvider);
	    encryptCipher.init(Cipher.ENCRYPT_MODE, pubKey);
	    encryptionByte = encryptCipher.doFinal(sessionKey);
	    
	    System.out.println("Before Encode : "+new String(encryptionByte));
	    
	    return base64Encode(encryptionByte);
	}
	
	public static String encryptRequestWithSessionKey(byte[] sessionKey, String symetricKeyAlg,String pkiProvider,byte[] xmlRequestData,String msgRefNo)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException{
		SecretKeySpec symmKeySpec = new SecretKeySpec(sessionKey, symetricKeyAlg);
		Cipher symmCipher = Cipher.getInstance(symetricKeyAlg, pkiProvider);
		symmCipher.init(Cipher.ENCRYPT_MODE, symmKeySpec, new IvParameterSpec(msgRefNo.getBytes()));
		byte[] encXMLPidData = symmCipher.doFinal(xmlRequestData);
		return base64Encode(encXMLPidData);
	}
	
	
}
