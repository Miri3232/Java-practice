
public class Group {
	Seat seats[] = new Seat[10];
	
	public Group() {
		for(int i = 0; i<seats.length; i++) {
			seats[i] = new Seat();
		}
	}
	public void show() {
		
		for(int i = 0; i<seats.length; i++) {
			System.out.print(seats[i].getName() + " ");
	}
		System.out.println();
	}
	public void book(String name, int num) {
		if(num<1 || num > seats.length) {
			System.out.println("잘못된 좌석 번호입니다.");
			return;
		}
		if(!seats[num - 1].getName().equals("---")) {
			System.out.println("이미 예약된 좌석입니다.");
			return;
		}
		seats[num-1].setName(name);
	}
	public void cancel(String name) {
		boolean found = false;
		for(int i=0; i<seats.length; i++) {
			if (seats[i].getName().equals(name)) {
				seats[i].setName("---");
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("예약자 이름을 찾을 수 없습니다.");
		}
	}

}
