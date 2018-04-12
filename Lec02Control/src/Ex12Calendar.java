import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12Calendar {
	
	public static void main(String[] args) throws IOException {

		// 과제)
		// 년월을 입력받아 해당 달력을 출력하시오.
		
		// 태양력, 365%7 = 1
		// 1년 1월 1일 : 월
		// 2년 1월 1일 : 화
		// 3년 1월 1일 : 수
		// 4년 1월 1일 : 목
		// 5년 1월 1일 : 토
		
		// dddays = (년추가수 + 윤년추가수 + 올해계산(year month 까지의 일수)
        // youl = dddays%7;
		
        // input year and month
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("INPUT year ? ");
		int year = Integer.parseInt(reader.readLine());    // *년 추가 수;year
        System.out.print("INPUT month ? ");
		int month = Integer.parseInt(reader.readLine());


        // *윤년추가 수는? until year ;leapYearCnt
		int leapYearCnt = (year/4) - (year/100) + (year/400);

        // *올해 계산 ;thisYearDays
        // 올해는 윤년인가?
		boolean bl1 = year%4 == 0;
		boolean bl2 = year%100 == 0;
		boolean bl3 = year%400 == 0;
		boolean nowLeapYear = (bl1 && !bl2 || bl3);

        // month 이전 31일 달은 몇개?
        int threeOne = 2; // ??? ex) 4 -> [2]{1, 3}

        int thisYearDays = (month-1) * 30 + threeOne + 1;
        if(month > 2) {
            if(nowLeapYear) {
                thisYearDays -= 1;
            } else {
                thisYearDays -= 2;
            }
        }

        // ;dddays
        int dddays = (year-1) + leapYearCnt - thisYearDays;
        int yoil = dddays%7;

        System.out.printf("[%d-%d] yoil: %d\n", year, month, yoil);



        // >> 달력만들기
        System.out.println(" 월\t화\t수\t목\t금\t토\t일");
        int d = 1;
        boolean term = true;
        while(term) {
            for(int w = 0; w < 7; w++) {
                System.out.printf(" %2d\t", d++);
                if(d == 31) {
                    term = false;
                    break;
                }
            }
            System.out.println();
        }
		
	}

}
