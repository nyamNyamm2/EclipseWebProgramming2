<%@page import="java.util.List"%>
<%@page import="com.office.fashion.clothes.ClothesVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/hope_Clothess.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>희망 의류</h3>
				
			</div>
			
			<div class="Clothes_list">
			
				<table>
					<thead>
						<tr>
							<th>요청회원</th>
							<th>의류명</th>
							<th>브랜드</th>
							<th>제조국가</th>
							<th>제조년도</th>
							<th>입고</th>
						</tr>
					</thead>
					
					<tbody>
						
						<c:forEach var="item" items="${hopeClothesVos}">
							<tr>
								<td>${item.u_m_id}</td>
								<td>${item.hc_name}</td>
								<td>${item.hc_author}</td>
								<td>${item.hc_publisher}</td>
								<td>${item.hc_publish_year}</td>
								<td>
									<c:choose>
										<c:when test="${item.hc_result eq 0}">
											<c:url value="/Clothes/admin/registerHopeClothesForm" var="hope_Clothes_url">
												<c:param name="hc_no" value="${item.hc_no}"/>
												<c:param name="hc_name" value="${item.hc_name}"/>
												<c:param name="hc_author" value="${item.hc_author}"/>
												<c:param name="hc_publisher" value="${item.hc_publisher}"/>
												<c:param name="hc_publish_year" value="${item.hc_publish_year}"/>
											</c:url>
											<a href="${hope_Clothes_url}">입고</a>
										</c:when>
										<c:when test="${item.hc_result eq 1}">
											완료
										</c:when>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
					
				</table>
				
			</div>
			
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>