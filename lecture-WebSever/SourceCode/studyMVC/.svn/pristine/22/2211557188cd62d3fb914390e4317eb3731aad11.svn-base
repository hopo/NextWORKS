package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "hello", urlPatterns = {"/service/*"})
@SuppressWarnings("serial")
public class HelloWorld extends HttpServlet {

	// init() : 서블릿이 메모리에 올라올 때 (인스턴스 될 때, 1번만 발생)
	// service() : 모든 요청이 있을때 진입
	// doGet() : 요청이 GET 방식일 때 진입
	// doPost() : 요청이 POST 방식일 때 생성
	// destory() : 서블릿이 메모리에서 내려갈때 (인스턴스 될때)

	// -- kr.or.nextit.setvlet 밑에 SixDan 클래스 생성
	// -- HttpServlet을 상속
	// -- doGet을 오버라이드
	// -- 간단하게 6단의 html 문서를 생성
	// -- web.xml servlet 항목 등록
	// -- wev.xml servlet-mapping 항목에 매핑
	// url-pattern 은 /dan/* 밑으로 들어오는 모든 것을 처리

	@Override
	public void init() throws ServletException {
		System.out.println(">>> HttpServlet init() Call");
	}

	@Override
	public void destroy() {
		System.out.println(">>> HttpServlet destroy() Call : 'Time to DIE!'");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(">>> HttpServlet service()");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");

		// ;;out을 구하기 전에 resp의 인코딩은 변경되어 있어야 함
		PrintWriter out = resp.getWriter(); // ;;;resp 기본 인코딩은 ISO-88591

		out.print("<html>");
		out.print("<head>");
		out.print("<title>HELLO WORLD</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hello World Hello Servlet</h1>");
		out.print("</body>");
		out.print("</html>");

	}

}
