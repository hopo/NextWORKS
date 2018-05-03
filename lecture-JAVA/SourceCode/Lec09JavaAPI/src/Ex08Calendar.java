import java.util.Calendar;

public class Ex08Calendar {

	public static void main(String[] args) {

		// !! 날짜시간 객체 생성
		Calendar cal = Calendar.getInstance();
		// new GregorianCalendar(); 도 사용가능하다만 권장은 getInstance()
		// System.out.println(cal.getClass().getName()); // 현재시간

		// ; set()
		// cal.set(Calendar.YEAR, 1997);
		// cal.set(2007, 5, 10); // month는 -1

		// ; add()
		// cal.add(Calendar.YEAR, 10);
		// cal.add(Calendar.MONTH, 10);
		// cal.add(Calendar.DATE, 100); // 100일 후
		cal.add(Calendar.DATE, -24); // 24일 전

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int amPm = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);

		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초", year, month, date, amPm == (Calendar.AM) ? "오전" : "오후", hour,
				min, sec);
	}

}
