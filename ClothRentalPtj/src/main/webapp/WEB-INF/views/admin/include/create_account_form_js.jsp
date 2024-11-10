<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function createAccountForm() {
		console.log('createAccountForm() CALLED!!');
		
		let form = document.create_account_form;
		
		if (form.a_m_id.value == '') {
			alert('관리자 ID는 필수 입력사항 입니다!');
			form.a_m_id.focus();
			
		} else if (form.a_m_pw.value == '') {
			alert('관리자 비밀번호는 필수 입력사항 입니다!');
			form.a_m_pw.focus();
			
		} else if (form.a_m_pw_again.value == '') {
			alert('비밀번호 재확인은 필수 입력사항 입니다!');
			form.a_m_pw_again.focus();
			
		} else if (form.a_m_pw.value != form.a_m_pw_again.value) {
			alert('비밀번호를 다시 확인해주세요!');
			form.a_m_pw.focus();
			
		} else if (form.a_m_name.value == '') {
			alert('관리자 이름은 필수 입력사항 입니다!');
			form.a_m_name.focus();
			
		} else if (form.a_m_gender.value == '') {
			alert('관리자 성별 선택은 필수 입력사항 입니다!');
			form.a_m_gender.focus();
			
		} else if (form.a_m_part.value == '') {
			alert('관리자 부서는 필수 입력사항 입니다!');
			form.a_m_part.focus();
			
		} else if (form.a_m_position.value == '') {
			alert('관리자 직책은 필수 입력사항 입니다!');
			form.a_m_position.focus();
			
		} else if (form.a_m_mail.value == '') {
			alert('관리자 메일은 필수 입력사항 입니다!');
			form.a_m_mail.focus();
			
		} else if (form.a_m_phone.value == '') {
			alert('관리자 전화번호는 필수 입력사항 입니다!');
			form.a_m_phone.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>