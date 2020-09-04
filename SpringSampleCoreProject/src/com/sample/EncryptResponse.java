/*package com.sample;



import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Hashtable;

//import com.ycs.api.model.xsd.NaradaRequest;
//import com.ycs.api.serviceprovider.security.YPKIImplementation;
//import com.ycs.api.serviceprovider.utils.LogPurpose;


public class EncryptResponse {

	public static void main(String[] args) {
		
		String responseXML = "<RequestXml><TxnRefNo>99a46a9443</TxnRefNo><ProxyNumber>000000000252</ProxyNumber></RequestXml>";
		
		Hashtable<String,String> hash = encryptResponse( responseXML );
		
		System.out.println("Encrypt : "+hash.get("encResponse"));
		System.out.println("SessionKey : "+hash.get("encSessionKey"));
		//System.out.println("Signing Value "+SignResponse.signResponse(responseXML));
	}
	public static java.util.Hashtable<String,String> encryptResponse(String responseXML){
		String pubkey = "E:\\Bank_keys\\yal_pub.der";
		String pkiProvider = "BC";
		String SYMETRICKEY_ALG = "AES/CBC/PKCS5Padding";
		String CIPHER_ALG = "RSA/ECB/PKCS1Padding";
		String KEYFACTORY_ALG ="RSA";	
		String KEYGEN_ALG = "AES";
		int SYMETRIC_KEY_SIZE= 256;
		String msgRefNo = "lRzdi5ABu5xx"+"0000";

		java.util.Hashtable<String,String> response =  new java.util.Hashtable<String,String>();

		try{ 
			byte[] sessionKey = YPKIImplementation.generateSessionKey(KEYGEN_ALG, pkiProvider, SYMETRIC_KEY_SIZE);
			System.out.println( "Generate Session Key : "+hexString(sessionKey) );
			
			String encSessionKey = YPKIImplementation.encryptSessionKey(sessionKey, pubkey, CIPHER_ALG, KEYFACTORY_ALG, pkiProvider);
			
			//System.out.println("[encryptResponse] Encrypted SessionKey["+encSessionKey+"]"+"  SessionKey length : "+encSessionKey.length());

			String encResponse= YPKIImplementation.encryptRequestWithSessionKey(sessionKey, SYMETRICKEY_ALG, pkiProvider, responseXML.getBytes(), msgRefNo);
			//System.out.println("[encryptResponse] Ecrypted Response ["+encResponse+"]");
			
			response.put("encResponse", encResponse);
			response.put("encSessionKey", encSessionKey);

			System.out.println("Encrypt Response : "+response.get("encResponse"));
			System.out.println("Session Key      : "+response.get("encSessionKey"));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised "+e.getMessage());
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised "+e.getMessage());
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised "+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("[encryptResponse] Exception Raised "+e.getMessage());
		}

		return response;
	}
	public static String decrypt(String encRequest,String encSessionKey,String cid,NaradaRequest naradaRequest){
		String finalresp = null;
		
		String pvtFileName = "E:\\Bank_keys\\giprivkey.pem";
		String PKI_PROVIDER = "BC";
		String SYMETRICKEY_ALG = "AES/CBC/PKCS5Padding";
		String CIPHER_ALG = "RSA/ECB/PKCS1Padding";
		
		try{
			byte[] decSessionKey = YPKIImplementation.decryptSessionKey(encSessionKey, pvtFileName, CIPHER_ALG, PKI_PROVIDER);
			byte[] decResponse = YPKIImplementation.decryptResponseWithSessionKey(decSessionKey, SYMETRICKEY_ALG, PKI_PROVIDER, encRequest,naradaRequest.getRequestHeader().getMsgRefNo());
			finalresp = new String(decResponse);
			if(finalresp != null){
				System.out.println("Before Plain Request Xml is ::"+finalresp.length());
			}
			else{
				System.out.println("Before Plain Request Xml is not decrypt");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception : "+e);
		}
		return finalresp;
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
}
*/