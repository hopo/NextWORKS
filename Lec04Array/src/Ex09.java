import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09 {

	public static void main(String[] args) throws IOException {

		// EXAM)
		// '3명'의 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		// 재수 없지만 등수를 구하여라.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 학생수 ;student
		System.out.print("*학생 수는 몇명입니까? ");
		int student = Integer.parseInt(reader.readLine());

		// 과목 ;subject
		String[] subject = { "국어", "영어", "수학" };

		int[][] table = new int[student][subject.length+2];

		// 데이터 입력 받기.
		for (int p = 0; p < table.length; p++) {
            System.out.printf("[%d번 학생]\n", p+1);
			for (int i = 0; i < subject.length; i++) {
				do {
					System.out.print(subject[i] + " : ");
					table[p][i] = Integer.parseInt(reader.readLine());
					if (table[p][i] < 0 || table[p][i] > 100) {
						System.out.println("0 ~ 100!!!");
					}
				} while (table[p][i] < 0 || table[p][i] > 100);

				// ;총점
				table[p][subject.length] += table[p][i];
			}

		}

        // ;평균
        float[] avg = new float[student];
        for(int p = 0; p < table.length; p++) {
            avg[p] = table[p][subject.length] / (float) subject.length;
        }

        // ;등수
		int tmp = 1;
        for(int p = 0; p < table.length; p++) {
        	tmp = table[p][subject.length];
        	for(int j = 0; j < table.length; j++) {
        		if(tmp < table[j][subject.length]) {
        			table[p][subject.length+1]++;
        		}
        	}
        	table[p][subject.length+1]++;
        }

        // !데이터 출력
        System.out.println("================ 중간고사 성적표 ================");
        System.out.print("\t");
        for (int i = 0; i < subject.length; i++) {
            System.out.print(subject[i] + "\t");	// 과목 목록
        }
        System.out.println("총점\t 등수\t 평균");

        for (int p = 0; p < table.length; p++) {
        	System.out.printf("%d번 학생| ", p+1);
            for(int i = 0; i < table[p].length; i++) {
                System.out.printf(table[p][i] + "\t ");	// ?번 학생 각과목 점수와 총점 등수 평
            }
            System.out.printf("%.2f\n",avg[p]);
        }
        System.out.println("=============================================");

	}
}
