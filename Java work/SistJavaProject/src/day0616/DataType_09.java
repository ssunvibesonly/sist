package day0616;

public class DataType_09 {

	public static void main(String[] args) {
		// 묵시적 형변환 : 자동 결정되는 타입
		// String+int = String
		// double+int = double
		// long+short = long
		// char+int = int
		
		char a='a';
		
		System.out.println(a);
		System.out.println(a+2);
		System.out.println((char)(a+2));//형변환해주고싶은 것들에 대해 괄호처리 꼭 해야 적용됨!
		
		System.out.println("Happy"+5+6);
		System.out.println("Happy"+(5+6)); //int안해줘도 괄호처리만 하면 정수 덧셈
		System.out.println('A'+3);//아스키 코드값 65+3=68
		System.out.println(2+'b');
		System.out.println('a'+'b');//97+98 문자+문자인데 왜 문자형? 기본이 정수형이라 문자형으로 알고싶으면 형변환 해줘야함, ''연산을 하게 되면 정수형으로 나옴
		System.out.println('a');
		

	}

}
