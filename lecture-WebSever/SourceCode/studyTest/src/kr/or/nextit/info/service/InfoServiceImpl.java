package kr.or.nextit.info.service;

import javax.servlet.http.HttpServletRequest;

public class InfoServiceImpl implements InfoService {

	@Override
	public InfoVo setInformation(HttpServletRequest request) {
		InfoVo info = null;

		try {
			info = new InfoVo();

			info.setUsername(request.getParameter("userName"));
			info.setEmail(request.getParameter("email"));
			info.setAdult(request.getParameter("adult"));
			info.setGender(request.getParameter("gender"));
			info.setByear(request.getParameter("birthYear"));
			info.setBmonth(request.getParameter("birthMonth"));
			info.setBday(request.getParameter("birthDay"));
			info.setHobs(request.getParameterValues("hobs"));

			info.setResult(true);
			info.setMessage("정보가 등록되었습니다.");

			// ;세션에 셋
			request.getSession().setAttribute("info", info);

			return info;
		} catch (Exception ex) {
			info = new InfoVo();

			info.setResult(false);
			info.setMessage(ex.getMessage());

			request.getSession().invalidate();

			return info;
		}

	}

}
