package 뇽뇽;

import java.util.Scanner;
import java.util.Random;

public class gambling1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int result [] = new int [3];
		
		System.out.println("***** 갬블링 게임을 시작합니다. *****");
		while(true) {
			while(true) {
			System.out.print("엔터키 입력>>");
			String enter = s.nextLine();
			
			for(int i=0; i<result.length; i++) {
				result[i] = r.nextInt(3);
				}
					System.out.println(result[0]+ " \t" + result [1] + "\t" + result[2]);
				if(result[0] == result[1] && result[1] == result[2]) {
					System.out.println("성공! 대박났어요~");
					break;
			}
		}
		while(true) {
		System.out.print("계속하시겠습니까? (yes/no)>> ");
		String re = s.nextLine();
		if(re.equals("no")) {
			System.out.println("게임을 종료합니다.");
			return;
			}
		else if(re.equals("yes")) {
			break;
			}
		else {
			System.out.println("(yes/no) 중에 입력해주세요.");
				}
			}
		}
	}
}