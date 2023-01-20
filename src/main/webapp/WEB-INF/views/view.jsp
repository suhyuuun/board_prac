<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작성된 글 보기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#list").click(function(){
			$("#frm").attr("action","list.do").submit();
		});
		$("#reply").click(function(){
			$("#frm").attr("action","write.do").submit();
		});
		$("#update").click(function(){
			$("#frm").attr("action","update.do").submit();
		});
		$("#delete").click(function(){
			$("#frm").attr("action","delete.do").submit();
		});
		
	});
</script>

</head>
<body>
	<table>
		<tr>
			<th width="20%">작성자</th>
			<td>${dto.writer}</td>
			<th width="20%">조회수</th>
			<td>${dto.readcount}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${dto.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${dto.content}</td>
		</tr>
	</table>
	
	<form name="frm" id="frm" method="get">
		<input type="hidden" name="no" value="${dto.no}" />
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage}" />
		<input type="hidden" name="ref" id="ref" value="${ref}" />
		<input type="hidden" name="re_step" id="re_step" value="${re_step}" />
		<input type="hidden" name="re_level" id="re_level" value="${re_level}" />
		<input type="button" id="list" value="글목록으로 가기" /> 
		<input type="button" id="reply" value="답변달기" /> 
		<input type="button" id="update" value="수정하기" /> 
		<input type="button" id="delete" value="삭제하기" />
	</form>
</body>
</html>