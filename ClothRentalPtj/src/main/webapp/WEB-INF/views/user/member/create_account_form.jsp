<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/create_account_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/create_account_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>계정 생성</h3>
				
			</div>
		
			<div class="create_account_form">
			
				<form action="<c:url value='/user/member/createAccountConfirm' />" name="create_account_form" method="post">
					
					<input type="text" name="u_m_id" placeholder="사용자 ID 입력"> <br>
					<input type="password" name="u_m_pw" placeholder="사용자 비밀번호 입력"> <br>
					<input type="password" name="u_m_pw_again" placeholder="사용자 비밀번호 재입력"> <br>
					<input type="text" name="u_m_name" placeholder="사용자 이름 입력"> <br>
					<select name="u_m_gender">
						<option value="">사용자 성별 선택</option>
						<option value="M">남성</option>
						<option value="W">여성</option>
					</select> <br>
					<input type="email" name="u_m_mail"	placeholder="I사용자 메일 입력" ><br>
					<input type="text" name="u_m_phone"	placeholder="I사용자 전화번호 입력"> <br>
					<input type="button" value="계정 생성" onclick="createAccountForm();"> 
					<input type="reset" value="초기화">
					
				</form>
				
			</div>
			
			<div class="login">
				
				<a href="<c:url value='/user/member/loginForm' />">로그인</a>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>