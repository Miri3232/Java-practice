import java.util.*;

public class Bank {
	Scanner s = new Scanner(System.in);
	private HashMap<String, Integer> bank = new HashMap<String, Integer>();
	
	public Bank() {
		
	}
	
	public void deposit() {
		System.out.print("계좌명과 액수>> ");
		String name = s.next();
		int amount = s.nextInt();
		
		Integer total = bank.get(name);
		if(total == null) {
			bank.put(name, amount);			
		}
		else {
			total += amount;
			bank.put(name, total);
		}
	}
	
	public void withdraw() {
		System.out.print("계좌명과 액수>> ");
		String name = s.next();
		int amount = s.nextInt();
		
		Integer total = bank.get(name);
		if(total == null) {
			System.out.print("계좌명 없음");			
		}
		if(total < amount) {
			System.out.println("잔액이 부족하여 출금할 수 없음 !");
		}
		else {
			total -= amount;
			bank.put(name, total);
		}
	}

	public void view() {		
		System.out.print("계좌명>> ");
		String name = s.next();
		
		if(bank.get(name) == null) {
			System.out.println("계좌명 없음");
		}
		else {
			System.out.println("(" + name + ": " + bank.get(name) + "원)");
		}
	}
	
	public void viewAll() {
		Set<String> keys = bank.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			System.out.print("(" + name + ": " + bank.get(name) + "원)" + " ");
		}
		System.out.println();
	}
	
	public void run() {
		System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");
		
		while(true) {
		System.out.println("입금: 1, 출금: 2, 조회: 3, 전체 조회: 4, 종료: 5>> ");
		
		int selection = s.nextInt();
		
		switch(selection) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				view();
				break;
			case 4:
				viewAll();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("다시 선택해주세요.");
			}
		}	
	}
	public static void main(String[] args) {
		Bank b = new Bank();
		b.run();
	}
	
}
