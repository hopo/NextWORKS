import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Exception {

	public static void main(String[] args)  {

		// 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] subject = { "국어", "영어", "수학" };
		int[] score = new int[subject.length + 1];
		boolean isError;
		
		for (int i = 0; i < subject.length; i++) {
			do {

				isError = false;
				try {
					System.out.print(subject[i] + " : ");
					score[i] = Integer.parseInt(reader.readLine());
					if (score[i] < 0 || score[i] > 100) {
						System.out.println("Score is 0 ~ 100!!!");
					}
				} catch (IOException e) {
					System.out.println(" // IO Exception occur.");
				} catch (NumberFormatException e) {
					System.out.println(" // Number Format Exception occur.");
					isError = true;
				}

			} while (score[i] < 0 || score[i] > 100 || isError);

			// total
			score[score.length - 1] += score[i];
		}

		// avg
		float avg = score[score.length - 1] / (float) subject.length;

		System.out.println("========== 중간고사 성적표 ==========");
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + "\t");
		}
		System.out.println("총점\t 평균");

		for (int i = 0; i < score.length; i++) {
			System.out.printf(score[i] + "\t");
		}
		System.out.println(avg);

	}
}
