package 예외곱셈;
import java.util.Scanner;
import java.util.InputMismatchException;

public class lol {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			try {
			System.out.print("곱하고자 하는 정수 2개 입력>> ");
			int n = s.nextInt();
			int m = s.nextInt();
			System.out.println(n + "x" + m + "=" + n*m);
			break;
		}
		catch (InputMismatchException e) {
			System.out.println("정수를 입력하세요!");
			s.nextLine();
			}
		}
		s.close();
	}

}
