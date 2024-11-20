<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/register_Clothes_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/register_Clothes_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>의류 등록</h3>
				
			</div>
		
			<div class="register_Clothes_form">
			
				<form action="<c:url value='/Clothes/admin/registerClothesConfirm' />" name="register_Clothes_form" method="post" enctype="multipart/form-data">
					
					<input type="text"		name="c_name" 			placeholder="의류 이름 입력"> <br>
					<input type="text"		name="c_author" 		placeholder="의류 제조 브랜드 입력"> <br>
					<input type="text"		name="c_publisher"		placeholder="의류 제조 국가 입력"> <br>
					<input type="text"		name="c_publish_year" 	placeholder="의류 제조년월 입력"> <br>
					<input type="text"		name="c_isbn" 			placeholder="의류 고유 번호 입력"> <br>
					<select name="c_rantal_able">
						<option value="">의류 대여 가능 여부 선택</option>
						<option value="0">대여 불가능</option>
						<option value="1">대여 가능</option>
					</select><br>
					<input type="file"		name="file"><br>
					<input type="button"	value="의류 등록" onclick="registerClothesForm();"> 
					<input type="reset"		value="초기화">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>