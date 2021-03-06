let objeto_ajax = crear_objeto_XMLHttpRequest();

function peticionAjax(metodo, url, parametros=null, token=null) {
    return new Promise((resuelve, rechaza) => {
        objeto_ajax.onreadystatechange = () => {
            if ((objeto_ajax.readyState == 4) && objeto_ajax.status != 500) {
                resuelve(objeto_ajax.responseText);
            }
            if((objeto_ajax.readyState == 4) && (objeto_ajax.status == 500)){
                rechaza("ERROR PIDIENDO LA INFO  AL SERVIDOR...", objeto_ajax.statusText);
            }
            
        };
        objeto_ajax.open(metodo, url, true);
        objeto_ajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        objeto_ajax.setRequestHeader("Accept", "application/json");
        objeto_ajax.setRequestHeader("Authorization", "Bearer "+token);
        objeto_ajax.send(JSON.stringify(parametros));
    });
}