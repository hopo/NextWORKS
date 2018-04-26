
public class Ex01Object {
	public static void main(String[] args) {
		Member m1 = new Member("san", "Lee San", 25, "010-1234-5678"); // 0x1200
		Member m2 = new Member("san", "Lee San", 25, "010-1234-5678"); // 0x2400
		

		if(m1 == m2) {
			System.out.println("Same Obj");
		} else {
			System.out.println("Different Obj");
		}

		// 객체 비교 : equals()
		// ;실제 data value 비교를 위해 Overriding이 필요하다
		if(m1.equals(m2)) {
			System.out.println("Same Obj");
		} else {
			System.out.println("Different Obj");
		}
		
		System.out.println("m1: " + m1.toString());
		System.out.println("m2: " + m2);
	
	}

}
