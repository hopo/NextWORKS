package kr.or.nextit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter implements Filter {

	private String encoding = "UTF-8";

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		System.out.println(">>> CharacterEncodingFilter init() Call");
		// ;필터 초기화 작업.
		encoding = config.getInitParameter("encoding");

		if (encoding == null) {
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(">>> CharacterEncodingFilter doFilter() Call");
		
		HttpServletRequest req = (HttpServletRequest) request;

		System.out.println(req.getRequestURI());

		// ;필터 작업.
		request.setCharacterEncoding(encoding);

		request.setAttribute("title", "CENTRAL PARK");
		request.setAttribute("name", "Amber walk in the park.");
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// ;필터에서 사용한 자원해제.

	}

}
