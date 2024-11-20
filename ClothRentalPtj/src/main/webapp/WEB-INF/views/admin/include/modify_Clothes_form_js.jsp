<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function modifyClothesForm() {
		console.log('modifyClothesForm() CALLED!!');
		
		let form = document.modify_Clothes_form;
		
		if (form.c_name.value == '') {
			alert('의류 이름을 입력하십시오!');
			form.c_name.focus();
			
		} else if (form.c_author.value == '') {
			alert('의류 브랜드를 입력하십시오!');
			form.c_author.focus();
			
		} else if (form.c_publisher.value == '') {
			alert('의류 제조국가를 입력하십시오!');
			form.c_publisher.focus();
			
		} else if (form.c_publish_year.value == '') {
			alert('의류 제조년도를 입력하십시오!');
			form.c_publish_year.focus();
			
		} else if (form.c_isbn.value == '') {
			alert('의류 고유번호를 입력하십시오!');
			form.c_isbn.focus();
			
		} else if (form.c_rantal_able.value == '') {
			alert('의류 대여가능 여부를 선택하십시오!');
			form.c_rantal_able.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>