import java.util.List;
import java.util.Vector;

public class Ex02Vector {

	public static void main(String[] args) {
		List vec = new Vector();

		vec.add(new String("이상"));
		vec.add(25);	// Auto Boxing 됨
		vec.add('M');	// Auto Boxing 됨
		vec.add("010-1234-5678");
		
		System.out.println(vec);

	}
}
