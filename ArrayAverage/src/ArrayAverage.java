import java.util.Scanner;
import java.util.InputMismatchException;

public class ArrayAverage {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		int number[] = new int[100];
		
		System.out.print("양의 정수를 입력하세요. -1은 입력 끝>> ");
		
		while(true) {
			try {
				int num = s.nextInt();
				if(num == -1){
				break;
				}
				if(num > 0) {
					number[count] = num;
					sum += num;
					count++;
				}
				else {
					System.out.println(num + " 제외");
				}
			}
			catch(InputMismatchException e) {
				String a = s.next();
				System.out.println(a + " 제외");
			}
			catch(NumberFormatException e) {
				String a = s.next();
				System.out.println(a + " 제외");
			}
		}
		System.out.println("평균은 " + (sum/count));
		s.close();
	}

}