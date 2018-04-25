import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05Array {

	public static void main(String[] args) throws IOException {

		// 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// !!! sol1)
		// String[] subjName = new String[] { "국어", "영어", "수학" };
		// int total = 0;
		// int size = subjName.length;
		// int[] subjScore = new int[size];
		//
		// for (int i = 0; i < size; i++) {
		// System.out.printf("%s : ", subjName[i]);
		// subjScore[i] = Integer.parseInt(reader.readLine());
		// if (subjScore[i] < 0 || subjScore[i] > 100) {
		// System.out.println("!다시 입력하세요.");
		// i--;
		// continue;
		// }
		// total += subjScore[i];
		// }

		// 평균
		// float avg = total / (float)size;
		// System.out.println("========== 중간고사 성적표 ==========");
		// for (int i = 0; i < size; i++) {
		// System.out.printf("%s\t", subjName[i]);
		// }
		// System.out.println("총점\t 평균");
		// for (int i = 0; i < size; i++) {
		// System.out.printf("%d\t", subjScore[i]);
		// }
		// System.out.printf("%d\t %.2f", total, avg);

		// !!! sensei sol)
		String[] subject = { "국어", "영어", "수학" };
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
