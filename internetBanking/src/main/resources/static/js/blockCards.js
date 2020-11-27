function validate() {
    var card = document.getElementById("card").value
    var reason = document.getElementById("reason").value
    var pass = document.getElementById("pwd").value

    var bool1=/(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9A-Za-z!@#$%^&*]{6,15}/.test(pass)
   

    if(card==""){
        alert("PLEASE SELECT THE CARD TYPE")
        return false
    }
    if(reason==""){
        alert("PLEASE SELECT THE REASON")
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