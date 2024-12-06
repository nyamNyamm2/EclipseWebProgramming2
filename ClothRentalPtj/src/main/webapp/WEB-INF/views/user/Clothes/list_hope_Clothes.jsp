<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/user/list_hope_Clothes.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>희망 의류 목록</h3>
				
			</div>
			
			<div class="list_hope_Clothess">
				
				<table>
					<thead>
						<tr>
							<th>의류명</th>
							<th>브랜드</th>
							<th>제조국가</th>
							<th>제조년도</th>
							<th>요청일</th>
							<th>요청 수정일</th>
							<th>처리상태</th>
							<th>처리상태 수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${hopeClothesVos}">
							<tr>
							
								<td>${item.hc_name}</td>
								<td>${item.hc_author}</td>
								<td>${item.hc_publisher}</td>
								<td>${item.hc_publish_year}</td>
								<td>${item.hc_reg_date}</td>
								<td>${item.hc_mod_date}</td>
								<td>
								<c:choose>
									<c:when test="${item.hc_result eq 0}"> <c:out value="검토중" /> </c:when>
									<c:when test="${item.hc_result eq 1}"> <c:out value="완료" /> </c:when>
									<c:otherwise> <c:out value="입고대기" /> </c:otherwise>
								</c:choose>
								</td>
								<td>${item.hc_result_last_date}</td>
							
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