
public class Encrypting {
	
	public static void Decrypt(Client client, String message, String senderName) {
    	AES aes;
        DES des;
        String plainText = null;

        if(client.method.equals("AES") && client.mode.equals("CBC")){
            try {
                aes = new AES();
                plainText = aes.decrypt(message,1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else if(client.method.equals("AES") && client.mode.equals("OFB")){
            try {
                aes = new AES();
                plainText = aes.decrypt(message,2);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else if(client.method.equals("DES") && client.mode.equals("CBC")){

            try {
                des = new DES();
                plainText = des.decrypt(message,1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }else if(client.method.equals("DES") && client.mode.equals("OFB")){
            try {
                des = new DES();
                plainText = des.decrypt(message,2);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        client.mainTextPanel.textArea.append(message+"\n");
        client.mainTextPanel.textArea.append(senderName+": "+plainText+"\n");
    }
	
	public static void Encrypt(Client client) {
        String plainText = client.plainTextPanel.textArea.getText();
    	String encrypted = null;
        AES aes = null;
        DES des = null;
    	
    	if(client.method.equals("AES") && client.mode.equals("CBC")){
            try {
                aes = new AES();
                encrypted = aes.encrypt(plainText,1);
                client.cryptedTextPanel.textArea.setText(encrypted);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    	else if(client.method.equals("AES") && client.mode.equals("OFB")){
            try {
                aes = new AES();
                encrypted = aes.encrypt(plainText,2);
                client.cryptedTextPanel.textArea.setText(encrypted);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    	else if(client.method.equals("DES") && client.mode.equals("CBC")){
            try {
                des = new DES();
                encrypted = des.encrypt(plainText,1);
                client.cryptedTextPanel.textArea.setText(encrypted);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    	else if(client.method.equals("DES") && client.mode.equals("OFB")){
            try {
                des = new DES();
                encrypted = des.encrypt(plainText,2);
                client.cryptedTextPanel.textArea.setText(encrypted);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
