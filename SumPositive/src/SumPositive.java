import java.util.*;

public class SumPositive {
	Scanner s = new Scanner(System.in);
	private Vector<Integer> v = new Vector<Integer>();
	
	public void read() {
		System.out.print("0이 입력될 때까지 정수 입력>> ");
		while(true) {
			int a = s.nextInt();
			if(a == 0) {
				break;
			}
			v.add(a);
		}
	}
	
	public void changeToZero() {
		for(int i=0; i<v.size(); i++) {
			if(v.get(i) < 0) {
				v.set(i, 0);
			}
		}
	}
	
	public void showAll() {
		for(int i=0; i<v.size(); i++) {
		System.out.print(v.get(i) + " ");
		}
		System.out.println();		
	}
	
	public int add() {
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			sum += v.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		SumPositive sp = new SumPositive();
		sp.read();
		sp.changeToZero();
		System.out.print("음수를 0으로 바꾸면 ");
		sp.showAll();
		System.out.println("양수들의 합은 " + sp.add());
	}

}