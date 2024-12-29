import java.util.*;

class Student {
	String name, major;
	int number;
	double credit;
	
	public Student(String name, String major, int number, double credit) {
		this.name = name;
		this.major = major;
		this.number = number;
		this.credit = credit;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getNumber() {
		return number;
	}
	
	public double getCredit() {
		return credit;
	}
	
}
