const app = {
	baseURL : "/web-0.1",
}


function userRegister() {
const user ={
		userName:element("userName").value,
		email:element("email").value,
		password:element("password").value,
		verifiedPassword:element("vpassword").value,
		emailIsVerified:false,
}	



if(verifyUserName(user) && verifyEmail(user) && verifyPassword(user)){
	element("register_btn").style.visibility = "hidden";
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("new id is " + this.responseText);
			if(this.responseText == "-1"){
				element("userNot").innerText ="user name or email are already used";	
			}
		}
	};
	xhttp.open("POST", app.baseURL + "/register", true);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send(JSON.stringify(user));
	element("register_btn").style.visibility = "";
}



}

function verifyUserName(user) {
	if(user.userName == null ||user.userName.length > 20 || user.userName.length == 0){
		
		element("userNot").innerText ="enter a valid user name (0 < length < 20)";
		return false;
	}else{
		element("userNot").innerText ="";
		return true;
	}	
}
function verifyEmail(user) {
	if(user.email == null || !validateEmail(user.email)|| user.email.length == 0){
		element("emailNot").innerText= "enter a valid email";
		return false;
	}else {
		element("emailNot").innerText= "";
		return true;
	}	
}


function verifyPassword(user) {
	if(user.password == null || user.password.length == 0 ){
		element("passwordNot").innerText ="enter password";
		return false;
	}else{
		element("passwordNot").innerText ="";
	}
	if(user.verifiedPassword == null || user.verifiedPassword.length ==0){
		element("vpasswordNot").innerText ="enter password"; 
		return false;
	}else{
		element("vpasswordNot").innerText ="";
	
	const password = element("password").value;
	const vpassword = element("vpassword").value;
	if(password !== vpassword){
		element("vpasswordNot").innerText ="password and verify password are not identical ";
		return false;
	}else
	{
		element("vpasswordNot").innerText ="";
		return true;
	}
	}	
}
function validateEmail(elementValue){      
	   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	   return emailPattern.test(elementValue); 
	 } 


function element(elementId) {
	return document.getElementById(elementId);
}