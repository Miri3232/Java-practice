import java.util.*;

public class Player {
	Scanner s = new Scanner(System.in);
	public String name;
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void getEnterKey() {
		s.nextLine();
	}
	public boolean turn() {
		System.out.print("[" + getName() + "]: <Enter>" );
		getEnterKey();
		
		int[] num = new int[3];
		
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random()*3+1);
		}
		System.out.print("\t");
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i] + " ");
		}
		boolean result = true;
		for(int i=0; i<num.length; i++) {
			if(num[i] != num[0]) {
				result = false;
				break;
			}
		}
		return result;
	}
}
