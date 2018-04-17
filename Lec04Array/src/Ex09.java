import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09 {

	public static void main(String[] args) throws IOException {

		// EXAM)
		// '3명'의 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		// 재수 없지만 등수를 구하여라.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // *subject
		String[] subject = { "국어", "영어", "수학" };
		int[][] table = new int[3][subject.length+1];

		for (int p = 0; p < table.length; p++) {
            System.out.printf("[%d Student]\n", p);

			for (int i = 0; i < subject.length; i++) {
				do {
					System.out.print(subject[i] + " : ");
					table[p][i] = Integer.parseInt(reader.readLine());
					if (table[p][i] < 0 || table[p][i] > 100) {
						System.out.println("0 ~ 100!!!");
					}
				} while (table[p][i] < 0 || table[p][i] > 100);

				// total
				table[p][subject.length] += table[p][i];
			}

		}

        // find average
        float[] avg = new float[3];
        for(int p = 0; p < table.length; p++) {
            avg[p] = table[p][subject.length] / (float) subject.length;
        }

        // RANK???

        // print data
        System.out.println("========== 중간고사 성적표 ==========");
        for (int i = 0; i < subject.length; i++) {
            System.out.print(subject[i] + "\t");
        }
        System.out.println("총점\t 평균\t RANK");

        for (int p = 0; p < table.length; p++) {
            for(int i = 0; i < table[p].length; i++) {
                System.out.printf(table[p][i] + "\t ");
            }
            System.out.println(avg[p]);
        }

	}
}
