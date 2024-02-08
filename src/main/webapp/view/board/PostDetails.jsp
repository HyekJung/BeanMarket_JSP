<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	*{
		margin: 10 auto;
		padding: 0;
	}
	td {
	  width: 5%;
	}
	button {
	 float: right;
     padding: 8px 18px;
     background-color: #147814;
     color: white;
    }
	.border-cell{
		border-top: 1.5px solid black;
    	border-bottom: 1.5px solid black;
	}
	.title-cell{
		background-color: lightgray;
	}
</style>
<script>
function edit(){
		location.href="BoardEditForm?perNum=${dto.perNum}"
	}
	function deletePost(){//delete는 javascript의 예약어
		if(confirm("게시물을 삭제하면 복구할 수 없습니다. 정말로 삭제하시겠습니까?")){
			location.href="DeletePost?perNum=${dto.perNum}"
		}
	}
	function list(){
		location.href="BoardList"
	}
</script>
<table class="border-cell" border="">
	<tr>
		<td colspan = "6">${dto.perTitle}</td>
	</tr>
	<tr class="border-cell">
		<td class="title-cell">작성자</td>
		<td>${dto.userId}</td>
		<td class="title-cell">작성일</td>
		<td>${dto.perDate}</td>
		<td class="title-cell">답변여부</td>
		<td>${dto.perAnswer}</td>
	</tr>
	<tr>
		<td colspan = "6">${dto.perContent}</td>
	</tr>
	<tr>
		<td class="title-cell">첨부파일</td>
		<td>${dto.perFile}</td>
	</tr>
	<tr>
		<td colspan = "6">
			<button onclick="edit()">수정</button>
			<button onclick="deletePost()">삭제</button>
			<button onclick="list()">목록</button>
		</td>
	</tr>
</table>