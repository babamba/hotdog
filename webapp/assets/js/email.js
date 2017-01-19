var email;
var password;
var code;


$(function(){
	
	$("#joinNextButton").prop("disabled",true);
	
//		회원가입 폼    		
	$("#sendMailButton").click(function() {
		
		var formData = new FormData();
        email=$("#inputEmail").val();
        password=$("#inputPassword").val();
        formData.append("email",email);
    	formData.append("password",password);	
		
		if($("#inputEmail").val()==""){
			alert("이메일을 입력해주세요");
			$("#inputEmail").focus();
			return false;
		}
		if($("#inputPassword").val()==""){
			alert("패스워드를 입력해주세요");
			$("#inputPassword").focus();
			return false;
		}
		if($("#inputPassword").val()!=$("#inputPassword2").val()){
			alert("입력한 비밀번호가 다릅니다.");
			$("#inputPassword2").focus();
			return false;
			
		}
		// 배열에 TempUser 정보 넣어서 JSON 으로 던지기         {"data":arr}
		
//			var arr=[ $("#inputEmail").val() ,$("#inputPassword").val() ];
	
		$.ajax({
			url:"${pageContext.request.contextPath}/user/signupform",
			type:"post",
			data: formData , 
			processData : false,
            contentType : false
		})
		
		alert("입력하신 이메일에 인증 코드가 발송되었습니다.");
		$("#joinNextButton").prop("disabled",false);
		
		return true;
	});
	
	//  약관동의 체크
	$("#joinNext").prop("disabled",true);
	
	$("#accessCheck").change(function(){
		if($("#accessCheck").is(":checked")){
			console.log("체크됨");
			$("#joinNext").prop("disabled",false);
		}else{
			console.log("체크 풀림");
			$("#joinNext").prop("disabled",true);
		}
	})
	
	//  코드 체크
	$("#checkNext").prop("disabled",true);
	
	$("#inputCodeCheck").click(function(){
		
		code=$("#inputCode").val();
    	
		if(code==""){
			return;
		}
    	
		$.ajax({
			url:"${pageContext.request.contextPath}/user/checkcode?code="+code,
			type:"get",
			dataType:"json",
			data:"",
			success: function(response){
				
				// 통신에러
				if( response.result == "fail" ) {
					console.log( response.message );
					return;
				}
			
				// 코드가 일치할 때
			if(response.data=="yes"){
				alert("코드가 일치합니다.");
				$("#checkNext").prop("disabled",false);
			}
				if(response.data=="no"){
					alert("코드가 일치하지 않습니다.")
				}
			}
		})
		
	})
})
