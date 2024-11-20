<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/modify_Clothes_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/modify_Clothes_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>의류 상세정보 수정</h3>
				
			</div>
		
			<div class="modify_Clothes_form">
			
				<form action="<c:url value='/Clothes/admin/modifyClothesConfirm' />" name="modify_Clothes_form" method="post" enctype="multipart/form-data">
					
					<input type="hidden" name="c_no" value="${ClothesVo.c_no}">
					
					<input type="text" name="c_name" value="${ClothesVo.c_name}" placeholder="의류 이름을 입력"> <br>
					<input type="text" name="c_author" value="${ClothesVo.c_author}" placeholder="의류 브랜드를 입력"> <br>
					<input type="text" name="c_publisher" value="${ClothesVo.c_publisher}" placeholder="의류 제조국가를 입력"> <br>
					<input type="text" name="c_publish_year" value="${ClothesVo.c_publish_year}" placeholder="의류 제조년도를 입력"> <br>
					<input type="text" name="c_isbn" value="${ClothesVo.c_isbn}" placeholder="의류 고유 번호를 입력"> <br>
					<select name="c_rantal_able">
						<option value="">의류 대여 가능여부</option>
						<option value="0" <c:if test="${ClothesVo.c_rantal_able eq '0'}"> selected </c:if>>대여 불가</option>
						<option value="1" <c:if test="${ClothesVo.c_rantal_able eq '1'}"> selected </c:if>>대여 가능</option>
					</select><br>
					<input type="file"		name="file"><br>
					<input type="button"	value="수정 완료" onclick="modifyClothesForm();"> 
					<input type="reset"		value="초기화">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>