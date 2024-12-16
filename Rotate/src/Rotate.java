import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		String string = s.nextLine();
		String result = new String(string);
		
		for(int i=0; i<string.length(); i++) {
			result = string.substring(i) + string.substring(0, i);
			
			System.out.print(result);
			System.out.println();
		}
		System.out.print(string);
	}

}
