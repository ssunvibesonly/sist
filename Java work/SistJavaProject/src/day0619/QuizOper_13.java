package day0619;

import java.util.Scanner;

public class QuizOper_13 {

	public static void main(String[] args) {
		/*
		 * 이름 입력
		 * 강호동
		 * 키
		 * 177.5
		 * 체중
		 * 88
		 * 
		 * **학생 신체 정보**
		 * 이름: 강호동
		 * 키: 177.5cm
		 * 몸무게: 88kg
		 * 표준 몸무게:(키-100)*0.9kg
		 * 권장 표준 몸무게는 69.75kg입니다.*/

		Scanner sc=new Scanner(System.in);
		
		String name;
		double height,weight;
		
		System.out.println("이름 입력:");
		name=sc.nextLine();
		System.out.println("키 입력:");
		height=sc.nextDouble();
		System.out.println("몸무게 입력:");
		weight=sc.nextDouble();
	
		double stweight=(height-100.0)*0.9;
		
		System.out.println("**학생 신체 정보**");
		System.out.println("이름: "+name);
		System.out.println("키: "+height+"cm");
		System.out.println("몸무게: "+weight+"kg");
		System.out.println("권장 표준 몸무게는"+stweight+"kg 입니다.");
		System.out.printf("권장 표준 몸무게:%f KG",stweight);
		//.%f 형식을 쓸땐는 printf문이어야 하며 
		//.%f를 하면 소수점 아래 6자리까지 나온다 ex).%3f -> 소수점 아래 3자리까지 나온다ㅌ
	}

}
