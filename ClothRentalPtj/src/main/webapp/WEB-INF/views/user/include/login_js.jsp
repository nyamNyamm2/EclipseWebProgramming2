<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function loginForm() {
		console.log('loginForm() CALLED!!');
		
		let form = document.login_form;
		
		if (form.u_m_id.value == '') {
			alert('사용자 ID를 입력하십시오!');
			form.u_m_id.focus();
			
		} else if (form.u_m_pw.value == '') {
			alert('사용자 비밀번호를 입력하십시오!');
			form.u_m_pw.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>