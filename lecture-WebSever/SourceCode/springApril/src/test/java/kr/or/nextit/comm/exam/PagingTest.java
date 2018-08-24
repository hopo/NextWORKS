package kr.or.nextit.comm.exam;

import kr.or.nextit.comm.util.PagingVo;

public class PagingTest {
	
	public static void main(String[] args) {
		
		PagingVo vo = new PagingVo();
		
		vo.setTotalCount(100);
		vo.setPageBlockSize(10);
		vo.setCurPage(3);
		vo.setScreenSize(5);
		vo.pageSetting();
		
		System.out.printf("TotalCount: %d\n", vo.getTotalCount());
		System.out.printf("Row: %d ~ %d\n", vo.getStartRow(), vo.getEndRow());
		System.out.printf("Page: %d ~ %d\n", vo.getStartPage(), vo.getEndPage());
	}

}
