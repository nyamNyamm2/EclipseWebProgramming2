<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/create_account_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/create_account_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>관리자 계정 생성</h3>
				
			</div>
		
			<div class="create_account_form">
			
				<form action="<c:url value='/admin/member/createAccountConfirm' />" name="create_account_form" method="post">
					
					<input type="text" name="a_m_id" placeholder="관리자 ID"> <br>
					<input type="password" name="a_m_pw" placeholder="관리자 비밀번호"> <br>
					<input type="password" name="a_m_pw_again" placeholder="관리자 비밀번호 재확인"> <br>
					<input type="text" name="a_m_name" placeholder="관리자 이름"> <br>
					<select name="a_m_gender">
						<option value="">관리자 성별 선택</option>
						<option value="M">남성</option>
						<option value="W">여성</option>
					</select> <br>
					<input type="text" name="a_m_part" placeholder="관리자 부서"> <br>
					<input type="text" name="a_m_position" placeholder="관리자 직책"> <br>
					<input type="email" name="a_m_mail" placeholder="관리자 메일" ><br>
					<input type="text" name="a_m_phone" placeholder="관리자 전화번호"> <br>
					<input type="button" value="계정 생성" onclick="createAccountForm();"> 
					<input type="reset" value="취소">
					
				</form>
				
			</div>
			
			<div class="login">
				
				<a href="<c:url value='/admin/member/loginForm' />">로그인</a>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>