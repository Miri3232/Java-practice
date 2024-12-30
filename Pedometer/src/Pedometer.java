import java.util.*;

public class Pedometer {
	Scanner s = new Scanner(System.in);
	HashMap<String, ArrayList<Integer>> map =new HashMap<String, ArrayList<Integer>>();
	
	public Pedometer() {
		
	}
	
	public void read() {
		while(true) {
			System.out.print("이름과 걸음수>> ");
			String line = s.nextLine();
			
			if(line.equals("그만")) {
				break;
			}
			
			String[] st = line.split(" ");
			
			String name = st[0];
			ArrayList<Integer> list = map.get(name);
			if(list == null) {
				list = new ArrayList<Integer>();
				map.put(name, list);
			}
			
			for(int i=1; i< st.length; i++) {
				list.add(Integer.parseInt(st[i]));
			}
		}
	}
	public void best() {
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		String bestName = "";
		int bestWalk = 0;
		
		while(it.hasNext()) {
			String name = it.next();
			ArrayList<Integer> list = map.get(name);
			
			int sum = 0;
			for(int walk : list) {
				sum += walk;
			}
			if(bestWalk < sum) {
				bestWalk = sum;
				bestName = name;
			}
		}		
		System.out.println("걸음수가 가장 많은 사람은 " + bestName + " " + bestWalk + "보");
	}
	
	public void search() {
		while(true) {
			System.out.print("검색할 이름>> ");
			String name = s.next();
			
			if(name.equals("그만")) {
				break;
			}
			ArrayList<Integer> list = map.get(name);
			if(list == null) {
				System.out.println(name + "은 없는 학생입니다.");
				continue;
			}
			
			int sum = 0;
			for(int score : list) {
				System.out.print(score + " ");
				sum += score;
			}
			System.out.println("평균은" + sum/list.size());
		}
	}
	
	public void run() {
		read();
		best();
		search();
	}
	
	public static void main(String[] args) {
		Pedometer p = new Pedometer();
		p.run();
	}
}
