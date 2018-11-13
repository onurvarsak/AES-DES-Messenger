import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class BottomTitlePanel extends JPanel{
	
	JLabel label;
	public BottomTitlePanel() {
		super();
		this.setBounds(0, 600, 700, 30);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
		
		label = new JLabel("Not Connected");
		this.add(label);
	}
}
