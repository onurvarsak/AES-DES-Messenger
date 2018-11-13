import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class RadioButtonPanel extends JPanel{
	
	JRadioButton radio1;
	JRadioButton radio2;
	ButtonGroup bg;
	
	public RadioButtonPanel(int x, int y, String title, String arg0, String arg1) {
		super();
		this.setBounds(x, y, 150, 60);
		this.setBorder(new TitledBorder(title));
		
		bg = new ButtonGroup();
		
		radio1 = new JRadioButton(arg0);
		radio2 = new JRadioButton(arg1);
		radio1.setSelected(true);
		
		bg.add(radio1);
		bg.add(radio2);
		
		this.add(radio1);
		this.add(radio2);
		
	}
}
