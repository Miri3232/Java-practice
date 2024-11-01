package 뇽뇽;

import java.util.Random;
import java.util.Scanner;

public class syd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int a = 0;
		int b = 0;
		
		String boymiddle[] = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
		String boylast[] = {"태", "진", "광", "혁", "우", "철", "반", "준", "구", "호", "석"};
		String girlmiddle[] = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
		String girllast[] = {"진", "연", "경", "서", "리", "숙", "미", "원", "란", "희", "수"};
		
		System.out.println("***** 작명 프로그램이 실행됩니다. *****");
		
		while(true) {
			System.out.print("남/여 선택>> ");
			String gender = s.nextLine();
			if(gender.equals("남")) {
				a = r.nextInt(boymiddle.length);
				b = r.nextInt(boylast.length);
				System.out.print("성 입력>> ");
				String name = s.nextLine();
				System.out.println("추천 이름: " + name + boymiddle[a] + boylast[b]);
			}
			else if(gender.equals("여")) {
				a = r.nextInt(girlmiddle.length);
				b = r.nextInt(girllast.length);
				System.out.print("성 입력>> ");
				String name = s.nextLine();
				System.out.println("추천 이름: " + name + girlmiddle[a] + girllast[b]);
			}
			else if(gender.equals("그만")) {
				break;
			}
			else {
				System.out.println("남/여/그만 중에서 입력하세요!");
			}
		}
	}	
}