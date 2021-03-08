
function hobbyChk() {
	var frm = document.querySelector('#frm');
	var eleNm = frm.hobby;
	
	if(eleNm.value.length == 0) {
		alert('취미명 값을 입력해 주세요');
		return false; // 문제됐을 경우에만 return false 날려 줄거야 
	}
}

function chkDel(i_hobby) {
	
	if(confirm(`${i_hobby}번 취미를 삭제 하시겠습니까?`)) { // if문으로 감싸줬으니 확인 눌렀을때만 실행됨
		location.href = `/delHobby?i_hobby=${i_hobby}`; // get방식 >> 쿼리스트링 : 서버에게 자료 전달
	} // location.href >> 주소값 이동
		// 쿼리스트링과 주소값 이동과는 노상관
}