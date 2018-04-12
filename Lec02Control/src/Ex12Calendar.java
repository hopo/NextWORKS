import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12Calendar {
	
	public static void main(String[] args) throws IOException {

		// 과제)
		// 년월을 입력받아 해당 달력을 출력하시오.
	    // %% 참고	
		// 태양력, 365%7 = 1
		// 1년 1월 1일 : 월
		// 2년 1월 1일 : 화
		// 3년 1월 1일 : 수
		// 4년 1월 1일 : 목
		// 5년 1월 1일 : 토
		
        // *** ;weekNum
        // weekNum = dDays % 7;
		// dDays = (year + leapYearCnt + thisYearDayCnt
		
        // ()parameter ;year ;month
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(" === CALENDAR === "); 
        System.out.print("INPUT year ? ");
		int year = Integer.parseInt(reader.readLine());
        System.out.print("INPUT month (1~12) ? ");
		int month = Integer.parseInt(reader.readLine());
        System.out.println();


        // ** ;leapYearCnt
		int leapYearCnt = ((year-1)/4)-((year-1)/100)+((year-1)/400);
        // System.out.printf(">>*leapYearCnt : %d\n", leapYearCnt);

        // ** ;thisYearDayCnt
        // 올해는 윤년인가?
		boolean bl1 = year%4 == 0;
		boolean bl2 = year%100 == 0;
		boolean bl3 = year%400 == 0;
		boolean isNowLeapYear = (bl1 && !bl2 || bl3);

        // month 이전 31일 달은 몇개? ex)4 -> [2]{1, 3}
        int threeOne = 0; 
        for(int m = 1; m < month; m++) {
            if(m < 8) {
                if(m%2 != 0) {
                    threeOne++;
                }
            } else {
                if(m%2 == 0) {
                    threeOne++;
                }
            }
        }

        int thisYearDayCnt = (month-1) * 30 + threeOne + 1;
        if(month > 2) {
            if(isNowLeapYear) {
                thisYearDayCnt -= 1;
            } else {
                thisYearDayCnt -= 2;
            }
        }
        // System.out.printf(">>*isNowLeapYear : %b\n", isNowLeapYear);
        // System.out.printf(">>*thisYearDayCnt : %d\n", thisYearDayCnt);

        int weekNum  = ((year-1) + leapYearCnt + thisYearDayCnt) % 7;
        // System.out.printf("[%d-%d] weekNum: %d\n", year, month, weekNum);


        // !!! 달력출력
        int dEnd;
        if(month < 8 ) {
            dEnd = (month%2 == 0)? 30 : 31;  
        } else {
            dEnd = (month%2 != 0)? 30 : 31;  
        }
        if(month == 2) {
            if(isNowLeapYear) {
                dEnd -= 1;
            } else {
                dEnd -= 2;
            }
        }
        int d = 1;
        boolean next = true;
        boolean yet = true;
        System.out.printf("===== [ %d년 %d월 ] =====\n", year, month);
        System.out.println(" 월\t화\t수\t목\t금\t토\t일");

        while(next) {
            for(int w = 0; w < 7; w++) {
                if(w == weekNum) {
                    yet = false;
                }
                if(yet) {
                    if(w == weekNum-1) { yet = false; }
                    System.out.print(" \t");
                    continue;
                }

                System.out.printf(" %2d\t", d++);
                if(d > dEnd) { 
                    next = false;
                    break;
                }

            }
            System.out.println();
        }
	}
}
