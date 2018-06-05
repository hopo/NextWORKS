import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

// [과제 4] Calendar 클래스를 이용하여 달력을 출력하는 프로그램을 작성하시오.

public class Exam04 {

	public static void main(String[] args) throws IOException {

		Calendar cal = Calendar.getInstance();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("YEAR : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("MONTH : ");
		int month = Integer.parseInt(reader.readLine());

		cal.set(year, month - 1, 1);

		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;

		System.out.printf(" [[[ %d - %02d ]]]\n", year, month);
		System.out.println("Sun\t Mon\t Tue\t Wed\t Thi\t Fri\t Sat");

		for (int i = 0; i < week; i++) {
			System.out.print(" \t");
		}

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + " \t");
			if ((week + i) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
