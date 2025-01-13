import javax.swing.*;
import java.awt.*;

public class TwentyJLabels extends JFrame {
	public TwentyJLabels () {
		super("배치관리자 없는 컨테이너");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel[] label = new JLabel[20];
		for(int i=0; i<label.length; i++) {
			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);

			int x = (int)(Math.random()*240) + 10;
			int y = (int)(Math.random()*240) + 10;
			
			label[i] = new JLabel();
			label[i].setSize(10, 10);
			label[i].setOpaque(true);
			label[i].setBackground(new Color(r,g,b));
			label[i].setLocation(x, y);
			c.add(label[i]);
		}
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TwentyJLabels();
	}

}
