/**
 * 
 */

// ;USER function
function fn_paginagtion(search) {

	$(".pagination").empty();

	if (search.startPage != 1) {
		var rs = "";

		rs += "<li>";
		rs += "<a href='#' aria-label='Previous' data-curpage='"
				+ (search.startPage - 1) + "' class='prev goPage'>";
		rs += "<span aria-hidden='true'>Prev</span>";
		rs += "</a>";
		rs += "</li>";

		$(".pagination").append(rs);

	} else {
		var rs = "";

		rs += "<li>";
		rs += "<a href='#' aria-label='Previous'>";
		rs += "<span aria-hidden='true'>Prev</span>";
		rs += "</a>";
		rs += "</li>";
		$(".pagination").append(rs);
	}
}
