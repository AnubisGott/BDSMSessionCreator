package filesReadAndWrite;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import hilfsklassen.Logger;
 

public class CryptUtil {

	public static SecretKeySpec getKey() {
		// Das Passwort bzw der Schluesseltext
		Logger.log(Logger.all, "start of method CryptUtil.getKey()", CryptUtil.class);
		String keyStr = "asdklfasdkfakdsfsakd"; //! der Schlüssel sollte von Gerät/User/Datum abhängen
		
		// byte-Array erzeugen
		byte[] key;
		try {
			key = (keyStr).getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			Logger.log(e);
			return null;
		}
		// aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
		MessageDigest sha;
		try {
			sha = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			Logger.log(e);
			return null;
		}
		
		key = sha.digest(key);
		// nur die ersten 128 bit nutzen
		key = Arrays.copyOf(key, 16); 
		// der fertige Schluessel
		return new SecretKeySpec(key, "AES");
	}
	
	public static String encryptText(String text, SecretKeySpec key) {
		Logger.log(Logger.all, "start of method CryptUtil.encryptText()", CryptUtil.class);
	    Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			Logger.log(e);
			return null;
		}
	      try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			Logger.log(e);
			return null;
		}

	    byte[] encrypted;
		try {
			encrypted = cipher.doFinal(text.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			Logger.log(e);
			return null;
		}

	    String returnString = "";
	    for(int i=0; i<encrypted.length; i++) {
	    	if(i==encrypted.length-1) returnString = returnString.concat("" + encrypted[i]);
	    	else returnString = returnString.concat("" + encrypted[i] + " ");
	    }

		return returnString;
	}

	public static String decryptText(String entschluesselnText, SecretKeySpec key) {
		Logger.log(Logger.all, "start of method CryptUtil.decryptText()", CryptUtil.class);
		String[] numberStrs = entschluesselnText.split(" ");
		byte[] numbers = new byte[numberStrs.length];
		for(int i = 0;i < numberStrs.length;i++)
		{
			   numbers[i] = Byte.parseByte(numberStrs[i]);
		}
		
		
        Cipher cipher2;
		try {
			cipher2 = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			Logger.log(e);
			return null;
		}
	      try {
			cipher2.init(Cipher.DECRYPT_MODE, key);
		} catch (InvalidKeyException e) {
			Logger.log(e);
			return null;
		}
	      
        byte[] cipherData2;
		try {
			cipherData2 = cipher2.doFinal(numbers);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			Logger.log(e);
			return null;
		}
		
        String erg = new String(cipherData2);
	 
	    // Klartext
		Logger.log(Logger.all, "Ergebnis: " + erg, CryptUtil.class);		
	    
		return erg;
	}
}
