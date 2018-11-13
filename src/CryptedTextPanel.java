import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class CryptedTextPanel extends JPanel{
	
	JTextArea textArea;
	JScrollPane scrollPane;
	public CryptedTextPanel() {
		super();
		this.setBounds(256, 500, 250, 100);
		this.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setBorder(new TitledBorder("Crypted Text"));
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setLineWrap(true);
		add(scrollPane);
	}
}
