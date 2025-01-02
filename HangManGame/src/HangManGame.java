import java.util.*;
import java.io.*;

public class HangManGame {
	private final int HIDDENCHAR = 2;
	private StringBuffer hiddenWord;
	private String newWord;
	private Scanner s;
	private int failCount;
	
	public HangManGame() {
		s = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		Words words = new Words("words.txt"); // 파일 경로 입력
		while(true) {
			newWord = words.getRandomWord();
			if(newWord == null) break;
			makeHidden();
			go();
			System.out.print("Next(y/n)?");
			String answer = s.next();
			if(answer.equals("n"))
				break;
		}
	}

	private void makeHidden() {
		hiddenWord = new StringBuffer(newWord);
		Random r = new Random();
		
		for(int k=0; k<HIDDENCHAR; k++) {
			int index = r.nextInt(newWord.length());
			char c = newWord.charAt(index);
			for(int i=0; i<newWord.length(); i++) {
				if(hiddenWord.charAt(i) == c)
					hiddenWord.setCharAt(i,'-');
			}
		}
	}
	
	private void go() {
		failCount=0;
		char key;
		do {
			if(failCount == 5) {
				System.out.println("5번 실패 하였습니다.");
				break;
			}
			System.out.println(hiddenWord);
			System.out.print(">>");
			String text = s.next();
			key =  text.charAt(0);
		}while(!complete(key));
		System.out.println(newWord);
	}
	
	// 그리고 나서 hiddenWord의 '-'문자를 key 문자로 변경한다.
		private boolean complete(char key) {
			boolean hit = false;
			for(int i=0; i<newWord.length(); i++) {
				if(hiddenWord.charAt(i) == '-' && newWord.charAt(i) == key) {
					hiddenWord.setCharAt(i, key);
					hit = true;
				}
			}
			if(!hit)
				failCount++;
			for(int i=0; i<newWord.length(); i++) {
				if(hiddenWord.charAt(i) == '-')
					return false;
			}
			return true;
		}

		public static void main(String[] args) {
			HangManGame app = new HangManGame();
			app.run();
	}

}
