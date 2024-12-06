<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function requestHopeClothesForm() {
		console.log('requestHopeClothesForm() CALLED!!');
		
		let form = document.request_hope_Clothes_form;
		
		if (form.hc_name.value == '') {
			alert('의류 이름을 입력하십시오!');
			form.hc_name.focus();
			
		} else if (form.hc_author.value == '') {
			alert('브랜드를 입력하십시오!');
			form.hc_author.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>