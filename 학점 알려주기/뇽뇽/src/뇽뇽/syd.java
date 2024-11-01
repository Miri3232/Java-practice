package 뇽뇽;

import java.util.Random;
import java.util.Scanner;

public class syd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
	
		String course[] = {"C", "C++", "Python", "Java", "HTML5" };
		String grade[] = {"A", "B+", "B", "A+", "D" };
		
		while(true) {
			System.out.print("과목>> ");
			String a = s.nextLine();
			
			if(a.equals("그만")) {
				break;
			}
			for(int i=0; i<course.length; i++) {
				if(course[i].equals(a)) {
					System.out.println(a + "의 학점은" + grade[i]);
					break;
				}
				if(i+1 == course.length) {
					System.out.println(a + " 없어요.");
				}
			}
		}
		s`.close();
	}
}