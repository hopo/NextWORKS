package kr.or.nextit.session.service;

import javax.servlet.http.HttpServletRequest;

public interface SessionService {
	
	public SessionVo setSessionInfo(HttpServletRequest req);

}
