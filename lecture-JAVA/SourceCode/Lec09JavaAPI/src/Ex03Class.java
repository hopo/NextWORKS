import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Hello {
	public String name;

	public Hello() {}
	public Hello(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("sayHello() : " + this.name);
	}

	public void sayHello(String name) {
		System.out.println(name + "Hello :)"); // parameter name
	}
}

public class Ex03Class {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// #1. Static Loads (이름을 알고 있을 경우)
		Member m = new Member();
		m.setName("Lee San");

		// #2. Static Loads
		Class cls = Member.class; // (=) Class cls = m.getClass();

		// ;; InstantiationException -> 생성자 호출 e
		// ;; IllegalAccessException -> 생성자 접급 제어 e
		Object obj = cls.newInstance(); // new Member(); 와 같다,

		Member m2 = (Member) obj;
		m2.setName("Seol Hyun");
		System.out.println(m2.getName());

		// #3. Dynamic Loads
		String className = "Hello"; // ex) className에 "java.lang.String" 입력 받았다 가정

		// ClassNotFoundException 없는 클래스 이름을 입력 e
		Class clazz = Class.forName(className);

		System.out.println("Class / getName(): " + clazz.getName()); // get full-name
		System.out.println("Class / getSimpleName(): " + clazz.getSimpleName());

		// !!! Reflection을 위하 클래스 예제

		// Constructor Info
		System.out.println("\n=== INFO Constructors ===");
		Constructor[] constructors = clazz.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i]);
		}

		// ;Fields Info
		System.out.println("\n=== INFO Fields ===");
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}

		// ;Methods Info
		System.out.println("\n=== INFO Methods ===");
		Method[] methods = clazz.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}

	}
}
