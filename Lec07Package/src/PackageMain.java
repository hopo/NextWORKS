import kr.or.nextit.shape.Rectangle;
import kr.or.nextit.shape.common.Member;

public class PackageMain {

	public static void main(String[] args) {

		// protected 선언된 생성자는 외부에서 접근 불가
		// Account acc = new Account();

		Rectangle rect = new Rectangle();

		rect.width = 10;
		rect.height = 20;

		System.out.println("rect.getArea() : " + rect.getArea());
		
		
		// private 접근제어자
		Member m1 = Member.getInstance();
		
		m1.setName("이산");

		Member m2 = Member.getInstance();

		System.out.println("m1.name : "+ m1.getName());
		System.out.println("m2.name : "+ m2.getName());

	}

}
