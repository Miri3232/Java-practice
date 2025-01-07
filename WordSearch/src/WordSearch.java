import java.util.*;
import java.io.*;

public class WordSearch {
	Vector<String> wordVector = new Vector<String>();
	
	public WordSearch() {
		
	}
	
	public boolean readFile() {
		try {
			Scanner fs = new Scanner(new FileInputStream("words.txt"));
			while(fs.hasNext()) {
				wordVector.add(fs.nextLine());
			}
			fs.close();
		}
		catch(FileNotFoundException e) { 
			System.out.println("프로젝트 폴더 밑의 words.txt 파일이 없습니다");
			return false;
		} 
		System.out.println("프로젝트 폴더 밑의 words.txt 파일을 읽었습니다...");
		return true;
	}
	
	public void processQuery() {
		
		Scanner s = new Scanner(System.in);
		while(true) {
			boolean found = false;
			System.out.print("단어>>");
			String searchWord = s.nextLine();
			if(searchWord.equals("그만")) { 
				break;
			}
			for(int i=0; i<wordVector.size(); i++) {
				String word = wordVector.get(i);
				if(word.length() < searchWord.length())
					continue;
				
				String frontPart = word.substring(0, searchWord.length());
				
				if(searchWord.equals(frontPart)) {
					
					System.out.println(word);
					found = true;
				}
			}
			if(!found)
				System.out.println("발견할 수 없음");	
		}
		s.close();
	}
	
	public void run() {
		boolean res = readFile();
		if(res == true)
			processQuery();
		System.out.println("종료합니다...");
	}
	
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		ws.run();
	}

}
