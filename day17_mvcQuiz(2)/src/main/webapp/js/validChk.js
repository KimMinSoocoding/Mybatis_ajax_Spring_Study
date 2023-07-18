/**
 *  유효성 검사
 */
 
function inputChk(){
	if(document.registerForm.sName.value.length == 0){
		alert("이름을 입력하세요!!");
		registerForm.sName.focus();
		return;
	}
	
	var age = document.registerForm.sAge.value;
	
	if(age.length == 0){
		alert("나이를 입력하세요!!")
		registerForm.sAge.focus();
		return;
	}
	// 남 녀 두개 모두 체크 안되었을 경우
	if(!document.getElementById('m').checked && !document.getElementById('m').checked){
		alert("성별을 선택하세요!!");
		return;
	}
	if(document.registerForm.sEmail.value.length == 0){
		alert("이메일을 입력하세요!!");
		registerForm.sEmail.focus();
		return;
	}
	if(document.registerForm.sMajor.value.length == 0){
		alert("전공을 입력하세요!!");
		registerForm.sMajor.focus();
		return;
	}
	
	document.registerForm.submit();
} 