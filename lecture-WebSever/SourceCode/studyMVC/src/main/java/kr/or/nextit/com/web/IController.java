package kr.or.nextit.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	/**
	 * 페이지를 리다이렉트 처리 할지 안할지 여부
	 * 
	 * @return 리다이렉트 여부
	 */
	public boolean isRedirect();

	/**
	 * 비지니스 처리 레이어 영역
	 * 
	 * @param req
	 * @param resp
	 * @return 해당하는 프로세서가 실행이 되고 view단으로 넘겨주는 녀석
	 * @throws Exception
	 */
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
