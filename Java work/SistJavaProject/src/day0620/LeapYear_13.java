package day0620;

import java.util.Scanner;

public class LeapYear_13 {

	public static void main(String[] args) {
		/*년도를 입력 후 윤년인지 평년인지 출력하기
		 * 공식 
		 * 년도를 4로 나누어서 나머지가 0이고,
		 * 년도를 100으로 나누어서 나머지가 0이면 평년
		 * 년도를 400으로 나누어서 나머지가 0이면 윤년이다*/

		Scanner sc=new Scanner(System.in);
		int year;
		
		System.out.println("년도 입력");
		year=sc.nextInt();
		
		if(year%4==0&&year%100!=0||year%400==0)
			System.out.println(year+"년도는 윤년!");
		else
			System.out.println(year+"년도는 평년!");
	}

}
