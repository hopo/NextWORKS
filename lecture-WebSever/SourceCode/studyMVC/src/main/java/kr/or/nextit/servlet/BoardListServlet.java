package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.board.service.impl.BoardServiceImpl;

@SuppressWarnings("serial")
@WebServlet(name = "boardListServlet", urlPatterns = { "/boardList.oka" })
public class BoardListServlet extends HttpServlet {

	// private Logger logs = LoggerFactory.getLogger(this.getClass()); // ;;;아래를 권장
	private static final Logger log = LoggerFactory.getLogger(BoardListServlet.class);

	private BoardService board = null;

	@Override
	public void init() throws ServletException {
		log.debug(">>> Board List Servlet init() call");
		board = BoardServiceImpl.getInstance();
	}

	@Override
	public void destroy() {
		log.debug(">>> Board List Servlet destroy() call");
		board = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.debug(">>> Board List Servlet service() call");

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>BOARD LIST</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>***Board List***</h2>");

		out.print("<table class='table' border='1px'><tbody>");
		out.print("<tr><th>아이디</th><th>등록자</th><th>제목</th><th>보드타입</th><th>내용</th><th>등록일</th></tr>");

		try {

			BoardService board = BoardServiceImpl.getInstance();

			Map<String, Object> paramMap = new HashMap<>();

			// paramMap.put("test", req.getParameter("key"));
			
			List<BoardVo> items = board.selectBoardList(paramMap);

			for (BoardVo boardVo : items) {
				out.print("<tr>");
				out.print("<td>" + boardVo.getIdx() + "</td>");
				out.print("<td>" + boardVo.getRegUser() + "</td>");
				out.print("<td>" + boardVo.getTitle() + "</td>");
				out.print("<td>" + boardVo.getBoardType() + "</td>");
				out.printf("<td><a href=\'/boardView.oka?idx=%s\'>", boardVo.getIdx());
				out.print(boardVo.getContents());
				out.print("</a></td>");
				out.print("<td>" + boardVo.getRegDate() + "</td>");
				out.print("</tr>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());
		}

		out.print("</tbody></table>");
		out.print("</body>");
		out.print("</html>");

	}

}
