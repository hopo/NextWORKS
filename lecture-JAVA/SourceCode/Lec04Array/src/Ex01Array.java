
public class Ex01Array {

	public static void main(String[] args) {

		// int score1 = 10;
		// int score2 = 15;
		// int score3 = 20;
		// int score4 = 25;
		// int score5 = 30;

		// 배열 선언 및 생성.
		// int[] score = new int[5];

		// int[] arr; // 배열 선언
		// arr = new int[3];

		int arr1[] = new int[5];

		// 배열에 접근
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;

		// System.out.println("arr1[0] = " + arr1[0]);
		// System.out.println("arr1[1] = " + arr1[1]);
		// System.out.println("arr1[2] = " + arr1[2]);

		// 배열의 생성과 동시에 초기화
		// int[] arr2 = new int[] { 15, 25, 35, 45 };
		// int[] arr3 = { 15, 25, 35, 45, 55 };

		// int[] arr4;
		// arr4 = {10, 20, 30}; // 선언과 할당의 분리는 불가

		// System.out.println("arr2[0] = " + arr2[0]);
		// System.out.println("arr2[2] = " + arr2[2]);

		int[] num = { 3, 6, 9, 12, 15 }; // new int[5];

		// index : 0~4
		for(int i = 0; i < num.length; i++) {
			System.out.println("num[" + i + "]" + num[i]);
		}
		
		
		int[] num2 = new int[10];
		
		for(int i = 0; i < num2.length; i++) {
			num2[i] = (i+1) * 5;
		}
		

	}

}
