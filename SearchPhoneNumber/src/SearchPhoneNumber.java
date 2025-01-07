import java.io.*;
import java.util.*;

public class SearchPhoneNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<String, String> phoneBook = new HashMap<String, String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("phone.txt"))) {
			String line;
			
			while((line = br.readLine()) != null) {
				
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    phoneBook.put(name, phoneNumber);
				}
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("총 " + phoneBook.size() + "개의 전화번호를 읽었습니다.");
		
		while(true) {
			System.out.print("이름>> ");
			String name = s.next();
			
			if(name.equals("그만"))
				break;
			
			  String phoneNumber = phoneBook.get(name);
	            
	            if (phoneNumber != null) {
	                System.out.println(phoneNumber);
	            } else {
	                System.out.println("찾는 이름이 없습니다.");
	            }
		}
	}

}
