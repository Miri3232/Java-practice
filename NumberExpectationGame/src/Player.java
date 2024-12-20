import java.util.*;

public class Player {
	  Scanner s = new Scanner(System.in);
	    String name;
	    int guessedNum;
	    int score;
	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setGuessedNum() {
	        System.out.print("[" + getName() + "] 정수 선택(1~10)>> ");
	        guessedNum = s.nextInt();
	    }

	    public void calculateScore(int[] randomNum) {
	        score = 0;
	        for (int num : randomNum) {
	            if (num == guessedNum) {
	                score++;
	            }
	        }
	    }

	    public int getScore() {
	        return score;
	    }
	    
}
