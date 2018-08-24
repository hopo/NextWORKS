package kr.nextit.junit;

public class MyCalc {
	
	int sum(int a, int b) {
		int ret = 0;
		while(a != b+1) {
			ret += a++;
		}
		
		return ret;
	}

	public static void main(String[] args) {
		MyCalc st = new MyCalc();
		
		int a = 1;
		int b = 10;
				
		int ret = st.sum(a, b);
		System.out.printf("결과 : %d",ret);
	}

}
