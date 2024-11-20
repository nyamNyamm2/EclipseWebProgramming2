<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function searchClothesForm() {
		console.log('searchClothesForm() CALLED!!');
		
		let form = document.search_Clothes_form;
		
		if (form.c_name.value == '') {
			alert('찾으시는 옷을 입력하세요!');
			form.c_name.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>