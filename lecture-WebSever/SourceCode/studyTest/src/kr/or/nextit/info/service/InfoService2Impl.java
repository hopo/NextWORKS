package kr.or.nextit.info.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class InfoService2Impl extends InfoUtils2 implements InfoService2 {

	@Override
	public void setInfoItem(HttpServletRequest request) {
		InfoVo2 item = new InfoVo2();

		item.setUserName(request.getParameter("userName"));
		item.setUserEmail(request.getParameter("userEmail"));

		String adult = request.getParameter("isAdult");
		item.setIsAdult(adult);

		String adultName = getAdultName(adult);
		item.setIsAdultDisplay(adultName);

		// 성별 코드값을 넣어 줌
		String userSexCode = request.getParameter("userSex");
		item.setUserSex(userSexCode);

		// 성별 코드값에 해당하는 명을 넣어 줌
		String userSexName = getSexName(userSexCode);
		item.setUserSexDisplay(userSexName);

		item.setUserDate(request.getParameter("userDate"));

		// 취미 목록 value 값 배열로 담아주기
		String[] userHobbyCode = request.getParameterValues("userHobby");
		item.setUserHobby(userHobbyCode);

		// 선택된 취미 목록 코드 값과 네입값을 담기
		List<HashMap<String, Object>> hobbyNames = getHobbyName(userHobbyCode);
		item.setUserHobbyDisplay(hobbyNames);

		request.setAttribute("item", item);
		request.getSession().setAttribute("se", item);
	}
}
