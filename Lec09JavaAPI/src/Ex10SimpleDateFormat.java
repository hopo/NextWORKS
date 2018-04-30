import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Ex10SimpleDateFormat {

	public static void main(String[] args) throws ParseException {

		// ! Date -> String
		// String pattern = "yyyy년 MM월 dd일 a HH시 mm분 ss초";
		// String pattern = "yyyy-MM-dd HH:mm:ss:SSSS";
		// String pattern = "yyyy.MM.dd E";
		String pattern = "yyyy.MM.dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		Date today = new Date(); // 현재시간을 객체로 생성
		String strToday = formatter.format(today); // format(Date dt)의 리턴은 String
		System.out.println("strToday: " + strToday);

		// ! String -> Date
		String strBirthday = "1989.12.29";
		Date date = formatter.parse(strBirthday);
		System.out.println("date: " + date);

		// ! cal 객체
		Calendar cal = Calendar.getInstance(); // 현재시간
		cal.setTime(date);
		// cal.add(cal.YEAR, 20);

		System.out.println(formatter.format(cal.getTime()));

	}
}
