public class Ex07Array {

	public static void main(String[] args) {
		
		int[] source = { 1, 2, 3, 4, 5 };
		int[] target = { 10, 20, 30, 40, 50, 60, 70 };
		
		// 배열의 부분 복사
		System.arraycopy(source, 2, target, 2, 3);
		
		for(int i = 0; i < target.length; i++) {
			System.out.print(target[i] + ", ");
		}
		System.out.println("\n=========================");
		
		
		// 배열의 메모리를 복제, clone() 메소드
		int[] target2 = (int[])source.clone();
		for(int i = 0; i < target2.length; i++) {
			System.out.print(target2[i] + ", ");
		}
		System.out.println("\n=========================");
		
	}

}
