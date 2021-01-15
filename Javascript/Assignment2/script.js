
function FirstName() {
    var name = document.getElementById("fName").value;

    if(!name.match(/^[a-zA-Z]+$/)) {
        alert("Invalid Name : " + name);
        document.getElementById("fName").value = "";
    }
}

function LastName() {
    var name = document.getElementById("lName").value;

    if(!name.match(/^[a-zA-Z]+$/)) {
        alert("Invalid Name : " + name);
        document.getElementById("lName").value = "";
    }
}

function Email(){
    const emails = ["gmail.com", "accolitedigital.com", "outlook.com"];
    var name = document.getElementById("email").value;

    var arr = name.split('@');

    var firstName = arr[0];
    var domainName = arr[1];
    var a = firstName.split('');

    if(arr.length != 2 || !firstName.match(/^[0-9a-zA-Z]+$/) || ((a < "a" || a > "z") && (a < "A" || a > "Z"))){
        alert("Invalid Email : " + name);
    }
}

function Mobile() {
    var num = parseInt(document.getElementById("mobile").value);
    var s = num.toString();
    
    var arr = s.split("");

    if(arr.length != 10) {
        alert("Invalid num : " + num);
    }
}

function submittingData() {
    var fname = document.getElementById("fName").value;
    var lname = document.getElementById("lName").value;
    var email = document.getElementById("email").value;
    var num = parseInt(document.getElementById("mobile").value);
    
    var ele = document.getElementsByName("gender");
    var gender = "";
    for(var i = 0; i < ele.length; i++) {
        if(ele[i].checked)
            gender = ele[i].value;
    }

    var ch = document.getElementsByName("hob");
    var arr = [];

    for(var i = 0; i < ch.length; i++) {
        if(ch[i].checked)
            arr.push(ch[i]);
    }

    alert("Name: "+fname + ", LastName: " + lname + ", Email: " + email + ", Mobile: " + num + ", Gender: " + gender);
}

function reset(){
    document.getElementById("fName").value = "";
    document.getElementById("lName").value = "";
    document.getElementById("email").value = 0;
    document.getElementById("mobile").value = "";
    document.getElementsByName("gemder").value = "";

}