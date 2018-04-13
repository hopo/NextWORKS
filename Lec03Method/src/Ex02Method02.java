import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02Method02 {

	public static void main(String[] args) throws IOException {
		
		// 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int kor = getScore("국어", reader);
		int eng = getScore("영어",  reader);
		int math = getScore("수학", reader);
		
		// 총점
		int total = kor + eng + math;

		// 평균
		float avg = total / 3.0f;

		System.out.println("========== 중간고사 성적표 ==========");
		System.out.println("국어\t 영어\t 수학\t 총점\t 평균");
		System.out.printf("%d\t %d\t %d\t %d\t %.2f", kor, eng, math, total, avg);
	}
	
	public static int getScore(String subject, BufferedReader reader) throws NumberFormatException, IOException {
		int score;
		boolean scoreRange = false;
		do {
			System.out.print(subject + ": ");
			score = Integer.parseInt(reader.readLine());
			scoreRange = (score < 0 || score > 100);
			if(scoreRange) {
				System.out.print("다시 입력하시오! ");
			}
		} while(scoreRange);

		return score; 
	}

}
