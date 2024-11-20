import java.util.Scanner;

public class DicApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("한영 단어 검색프로그램입니다.");

		while (true) {
			System.out.print("한글 단어?");
			String search = scanner.next();
			if(search.equals("그만")) break;
			System.out.println(Dictionary.kor2Eng(search));		
		}
		scanner.close();
	}

}
