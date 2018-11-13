import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomButtonPanel extends JPanel{
	
	
	JButton encryptButton;
	JButton sendButton;
	
	
	public BottomButtonPanel() {
		super();
		this.setBounds(509, 530, 181, 50);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		encryptButton = new JButton("Encrypt");
		sendButton = new JButton("Send");
		
		this.add(encryptButton);
		this.add(sendButton);
	}
}
