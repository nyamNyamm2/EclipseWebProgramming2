<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/register_hope_Clothes_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/register_hope_Clothes_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>희망 의류 등록</h3>
				
			</div>
		
			<div class="register_hope_Clothes_form">
			
				<form action="<c:url value='/Clothes/admin/registerHopeClothesConfirm' />" name="register_hope_Clothes_form" method="post" enctype="multipart/form-data">
					
					<input type="hidden" name="hc_no" value="${hopeClothesVo.hc_no}">
					
					<input type="text" name="c_name" value="${hopeClothesVo.hc_name}" placeholder="의류명 입력"> <br>
					<input type="text" name="c_author" value="${hopeClothesVo.hc_author}" placeholder="의류 브랜드 입력"> <br>
					<input type="text" name="c_publisher" value="${hopeClothesVo.hc_publisher}" placeholder="제조국가 입력"> <br>
					<input type="text" name="c_publish_year" value="${hopeClothesVo.hc_publish_year}" placeholder="제조년도 입력"> <br>
					<input type="text" name="c_isbn" placeholder="고유번호 입력"> <br>
					<select name="c_rantal_able">
						<option value="">대여 가능 여부 선택</option>
						<option value="0">대여 불가</option>
						<option value="1">대여 가능</option>
					</select><br>
					<input type="file"		name="file"><br>
					<input type="button"	value="등록하기" onclick="registerHopeClothesForm();"> 
					<input type="reset"		value="초기화">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>