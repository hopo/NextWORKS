
class Calculator {
	
	// overloading
	public int plus(int a, int b) {
		return a + b;
	}

	public float plus(float a, float b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public float minus(float a, float b) {
		return a - b;
	}
	
}

public class Overloading {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int x = 10;
		int y = 20;
		int z = calc.plus(x, y);
		System.out.println("int plus(int, int): " + z);
		
		float a = 3.14f;
		float b = 5.5f;
		float c = calc.plus(a, b);
		System.out.println("int plus(int, int): " + c);
		
	}

}
