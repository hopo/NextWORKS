
public class Ex04Array {

	public static void main(String[] args) {
		int[] num = new int[30];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 10); // 0 ~ 9 사이의 난수

			System.out.print(num[i] + ", ");
		}
		System.out.println();

		// num = { 9, 6, 2, 1, 4, ... 3, 5, 9 };

		// 배열에 들어있는 각각의 숫자가 몇 번 발생하는 지 카운트.
		// sol1)
		// int[] count = new int[10];
		// for(int i = 0; i < num.length; i++) {
		// switch(num[i]) {
		// case 0: count[0]++; break;
		// case 1: count[1]++; break;
		// case 2: count[2]++; break;
		// case 3: count[3]++; break;
		// case 4: count[4]++; break;
		// case 5: count[5]++; break;
		// case 6: count[6]++; break;
		// case 7: count[7]++; break;
		// case 8: count[8]++; break;
		// case 9: count[9]++; break;
		// }
		// }
		// for(int i = 0; i < count.length; i++) {
		// System.out.printf("%d : %d번, ", i, count[i] );
		// }
		
		// sol2)
		int temp;
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num.length; j++) {
				if(num[i] < num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		// sensei sol)
//		 int[] count = new int[10];
//		 for(int i = 0; i < num.length; i++) { count[num[i]]++; }
//
//		 for(int i = 0; i < count.length; i++) {
//			 System.out.printf("%d: %d번, ", i, count[i] );
//		 }
		

	}
}
