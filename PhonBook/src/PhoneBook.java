import java.util.*;
import java.io.*;

public class PhoneBook {
	public static void main(String[] args) {
		
	Scanner s = new Scanner(System.in);
	FileWriter fw = null;
	File f = new File("D:\\자바학습\\phone.txt"); //경로 지정
	
	try {
		fw = new FileWriter(f);
		
		System.out.println("전화번호 입력 프로그램ㅇ비니다.");
		while(true) {
			System.out.print("이름 전화번호>> ");
			String line = s.nextLine();
			
			if(line.equals("그만"))
				break;
			fw.write(line + "\r\n");
		}
		System.out.println(f.getPath()+"에 저장하였습니다.");
		
		s.close();
		fw.close();
	}
	catch (IOException e) {
		e.printStackTrace();
		}
	}

}
