import java.util.*;

public class ArrayListString {
	Scanner s = new Scanner(System.in);
	ArrayList<String> a = new ArrayList<String>();
	
	public void run() {
		while(true) {
			System.out.println("문자열을 입력하세요>> ");
			String input = s.nextLine();
			
			if(input.equals("그만")) {
				break;
			}
			
			String[] str = input.split(" ");
			
			for(String values : str) {
				boolean isDuplicate = false;
				
				for(String existingWord : a) {
					if(existingWord.equals(values)) {
						isDuplicate = true;
						break;
					}
				}
				
				if(!isDuplicate) {
					a.add(values);
				}
			}
			for (String word : a) {
				
	            System.out.print(word + " ");
			}
			System.out.println();
			a.clear();
		}
	}
	public static void main(String[] args) {
		ArrayListString as = new ArrayListString();
		as.run();
	}
}
