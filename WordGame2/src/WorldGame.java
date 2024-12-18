import java.util.*;

public class WordGame {
	String[] words = {"lovely" ,"sunny", "happy", "present", "morning", "package","nation"};
	String word;
	String input;
	int elapsedTime;
	
	public WordGame() {
		
	}
	public void setWord() {
		Random r = new Random();
		int ran = (int)(Math.random()*words.length);
		word = words[ran];
		char[] setWord = word.toCharArray();
		
		for (int i = setWord.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            char temp = setWord[i];
            setWord[i] = setWord[j];
            setWord[j] = temp;
			}
		String shuffledWord = new String(setWord);
		System.out.println(shuffledWord);
		}
	public void correct() {
		Scanner s = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
		System.out.print(">> ");
		input = s.next();
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		if (elapsedTime > 10000) {
            System.out.println("시간 초과! 정답은 " + word + " 입니다.");
            return;
		}
		if(word.equals(input)) {
			System.out.println("성공!!");
			return;
		}
		if(input.equals("그만")) {
			return;
		}
		else {
			System.out.println("실패!!!" + word + " 입니다.");
			return;			
		}
	}
	public void run() {	
		while(true) {
		setWord();
		correct();
		if(input.equals("그만")) {
			break;
			}
		if (elapsedTime > 10000) {
			break;
			}
		}
	}
	public static void main(String[] args) {
		WordGame wg = new WordGame();
		wg.run();
	}
}
