package kr.or.nextit.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.nextit.com.web.IController;
import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

public class MemberListController implements IController {

	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect() {
		// TODO MemberListController.isRedirect()
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println(">>> MemberListController.process() 콜");

		MemberSearchVo search = new MemberSearchVo();

		search.setSearchType(req.getParameter("searchType"));
		search.setSearchText(req.getParameter("searchText"));

		// ;객체의 키값이 존재하는지?
		if (!StringUtils.isAllEmpty(req.getParameter("curPage"))) {
			search.setCurPage(Integer.parseInt(req.getParameter("curPage")));
		}

		int totalCount = memberService.selectTotalCount(search);

		search.setTotalCount(totalCount);
		search.setPageBlockSize(3); // ;;; 1 2 3 next
		search.setScreenSize(5); // ;;;목록이 3개
		search.pageSetting();

		req.setAttribute("search", search);

		System.out.printf(">>> {totalCount : %d}", totalCount);
		System.out.printf(", {startRow, EndRow : %d, %d}", search.getStartRow(), search.getEndRow());
		System.out.printf(", {startPage, endPage : %d, %d}\n", search.getStartPage(), search.getEndPage());

		List<MemberVo> result = memberService.selectItems(search);

		req.setAttribute("result", result);

		return "member/memberList";
	}

}
