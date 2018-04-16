
public class Ex02Array {

	public static void main(String[] args) {

		// 메모리를 동적 할당한다. 'new'
		int[] num = new int[10]; // ex) num = 0x1200

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 20); // 난수 발생 메서드. 0.0 <= x < 1.0; double return
			System.out.print(num[i] + ", ");
		}
		System.out.println();

		// >>*배열의 요소(element) 중에서 최소값과 최대값을 구하시오
		int min, max;
		// int mnidx, mxidx;
		// solution1
		// min = max = num[0];
		// for(int i = 1; i < num.length; i++) {
		// if(num[i] < min) { min = num[i]; }
		// if(num[i] > max) { max = num[i]; }
		// }
		// System.out.printf("min: %d, max: %d", min, max);

		// solution1-1
		// mnidx = mxidx = 0;
		// min = max = num[0];
		// for(int i = 1; i < num.length; i++) {
		// if(min > num[i]) {
		// min = num[i];
		// mnidx = i;
		// }
		// if(max < num[i]) {
		// max = num[i];
		// mxidx = i;
		// }
		// }
		// System.out.printf("min: num[%d] %d\n", mnidx, min);
		// System.out.printf("max: num[%d] %d", mxidx, max);

		// sensei solution
		min = max = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] < min) {
				min = num[i];
			}
			if (num[i] > max) {
				max = num[i];
			}
		}

	}

}
