import java.util.Scanner;

abstract class Box {
	protected int size;
	public Box(int size) {
		this.size = size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public abstract boolean consume();
	public abstract void print();
}
class IngredientBox extends Box {
	private String name;
	
	public IngredientBox(String name, int size) {
		super(size);
		this.name = name;	
	}
	public boolean consume() {
	if(isEmpty()) return false;
	size --;
	return true;
	}
	public void print() {
		System.out.print(name + " ");
		for(int i=0; i<size ; i++) {
			System.out.print("*");
		}
		System.out.print(" " + size);
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("*****청춘 커피 자판기 입니다. *****");
		IngredientBox a = new IngredientBox("커피", 5);
		IngredientBox b = new IngredientBox("프림", 5);
		IngredientBox c = new IngredientBox("설탕", 5);
		
		while(true) {
		a.print();
		b.print();
		c.print();
		System.out.print("다방 커피: 1, 설탕 커피: 2, 블랙 커피: 3, 종료: 4 >>");
		int choice = s.nextInt();
		switch(choice) {
		case 1 :
			if(a.consume()&&b.consume()&&c.consume()) {
				break;
			}
			else
				System.out.println("원료가 부족합니다.");
			break;
		case 2 :
			if(a.consume()&&c.consume()) {
				break;
			}
			else
				System.out.println("원료가 부족합니다.");
			break;
		case 3 :
			if(a.consume()) {
				break;
			}
			else
				System.out.println("원료가 부족합니다.");
			break;
		case 4 :
			System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
			s.close();
			return;
		default :
			System.out.println("유효하지 않는 번호입니다. 다시 입력해주세요.");
			continue;
			}
		}
	}
}

