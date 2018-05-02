import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// * Inheritance Relation : Map <- HashMap
public class Ex06HashMap {

	public static void main(String[] args) {

		// key, value 쌍으로 이뤄진 Map. 중복 불가
		HashMap<String, Object> map = new HashMap<>();
		// Map<String, Object> map = new LinkedHashMap<>(); // put한 순서대로 이용하는 Map

		map.put("id", "san");
		map.put("name", "이산");
		map.put("age", 25);
		map.put("gender", 'M');
		map.put("phone", "010-1234-5678");

		// System.out.println("name=" + map.get("name"));
		// System.out.println("age=" + map.get("age"));

		// ; 키s를 Set화
		Set<String> keySet = map.keySet();

		Iterator<String> itr = keySet.iterator();

		while (itr.hasNext()) {
			String key = itr.next();
			System.out.println(key + "=" + map.get(key));
		}
	
		
		// ; ex) image extension : .jpg, .png, .bmp, .gif 확인하기
		Map<String, String> extensionMap = new HashMap();
		extensionMap.put(".jpg", "JPEG 이미지 파일");
		extensionMap.put(".png", "png 이미지 파일");
		extensionMap.put(".bmp", "bmp 이미지 파일");
		extensionMap.put(".gif", "gif 이미지 파일");
		
		String fileExtenstion = ".png";
		
		if(extensionMap.containsKey(fileExtenstion)) {
			System.out.println("해당 파일은 " + extensionMap.get(fileExtenstion) + "입니다.");
		} else {
			System.out.println("이미지 파일이 아닙니다.");
		}
		

	}

}
