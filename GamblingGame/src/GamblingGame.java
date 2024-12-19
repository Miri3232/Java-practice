import java.util.*;

public class GamblingGame {
	Scanner s = new Scanner(System.in);
	Player[] players;
	
	public GamblingGame() {
		System.out.print("겜블링 게임에 참여할 선수 숫자>> ");
		int nPlayers = s.nextInt();
		s.nextLine();
		
		players = new Player[nPlayers];
		
		for(int i=0; i<players.length; i++) {
			System.out.println((i+1) + "번째 선수 이름>> ");
			players[i] = new Player(s.nextLine());
		}
	}
	public void run()  {
		int i=0;
		
		while(true) {
			if(players[i].turn()) {
				System.out.println(players[i].getName()+"님이 이겼습니다!");
				break;
		}
			else {
				System.out.println("아쉽군요!");
				i++;
				i = i%players.length;
			}
		}
	}
		public static void main(String [] args) {
			GamblingGame game = new GamblingGame();
			game.run();
	}

}
