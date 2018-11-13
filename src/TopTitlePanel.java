import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class TopTitlePanel extends JPanel{
	
	public TopTitlePanel() {
		super();
		this.setBounds(0, 0, 700, 30);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		this.add(new JLabel("<HTML><U>S</U>erver</HTML>"));
		this.setVisible(true);
	}
}
