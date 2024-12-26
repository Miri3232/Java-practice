import java.util.*;

public class Mileage {
	Scanner s = new Scanner(System.in);
	private HashMap<String, Integer> mileage = new HashMap<String, Integer>();
	
	public Mileage() {
		
	}
	
	public void accumulateMileage()  {
		System.out.println("*** 마일리지 관리 프로그램입니다. ***");
		
		while(true) {
			System.out.print("이름과 마일리지>> ");	
		
			String name = s.next();
				if(name.equals("그만")) {
					break;				
			}
			int mileagePoint = s.nextInt();
			
			Integer value = mileage.get(name);
			if(value == null) {
				mileage.put(name, mileagePoint);
			}
			else {
				value += mileagePoint;
				mileage.put(name, value);
			}
		}
	}
		
	public void printAll() {
			Set<String> keys = mileage.keySet();
			Iterator<String> it = keys.iterator();
			int bestPoint = 0;
			String bestUser = "";
			
			while(it.hasNext()) {
				String name = it.next();
				int mileagePoint = mileage.get(name);
				System.out.print("("+ name + ": " + mileagePoint + ") ");
				
				if(bestPoint < mileagePoint) {
					bestPoint = mileagePoint;
					bestUser = name;
			}			
		}			
			System.out.println();
			System.out.println("가장 마일리지가 높은 고객은 " + bestUser + "입니다.");
			System.out.println("프로그램을 종료합니다.");
	}
	public void run() {
		accumulateMileage();
		printAll();
	}
	public static void main(String[] args) {
		Mileage m = new Mileage();
		m.run();
	}

}
