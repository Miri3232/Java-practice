
public class Memo {
	private String name, time, content;
	
	public Memo(String name, String time, String content) {
		this.name = name;
		this.time = time;
		this.content = content;
	}
	public boolean isSameName(Memo r) {
		if(r.name.equals(this.name)) {
			return (true);
		}
		else return (false);	
	}
	public void show() {
		System.out.println(name + ", " + time + content);
	}
	public String getName() {
		return this.name;
	}
	public int length() {
		return content.length();
	}
	public static void main(String[] args) {
		Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
		Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
		Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");
		
		a.show();
		if(a.isSameName(b)) System.out.println("동일한 사람입니다.");
		else System.out.println("다른 사람입니다.");
		System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
	}
}
