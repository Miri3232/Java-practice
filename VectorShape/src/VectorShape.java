import java.util.*;

public class VectorShape {
	Scanner s = new Scanner(System.in);
	Vector<Shape> v = new Vector<Shape>();
	
	public VectorShape() {
		
	}
	
	public void insert(int choice) {
		Shape shape = null;
		switch(choice) {
			case 1:
				shape = new Line();
				break;
			case 2:
				shape = new Rect();
				break;
			case 3:
				shape = new Circle();
				break;
		}
		v.add(shape);
		
	}
	
	public boolean delete(int index) {
		if(v.size() == 0 || index > v.size()) {
			return false;
		}
			v.remove(index-1);
			return true;
	}
	
	public void viewAll() {
		for(int i=0; i<v.size(); i++) 
			v.get(i).draw();
	}
	
	public void run() {
		System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			int selection = s.nextInt();
			
			switch(selection) {
				case 1:
					System.out.print("Line(1), Rect(2), Circle(3)>> ");
					int shape = s.nextInt();
					if(shape > 3 || shape < 1) {
						
						System.out.println("잘못 선택하셨습니다.");
						break;				
					}
					insert(shape);
					break;
				case 2:
					System.out.print("삭제할 도형의 위치>>");
					int index = s.nextInt();
					if (!delete(index)) {
						System.out.println("삭제할 수 없습니다.");
					}
					break;
				case 3:
					viewAll();
					break;
				case 4:
					System.out.println("Beauty Graphic Editor를 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	public static void main(String[] args) {
		VectorShape vs = new VectorShape();
		vs.run();
	}
	
}
