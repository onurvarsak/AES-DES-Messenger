import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainTextAreaPanel extends JPanel{
	
	
	JTextArea textArea;
	JScrollPane scrollPane;
	
	public MainTextAreaPanel() {
		super();
		this.setBounds(0, 100, 700, 400);
		textArea = new JTextArea(25,63);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setLineWrap(true);
		this.add(scrollPane);

	}
}
