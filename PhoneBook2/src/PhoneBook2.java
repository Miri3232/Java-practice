import java.util.*;
import java.io.*;

public class PhoneBook2 {
	public static void main(String[] args) {
		
		try {
			
		File f = new File("D:\\자바학습\\phone.txt");
		FileReader fr = new FileReader(f);
		
		int c;
		while((c = fr.read()) != -1) {
			System.out.print((char) c);
		}
		fr.close();		
		}
		catch (IOException e) {
            e.printStackTrace();			
		}
	}
}
