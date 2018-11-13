

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class ClientPanel {
    public JFrame frame = new JFrame("Cyrpto Messenger");
    public TopTitlePanel topTitlePanel;
    public TopButtonPanel topButtonPanel;
    public RadioButtonPanel panelMethod;
    public RadioButtonPanel panelMode;
    public MainTextAreaPanel mainTextPanel;
    public PlainTextPanel plainTextPanel;
    public CryptedTextPanel cryptedTextPanel;
    public BottomButtonPanel bottomButtonPanel;
    public BottomTitlePanel bottomTitlePanel;
    public BufferedReader in;
    public PrintWriter out;
    public String method;
    public String mode;
    
    
    public ClientPanel() {
    	topTitlePanel = new TopTitlePanel();
        topButtonPanel = new TopButtonPanel();

        panelMethod = new RadioButtonPanel(290, 40, "Method", "AES", "DES");
        panelMode = new RadioButtonPanel(460, 40, "Mode", "CBC", "OFB");

        mainTextPanel = new MainTextAreaPanel();
        DefaultCaret caret = (DefaultCaret) mainTextPanel.textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);


        plainTextPanel = new PlainTextPanel();
        cryptedTextPanel = new CryptedTextPanel();
        bottomButtonPanel = new BottomButtonPanel();
        bottomTitlePanel = new BottomTitlePanel();

        plainTextPanel.textArea.setEditable(false);
        cryptedTextPanel.textArea.setEditable(false);
        bottomButtonPanel.sendButton.setEnabled(false);


        frame.add(bottomTitlePanel);
        frame.add(topButtonPanel);
        frame.add(bottomButtonPanel);
        frame.add(cryptedTextPanel);
        frame.add(plainTextPanel);
        frame.add(mainTextPanel);
        frame.add(panelMethod);
        frame.add(panelMode);
        frame.add(topTitlePanel);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setBounds(500, 50, 700, 660);
        frame.setVisible(true);
    }
    
    public void radioButtonsSetEnable(String method, String mode) {
    	if(method.equals("AES")){
            panelMethod.radio1.setSelected(true);
            panelMethod.radio2.getModel().setEnabled(false);
        }
        else{
            panelMethod.radio2.setSelected(true);
            panelMethod.radio1.getModel().setEnabled(false);
        }
    	
    	if(mode.equals("CBC")){
            panelMode.radio1.setSelected(true);
            panelMode.radio2.getModel().setEnabled(false);
        }
        else{
            panelMode.radio2.setSelected(true);
            panelMode.radio1.getModel().setEnabled(false);
        }
    }
    
    public void JOptionPanelSetting(String line, int id) {
    	if(line.startsWith("ID")){
            id = Integer.valueOf(line.substring(3));
            if(id == 1){
                out.println("METHOD:"+method);
                out.println("MODE:"+mode);
		radioButtonsSetEnable(method,mode);
            }
        }
        if(line.startsWith("METHOD:"))
            method = line.substring(7);
        if(line.startsWith("MODE:")){
            mode = line.substring(5);
            if(id != 1)
                JOptionPane.showMessageDialog(frame,"This chat room's encryption is set to: "+method+"/"+mode);
	    radioButtonsSetEnable(method,mode);
        }
    }
    
    public String getName(){
        return JOptionPane.showInputDialog(frame,"Enter your nickname",
                "Choose a nickname",JOptionPane.QUESTION_MESSAGE);
    }
}
