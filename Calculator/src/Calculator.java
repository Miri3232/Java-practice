import java.util.Scanner;

abstract class Calc {
	
	public String errorMsg;
	protected int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}	
	abstract public int calculate();	
}
class Add extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a+b;
	}
}
class Sub extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a-b;
	}
}
class Div extends Calc {
	@Override
	public int calculate() {
		if(b==0) {
			errorMsg = "0으로 나눌 수 없음.";
			return 0;
		}
		else {
		errorMsg = null;
		return a/b;
		}
	}
}
class Mul extends Calc {
	@Override
	public int calculate() {
		errorMsg = null;
		return a*b;
	}
}
public class Calculator {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Calc calc = null;
		while(true) {
			System.out.print("두 정수와 연산자를 입력하시오>> ");
			int a = s.nextInt();
			int b = s.nextInt();
			String operator = s.next();

			switch(operator) {
			case "+" :
				calc = new Add();
				break;
			case "-" :
				calc = new Sub();
				break;
			case "/" :
				calc = new Div();
				break;
			case "*" :
				calc = new Mul();
				break;
			default :
				System.out.println("잘못된 연산자 입니다.");
				return;
			}
			calc.setValue(a, b);
			int result = calc.calculate();
			if(calc.errorMsg == null) {
				System.out.println("계산 결과 " + result);
			}
			else {				
				 System.out.print(calc.errorMsg);
				 System.out.println(" 프로그램 종료");
				 break;
			}
		}
	}
}

