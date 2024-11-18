public class Account {
	
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void deposit(int bulk[]) {
		for(int i=0; i<bulk.length; i++) {
			balance += bulk[i];
		}
	}
	public int getBalance() {
		return balance;
	}
	public int withDraw(int money) {
		if(balance < money) {
			int wMoney = balance;
			balance = 0;
			return wMoney;
		}
		else {
			balance -= money;
			return money;
		}
	}
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은 " + a.getBalance() + "원 입니다.");
		
		int bulk[] = {100, 500, 200, 700};
		a.deposit(bulk);
		System.out.println("잔금은 " + a.getBalance() + "원 입니다.");
		
		int money = 1000;
		int wMoney = a.withDraw(money);
		if(wMoney < money)
			System.out.println(wMoney+ "원만 인출");
		else
			System.out.println(wMoney+ "원 인출");

		System.out.println("잔금은 " + a.getBalance() + "원 입니다.");
	}
}