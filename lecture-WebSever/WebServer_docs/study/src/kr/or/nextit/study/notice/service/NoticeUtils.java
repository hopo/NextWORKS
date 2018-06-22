package kr.or.nextit.study.notice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoticeUtils {

	// =================================================
	// ! IsOpen을 위하 리스트와 디스플레이
	// =================================================
	public List<HashMap<String, Object>> getIsOpenItems() {
		List<HashMap<String, Object>> result = new ArrayList<>();

		HashMap<String, Object> item = new HashMap<>();
		item.put("value", "YES");
		item.put("display", "공개");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "NO");
		item.put("display", "비공개");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "WAIT");
		item.put("display", "대기");
		result.add(item);

		return result;
	}

	public String isOpenDisplay(String isOpen) {
		List<HashMap<String, Object>> list = getIsOpenItems();

		for (HashMap<String, Object> item : list) {
			if (isOpen.equals(item.get("value"))) {
				return String.format("%s=%s", item.get("value"), (String) item.get("display"));
			}
		}

		return null;
	}

	// =================================================
	// ! regUser을 위하 리스트와 디스플레이
	// =================================================
	public List<HashMap<String, Object>> getRegUserItems() {
		List<HashMap<String, Object>> result = new ArrayList<>();

		HashMap<String, Object> item = new HashMap<>();
		item.put("value", "admin");
		item.put("display", "오바마");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "webMaster");
		item.put("display", "오라클");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "root");
		item.put("display", "오까네");
		result.add(item);

		return result;
	}

	public String regUserDisplay(String regUser) {
		List<HashMap<String, Object>> list = getRegUserItems();

		for (HashMap<String, Object> item : list) {
			if (regUser.equals(item.get("value"))) {
				return String.format("%s=%s", item.get("value"), (String) item.get("display"));
			}
		}

		return null;
	}

	// =================================================
	// ! serviceType을 위하 리스트와 디스플레이
	// =================================================
	public List<HashMap<String, Object>> getServiceTypeItems() {
		List<HashMap<String, Object>> result = new ArrayList<>();

		HashMap<String, Object> item = new HashMap<>();
		item.put("value", "101");
		item.put("display", "메인");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "202");
		item.put("display", "팝업");
		result.add(item);

		item = new HashMap<>();
		item.put("value", "303");
		item.put("display", "게시판");
		result.add(item);

		return result;
	}

	public String serviceTypeDisplay(String[] serviceType) {
		List<HashMap<String, Object>> list = getServiceTypeItems();
		StringBuilder result = new StringBuilder();

		String each = null;

		result.append("[ ");
		for (String type : serviceType) {
			for (HashMap<String, Object> item : list) {
				if (type.equals(item.get("value"))) {
					each = String.format("%s=%s, ", item.get("value"), (String) item.get("display"));
					result.append(each);
				}
			}
		}
		result.append(" ]");

		return result.toString();
	}

}
