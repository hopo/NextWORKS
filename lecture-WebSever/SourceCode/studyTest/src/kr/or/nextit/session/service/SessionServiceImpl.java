package kr.or.nextit.session.service;

import javax.servlet.http.HttpServletRequest;

public class SessionServiceImpl implements SessionService {

	@Override
	public SessionVo setSessionInfo(HttpServletRequest req) {
		SessionVo info = new SessionVo();

		try {
			info.setId(req.getParameter("id"));
			info.setPw(req.getParameter("pw"));

			info.setIp(req.getRemoteAddr());
			info.setSessionId(req.getSession().getId());

			info.setResult(true);
			info.setMessage("GoodJob~!");

			// ;세션에 셋
			req.getSession().setAttribute("info", info);

		} catch (Exception ex) {

			info.setResult(false);
			info.setMessage(ex.getMessage());

			req.getSession().invalidate();

		}

		return info;
	}

}
