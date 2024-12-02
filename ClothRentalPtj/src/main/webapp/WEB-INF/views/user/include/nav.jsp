<%@page import="com.office.fashion.user.member.UserMemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="<c:url value='/resources/css/user/include/nav.css' />" rel="stylesheet" type="text/css">

<jsp:include page="./nav_js.jsp" />

<nav>
	
	<div id="nav_wrap">
		
		<%
		UserMemberVo loginedUserMemberVo = (UserMemberVo) session.getAttribute("loginedUserMemberVo");
		if (loginedUserMemberVo != null) {
		%>
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/user/member/logoutConfirm' />">로그아웃</a></li>
				<li><a href="<c:url value='/user/member/modifyAccountForm' />">계정수정</a></li>
				<li><a href="<c:url value='/Clothes/user/enterClothesshelf' />">나의옷장</a></li>
			</ul>
		</div>
		<%
		} else {
		%>
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/user/member/loginForm' />">로그인</a></li>
				<li><a href="<c:url value='/user/member/createAccountForm' />">회원가입</a></li>
			</ul>
		</div>
		<%
		}
		%>
		
		<div class="search">
			
			<form action="<c:url value='/Clothes/user/searchClothesConfirm' />" name="search_Clothes_form" method="get">
				<input type="text" name="b_name" placeholder="찾으시는 의류를 검색해보세요!">
				<input type="button" value="검색" onclick="searchClothesForm();">
			</form>
			
		</div>
		
	</div>
	
</nav>