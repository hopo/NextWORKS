import java.util.ArrayList;
import java.util.List;

public class Ex01ArrayList {

	public static void main(String[] args) {

		// * JAVA 1.5 이후 Generic 표현
		List<String> list = new ArrayList<String>();

		// ; 데이터 입력
		list.add("김복남"); // upcasting: String -> Object
		list.add(new String("남숙희"));
		list.add("오대수");
		list.add(new String("동치성"));
		// System.out.println(list);

		if (list.contains("오대수")) {
			System.out.println("자료가 존재합니다.");
		} else {
			System.out.println("자료가 NOT 존재합니다.");
		}
		System.out.println();

		// ; 데이터 접근, 접근 전 list 체크
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				// String name = (String)list.get(i); // downcasting: Object -> String
				String name = list.get(i); // generic 표현시, downcasting: Object -> String
				System.out.println(name);
			}
			System.out.println("====== Advanced for문(foreach) =====");
			for (String name : list) { 
				System.out.println(name);
			}
		}

	}

}
