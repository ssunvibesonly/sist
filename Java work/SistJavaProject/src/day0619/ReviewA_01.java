package day0619;

public class ReviewA_01 {

	public static void main(String[] args) {
		// 매개변수로 실행 시 이름, 국영수 3과목을 넘겨서 이름, 과목점수, 총점, 평균까지 출력하시오
		
		/* ****중간고사 시험점수**** 
		 * 학생명 : 홍길동
		 * 국어 점수 : 80점 
		 * 영어 점수 : 90점
		 * 수학 점수 : 70점
		 * =======================
		 * 총점 : 
		 * 평균 : */
		
		//변수 선언
		String name=args[0];
		int kor=Integer.parseInt(args[1]);
		int eng=Integer.parseInt(args[2]);
		int math=Integer.parseInt(args[3]);
		
		//계산
		int total=kor+eng+math;
		int avg=total/3;
		
		//출력
		System.out.println("****중간고사 시험점수****");
		System.out.println("학생명:"+name);
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("===========================");
		System.out.println("총점:"+total);
		System.out.println("평균:"+avg);
	
	
	}

}
