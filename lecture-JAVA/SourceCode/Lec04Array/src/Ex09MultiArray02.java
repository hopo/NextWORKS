import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// >>* sensei solution)
public class Ex09MultiArray02 {

	public static void main(String[] args) throws IOException {

		// EXAM)
		// '3명'의 국, 영, 수 3과목 점수를 받아서 총점, 평균 구하기.
		// 재수 없지만 등수를 구하여라.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 학생수 ;student
		System.out.print("*학생 수는 몇명입니까? ");
		int studentCnt = Integer.parseInt(reader.readLine());

		// 과목 ;subject
		String[] subject = { "국어", "영어", "수학" };

		// int[][?] ?배열의 마지막 인덱스는 등수 마지막 앞 인덱스는 총점
		int[][] score = new int[studentCnt][subject.length + 2];
        float[] avg = new float[studentCnt];

		// 데이터 입력 받기.
		for (int n = 0; n < studentCnt; n++) {
            System.out.printf("[%d번 학생]\n", n+1);
			for (int i = 0; i < subject.length; i++) {
				do {
					System.out.print(subject[i] + " : ");
					score[n][i] = Integer.parseInt(reader.readLine());
					if (score[n][i] < 0 || score[n][i] > 100) {
						System.out.println("0 ~ 100 다시 입력하세요!");
					}
				} while (score[n][i] < 0 || score[n][i] > 100);

				// ;총점
				score[n][score[n].length - 2] += score[n][i];
			}
			// ;평균
            avg[n] = score[n][score[n].length - 2] / (float) subject.length;
            
            // ;등수, 인덱스에 1을 넣어 초기화
            score[n][score[n].length - 1] = 1;
		}

        // ;등수
		for(int n = 0; n < studentCnt; n++) {
			for(int i = 0; i < studentCnt; i++) {
				if(score[n][score[n].length - 2] < score[i][score[i].length -2]) {
					score[n][score[n].length - 1]++;
				}
			}
		}

        // !데이터 출력
        System.out.println("================ 중간고사 성적표 ================");
        System.out.print("\t");
        for (int i = 0; i < subject.length; i++) {
            System.out.print(subject[i] + "\t ");	// 과목 목록
        }
        System.out.println("총점\t 등수\t 평균");

        for (int n = 0; n < studentCnt; n++) {
        	System.out.printf("%d번 학생| ", n+1);
            for(int i = 0; i < score[n].length; i++) {
                System.out.printf(score[n][i] + "\t ");	// ?번 학생 각과목 점수와 총점 등수 평
            }
            System.out.printf("%.2f\n",avg[n]);
        }
        System.out.println("=================================================");

	}
}
