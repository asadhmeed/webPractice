const app = {
	baseURL : "/web-0.1/rest",
}

function addSubscriber() {

	const subscriber = {
		email : element("subscribe-in").value,
		
	}
	if(validateEmail( subscriber.email ) && subscriber.email.length != 0){
	element("subscribe-btn").style.visibility = "hidden";
	if (subscriber.email == null || subscriber.email.length == 0) {
		alert("Please fill all the fileds");
		element("subscribe-btn").style.visibility = "";
		return;
	}
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("new id is " + this.responseText);
			
		}
	};
	xhttp.open("POST", app.baseURL + "/subscribe", true);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send(JSON.stringify(subscriber));
	element("subscribe-btn").style.visibility = "";
	}else{
		alert("email is unvalid !!!!")
	}
}
function validateEmail(elementValue){      
	   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	   return emailPattern.test(elementValue); 
	 } 

function element(elementId) {
	return document.getElementById(elementId);
}