package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name = "boardViewServlet", urlPatterns = { "/boardView.oka" })
public class BoardViewServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(BoardListServlet.class);

	private BoardService board = null;

	@Override
	public void init() throws ServletException {
		log.debug(">>> Board View Servlet init() call");
		board = BoardServiceImpl.getInstance();
	}

	@Override
	public void destroy() {
		log.debug(">>> Board View Servlet destroy() call");
		board = null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.debug(">>> Board View Servlet service() call");

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");

		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<head>");
		out.print("<title>BOARD VIEW</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>***Board View***</h2>");

		out.print("<blockquote><table class='table' border='1px'>");
		out.print("<tbody>");
		out.print("<tr>");
		out.print("<td>순번</td>");
		out.print("<td>제목</td>");
		out.print("<td>작성자</td>");
		out.print("<td>수정일</td>");
		out.print("</tr>");

		try {

			BoardService board = BoardServiceImpl.getInstance();

			BoardVo paramVo = new BoardVo();

			paramVo.setIdx(req.getParameter("idx")); 

			BoardVo item = board.selectBoardView(paramVo);

			out.print("<tr>");
			out.printf("<td>%s</td>", item.getIdx());
			out.printf("<td><a href='#'>%s</a></td>", item.getTitle());
			out.printf("<td>%s</td>", item.getRegUser());
			out.printf("<td>%s</td>", item.getUpDate());
			out.print("</tr>");

		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());
		}

		out.print("</tbody>");
		out.print("</table></blockquote>");
	}

}
