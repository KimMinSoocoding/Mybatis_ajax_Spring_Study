function checkAll(){
	// 체크가 되어있으면 true, 아니면 false
	let isChecked = document.getElementById("checkAll").checked;
	
	let chkBoxes = document.getElementsByName("chk");
	for(let i=0; i<chkBoxes.length; i++){
		chkBoxes[i].checked = isChecked;
	}
}

function prodDel(){
	var chks = document.getElementsByName("chk");
	var prodNumStr = "";
	
	var pNumSeparator=false;
	
	// 장바구니에서 삭제할 상품번호를 추려내기 위한 로직 
	// 7번 9번이 체크되면 7/9 문자열을 생성
	for(i=0; i<chks.length; i++){
		if(chks[i].checked){
			if(pNumSeparator){
				prodNumStr = prodNumStr + '/';
			}
			prodNumStr = prodNumStr + chks[i].value;
			
			pNumSeparator=true;
		}
	}
	
	if(!prodNumStr){
		alert("삭제할 상품을 체크하세요!!");
		return;
	}
	
	// 삭제할 상품번호를 '/'로 묶어 delProdNums input에 저장
	document.cartForm.delProdNums.value = prodNumStr;
	
	console.log(prodNumStr);
	
	var res = confirm("삭제 하시겠습니까?");
	if(res){
		document.cartForm.submit();
	}
}

// 포인트 입력박스의 금액이 전액 포인트보다 큰경우 경고창 띄우고
// 재입력 받을 수 있도록 처리하는 함수
function inputPoint(obj, point){
	//alert(obj.value);
	if(obj.value > point){
		alert("적립 포인트가 부족합니다...!!");
		obj.value = "";
		obj.focus;
		return;
	}

}

// 포인트를 직접 입력할 때 동시에 결제금액이 계산되도록하는 함수
function enterKey(obj,point, price){
	var tot_amount = document.getElementById("cartTotPrice");
	if(event.key >=0 && event.key < 10 || event.key=='Backspace'){
		if(obj.value <= point){
			var value = price -obj.value;
			tot_amount.innerText = value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "원"; 
		}
	}
	
	// Enter의 keyCode는 13
	if(event.keyCode == 13){
		obj.value = obj.value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
}

// 전액체크가 되면 포인트 입력박스에 전액포인트가 입력되고
// 전액포인트가 감액된 결제금액이 계산되도록 하기 위한 함수
function usePoint(obj,point,price){
	var elem = document.getElementById("point");
	var tot_amount = document.getElementById("cartTotPrice");
	if(obj.checked){
		// 천단위 정규표현식 사용
		elem.value = point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		tot_amount.innerText = (price - point).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+ "원";
	}else{
		elem.value = "";
		tot_amount.innerText = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+ "원";
	}
}

// 숫자가 아닌 문자를 자동으로 제거하는 함수
function removeChar(e){
	var e = e || window.event, keyCode = (e.which) ? e.which : e.keyCode;
	   
	if (keyCode == 8 || keyCode == 46 || keyCode == 37 || keyCode == 39) {
	   return;
	} else {
	   e.target.value = e.target.value.replace(/[^0-9]/g, '');
	};
}

// 전액사용 체크가되면 입력박스의 포인트를 삭제하기
function clearVal(obj){
	let use = document.getElementById("use");
	if(use.checked){
		obj.value="";
		use.checked = false;
	}
}

function selPayment(){
	var pm = document.getElementsByName("payment");
	
	for(var i = 0; i<pm.length; i++){
		if(pm[i].checked){
			document.getElementById(pm[i].value).style.display="block";
		}else{
			document.getElementById(pm[i].value).style.display="none";									
		}
	}
}
	

