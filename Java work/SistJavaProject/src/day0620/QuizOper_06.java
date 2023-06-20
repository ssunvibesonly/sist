package day0620;

import java.util.Scanner;

public class QuizOper_06 {

	public static void main(String[] args) {
		/*
		 * 이름을 입력하세요.
		 * 강민호
		 * 3과목의 점수를 입력하세요(국영수)
		 * 39
		 * 88
		 * 99
		 * ================================
		 * 3과목 점수: 39,88,99
		 * 평균: 75.3333
		 * -------------------------------------------
		 * ****합격 조건: 평균이 70점 이상이고, 각 과목이 40점이상이면 합격****
		 * --------------------------------------------
		 * 강민호님은 불합격입니다.
		 * 
		 * */
		Scanner sc=new Scanner(System.in);
		
		//변수
		String name,score;
		int kor,eng,math;
		
		//입력
		System.out.println("이름을 입력하시오");
		name=sc.nextLine();
		System.out.println("3과목의 점수를 입력하세요");
		kor=sc.nextInt();
		eng=sc.nextInt();
		math=sc.nextInt();
		
		//계산
		int total=kor+eng+math;
		double avg=total/3.0;
		
		//출력
		System.out.println("=============================");
		System.out.println("3과목 점수: "+kor+","+eng+","+math);
		System.out.println("평균: "+avg);
		System.out.println("------------------------------");
		
		//if조건문
		if(avg>=70 && kor>=40 && eng>=40 && math>=40)
			System.out.println(name+"님은 합격입니다.");
		else
			System.out.println(name+"님은 불합격입니다.");
		
		//삼항조건문
		/*String hap;
		hap=(avg>=70 && kor>=40 && eng>=40 && math>=40)?"합격":"불합격";
		
		System.out.println("***합격조건:평균이 70점 이상이고 \n각 과목이 40점 이상이면 합격");
		System.out.println("------------------------------");
		
		System.out.println(name+"님은 "+hap+" 입니다");*/
		
		
	}

}
