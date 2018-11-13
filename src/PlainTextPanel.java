import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PlainTextPanel extends JPanel{
	JTextArea textArea;
	JScrollPane scrollPane;
	
	
	public PlainTextPanel() {
		super();
		this.setBounds(3, 500, 250, 100);
		this.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setBorder(new TitledBorder("Text"));

		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setLineWrap(true);
		add(scrollPane);
	}
}
