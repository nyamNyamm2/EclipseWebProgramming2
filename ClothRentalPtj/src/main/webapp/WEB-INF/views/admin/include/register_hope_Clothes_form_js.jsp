<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function registerHopeClothesForm() {
		console.log('registerHopeClothesForm() CALLED!!');
		
		let form = document.register_hope_Clothes_form;
		
		if (form.c_name.value == '') {
			alert('의류명을 입력하십시오!');
			form.c_name.focus();
			
		} else if (form.c_author.value == '') {
			alert('브랜드를 입력하십시오!');
			form.c_author.focus();
			
		} else if (form.c_publisher.value == '') {
			alert('제조국가를 입력하십시오!');
			form.c_publisher.focus();
			
		} else if (form.c_publish_year.value == '') {
			alert('제조년도를 입력하십시오!');
			form.c_publish_year.focus();
			
		} else if (form.c_isbn.value == '') {
			alert('고유번호를 입력하십시오!');
			form.c_isbn.focus();
			
		} else if (form.c_rantal_able.value == '') {
			alert('대여 가능 여부를 선택하십시오!');
			form.c_rantal_able.focus();
			
		} else if (form.file.value == '') {
			alert('이미지 파일을 선택하십시오!');
			form.c_thumbnail.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>