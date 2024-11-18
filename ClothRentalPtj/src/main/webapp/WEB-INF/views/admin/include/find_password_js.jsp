<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function findPassword() {
		console.log('findPassword() CALLED!!');
		
		let form = document.find_password_form;
		
		if (form.a_m_id.value == '') {
			alert('관리자 아이디를 입력하세요!');
			form.a_m_id.focus();
			
		} else if (form.a_m_name.value == '') {
			alert('관리자 이름을 입력하세요!');
			form.a_m_name.focus();
			
		} else if (form.a_m_mail.value == '') {
			alert('관리자 메일을 입력하세요!');
			form.a_m_mail.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>