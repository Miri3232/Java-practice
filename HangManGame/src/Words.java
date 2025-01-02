import java.util.*;
import java.io.*;

public class Words {
	Vector<String> wordVector = new Vector<String>();
	
	public Words(String fileName) {
		try {
			Scanner s = new Scanner(new FileReader(fileName));
			while(s.hasNext()) {
				String word = s.nextLine();
				wordVector.add(word);
			}
			s.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("file not found error");
			System.exit(0);
		}
	}
	public String getRandomWord() {
		final int WORDMAX = wordVector.size();
		int index = (int)(Math.random()*WORDMAX);
		return wordVector.get(index);
	}

}
