package kr.or.nextit.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;

@SuppressWarnings("serial")
public class ComController extends HttpServlet {

	private Map<String, IController> controllerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {

		System.out.println(">>> ComController.init() 콜");

		// ;클래스패스에서 프로퍼티 파일 검색
		ResourceBundle bundle = ResourceBundle.getBundle("ComMapper"); // src/main/resources/ComMapper.properties

		Enumeration<String> en = bundle.getKeys();

		// ;String형식 properties의 파일 내용을 같은 모양으로 자바 Map으로 만든다
		while (en.hasMoreElements()) {

			String key = en.nextElement().trim();
			String value = bundle.getString(key).trim();

			try {

				IController controller = (IController) Class.forName(value).newInstance(); // ;;;구현체를 생성 넣어준다

				controllerMap.put(key, controller);

				System.out.printf(">>> controllerMap에 %s=%s 등록\n", key, value);

			} catch (Exception e) {

				e.printStackTrace();
				throw new ServletException(e);

			}
		}

	}

	@Override
	public void destroy() {
		System.out.println(">>> ComController.destroy() 콜");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>> ComController.serivice() 콜");

		try {

			String uri = req.getRequestURI();
			uri = uri.substring(req.getContextPath().length()); // ;;;컨텍스트패스가 들어 온다면 제거한다

			if (controllerMap.containsKey(uri)) {

				// ;init()에서 만들어 진 controllerMap으로 부터 reqUri를 키로 사용 하여 controller 밸류를 가져온다
				IController controller = controllerMap.get(uri);

				String viewPage = controller.process(req, resp);
				String viewPath = String.format("/WEB-INF/views/%s.jsp", viewPage);

				RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
				
				dispatcher.forward(req, resp);

			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // ;;;요청에 대한 컨트롤이 없을 경우 404
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
