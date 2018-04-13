import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12Calendar03 {
	
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
		
        // !!! ;weekNum
        // weekNum = dDays % 7;
		// dDays = year-1 + leapYearCnt + thisYearDayCnt
		
        // ()parameter ;year ;month
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int year = 0;
		int month = 0;
        System.out.println(" === CALENDAR === "); 
        do {
        System.out.print("INPUT 년도 (1~10000) ? ");
		year = Integer.parseInt(reader.readLine());
        } while(year < 1 || year > 10000);

		do {
        System.out.print("INPUT 월 (1~12) ? ");
		month = Integer.parseInt(reader.readLine());
		} while(month < 1 || month > 12);
        System.out.println();


        // !! ;leapYearCnt
		int leapYearCnt = ((year-1)/4)-((year-1)/100)+((year-1)/400);
        // System.out.printf(">>*leapYearCnt : %d\n", leapYearCnt);

        // !! ;thisYearDayCnt
        // 올해는 윤년인가? ;isNowLeap
		boolean bl1 = year%4 == 0;
		boolean bl2 = year%100 == 0;
		boolean bl3 = year%400 == 0;
		boolean isNowLeap = (bl1 && !bl2 || bl3);
		
		// month가 2월인가? ;isNowFeb
		boolean isNowFeb = month == 2;

        // month 이전 31일 달 ;sumMDay
		int mDay = 0;
		int oChk = 1;
		int sumMDays = 0;
		for(int m = 1; m <= month; m++) {
			sumMDays += mDay;
			if(m == 8) {
				oChk ^= 1;
			}
			switch(oChk) {
			case 1:
				mDay = 31;
				break;
			case 0:
				mDay = 30;
				break;
			}
			oChk ^= 1;
		}

        int thisYearDayCnt = sumMDays + 1;
		if(month > 2) {
			if(isNowLeap) {
				thisYearDayCnt -= 1;
			} else {
				thisYearDayCnt -= 2;
			}
		}
//         System.out.printf(">>*isNowLeap : %b\n", isNowLeap);
//         System.out.printf(">>*thisYearDayCnt : %d\n", thisYearDayCnt);

        int weekNum  = ((year-1) + leapYearCnt + thisYearDayCnt) % 7;
         System.out.printf("[%d-%d] 요일넘버: %d\n", year, month, weekNum);


        // !!! 달력출력
        if(isNowFeb) {
            if(isNowLeap) {
                mDay -= 1;
            } else {
                mDay -= 2;
            }
        }
        int d = 1;
        boolean hasNext = true;
        boolean yet = true;
        System.out.printf("======= [ %d년 %d월 ] =======\n", year, month);
        System.out.println(" 일\t월\t화\t수\t목\t금\t토");

        while(hasNext) {
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
                if(d > mDay) { 
                    hasNext = false;
                    break;
                }

            }
            System.out.println();
        }
	}
}
