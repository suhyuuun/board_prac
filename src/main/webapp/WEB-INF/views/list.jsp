<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style type="text/css">
#bodywrap {
	width: auto;
	margin: auto;
}

.dataRow:hover {
	background: #eee;
	cursor: pointer;
}

.pagelist a {
	text-decoration: none;
	color: black;
}

.pagelist a:hover, .pagelist .pagecolor {
	text-decoration: none;
	color: olive;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<div id="body wrap">
		<h2>자유게시판 리스트</h2>
		<table>
			<tr>
				<th width="5%" colspan="5">번호</th>
				<th width="40%" colspan="5">제목</th>
				<th width="20%" colspan="5">작성자</th>
				<th width="10%" colspan="5">작성일</th>
				<th width="5%" colspan="5">조회수</th>
			</tr>
			<c:if test="${empty aList}">
				<tr>
					<td>데이터가 존재하지 않습니다. 첫번째 글의 주인공이 되어보세요!</td>
				</tr>
			</c:if>
			<c:if test="${! empty aList}">
				<c:forEach items="${aList}" var="dto">
					<tr class="dataRow">
						<td colspan="5">${dto.no}</td>
						<td colspan="5">
							<c:url var="path" value="view.do">
								<c:param name="currentPage" value="${pv.currentPage}" />
								<c:param name="no" value="${dto.no}" />
							</c:url> 
							<!-- 답변글임? -->
							<c:if test="${dto.re_level>0}">
								<img src="resources/images/level.gif" width="${20*dto.re_level}" height="15" />
								<img src="resources/images/re.gif" />
							</c:if> 
							<a href="${path}" style="text-decoration: none;">${dto.title}</a></td>
						<td colspan="5">${dto.writer}</td>
						<td colspan="5">${dto.reg_date}</td>
						<td colspan="5">${dto.readcount}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>

		<div class="pagelist">
		<!--페이지 이전 출력 시작 -->
			<c:if test="${pv.startPage>1}">
				<a href="list.do?currentPage=${pv.startPage-pv.blockPage}">이전</a>
			</c:if>
			
			
		<!-- 페이지 출력 -->
			<c:forEach var="page" begin="${pv.startPage}" end="${pv.endPage}">
				<span> 
				<c:url var="curr" value="list.do">
						<c:param name="currentPage" value="${page}" />
				</c:url> 
				<c:choose>
						<c:when test="${page==pv.currentPage}">
							<a href="${curr}" class="pagecolor">${page}</a>
						</c:when>
						<c:otherwise>
							<a href="${curr}">${page}</a>
						</c:otherwise>
					</c:choose>
				</span>
			</c:forEach>

		<!-- 다음 -->
			<c:if test="${pv.endPage<pv.totalPage}">
				<a href="list.do?currentPage=${pv.startPage+pv.blockPage}">다음</a>
			</c:if>
		</div>
		<form id="frm" name="frm" method="get" action="write.do">
			<input type="submit" id="btnWrite" value="글 작성하기" />
		</form>
	</div>
</body>
</html>