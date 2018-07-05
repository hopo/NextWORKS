package kr.or.nextit.info.service;

public class InfoUtils {

	public static void main(String[] args) {
		System.out.println("InfoUtils main()");
	}

	public static String dispAdult(String adult) {
		if (adult.equals("t")) {
			return "성인";
		} else {
			return "미성년";
		}

	}

	public static String dispGender(String gender) {
		if (gender.equals("male")) {
			return "남자";
		} else {
			return "여자";
		}
	}

	public static String dispBirth(String yr, String mn, String dy) {
		return String.format("%s년 %s월 %s일", yr, mn, dy);
	}

	public static String dispHobs(String[] hops) {
		StringBuilder sb = new StringBuilder();

		for (String h : hops) {
			sb.append(h);
			sb.append(", ");
		}
		return sb.toString();
	}

}
