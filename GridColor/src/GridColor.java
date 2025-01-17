import javax.swing.*;
import java.awt.*;

public class GridColor extends JFrame {	
	public GridColor() {
		super("배경색을 가진 10개의 버튼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		JButton[] btn = new JButton[10];
		Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
				Color.PINK, Color.LIGHT_GRAY};
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton(Integer.toString(i));
			btn[i].setBackground(color[i]);;
			c.add(btn[i]);
		}
		
		setSize(500,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridColor();
	}

}
