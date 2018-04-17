import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09 {

	public static void main(String[] args) throws IOException {

		// EXAM)
		// 3명의 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		// 재수 없지만 등수를 구하여라.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] subject = { "국어", "영어", "수학" };
		int[][] mat = new int[3][subject.length+1];

		// >>* sensei sol)
		for (int m = 0; m < mat.length; m++) {
			int[] score = new int[subject.length + 1];
			for (int i = 0; i < subject.length; i++) {
				do {
					System.out.print(subject[i] + " : ");
					score[i] = Integer.parseInt(reader.readLine());
					if (score[i] < 0 || score[i] > 100) {
						System.out.println("0 ~ 100!!!");
					}
				} while (score[i] < 0 || score[i] > 100);

				// total
				score[score.length - 1] += score[i];
			}
		}

		// avg
		// float avg = score[score.length - 1] / (float) subject.length;
		//
		// System.out.println("========== 중간고사 성적표 ==========");
		// for (int i = 0; i < subject.length; i++) {
		// System.out.print(subject[i] + "\t");
		// }
		// System.out.println("총점\t 평균");
		//
		// for (int i = 0; i < score.length; i++) {
		// System.out.printf(score[i] + "\t");
		// }
		// System.out.println(avg);

	}
}
