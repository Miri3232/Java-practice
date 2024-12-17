import java.util.*;

public class Calandar {
	public static void makeCalendar(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		
		for(int i=0; i<12; i++) {
			System.out.println("\n" + year + "년 " + (i+1) + "월");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			cal.set(Calendar.MONTH, i);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			for(int j=0; j<dayOfWeek-1; j++) {
				System.out.print("\t");				
			}
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int j=1; j<=lastDay; j++) {
				System.out.print(j + "\t");
				if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					System.out.println();
				cal.set(Calendar.DAY_OF_MONTH, j+1);
			}
			System.out.println();
		}
	}
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			while(true) {
				System.out.print("년도 입력(-1이면 종료)>>");
				int year = s.nextInt();
				if (year == -1)
					break;
				makeCalendar(year);
			}
			s.close();	
	}
}
