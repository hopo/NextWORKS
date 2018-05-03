import java.util.Enumeration;
import java.util.Hashtable;

// * Inheritance Relation : Map <- Hashtable
public class Ex05Hashtable {

	public static void main(String[] args) {

		Hashtable<String, String> table = new Hashtable<>();

		// ; hashtable.put()
		table.put("이산", "010-1234-5689");
		table.put("설현", "010-1004-0009");
		table.put("소향", "010-4449-4444");

		// System.out.println(table);

		// System.out.println("이산 : " + table.get("이산"));

		// ! 열거자(Enumeration) 이용하여 키s 가져오기, like Iteration
		// ; hashtable.keys()
		Enumeration<String> keyEnum = table.keys();

		while (keyEnum.hasMoreElements()) {
			String key =  keyEnum.nextElement();
			System.out.println(key + " = " + table.get(key));
		}

	}
}
