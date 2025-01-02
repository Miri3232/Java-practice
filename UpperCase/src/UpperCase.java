import java.io.*;
import java.util.*;

public class UpperCase {
	public static void main(String[] args) {
		
		try {			
		File f = new File("D:\\자바학습\\UpperCase.txt"); //경로 지정
		Scanner s = new Scanner(new FileReader(f));
		while(s.hasNext()) {
			String line = s.nextLine();
			line = line.toUpperCase();
			System.out.println(line);
		}
		s.close();
	}
	catch(IOException e) {
		System.out.println("파일 읽기 오류");
		}
	}

}
