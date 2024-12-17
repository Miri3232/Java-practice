import java.util.*;

public class LivedDay {
    
    public static int livedDays(int year, int month, int dayOfMonth) {
        Calendar birthDate = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        
        birthDate.set(year, month - 1, dayOfMonth);
        
        long diffInMillis = today.getTimeInMillis() - birthDate.getTimeInMillis();
        
        int diffInDays = (int) (diffInMillis / (24 * 60 * 60 * 1000));
        
        return diffInDays;
    }

    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        Scanner s = new Scanner(System.in);
        
        System.out.println("오늘은 " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 " + today.get(Calendar.DAY_OF_MONTH) + "일");
        
        while(true) {
            System.out.print("생년월일 입력 (년 월 일)>> ");
            String birth = s.nextLine();
            if(birth.equals("그만"))
                break;
            
            StringTokenizer st = new StringTokenizer(birth, " ");
            
            int year = Integer.parseInt(st.nextToken().trim());
            int month = Integer.parseInt(st.nextToken().trim());
            int dayOfMonth = Integer.parseInt(st.nextToken().trim());
            
            int days = livedDays(year, month, dayOfMonth);
            
            if(days > 0)
            	System.out.println("오늘까지 " + days + "일 살아왔습니다.");
            else
            	System.out.println((days*-1) + "일 더 살아야 생일이 됩니다.");
        }
    }
}
