function validate(){
    var id=document.getElementById("id").value
    var bool=/^[0-9]{6}$/.test(id)
    var number=document.getElementById("number").value
    var bool1=/^[6-9]{1}[0-9]{9}$/.test(number)
    if(id==""){
        alert("USER ID REQUIRED")
        return false
    }
    else if (bool==false) {
        alert("USER ID MUST BE 6 CHARACTERS")
        return false
    }
    if (number=="") {
        alert("MOBILE NUMBER REQUIRED")
        return false
    }
   
    else if(bool1==false){
        alert("MOBILE NUMBER STARTS WITH 6-9 AND MUST BE 10 DIGITS")
        return false
    }
    return true
}