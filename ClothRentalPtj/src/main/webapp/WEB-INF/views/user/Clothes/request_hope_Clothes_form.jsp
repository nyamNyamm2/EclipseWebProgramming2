<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/request_hope_Clothes_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/request_hope_Clothes_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>희망 의류 요청</h3>
				
			</div>
		
			<div class="request_hope_Clothes_form">
			
				<form action="<c:url value='/Clothes/user/requestHopeClothesConfirm' />" name="request_hope_Clothes_form" method="get">
					
					<input type="text"		name="hc_name" 			placeholder="* 희망 의류 이름을 입력"> <br>
					<input type="text"		name="hc_author" 		placeholder="* 희망 의류 브랜드 입력"> <br>
					<input type="text"		name="hc_publisher"		placeholder="희망 의류 제조국가 입력"> <br>
					<input type="text"		name="hc_publish_year" 	placeholder="희망 의류 제조년도 입력"> <br>
					<input type="button"	value="요청하기" onclick="requestHopeClothesForm();"> 
					<input type="reset"		value="초기화">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>