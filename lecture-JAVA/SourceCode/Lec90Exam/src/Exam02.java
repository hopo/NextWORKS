import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [과제 2] 국어, 영어, 수학 점수를 입력 받아 총점, 평균 그리고 등급을 구하는 프로그램을 작성하시오. 
public class Exam02 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int kor, eng, math;
		kor = eng = math = 0;

		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print("KOR(0~100)? ");
			kor = Integer.parseInt(reader.readLine());
		} while (kor > 100 || kor < 0);

		do {
			System.out.print("ENG(0~100)? ");
			eng = Integer.parseInt(reader.readLine());
		} while (eng > 100 || eng < 0);

		do {
			System.out.print("MATH(0~100)? ");
			math = Integer.parseInt(reader.readLine());
		} while (math > 100 || math < 0);

		int total = kor + eng + math;
		double avg = total / 3f;

		String grade = null;

		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		if (avg == 100 || grade != "F" && avg % 10 >= 5) {
			grade += "+";
		}

		System.out.printf("*\ntotal: %d\navg: %.2f\ngrade: %s", total, avg, grade);

	}

}
