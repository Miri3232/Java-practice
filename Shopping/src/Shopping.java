import java.util.*;

public class Shopping {
	Scanner s = new Scanner(System.in);
	private ArrayList<String> item = new ArrayList<String>();
	private ArrayList<Integer> price = new ArrayList<Integer>();
	
	public Shopping(){
		item.add("고추장");		
		item.add("만두");		
		item.add("새우깡");		
		item.add("콜라");		
		item.add("참치캔");		
		item.add("치약");		
		item.add("연어");		
		item.add("삼겹살");
		
		price.add(3000);
		price.add(500);
		price.add(1500);
		price.add(600);
		price.add(2000);
		price.add(1000);
		price.add(2500);
		price.add(2500);		
	}
	
	public void ShoppingItem() {
		System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
		
		for(int i=0; i<item.size(); i++) {
			System.out.print("[" + item.get(i) + " " + price.get(i) + "] ");
		}
		System.out.println();
		
		int totalPrice = 0;
		
		while(true) {
			System.out.print("물건과 계수를 입력하세요>> ");
			String input = s.nextLine();
			
			if(input.equals("그만"))
				break;
			
			String[] inputItem = input.split(" ");
			
			if (inputItem.length%2 != 0) {
                System.out.println("입력에 문제가 있습니다.");
                continue;
            }
			
			boolean validInput = true;
			
			for(int i=0; i<inputItem.length; i+=2) {
				String itemName = inputItem[i];
				Integer count = Integer.parseInt(inputItem [i+1]);
				
				boolean itemFound = false;
				
				for(int j=0; j<item.size(); j++) {
					if(itemName.equals(item.get(j))) {
						itemFound = true;
						int allPrice = price.get(j)*count;
						
						totalPrice += allPrice;
					}
				}
				if(!itemFound) {
					System.out.println(itemName + " 없는 상품입니다.");
					validInput = false;
					break;
				}
			}	
			if(validInput) {
				System.out.println("전체 비용은 " + totalPrice + "원 입니다.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Shopping sp = new Shopping();
		sp.ShoppingItem();
	}

}