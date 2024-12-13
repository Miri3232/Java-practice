import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Histogram {
	private int histoData[] = new int[26];
	
	public Histogram() {
		for(int i=0; i<histoData.length; i++)
			histoData[i] = 0;
	}
	public void run() {
		String s = readString();
		makeHistogram(s);
		drawHistogram();
	}
	private void makeHistogram(String text) {
		String s = text.toString();
		s = s.toUpperCase();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				int index = c - 'A';
				histoData[index]++;
			}
		}
	}
	private void drawHistogram() {
		System.out.println("\n히스토그램을 그립니다.");
		for(int i=0; i<histoData.length; i++) {
			System.out.print((char)('A' + i));
			
			for(int j=0; j<histoData[i]; j++)
				System.out.print('-');
			System.out.println();
		}
	}
	private String readString() {
		System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
		StringBuffer sb = new StringBuffer();
		Scanner s = new Scanner(System.in);
		while(true) {
			String line = s.nextLine();
			if(line.length() == 1 && line.charAt(0)==';')
				break;
			sb.append(line);
		}
		s.close();
		return sb.toString();
	}
	public static void main(String[] args) {
		Histogram app = new Histogram();
		app.run();
	}

}
