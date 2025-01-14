import javax.swing.*;
import java.awt.*;

public class GuiRandomStar extends JFrame {
	public GuiRandomStar() {
		super("랜덤한 별");
		setDefaultCloseOperation(GuiRandomStar.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setSize(300, 300);
		c.add(new SouthPanel(), BorderLayout.SOUTH); 
		c.add(new CenterPanel(), BorderLayout.CENTER); 
		c.add(new NorthPanel(), BorderLayout.NORTH);;
		setVisible(true);
	}
	
	public class SouthPanel extends JPanel {
		public SouthPanel() {
			setBackground(Color.YELLOW);
			setOpaque(true);
			add(new JButton("Exit"));
		}
	}

	public class CenterPanel extends JPanel {
		public CenterPanel() {
			setBackground(Color.WHITE);
			setOpaque(true);
			setLayout(null);		
			
			for(int i=0; i<15; i++) {
				int x = (int)(Math.random()*280);
				int y = (int)(Math.random()*180);
				JLabel star = new JLabel("*");
				star.setLocation(x,y);
				star.setForeground(Color.RED);
				star.setSize(10,10);
				add(star);
			}

			JButton refreshBtn = new JButton("Refresh");
			refreshBtn.setSize(80, 20);
			refreshBtn.setLocation(10, 10);
			add(refreshBtn);

		}
	}
	
	public class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setOpaque(true);
			add(new JLabel("별 개수"));
			add(new JTextField(10));
			add(new JButton("별 만들기"));
		}
	}
	
	public static void main(String[] args) {
		new GuiRandomStar();
	}
}