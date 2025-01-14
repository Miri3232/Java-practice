import javax.swing.*;
import java.awt.*;

public class GuiRandomNumber extends JFrame {
	public GuiRandomNumber() {
		super("West Grid 프레임");
		setDefaultCloseOperation(GuiRandomNumber.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setSize(300, 300);
		c.add(new CenterPanel(), BorderLayout.CENTER); 
		c.add(new WestPanel(), BorderLayout.WEST);
		setVisible(true);
	}

	public class CenterPanel extends JPanel {
		public CenterPanel() {
			setBackground(Color.WHITE);
			setOpaque(true);
			setLayout(null);
			
			for(int i=0; i<9; i++) {
				int x = (int)(Math.random()*150 + 50);
				int y = (int)(Math.random()*150 + 50);
				JLabel number = new JLabel(Integer.toString(i));
				number.setForeground(Color.RED);
				number.setLocation(x, y);
				number.setSize(15, 15);
				add(number);
			}
		}
	}
	
	public class WestPanel extends JPanel {
		Color[] color = {Color.ORANGE, Color.YELLOW, Color.GREEN,
				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
				Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY };
		public WestPanel() {
			setLayout(new GridLayout(10, 1));
			JButton[] btn = new JButton[10];
			for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton();
			btn[i].setOpaque(true);
			btn[i].setBackground(color[i]);
			add(btn[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		new GuiRandomNumber();
	}
}