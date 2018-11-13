
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DES {
	IvParameterSpec IV;
	SecretKeySpec key;
	Cipher cipher;
	
	
	/* mode = 1 is CBC
	 * mode = 2 is OFB
	 */
	public DES() throws Exception {
		
		/* initVector = "00000000"
		 * symetrcKey = "velionur"
		 */
		this.IV = new IvParameterSpec("00000000".getBytes("UTF-8"));
		this.key = new SecretKeySpec("velionur".getBytes("UTF-8"),"DES");
		
	}
	
	
	public String encrypt(String plaintText, int mode) throws Exception {
		if(mode == 1) 
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		else 
			cipher = Cipher.getInstance("DES/OFB/NoPadding");
		
		return modeEncrypt(plaintText);
	}
	
	
	
	public String decrypt(String ciphertext, int mode) throws Exception{
		if(mode == 1)
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		else 
			cipher = Cipher.getInstance("DES/OFB/NoPadding");
		
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
