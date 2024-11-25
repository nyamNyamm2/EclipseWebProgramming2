<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function findPasswordForm() {
		console.log('findPasswordForm() CALLED!!');
		
		let form = document.find_password_form;
		
		if (form.u_m_id.value == '') {
			alert('사용자 ID 입력하십시오!');
			form.u_m_id.focus();
			
		} else if (form.u_m_name.value == '') {
			alert('사용자 이름을 입력하십시오!');
			form.u_m_name.focus();
			
		} else if (form.u_m_mail.value == '') {
			alert('사용자 메일을 입력하십시오!');
			form.u_m_mail.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>