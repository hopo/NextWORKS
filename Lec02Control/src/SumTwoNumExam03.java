import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumTwoNumExam03 {

	public static void main(String[] args) throws IOException {

		// 과제2> 두 개의 숫자를 입력받아 두 수 사이의 합을 구하시오.
		// 단, 프로그램의 수행 횟수는 항상 일정하게 작성하시오.
		// 예시)
		// 1 ~ 10 합 : 55
		// 1 ~ 100 합 : 5050
		// 1 ~ 10000 합 : 50005000

		// 입력받기 위해 BufferdReader 참조형 변수 br 생성.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("num1 : ");
		int num1 =  Integer.parseInt(reader.readLine());

		System.out.print("num2 : ");
		int num2 =  Integer.parseInt(reader.readLine());
		
		int temp = 0;
		// swapping
		if(num2 < num1) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}

//		// 1) for statement 
//		int sum = 0;
//		for(int i = num1; i <= num2; i++) {
//			sum += i; // 자동형변환도 한다
//		}
//		System.out.printf("1)%d ~ %d 까지의 합 = %d\n", num1, num2, sum);

		// 2) 가우스
		int sum = num1+num2;
		int sub = num2-num1;
		int ret = 0;
		
		ret = sum * (sub+1)/2;
		System.out.printf("2)%d ~ %d 까지의 합 = %d\n", num1, num2, ret);
		
		// 3)
		ret = 0;
		for(int j = 0; j < (sub+1)/2; j++) {
			ret += sum;
		}

		System.out.printf("3)%d ~ %d 까지의 합 = %d", num1, num2, ret);
	}
}
