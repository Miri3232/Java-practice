import java.util.Scanner;

abstract class Shape {
	private Shape next;
	public Shape() {
		next = null;
	}
	public void setNext(Shape obj) {
		next = obj;
	}
	public Shape getNext() {
		return next;
	}
	public abstract void draw();
}
class Line extends Shape {
	@Override
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape {
	@Override
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
public class GraphicEditor {
	Shape SArray[];
	int index = 0;
	
	public GraphicEditor() {
		SArray = new Shape[10];
	}
	public void insert(Shape obj) {
		if(index < SArray.length) {	
			expandArray();
		}
		SArray[index] = obj;
		index++;
	}
	private void expandArray() {
        Shape[] newArray = new Shape[SArray.length * 2];
        System.arraycopy(SArray, 0, newArray, 0, SArray.length);
        SArray = newArray;
	}
	public void delete(int idx) {
		  if (idx >= 0 && idx < index) {
	            for (int i = idx; i < index - 1; i++) {
	                SArray[i] = SArray[i + 1];
	            }
	            SArray[index - 1] = null;
	            index--;
	        } else {
	            System.out.println("삭제할 수 없습니다.");
	        }
	    }
	public void viewAll() {
		for(int i=0; i<index; i++) {
			SArray[i].draw();
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GraphicEditor gE = new GraphicEditor();
		System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>> ");
			int choice = s.nextInt();
			switch(choice) {
			case 1 :
				Shape shape =null;
				System.out.print("Line(1), Rect(2), Circle(3)>> ");
				int shapeC = s.nextInt();
				switch(shapeC) {
				case 1 :
					shape = new Line();
					break;
				case 2 :
					shape = new Rect();
					break;
				case 3 :
					shape = new Circle();
					break;
				default :
					System.out.println("다시 선택해주세요.");
					continue;
				}
				gE.insert(shape);
				break;
			case 2 :
				System.out.print("삭제할 도형의 위치>> ");
				int shapeC2 = s.nextInt();
				gE.delete(shapeC2);
				break;
			case 3 :
				gE.viewAll();
				break;
			case 4 :
				System.out.println("Beauty Graphic Editor를 종료합니다.");
				return;
			default :
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
	}
}
