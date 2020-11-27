function validate(){
    var npwd=document.getElementById("npwd").value
    var bool=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}$/.test(npwd)
    var cpwd=document.getElementById("cpwd").value
    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(cpwd)
    if(npwd==""){
        alert("PASSWORD REQUIRED")
        return false
    }
    else if (bool==false) {
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
    if (cpwd=="") {
        alert("CONFORM PASSWORD REQUIRED")
        return false
    }
   
    else if(bool1==false){
        alert("Conform password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
    if(npwd!==cpwd){
        alert("PASSWORD AND CONFORM PASSWORD MUST BE SAME")
    		return false
    }
}