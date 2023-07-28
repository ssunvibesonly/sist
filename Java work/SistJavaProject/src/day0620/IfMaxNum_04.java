package day0620;

import java.util.Scanner;

public class IfMaxNum_04 {

	public static void main(String[] args) {
		/*
		 * 3개의 숫자를 입력(ex. 5 7 8)
		 * 
		 * 
		 * ***if문 / 삼항연산자 둘 다 활용해보기
		 * 
		 * if문 가장 큰 수 : 8
		 * 삼항연산자 큰 수 : 8
		 * */
		
		Scanner sc=new Scanner(System.in);
		
		int a,b,c,max;
		
		System.out.println("3개의 숫자를 입력하세요");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		
		System.out.println("입력한 수 : "+a+","+b+","+c);
		
		//if문
		System.out.println("if문");
		
		if(a>b && a>c)
			max=a;
		else if(b>a && b>c)
			max=b;
		else
			max=c;
		System.out.println("가장큰수 : "+max);

		//삼항연산자
		System.out.println("삼항조건연산자");
		max=(a>b&&a>c)?a:(b>a&&b>c)?b:c;
		System.out.println("가장큰수: "+max);
				
	}

}
