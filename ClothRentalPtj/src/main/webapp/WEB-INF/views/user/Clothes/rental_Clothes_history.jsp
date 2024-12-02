<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/rental_Clothes_history.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>대여 의류 목록</h3>
				
			</div>
			
			<div class="rental_Clothes_history">
				
				<table>
					<thead>
						<tr>
							<th>의류명</th>
							<th>고유번호</th>
							<th>대여일</th>
							<th>반납일</th>
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
								<td>
								<c:choose>
									<c:when test="${fn:contains(item.rc_end_date, '1000-01-01')}">대여중</c:when>
									<c:otherwise>${item.rc_end_date}</c:otherwise>
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