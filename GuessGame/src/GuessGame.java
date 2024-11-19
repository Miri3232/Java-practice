import java.util.Scanner;
import java.util.Random;

public class GuessGame {
	private int numOfPlayer;
	private Player[] players;
	private int[] answers;
	private Scanner s = new Scanner(System.in);
	
	public GuessGame() {
		System.out.println("*** 예측 게임을 시작합니다. ***");
		inputPlayers();
		playGame();
	}
	
	public void inputPlayers() {
		System.out.print("게임에 참여할 선수 수 >> ");
		this.numOfPlayer = s.nextInt();
		players = new Player[numOfPlayer];
		answers = new int[numOfPlayer];
		
		for(int i = 0; i<numOfPlayer; i++) {
			System.out.print("선수 이름 >> ");
			players[i] = new Player(s.next());			
		}
		
	}
	public void inputAnswers() {
		for(int i=0; i<numOfPlayer; i++) {
			System.out.print(players[i].getName() + " >> ");
			answers[i] = s.nextInt();			
			
			if(answers[i] < 1 || answers[i] > 100) {
				System.out.println("1~100 사이의 숫자만 입력해주세요.");
				i--;
			}
		}
	}
	public int randomNum() {
		Random r = new Random();
		System.out.println("1~100 사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");
		int randomNum = r.nextInt(100)+1;		
		return randomNum;
	}
	
	public void result() {
		int winnerScore = 0;
		
		for(int i=0; i<numOfPlayer; i++) {
			if(players[i].getScore() > players[winnerScore].getScore()) {
				winnerScore = i;
			}
			players[i].show();
		}
		System.out.println();
		System.out.println(players[winnerScore].getName() + " 최종 승리.");
	}
	public void playGame() {
		while(true) {
			int random = randomNum();
			inputAnswers();
			
			int winnerIndex = 0;
			int diff = Math.abs(random - answers[0]);
			
			for(int j=1; j<numOfPlayer; j++) {
				int currentDiff = Math.abs(random - answers[j]);
				if(diff > currentDiff) {
					winnerIndex = j;
					diff = currentDiff;
				}
			}
			players[winnerIndex].upScore();
			System.out.print("정답은 " + random +". ");
			System.out.println(players[winnerIndex].getName() + " 승리. 승점 1점 확보");
			System.out.print("계속하시려면 yes >> ");
			String re = s.next();
				if(!re.equals("yes")) {
					result();					
					break;
			}
		}
		s.close();
	}
	public static void main(String[] args) {
		GuessGame game = new GuessGame();
	}

}
