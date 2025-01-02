import java.util.*;
import java.io.*;

public class FileLineNumber {
	public static void main(String[] args) {
		
		try {
			File f = new File("D:\\자바학습\\FileLineNumber.txt");
			Scanner sfr = new Scanner(new FileReader(f));
			
			System.out.println(f.getPath() + " 파일을 읽어 출력합니다.");
			int i = 1;
			
			while(sfr.hasNext()) {
				String line = sfr.nextLine();
				
				System.out.printf("%4d: %s%n", i, line);
				i++;
			}
			sfr.close();
		}
	catch(IOException e) {
		System.out.println("입출력 오류");
		}
	}

}
