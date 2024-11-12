import java.util.Scanner;

public class WordGame {
	private Scanner s;
	private String startWord = "아버지";
	private Player[] players;
	
	public WordGame() {
		s = new Scanner(System.in);
	}
	private void createPlayers() {
		System.out.println("게임에 참가하는 인원은 몇명입니까? >> ");
		int nPlayers = s.nextInt();
		players = new Player[nPlayers];
		
		for(int i=0; i<nPlayers; i++) {
			System.out.print("참가자의 이름을 입력하세요. >> ");
			String name = s.next();
			players[i] = new Player(name);
		}
	}
	public boolean checkSuccess(String lastWord, String newWord) {
		int lastIndex = lastWord.length()-1;
		
		if(lastWord.charAt(lastIndex) == newWord.charAt(0))
			return true;
		else
			return false;
	}
	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다.");
		createPlayers();
		String lastWord = startWord;
		
		System.out.println("시작하는 단어는 " + lastWord + "입니다.");
		int next = 0;
		
		while(true) {
			String newWord = players[next].getWordFromUser();
			if(checkSuccess(lastWord, newWord) == false) {
				System.out.print(players[next].getName() + " 패배");
				break;
			}
			next++;
			next %= players.length;
			lastWord = newWord;
		}
	}
	public static void main(String[] args) {
		WordGame game = new WordGame();
		game.run();
	}

}
class Player {
	private Scanner scanner;
	private String name;
	private String word;
	
	public Player(String name) {
		this.name = name;
		scanner = new Scanner(System.in);	
	}
	
	public String getName() {return name;}
	
	public String getWordFromUser() {
		System.out.print(name+">>");
		word = scanner.next();
		return word;
	}
	
}
