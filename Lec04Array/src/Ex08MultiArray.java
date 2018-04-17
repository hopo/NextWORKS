
public class Ex08MultiArray {

	public static void main(String[] args) {

		int[][] a = new int[3][3]; // [행][열] ??

		a[0][0] = 10;
		a[0][1] = 20;
		a[0][2] = 30;
		a[1][0] = 15;
		a[1][1] = 25;
		a[1][2] = 35;
		disp(a);
		
		int[][] b = { { 10, 20, 30 }, { 40, 50, 60 } };
		disp(b);
		
		// JAVA의 특징.
		int[][] c = new int[3][];
		c[0] = new int[4];
		c[1] = new int[2];
		c[2] = new int[3];
		disp(c);

	}

	public static void disp(int[][] arr) { // 행을 제어
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) { // 열을 제어
				System.out.print("[" + arr[i][j]+ "]");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

}
