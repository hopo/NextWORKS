package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "guguDan", urlPatterns = {"/gugu.dan"})
public class Gugudan extends HttpServlet {

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();

		Boolean flag = (req.getParameter("flag").equals("0"));

		out.println("<html>");
		out.println("<head>");
		out.println("<title>구구구구단</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<h3>gogo gugu dandan</h3>");

		out.println("<table border='2' style='border-color: tomato;'>");
		out.println("<tbody>");

		out.println(flag ? "<tr>" : "");
		for (int i = 2; i <= 9; i++) {
			out.println(flag ? "" : "<tr>");
			out.println("<td>");
			for (int j = 1; j <= 9; j++) {
				out.printf("%d x %d = %d<br>", i, j, i * j);
			}
			out.println("</td>");
			out.println(flag ? "" : "</tr>");
		}
		out.println(flag ? "</tr>" : "");

		out.println("</tbody>");
		out.println("</table>");

		out.print("</body>");
		out.print("</html>");
	}

}
