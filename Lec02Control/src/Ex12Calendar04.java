import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// sensei style
public class Ex12Calendar04 {

	public static void main(String[] args)throws IOException {

		// 년월을 입력받아 해당 달력을 출력하시오.
		int year = 0;
		int month = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println(" === CALENDAR === ");
		do {
			System.out.print("INPUT 년도 (1~10000) ? ");
			year = Integer.parseInt(reader.readLine());
		} while (year < 1 || year > 10000);

		do {
			System.out.print("INPUT 월 (1~12) ? ");
			month = Integer.parseInt(reader.readLine());
		} while (month < 1 || month > 12);
		
		// 작년
		int lastYear = year -1;
		// 작년까지의 윤년의 횟수
		int leapYearCnt = (lastYear /4) - (lastYear / 100) + (lastYear / 400);
		
		// 해당년이 윤년인지 확인
		boolean isLeapYear = false;
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			isLeapYear = true;
		}
		
		// 해당월의 1일 까지 일 수
		int dayOfYear = 1;
		
		for(int i = 1; i < month; i++) {
			switch(i) {
			case 4:
			case 5:
			case 6:
			case 9:
			case 11:
				dayOfYear += 30;
				break;
			case 2:
				dayOfYear += (isLeapYear? 29 : 28);
				break;
			default:
				dayOfYear += 31;
			}
		}
		
		
		// 해당 월의 첫번째 날짜(1일)의 시작 요일 구하기.
		// 작년까지 평년 횟수 + 작년까지 윤년 횟수 + 해당년 해당월의 1일 까지의 일수
		int week = (lastYear + leapYearCnt + dayOfYear)%7;
		
		System.out.printf("		%d년 %2d월\n", year, month);
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t 일");
		
		// 공백출력
		for(int i = 0; i < week; i++) {
			System.out.print(" \t");
		}
		// 날짝 출력
		int lastDay =  0;
		
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			lastDay = 30;
		} else if(month == 2) {
				lastDay = 28;
			if(isLeapYear) {
				lastDay = 29;
			}
		} else {
			lastDay = 31;
		}
		
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i + " \t");
			if((week + i) % 7 == 0) {
				System.out.println();
			}
		}

	}
}
