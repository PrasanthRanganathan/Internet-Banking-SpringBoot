function validate() {
    var pass = document.getElementById("pwd").value
    var cpass = document.getElementById("cpwd").value
    var card =document.getElementById("card").value

    var bool1=/^[0-9]{4}$/.test(pass)
    var bool2=/^[0-9]{4}$/.test(cpass)
   
    if(card==""){
        alert("PLEASE SELECT THE CARD TYPE")
        return false
    }
    if(pass==""){
        alert("PIN NUMBER REQUIRED")
        return false
    }
    else if (isNaN(pass)) {
		alert("PIN NUMBER ACCEPT ONLY NUMBERIC VALUE")
		return false
	}
    else if(bool1==false){
        alert("PIN NUMBER MUST BE 4 DIGIT NUMBER")
        return false
    }
    if(cpass==""){
        alert("CONFORM PIN NUMBER REQUIRED")
        return false
    }
    else if (isNaN(cpass)) {
		alert("PIN NUMBER ACCEPT ONLY NUMBERIC VALUE")
		return false
	}
    else if(bool2==false){
        alert("PIN NUMBER MUST BE 4 DIGIT NUMBER")
        return false
    }
    else if(pass!=cpass){
        alert("PIN AND CONFORM PIN NUMBER MUST BE SAME")
        return false
    }
}