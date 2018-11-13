import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.Socket;
import javax.swing.*;
import java.io.*;



public class Client extends ClientPanel{
    
    
    public Client(){
        bottomButtonPanel.sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println(cryptedTextPanel.textArea.getText());
                plainTextPanel.textArea.setText("");
                cryptedTextPanel.textArea.setText("");
                bottomButtonPanel.sendButton.setEnabled(false);
                bottomButtonPanel.encryptButton.setEnabled(true);
            }
        });

        topButtonPanel.disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(1);
            }
        });
    }
    
    
    private void run() throws IOException{
        Socket socket = new Socket("127.0.0.1",6565);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        mainTextPanel.textArea.setEditable(false);
        String name = null;
        while(true) {
            String line = in.readLine();
            int id = 0;
            
         
            JOptionPanelSetting(line, id);
            //radioButtonsSetEnable(this.method, this.mode);
            
            if (line.startsWith("USERNAME")) {
                name = getName();
                out.println(name);
            } 
            else if (line.startsWith("NAMEOK")) {
                bottomTitlePanel.label.setText("Connected: " + name);
                plainTextPanel.textArea.setEditable(true);
            }
            else if (line.startsWith("MESSAGE")) {
                String senderName = line.split(": ")[0].substring(7);
                String message = line.split(": ")[1];
                Encrypting.Decrypt(this, message, senderName);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Client client = new Client();
        client.mainTextPanel.textArea.setEditable(false);
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.topButtonPanel.connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if(client.panelMethod.radio1.isSelected())
                    client.method = "AES";
                else
                    client.method = "DES";
                if(client.panelMode.radio1.isSelected())
                    client.mode = "CBC";
                else
                    client.mode = "OFB";
                
                
                client.topButtonPanel.connectButton.setEnabled(false);
                client.topButtonPanel.disconnectButton.setEnabled(true);
                client.mainTextPanel.textArea.setEditable(true);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.run();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
        client.bottomButtonPanel.encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Encrypting.Encrypt(client);
                client.bottomButtonPanel.encryptButton.setEnabled(false);
                client.bottomButtonPanel.sendButton.setEnabled(true);
            }
        });

    }
}
