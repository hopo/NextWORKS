import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06Calendar {

	public static void main(String[] args)throws IOException {

		// 년월을 입력받아 해당 달력을 출력하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int year = 0;
		int month = 0;

		System.out.println(" === 출력하고픈 년 월을 입력하시오 === ");
		do {
			System.out.print("INPUT 년도 (1~10000) ? ");
			year = Integer.parseInt(reader.readLine());
		} while (year < 1 || year > 10000);

		do {
			System.out.print("INPUT 월 (1~12) ? ");
			month = Integer.parseInt(reader.readLine());
		} while (month < 1 || month > 12);
		
		// 매월의 마직막 날짜를 array에 담기 (1월 ~ 12월)
		int[] maxDate = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// 작년
		int lastYear = year -1;
		// 작년까지의 윤년의 횟수
		int leapYearCnt = (lastYear /4) - (lastYear / 100) + (lastYear / 400);
		
		// 해당년이 윤년인지 확인
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			maxDate[1] = 29;
		}
		
		// 해당월의 1일 까지 일 수
		int dayOfYear = 1;
		
		for(int i = 0; i < month - 1; i++) {
			dayOfYear += maxDate[i];
		}
		
		// 해당 월의 첫번째 날짜(1일)의 시작 요일 구하기.
		// 작년까지 평년 횟수 + 작년까지 윤년 횟수 + 해당년 해당월의 1일 까지의 일수
		int week = (lastYear + leapYearCnt + dayOfYear) % 7;
		
		System.out.printf("		[%d년 %2d월]\n", year, month);
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토");
		
		// 공백출력
		for(int i = 0; i < week; i++) {
			System.out.print(" \t");
		}

		// 날짝 출력
		int lastDay =  maxDate[month-1];
		
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i + " \t");
			if((week + i) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
