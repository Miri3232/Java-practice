import java.util.Scanner;
import java.util.Random;

abstract class Player {
	protected String bet[] = {"묵", "찌", "빠"};
	protected String name;
	protected String lastBet = null;
	
	protected Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getBet() {
		return lastBet;
	}
	abstract public String next();
}

class Human extends Player {
	private Scanner s = new Scanner(System.in);
	
	public Human(String name) {
		super(name);
	}
	@Override
	public String next() {
		while(true) {
			System.out.print(name + ">> ");
			String curBet = s.next();
			for(String b : bet) {
				if(b.equals(curBet)) {
					lastBet = curBet;
					return lastBet;
				}
			}
			System.out.println("묵, 찌, 빠 중에서 다시 입력하세요.");
		}
	}
}
class Computer extends Player {
	private Random r = new Random();
	
	public Computer(String name) {
		super(name);
	}
	@Override
	public String next() {
		int index = r.nextInt(bet.length);
		System.out.println(name + ">> 결정하였습니다.");
		lastBet = bet[index];
		return lastBet;
	}
	
}
class Game{
	private Player[] players = new Player[2];
	private Scanner s = new Scanner(System.in);
	
	public Game() {
		
	}	
	private void creatPlayer() {
		System.out.print("선수이름 입력>> ");
		String name = s.next();
		players[0] = new Human(name);
		
		System.out.print("컴퓨터이름 입력>> ");
		name = s.next();
		players[1] = new Computer(name);
		System.out.println("2명의 선수를 생성 완료하였습니다.\n");		
	}
	public void run() {
		System.out.println("***** 묵찌빠 게임을 시작합니다.");
		creatPlayer();
		int ownerIndex = 0;
		while(true) {
			String owner = players[ownerIndex].next();
			int opponentIndex = (ownerIndex + 1)%2;
			String opponent = players[opponentIndex].next();
			System.out.println(players[ownerIndex].getName() + ": " + players[ownerIndex].getBet() + ", " 
								+ players[opponentIndex].getName() + ": " + players[opponentIndex].getBet());
			
			if(owner.equals(opponent)) {
				System.out.println(players[ownerIndex].getName() + "승리");
				break;
			}
			if((owner.equals("묵")&&opponent.equals("빠"))||(owner.equals("찌")&&opponent.equals("묵"))||(owner.equals("빠")&&opponent.equals("찌"))) {
				ownerIndex = opponentIndex;
				System.out.println("오너가 " + players[ownerIndex].getName() + " 입니다.");
			}
			System.out.println();
		}
		System.out.println("게임을 종료합니다...");
	}
	
}

public class MGPGame {
	public static void main(String[] args) {
		new Game().run();
	}
}
