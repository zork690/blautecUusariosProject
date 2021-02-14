function crear_objeto_XMLHttpRequest(){
	try{
		objeto = new XMLHttpRequest();
	}catch (err1){
		try{
			objeto = new ActiveXObject("MSXML2.XMLHTTP");
		}catch (err2){
		try{
			objeto = new ActiveXObject("Microsoft.XMLHTTP");
		}catch (err3){
			objeto = false;
		}
	}
}
return objeto;
}

