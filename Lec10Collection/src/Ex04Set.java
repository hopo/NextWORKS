import java.util.HashSet;
import java.util.Iterator;

// * Inheritance Relation: Collection <- Set <- HashSet
public class Ex04Set {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<String>();

		set.add(new String("이산"));
		set.add("설현");
		set.add("박보영");
		set.add("서현");

		// set.add(123); // error, Gereric <String>

		// ; 데이터 중복 불가
		set.add("설현");

		// ; set은 순서 개념이 없다
		// System.out.println(set);

		// >> set은 map의 key 관리하는데 이용된다.

		// iterator()를 이용하여 Iterator 객체생성
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}

}
