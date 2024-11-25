<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function searchClothesForm() {
		console.log('searchClothesForm() CALLED!!');
		
		let form = document.search_Clothes_form;
		
		if (form.b_name.value == '') {
			alert('찾으시는 의류 이름을 입력하십시오!');
			form.b_name.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>