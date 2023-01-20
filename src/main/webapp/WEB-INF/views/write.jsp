<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  content="text/html; charset=UTF-8">
<title>글 작성하기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
				$('#btnList').click(function() {
					$('#frm').attr('action', 'list.do');
					$('#frm').submit();
				});
				$('#btnSave').click(function() {
							$('[name=content]').val($('[name=content]').val().replace(/\n/gi,'<br/>'));
							$('#frm').attr('action', 'write.do').submit();
				});
			});
</script>
</head>
<body>
	<form name="frm" id="frm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td width="20%" align="center">작성자</td>
				<td><input type="text" name="writer" size="10" maxlength="10" /></td>
			</tr>
			
			<tr>
				<td width="20%" align="center">제목</td>
				<td>
					<c:if test="${dto!=null}">답변</c:if> 
					<input type="text" name="title" size="40" />
				</td>
			</tr>
			
			<tr>
				<td width="20%" align="center">내용</td>
				<td><textarea name="content" rows="13" cols="40"></textarea></td>
			</tr>
		</table>
		<!-- 답변글 -->
		<c:if test="${dto!=null}">
			<input type="text" name="no" id="no" value="${dto.no}" />
			<input type="text" name="currentPage" id="currentPage" value="${currentPage}" />
			<input type="text" name="ref" value="${dto.ref}" />
			<input type="text" name="re_step" value="${dto.re_step}" />
			<input type="text" name="re_level" value="${dto.re_level}" />
		</c:if>
		<input type="button" id="btnList" value="글목록으로 가기" /> 
		<input type="button" id="btnSave" value="저장하기" />
	</form>
</body>
</html>