<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/Clothes_detail.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/Clothes_detail_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>의류 상세정보</h3>
				
			</div>
			
			<div class="Clothes_detail">
			
				<ul>
					<li>
						<img src="<c:url value="/libraryUploadImg/${ClothesVo.c_thumbnail}"/>">
					</li>
					<li>
						<table>
							<tr>
								<td>의류명</td>
								<td>${ClothesVo.c_name}</td>
							</tr>
							<tr>
								<td>브랜드</td>
								<td>${ClothesVo.c_author}</td>
							</tr>
							<tr>
								<td>제조국가</td>
								<td>${ClothesVo.c_publisher}</td>
							</tr>
							<tr>
								<td>제조년도</td>
								<td>${ClothesVo.c_publish_year}</td>
							</tr>
							<tr>
								<td>고유번호</td>
								<td>${ClothesVo.c_isbn}</td>
							</tr>
							<tr>
								<td>대여가능</td>
								<td>
								<c:choose>
									<c:when test="${ClothesVo.c_rantal_able eq '0'}"> <c:out value="X" /> </c:when>
									<c:when test="${ClothesVo.c_rantal_able eq '1'}"> <c:out value="O" /> </c:when>
									<c:otherwise> <c:out value="X" /> </c:otherwise>
								</c:choose>
								</td>
							</tr>
							<tr>
								<td>등록일</td>
								<td>${ClothesVo.c_reg_date}</td>
							</tr>
							<tr>
								<td>수정일</td>
								<td>${ClothesVo.c_mod_date}</td>
							</tr>
						</table>
					</li>
				</ul>
				
			</div>
			
			<div class="buttons">
				
				<c:url value='/Clothes/admin/modifyClothesForm' var='modify_url'>
					<c:param name='c_no' value='${ClothesVo.c_no}'/>
				</c:url>
				<a class="modify_Clothes_button" href="${modify_url}">의류 수정</a>
				
				<c:url value='/Clothes/admin/deleteClothesForm' var='delete_url'>
					<c:param name='c_no' value='${ClothesVo.c_no}'/>
				</c:url>
				<%-- <a class="delete_Clothes_button" href="${delete_url}">도서 삭제</a> --%>
				<a class="delete_Clothes_button" href="#none" onclick="deleteClothes(${ClothesVo.c_no},'${ClothesVo.c_name}')">의류 삭제</a>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>