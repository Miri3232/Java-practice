import java.util.*;

public class Stock {
	private Scanner s = new Scanner(System.in);
	private HashMap<String, Integer> stockMap = new HashMap<String, Integer>();
	public Stock() {
		
	}
	
	public void read() {
		System.out.println("주식 종목과 주기를 입력하세요(예: 삼송전자 75000)");		
		while(true) {
			System.out.print("종목, 주가>> ");
			String stockName = s.next();						
			if(stockName.equals("그만")) {
				break;
			}
			int stockPrice = s.nextInt();
			stockMap.put(stockName,stockPrice);
		}
	}
	
	public void search() {
		System.out.println("주가를 검색합니다.");
		while(true) {
			System.out.print("종목>> ");
			String stockName = s.next();
			if(stockName.equals("그만")) {
				break;
			}
			Integer stockPrice = stockMap.get(stockName);
			if(stockName == null) {
				System.out.println(stockName + "은 없는 종목입니다.");
			}
			else {
				System.out.println(stockName + "의 주가는 " + stockPrice + "원");
			}
		}
	}
	
	public void run()  {
		read();
		search();
	}
	
	public static void main(String[] args) {
		Stock st = new Stock();
		st.run();
	}

}
