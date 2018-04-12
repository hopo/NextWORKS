
public class Ex12Calendar {
	
	public static void main(String[] args) {

		// 과제)
		// 년월을 입력받아 해당 달력을 출력하시오.
		
		// 태양력, 365%7 = 1
		// 1년 1월 1일 : 월
		// 2년 1월 1일 : 화
		// 3년 1월 1일 : 수
		// 4년 1월 1일 : 목
		// 5년 1월 1일 : 토
		
		// yoil = (평년추가수 + 윤년추가수 + year month 까지의 일수)%7
		
		int year = 2018;
		int month = 4;

		int yoil;
		int leapYearCnt = (year/4) - (year/100) + (year/400);

		boolean bl1 = year%4 == 0;
		boolean bl2 = year%100 == 0;
		boolean bl3 = year%400 == 0;
		boolean nowLeapYear = (bl1 && !bl2 || bl3);
		
		
		
	}

}
