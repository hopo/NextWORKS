import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex13Pattern {
	
	public static void main(String[] args) {
		
		// !! matches()
		// ; 전화번호 검증
		String phone = "010-123-5678";	// 02-2342-4343, 042-344-8850, 010-233-4456
		String regex = "0\\d{1,2}-\\d{3,4}-\\d{4}";
		
		if(Pattern.matches(regex, phone)) {
			System.out.println("유효한 전화번호 입니다.");
		} else {
			System.out.println("유효하지 않는 전화번호 입니다.");
		}
		
		// ; 이메일 검증
		String email = "abcd1234@gmail.com";	// xxx@yahoo.co.kr, p@i.io
		regex = "\\w+@\\w+[.]\\w+([.]\\w+)?";
		
		if(Pattern.matches(regex, email)) {
			System.out.println("유효한 이메일 입니다.");
		} else {
			System.out.println("유효하지 않는 이메일 입니다.");
		}
		
		
		// !! compile(), matcher(), find()
		// ; 텍스트 검증
		String text = "안녕사세요. <br> 이산(san0515@naber.com)입니다.<p>냉무...</p>" +
				"저는 설현[hyun1004@gamil.com] 입니다.";
		
		// 주어진 정규표현식으로 패턴을 생성(compile)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			String strEmail = matcher.group();
			System.out.println(strEmail);
		}
		
	}
}
