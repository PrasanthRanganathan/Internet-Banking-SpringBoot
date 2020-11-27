function validate(){
    var id=document.getElementById("id").value
    var bool=/^[0-9]{6}$/.test(id)
    var pass=document.getElementById("pass").value
    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(pass)
    if(id==""){
        alert("USER ID REQUIRED")
        return false
    }
    else if (bool==false) {
        alert("USER ID MUST BE 6 CHARACTERS")
        return false
    }
    if (pass=="") {
        alert("PASSWORD REQUIRED")
        return false
    }
   
    else if(bool1==false){
        alert("Password must contain A-Z, a-z, 0-9 and special char & length min 6 upto 15")
        return false
    }
}

