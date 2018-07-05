package kr.or.nextit.info.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoUtils2 {

	public List<HashMap<String, Object>> getHobbyName(String[] params) {
		List<HashMap<String, Object>> result = new ArrayList<>();
		List<HashMap<String, Object>> items = getHobbyDisplay();

		for (String param : params) {
			for (HashMap<String, Object> item : items) {
				String value = (String) item.get("value");
				if (param.equals(value)) {
					result.add(item);
					break;
				}
			}

		}

		return result;
	}

	public String getSexName(String param) {
		String result = "";

		List<HashMap<String, Object>> items = getSex();

		for (HashMap<String, Object> item : items) {
			String value = (String) item.get("value");

			if (param.equals(value)) {
				result = (String) item.get("display");
				break;
			}
		}

		return result;
	}

	public static List<HashMap<String, Object>> getHobbyDisplay() {

		List<HashMap<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> item = new HashMap<>();

		item = new HashMap<>();
		item.put("value", "01");
		item.put("display", "야구");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "02");
		item.put("display", "축구");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "03");
		item.put("display", "농구");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "04");
		item.put("display", "농사");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "05");
		item.put("display", "하영이와 놀아주기");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "06");
		item.put("display", "선균이와 놀아주기");
		result.add(item);

		return result;
	}

	public static List<HashMap<String, Object>> getHobbyDisplay(String[] params) {

		List<HashMap<String, Object>> result = new ArrayList<>();
		List<HashMap<String, Object>> items = getHobbyDisplay();

		for (String value : params) {
			for (HashMap<String, Object> item : items) {
				String getItem = (String) item.get("value");
				if (value.equalsIgnoreCase(getItem)) {
					result.add(item);
				}
			}
		}

		return result;
	}

	/**
	 * 성별을 리스트 형으로 반환을 해주는 녀
	 * 
	 * @return List<HashMap<String, Object>>
	 */
	public static List<HashMap<String, Object>> getSex() {

		List<HashMap<String, Object>> result = new ArrayList<>();

		HashMap<String, Object> item = new HashMap<>();

		item = new HashMap<>();
		item.put("value", "W");
		item.put("display", "여성");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "M");
		item.put("display", "남성");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "G");
		item.put("display", "중성");
		result.add(item);

		return result;
	}

	/**
	 * 화면에서 넘어온 코드 값으로 화면에 출력할 값을 반환
	 * 
	 * @param param
	 * @return HashMap<String, Object>
	 */
	public static HashMap<String, Object> getSex(String param) {

		HashMap<String, Object> result = new HashMap<>();
		List<HashMap<String, Object>> items = getSex();

		for (HashMap<String, Object> item : items) {
			String getItem = (String) item.get("value");
			if (param.equalsIgnoreCase(getItem)) {
				result = item;
				break;
			}
		}
		return result;
	}

	public static List<ComVo> getAdult() {

		List<ComVo> result = new ArrayList<>();

		ComVo item = new ComVo();
		item.setName("미성년자");
		item.setValue("01");
		result.add(item);

		item = new ComVo();
		item.setName("성인");
		item.setValue("02");
		result.add(item);

		item = new ComVo();
		item.setName("외계인");
		item.setValue("03");
		result.add(item);

		return result;
	}

	public String getAdultName(String param) {
		String result = "";

		List<ComVo> items = getAdult();

		for (ComVo item : items) {
			if (item.getValue().equals(param)) {
				result = item.getName();
				break;
			}
		}

		return result;
	}
}
