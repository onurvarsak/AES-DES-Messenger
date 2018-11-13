import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopButtonPanel extends JPanel{

	JButton connectButton;
	JButton disconnectButton;
	
	public TopButtonPanel() {
		super();
		
		this.setBounds(0, 50, 260, 50);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		connectButton = new JButton("Connect");
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setEnabled(false);
		

		
		this.add(connectButton);
		this.add(disconnectButton);
		
	}
	

}
