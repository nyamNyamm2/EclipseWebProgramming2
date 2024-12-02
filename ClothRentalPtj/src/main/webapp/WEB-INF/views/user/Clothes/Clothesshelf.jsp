<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/Clothesshelf.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>나의 옷장</h3>
				
			</div>
			
			<%-- 대출 목록 --%>
			<div class="category_name">
				<h4>대여 목록</h4>
			</div>
			
			<div class="rental_Clothes_list">
				
				<table>
					<thead>
						<tr>
							<th>의류명</th>
							<th>고유번호</th>
							<th>대여일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${rentalClothesVos}">
							<tr>
								<td>
								<c:url value='/Clothes/user/ClothesDetail' var='detail_url'>
									<c:param name='c_no' value='${item.c_no}'/>
								</c:url>
								<a href="${detail_url}">${item.c_name}</a>
								</td>
								<td>${item.c_isbn}</td>
								<td>${item.rc_start_date}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
			
			<%-- 
			 - 전체 대출 이력 
			 - 희망 도서 요청 
			 - 희망 도서 요청 목록 
			--%>
			<div class="other_category">
				<a href="<c:url value='/Clothes/user/listupRentalClothesHistory'/>">전체 대여 이력</a>
				<a href="<c:url value='/Clothes/user/requestHopeClothesForm'/>">희망 의류 요청</a>
				<a href="<c:url value='/Clothes/user/listupRequestHopeClothes'/>">희망 의류 요청 목록 </a>
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />
	
</body>
</html>