import java.util.Scanner;

public class ConcertReservation {
	Scanner s = new Scanner(System.in);
	Group S = new Group();
	Group A = new Group();
	Group B = new Group();
	
	public void reserve() {
		System.out.print("좌석구분 S(1) A(2) B(3) >> ");
		int reserveSelection = s.nextInt();
		Group reserve;
		
		switch(reserveSelection) {
			case 1:
				reserve = S;
				System.out.print("S >> ");
				break;
			case 2:
				reserve = A;
				System.out.print("A >> ");
				break;
			case 3:
				reserve = B;
				System.out.print("B >> ");
				break;
			default:
				System.out.print("유효하지 않은 번호입니다.");
				return;
		}
		reserve.show();
		
		System.out.print("이름 >> ");
		String name = s.next();
		System.out.print("번호 >> ");
		int num = s.nextInt();
		
		reserve.book(name, num);
	}
	public void cancel() {
		System.out.print("좌석구분 S(1) A(2) B(3) >> ");
		int group = s.nextInt();
		Group reserve;
		
		switch(group) {
			case 1:
				reserve = S;
				break;
			case 2:
				reserve = A;
				break;
			case 3:
				reserve = B;
				break;
			default :
				System.out.print("유효하지 않은 번호입니다.");
				return;					
		}
		reserve.show();
		
		System.out.print("이름 >> ");
		String name = s.next();
		
		reserve.cancel(name);
	}
	public void showAll() {
		S.show();
		System.out.println();
		A.show();
		System.out.println();
		B.show();
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ConcertReservation concert = new ConcertReservation();
			
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		
			while(true) {
				System.out.println("예약: 1, 조회: 2, 취소: 3, 끝내기: 4 >> ");
				int option = s.nextInt();
				
				switch(option) {
					case 1:
						concert.reserve();
						break;
					case 2:
						concert.showAll();
						break;
					case 3:
						concert.cancel();
						break;
					case 4:
						s.close();
						return;
					default:
						System.out.print("유효하지 않은 번호입니다.");
						break;
			}
		}
	}
	
}
