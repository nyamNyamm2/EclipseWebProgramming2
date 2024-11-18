<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/find_password_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/find_password_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
			
			<div class="word">
			
				<h3>비밀번호 찾기</h3>
				<p>(새로운 비밀번호를 메일로 전송합니다.)</p>
				
			</div>
			
			<div class="find_password_form">
			
				<form action="<c:url value='/admin/member/findPasswordConfirm' />" name="find_password_form" method="post">
					
					<input type="text" name="a_m_id" placeholder="관리자 ID 입력"> <br>
					<input type="text" name="a_m_name" placeholder="관리자 이름 입력"> <br>
					<input type="text" name="a_m_mail" placeholder="관리자 메일 입력"> <br>
					<input type="button" value="비밀번호 찾기" onclick="findPassword();"> 
					<input type="reset" value="초기화">
					
				</form>
				
			</div>
			
			<div class="create_account_login">
				
				<a href="<c:url value='/admin/member/createAccountForm' />">계정 생성</a>
				<a href="<c:url value='/admin/member/loginForm' />">로그인</a>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>