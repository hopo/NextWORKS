
public class StaticBlock {
	
	// static field = class field
	static int a = 10;
	static int b = 20;
	static float c = 3.14f;
	
	static int[] num = new int[10];	// {0, 0, 0}
	
	// static 초기화 블럭.
	static {
		for(int i = 0; i < num.length; i++) {
			num[i] = 3 * (i+1);
			System.out.print(num[i] + ", ");
		}
	}

	public static void main(String[] args) {}
}
