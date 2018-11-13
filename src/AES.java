import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {
	IvParameterSpec IV;
	SecretKeySpec key;
	Cipher cipher;
	
	
	/* mode = 1 is CBC
	 * mode = 2 is OFB
	 */
	public AES()  throws Exception {
		
		
		/* initVector = "myOwnInitVector0"
		 * symetrcKey = "onurvelibbm46518"
		 */
		this.IV = new IvParameterSpec("myOwnInitVector0".getBytes("UTF-8"));
		this.key = new SecretKeySpec("onurvelibbm46518".getBytes("UTF-8"), "AES");
	}
	
	public String encrypt(String plaintText, int mode) throws Exception {
		if(mode == 1) 
			cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		else 
			cipher = Cipher.getInstance("AES/OFB/NoPadding");
		
		return modeEncrypt(plaintText);
	}
	
	
	
	public String decrypt(String ciphertext, int mode) throws Exception{
		if(mode == 1)
			cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		else 
			cipher = Cipher.getInstance("AES/OFB/NoPadding");
		
		return modeDecrypt(ciphertext);
	}
	
	
	public String modeEncrypt(String plainText) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, key, IV);
		byte[] text = plainText.getBytes();
		byte[] ciphertext = cipher.doFinal(text);
		return Base64.getEncoder().encodeToString(ciphertext);
	}
	
	
	
	
	public String modeDecrypt(String ciphertext) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, key, IV);
		byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
		return new String(plaintext);
	}
	
}
