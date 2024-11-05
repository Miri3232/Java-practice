import java.util.Scanner;
import java.util.InputMismatchException;

public class coffee {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String coffee[] = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
		int price[] = {3000, 3500, 4000, 4500};
		
		System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다");
		
		while(true) {
			System.out.print("주문>> ");
			String menu = s.next();
			if(menu.equals("그만")) {
					break;
			}
			int count = 0;
			try {
				count = s.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("잔 수는 양의 정수로 입력해주세요!");
				s.nextLine();
				continue;
			}
			if(count <= 0) {
				System.out.println("잔 수는 양의 정수로 입력해주세요!");
				continue;
			}
			boolean found = false;
			int cost = 0;
			for(int i = 0; i<coffee.length; i++) {
				if(coffee[i].equals(menu)) {
					cost = price[i]*count;
					System.out.println("가격은 " + cost + "원 입니다.");
					found = true;
					break;
				}
			}
			if(found == false) {
				System.out.println(menu + " 없는 메뉴입니다.");
			}
		}
		s.close();
	}

}
