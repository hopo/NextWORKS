import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02Method {

	public static void main(String[] args) throws IOException {
		
		// 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		StringBuffer sb = new StringBuffer();
//		sb.append("국어");
//		sb.append("영어");
//		sb.append("수학");
		
		System.out.print("국어 : ");
		int kor = getScore(reader);

		System.out.print("영어 : ");
		int eng = getScore(reader);

		System.out.print("수학 : ");
		int math = getScore(reader);
		
		// 총점
		int total = kor + eng + math;

		// 평균
		float avg = total / 3.0f;

		System.out.println("========== 중간고사 성적표 ==========");
		System.out.println("국어\t 영어\t 수학\t 총점\t 평균");
		System.out.printf("%d\t %d\t %d\t %d\t %.2f", kor, eng, math, total, avg);
	}
	
	public static int getScore(BufferedReader reader) throws IOException {
		int score;
		do {
			score = Integer.parseInt(reader.readLine());
			if(score < 0 || score > 100) {
				System.out.print("다시 입력하시오! ");
			}
		} while(score < 0 || score > 100);

		return score; 
	}

}
