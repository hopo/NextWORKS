package kr.or.nextit.study.ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringUtiles {

	public static void main(String[] args) {
		System.out.println("RUN StringUtiles.main()");
	}

	public static String getHi() {
		return "Hi Sia~!";
	}

	
	// ! select 만들기 (select gender)
	public static String getGender(String name) {
		StringBuilder result = new StringBuilder();

		result.append(String.format("<select name=\"%s\"> \n", name));
		result.append("<option value=\"\" disabled=\"disabled\">select...</option>");
		result.append("<option value=\"f\" selected>Female</option>");
		result.append("<option value=\"m\">Male</option>");
		result.append("</select>");

		return result.toString();
	}

	
	// ! Gender 정보 가져오기
	public static String getGenderProc(String gender) {
		String genderVal = "";

		if ("f".equalsIgnoreCase(gender)) {
			genderVal = "여성";
		} else if ("m".equalsIgnoreCase(gender)) {
			genderVal = "남성";
		} else {
			genderVal = "성별 누락";
		}

		return genderVal;
	}

	
	// ! Age 정보 가져오기
	public static String getAge(String age) {
		StringBuilder ageVal = new StringBuilder(age);

		if (Integer.parseInt(age) < 19) {
			ageVal.insert(0, "(미성년자) ");
		} else {
			ageVal.insert(0, "(성인) ");
		}
		ageVal.append("세");

		return ageVal.toString();
	}

	
	// ! Phone 정보 가져오기
	public static String getPhone(int hp0, int hp1, int hp2) {
		// if (hp1 == 0 || hp2 == 0) {
		// return "0000";
		// }
		String hp = String.format("%03d - %03d - %04d", hp0, hp1, hp2);

		StringBuilder sb = new StringBuilder(hp);
		switch (hp0) {
		case 42:
			sb.insert(0, "(대전) ");
			break;
		case 51:
			sb.insert(0, "(부산) ");
			break;
		default:
			sb.insert(0, "(휴대전화) ");
		}

		return sb.toString();
	}

	
	// ! Phone 선택지 보여주기 (tag 만들때)
	public static List<HashMap> getHp() {
		List<HashMap> result = new ArrayList<>();

		HashMap<String, Object> item = null;

		item = new HashMap<>();
		item.put("value", "010");
		item.put("display", "010");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "042");
		item.put("display", "042");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "051");
		item.put("display", "051");
		result.add(item);

		return result;
	}

	
	// ! Interest 체크박스로 보여주기
	public static String getFlag(String[] flag) {
		StringBuilder flagVal = new StringBuilder();

		for (String value : flag) {
			if ("01".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:책 ", value));
			} else if ("02".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:영화 ", value));
			} else if ("03".equalsIgnoreCase(value)) {
				flagVal.append(String.format("%s:운동 ", value));
			}
		}

		return flagVal.toString();
	}


	// ! Married 라디오로 보여주기
	public static String getFlag2(String flag2) {
		return "Y".equals(flag2) ? "기혼" : "미혼";
	}
}
