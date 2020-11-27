function validate() {
  var toAcc = document.getElementById("accno").value
  var ctoAcc = document.getElementById("caccno").value
    var name= document.getElementById("name").value
    var amount = document.getElementById("amt").value
    var pmode = document.getElementById("mode").value

    bool1=/[0-9]{16}/.test(toAcc)
    bool2=/[0-9]{16}/.test(ctoAcc)
    bool3=/^[A-Za-z]{3,15}$/.test(name)
    
    if(toAcc==""){
        alert("BENEFICIARY ACCOUNT NUMBER REQUIRED")
        return false
    }
    else if (isNaN(toAcc)) {
		alert("BENEFICIARY ACCOUNT NUMBER ACCEPT ONLY NUMERIC VALUE")
		return false
    }
    else if(bool1==false){
    	alert("BENEFICIARY ACCOUNT NUMBER MUST BE 16 DIGITS")
    	return false
    }
    
    if(ctoAcc==""){
        alert("BENEFICIARY CONFORM ACCOUNT NUMBER REQUIRED")
        return false
    }
    else if (isNaN(ctoAcc)) {
		alert("CONFORM BENEFICIARY ACCOUNT NUMBER ACCEPT ONLY NUMERIC VALUE")
		return false
	}
    else if(bool2==false){
        alert("BENEFICIARY CONFORM ACCOUNT NUMBER MUST BE 16 DIGITS")
        return false
    }
    else if(ctoAcc!=toAcc){
        alert("BENEFICIARY AND CONFORM ACCOUNT NUMBER MUST BE SAME")
        return false
    }

    if(name==""){
        alert("BENEFICIARY NAME REQUIRED")
        return false
    }
    else if(bool3==false){
       alert("BENEFICIARY NAME MUST CONTAIN A-Z, a-z AND MIN 3 UPTO 15 CHARACTERS")
        return false
    }

    if(amount==0){
        alert("PLEASE ENTER AMOUNT")
        return false
    }

    if(pmode!="NEFT" && pmode!="IMPS"){
        alert("PLEASE SELECT THE PAYMENT MODE")
        return false
    }
}