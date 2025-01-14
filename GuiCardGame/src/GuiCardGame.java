import javax.swing.*;
import java.awt.*;

public class GuiCardGame extends JFrame {
	public GuiCardGame() {
		super("카드 게임");
		setDefaultCloseOperation(GuiCardGame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setSize(300, 300);
		c.add(new SouthPanel(), BorderLayout.SOUTH); 
		c.add(new CenterPanel(), BorderLayout.CENTER); 
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new WestPanel(), BorderLayout.WEST); 
		c.add(new EastPanel(), BorderLayout.EAST);
		setVisible(true);
	}
	
	public class SouthPanel extends JPanel {
		public SouthPanel() {
			setBackground(Color.YELLOW);
			setOpaque(true);
			add(new JButton("실행 시작"));
		}
	}

	public class CenterPanel extends JPanel {
		public CenterPanel() {
			setBackground(Color.WHITE);
			setOpaque(true);
			setSize(200,200);
			setLayout(new GridLayout(4,4,10,10));
			
			for(int i=0; i<16; i++) {
				JLabel label = new JLabel(i + "");
				label.setBackground(Color.GREEN);
				label.setOpaque(true);
	            add(label);
			}
		}
	}
	
	public class NorthPanel extends JPanel {
		public NorthPanel() {
			setBackground(Color.YELLOW);
			setOpaque(true);
			add(new JLabel("숨겨진 이미지 찾기"));
		}
	}
	
	public class WestPanel extends JPanel {
		public WestPanel() {
			add(new JLabel("          "));
		}
	}
		
	public class EastPanel extends JPanel {
		public EastPanel() {
				add(new JLabel("          "));
		}
	}
	
	public static void main(String[] args) {
		new GuiCardGame();
	}
}
