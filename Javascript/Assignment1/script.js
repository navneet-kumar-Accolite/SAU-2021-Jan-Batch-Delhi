function changeEvenColor() {	
	resetAllColor();

	for(var i = 2; i <= 20; i += 2) {
		var ind = i.toString();
		document.getElementById(ind).style.color = "white";	
		document.getElementById(ind).style.backgroundColor = "black";
		document.getElementById(ind).style.fontSize = "25px";
	}
}

function changeMultiple5Color() {
	resetAllColor();
	
	for(var i = 5; i <= 20; i += 5) {
		var ind = i.toString();
		document.getElementById(ind).style.backgroundColor = "black";
		document.getElementById(ind).style.color = "white";
		document.getElementById(ind).style.fontSize = "25px";
	}
}

function resetAllColor() {
	for(var i = 1; i <= 20; i++) {
		var ind = i.toString();
		document.getElementById(ind).style.backgroundColor = "white";
		document.getElementById(ind).style.color = "black";	
		document.getElementById(ind).style.fontSize = "16px";

	}
}