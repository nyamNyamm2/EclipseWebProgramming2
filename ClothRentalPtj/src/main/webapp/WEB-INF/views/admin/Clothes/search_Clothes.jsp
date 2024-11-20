<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/search_Clothes.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>의류 검색 결과</h3>
				
			</div>
			
			<div class="Clothes_list">
			
				<table>
					<thead>
						<tr>
							<th>의류명</th>
							<th>브랜드</th>
							<th>제조국가</th>
							<th>제조년도</th>
							<th>고유번호</th>
							<th>대출가능</th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach var="item" items="${ClothesVos}">
							<tr>
								<td>
								<c:url value='/Clothes/admin/ClothesDetail' var='detail_url'>
									<c:param name='c_no' value='${item.c_no}'/>
								</c:url>
								<a href="${detail_url}">${item.c_name}</a>
								</td>
								<td>${item.c_author}</td>
								<td>${item.c_publisher}</td>
								<td>${item.c_publish_year}</td>
								<td>${item.c_isbn}</td>
								<td>
								<c:choose>
									<c:when test="${item.c_rantal_able eq '0'}"> <c:out value="대여중" /> </c:when>
									<c:when test="${item.c_rantal_able eq '1'}"> <c:out value="대여가능" /> </c:when>
									<c:otherwise> <c:out value="X" /> </c:otherwise>
								</c:choose>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
					
					<%--
					<tbody>
						<%
							List<ClothesVo> ClothesVos = (List<ClothesVo>) request.getAttribute("ClothesVos");
							for (int i = 0; i < ClothesVos.size(); i++) {
						%>
						<tr>
							<td>
								<a href="/library/Clothes/admin/ClothesDetail?c_no=<%=ClothesVos.get(i).getc_no()%>"><%=ClothesVos.get(i).getc_name()%></a>
							</td>
							<td><%=ClothesVos.get(i).getc_author()%></td>
							<td><%=ClothesVos.get(i).getc_publisher()%></td>
							<td><%=ClothesVos.get(i).getc_publish_year()%></td>
							<td><%=ClothesVos.get(i).getc_isbn()%></td>
							<td><%=ClothesVos.get(i).getc_call_number()%></td>
							<td><%=ClothesVos.get(i).getc_rantal_able()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
					--%>
					
				</table>
				
			</div>
		
		</div>
		
	</section>
	
	<jsp:include page="../../include/footer.jsp" />

</body>
</html>