import java.util.*;

public class StudentCredit {
	Scanner s = new Scanner(System.in);
	Vector<Student> students = new Vector<Student>();
	
	public void read() {
		System.out.println("4명 이름, 전공, 학번, 학점 입력");
		for(int i=0; i<4; i++) {
			System.out.print(">> ");
			String input = s.nextLine();
			
			StringTokenizer st = new StringTokenizer(input, ",");
			String name = st.nextToken().trim();
			String major = st.nextToken().trim();
			int number = Integer.parseInt(st.nextToken().trim());
			double credit = Double.parseDouble(st.nextToken().trim());
			
			Student student = new Student(name, major, number, credit);
			
			students.add(student);
		}
	}
	
	public void printAll() {
		System.out.println("--------------------------------------------------");
		
		for(Student student : students) {
			System.out.print("이름: " + student.getName() + "\t");
			System.out.print("전공: " + student.getMajor() + "\t");
			System.out.print("학번: " + student.getNumber() + "\t");
			System.out.println("학점평균: " + student.getCredit());			
		}
		System.out.println("--------------------------------------------------");
	}
	
	public void bestStudent() {
		
		List<Student> bestStudents = new ArrayList<>();
		
		System.out.print("장학생: ");
		
		double bestCredit = 0;
		String bestStudent = null;
		
		for(Student student : students) {
			if(student.getCredit() > bestCredit) {
				bestCredit = student.getCredit();
				bestStudent = student.getName();
				bestStudents.clear();
				bestStudents.add(student);
			}
			else if (student.getCredit() == bestCredit) {
                bestStudents.add(student);
			}
		}
		for (Student student : bestStudents) {
            System.out.print(student.getName() + " ");		
		}
		System.out.println();
		System.out.println("--------------------------------------------------");
	}
	
	public void print() {
		while(true) {
		System.out.print("학생 이름>> ");
		String name = s.next();
		
		if(name.equals("그만"))
			break;

		
		boolean found = false;
		
		for(Student student : students) {
			if(student.getName().equals(name)) {
				System.out.print("이름: " + student.getName() + "\t");
				System.out.print("전공: " + student.getMajor() + "\t");
				System.out.print("학번: " + student.getNumber() + "\t");
				System.out.println("학점평균: " + student.getCredit());
				found = true;
				break;
			}
		}
			if(!found) {
				System.out.println(name + " 학생이 없습니다.");
				}
			}
		}
	
	public void run() {
		read();
		printAll();
		bestStudent();
		print();
	}
	
	public static void main(String[] args) {
		StudentCredit sc = new StudentCredit();
		sc.run();
	}

}