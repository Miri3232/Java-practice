import java.util.Scanner;

public class Diary {
	private dayDiary[] day; 
	private int year, month;
	private Scanner s = new Scanner(System.in);
	
	public Diary(int year, int month) {
		this.year = year;
		this.month = month;
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = new dayDiary[31];
			break;
		case 4: case 6: case 11:
			day = new dayDiary[30];
			break;
		case 2:
			day = new dayDiary[30];
			break;
		}
		for(int i = 0; i<day.length; i++) {
			day[i] = new dayDiary();
		}
	}
	public void writeDiary() {
		System.out.print("날짜(1~31)와 텍스트(빈칸없이 4글자이하) >> ");
		int date = s.nextInt();
		String writeDiary = s.next();
		day[date-1].setText(writeDiary);
	}
	public void showDiary() {
		for(int i=0; i<day.length; i++) {
			System.out.print(day[i].getText() + "\t");
			if((i+1)%7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	public void run() {
		System.out.println("***** " + year + "년 " + month + "월 다이어리");
		
		while(true) {
			System.out.print("기록: 1, 보기: 2, 종료: 3 >> ");
			int choice = s.nextInt();
			
			switch(choice) {
			case 1:
				writeDiary();
				break;
			case 2:
				showDiary();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	public static void main(String[] args) {
		Diary diary = new Diary(2024, 10);
		diary.run();
	}
}

