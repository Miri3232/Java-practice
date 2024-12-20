import java.util.*;

public class NumberExpectationGame {
	Player[] players;
    int[] randomNum = new int[15];
    Scanner s = new Scanner(System.in);
    int[] scoreBoard[];

    public void RandomNumbers() {
        for (int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int) (Math.random() * 10 + 1);
        }
    }
    private Player[] removePlayer(Player[] players, int index) {
        Player[] newPlayers = new Player[players.length - 1];
        int j = 0;
        for (int i = 0; i < players.length; i++) {
            if (i != index) {
                newPlayers[j++] = players[i];
            }
        }
        return newPlayers;
    }
    
    public void run() {
    	
        System.out.print("게임에 참여할 선수들 이름>> ");
        String name = s.nextLine();
        String[] names = name.split(" ");

        players = new Player[names.length];
        
        for(int i=0; i<names.length; i++) {
            players[i] = new Player();
            players[i].setName(names[i]);
            players[i].setGuessedNum();
        }
        
        while(true) {
        	RandomNumbers();
        	for(int i=0; i<players.length; i++) {
        		players[i].calculateScore(randomNum);
        	}
        	
        	System.out.print("Enter키 입력>> ");
        	s.nextLine();

        	for(int i=0; i<randomNum.length; i++) {
        		System.out.print(randomNum[i] + " ");
        	}
        	System.out.println();
        	for(int i=0; i<players.length; i++) {
        		System.out.println("[" + players[i].getName() + "] 맞춘 개수: " + players[i].getScore());
        	}
        	
        	int minScore = Integer.MAX_VALUE;
            int loserIndex = -1;
            
            for (int i = 0; i < players.length; i++) {
                if (players[i].getScore() < minScore) {
                    minScore = players[i].getScore();
                    loserIndex = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberExpectationGame game = new NumberExpectationGame();
        game.run();
    }

}
