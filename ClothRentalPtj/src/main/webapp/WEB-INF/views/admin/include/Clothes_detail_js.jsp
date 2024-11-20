<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

	function deleteClothes(c_no, c_name) {
		console.log('deleteClothes() CALLED!!');
		
		let result = confirm('의류(' + c_name + ')를(을) 정말 삭제 하시겠습니까?');
		
		if (result)
			location.href = "<c:url value='/Clothes/admin/deleteClothesConfirm?c_no='/>" + c_no;

	}

</script>