import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11DoWhileStmt {

	public static void main(String[] args) throws IOException {

		// 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int kor, eng, math;

		do {
			System.out.print("국어 : ");
			kor = Integer.parseInt(reader.readLine());
		} while (kor < 0 || kor > 100);

		do {
			System.out.print("영어 : ");
			eng = Integer.parseInt(reader.readLine());
		} while (eng < 0 || eng > 100);

		do {
			System.out.print("수학 : ");
			math = Integer.parseInt(reader.readLine());
		} while (math < 0 || math > 100);

		// 총점
		int total = kor + eng + math;

		// 평균
		float avg = total / 3.0f;

		System.out.println("========== 중간고사 성적표 ==========");
		System.out.println("국어\t 영어\t 수학\t 총점\t 평균");
		System.out.printf("%d\t %d\t %d\t %d\t %.2f", kor, eng, math, total, avg);
	}

}
