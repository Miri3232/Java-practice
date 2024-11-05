import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentScore {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int student[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int score[] = {10, 20, 30, 30, 30, 80, 80, 80, 90};
		int choice = 0;
		int students = 0;
		int scores = 0;
		
		while(true) {
			System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>> ");
				try {
					choice = s.nextInt();
					if(choice == 3) {
						break;
					}
					if(choice > 3 || choice < 1) {
						System.out.println("1, 2, 3 중에 입력해주새요");
						continue;
					}
				}
				catch(InputMismatchException e) {
					System.out.println("경고!! 정수로 입력해주세요.");
					s.next();
					continue;
				}

					if(choice == 1) {
						while(true){
						System.out.print("학번 >> ");
						try {
						students = s.nextInt();
						boolean found = false;
						for(int i=0; i<student.length; i++) {
							if(students == student[i]) {
								System.out.println("점수는 " + score[i]);
								found = true;
								break;
								}
							}
						if(!found) {
							System.out.println(students + "학생은 없습니다.");
						}
						break;
					}
						catch(InputMismatchException e) {
							System.out.println("경고!! 정수로 입력해주세요.");
							s.next();
							break;
						}
					}
				}
				loopOut:
				if(choice == 2) {
					while(true) {
					System.out.print("점수>> ");
					try {
						scores = s.nextInt();
						boolean found = false;
						for(int j=0; j<score.length; j++) {
							if(scores == score[j]) {
								if(!found) {
								System.out.print("점수가 " + scores + "인 학생은 ");
								found = true;
							}
							System.out.print(student[j] + " ");
						}
					}
						
					if(found) {
						System.out.println("입니다.");
						break;
					}
					else {
						System.out.println("없습니다.");
						break;
						}
					}
					catch(InputMismatchException e) {
						System.out.println("경고!! 정수로 입력해주세요.");
						s.next();
					}
				}
			}
		}
	}

}
