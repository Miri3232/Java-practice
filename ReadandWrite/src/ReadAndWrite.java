import java.util.*;
import java.io.*;

public class ReadAndWrite {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BufferedReader f1 = null;
		BufferedReader f2 = null;
		BufferedWriter appended = null;
		
System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String file1 = s.nextLine();
		
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String file2 = s.nextLine();
		
		try {
			f1 = new BufferedReader(new FileReader(file1));
			f2 = new BufferedReader(new FileReader(file2));
			appended = new BufferedWriter(new FileWriter("appended.txt"));
			
			String line;
			
            while ((line = f1.readLine()) != null) {
                appended.write(line);
                appended.newLine();
	}
            while ((line = f2.readLine()) != null) {
                appended.write(line);
                appended.newLine();
	}
            System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
            f1.close();
            f2.close();
            appended.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
