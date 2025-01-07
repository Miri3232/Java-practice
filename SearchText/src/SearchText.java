import java.util.*;
import java.io.*;

public class SearchText {
	Scanner s = new Scanner(System.in);
	Vector<String> line = new Vector<String>();
	
	public SearchText() {
		
	}
	
	public boolean SearchLine() {
		try {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		
		String filename = s.next();
		
		Scanner fs = new Scanner(new FileInputStream(filename));
		while(fs.hasNext()) {
			line.add(fs.nextLine());
			}
		fs.close();
		}
		catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            return false;		
		}
		return true;
	}
	
	public void Search()  {
		s.nextLine();
		while(true) {
			boolean found = false;
			System.out.print("검색할 단어나 문장>> ");
			String word = s.nextLine();
			
			if(word.equals("그만"))
				break;
			
			for(int i=0; i<line.size(); i++) {
				String print = line.get(i);
				if(line.get(i).contains(word)) {
					System.out.println(i + ": " + line.get(i));
					found = true;
				}
			}
			if(!found) {
                System.out.println("발견할 수 없음");
            }
		}
	}
	
	public void run() {
		boolean res = SearchLine();
		if(res == true)
			Search();
		System.out.println("프로그램을 종료합니다.");

	}
	
	public static void main(String[] args) {
		SearchText sl = new SearchText();
		sl.run();
	}
	
}
