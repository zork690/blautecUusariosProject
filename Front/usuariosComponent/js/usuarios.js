let id = "";
const SERVIDOR = "http://localhost:8080/";
let tieneToken = false;
let token = "";
let accionUsuario = "";
$("#editar").hide();
$("#mensajeUsuarioDiv").hide();

function guardar() {
    accionUsuario = "guardar";
    if (tieneToken) {
        let urlCompleta = SERVIDOR + "guardarUsuario";
        let obj = {
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
            fechaNacimiento: $("#fechaNac").val()
        };
        peticionAjax("POST", urlCompleta, obj, token).then((respuesta) => {
            console.log("GUARDANDO USUARIO...");
            console.log("Document written with ID: ", respuesta);
            limpiarCampos();
            leerUsuarios();
        }).catch(function (error) {
            console.error("Error adding document: ", error);
        });
    } else {
        mostrarModal();
    }
}

function leerUsuarios() {
    accionUsuario = "listar";
    if (tieneToken) {
        let urlCompleta = SERVIDOR + "listarUsuarios";
        let tabla = $("#tabla");
        peticionAjax("POST", urlCompleta, {}, token).then((respuesta) => {
            console.log(JSON.parse(respuesta));
            let jsonR = JSON.parse(respuesta)
            tabla.html("");

            jsonR.forEach((usuario) => {
                tabla.append(`<tr><th scope="row">${usuario.id}</th>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.apellido}</td>
                    <td>${usuario.fechaNacimiento}</td>
                    <td><button class="btn btn-danger" onclick="borrarUsuario('${usuario.id}')">Eliminar</button></td>
                    <td><button class="btn btn-warning" onclick="editarUsuario(
                        '${usuario.id}', '${usuario.nombre}', '${usuario.apellido}', '${usuario.fechaNacimiento}'
                        )">Editar</button></td></tr>`);
            });

        });
    } else {
        mostrarModal();
    }
}

function borrarUsuario(idUsuario) {
    let urlCompleta = SERVIDOR + "borrarUsuario/" + idUsuario;
    peticionAjax("POST", urlCompleta, {}, token).then((respuesta) => {
        console.log(respuesta);
        leerUsuarios();
    }).catch(function (error) {
        console.error("Error removing document: ", error);
    });
}

function editarUsuario(usuario, nombre, apellido, fecha) {
    id = usuario;

    $("#nombre").val(nombre);
    $("#apellido").val(apellido);
    $("#fechaNac").val(fecha);

    $("#guardar").hide();
    $("#editar").show();

}

function editar() {

    let obj = {
        nombre: $("#nombre").val(),
        apellido: $("#apellido").val(),
        fechaNacimiento: $("#fechaNac").val(),
    }

    let urlCompleta = SERVIDOR + "editarUsuario/" + id;
    peticionAjax("POST", urlCompleta, obj, token).then((respuesta) => {
        console.log(respuesta);
        $("#editar").hide();
        $("#guardar").show();
        limpiarCampos();
        leerUsuarios();
    })
        .catch(function (error) {
            console.error("Error updating document: ", error);
        });

}

function limpiarCampos() {
    $("#nombre").val("");
    $("#apellido").val("");
    $("#fechaNac").val("");
}

function crearBodyModal() {
    $("#bodyModal").html("");
    $("#mensajeUsuarioDiv").html("");
    $("#mensajeUsuarioDiv").hide();
    let usuarioInput = `<input type="text" id="usuario" placeholder="Ingresa Usuario" class="form-control my-3" />`;
    let claveInput = `<input type="password" id="clave" placeholder="Ingresa Clave" class="form-control"  />`;
    $("#bodyModal").append(usuarioInput);
    $("#bodyModal").append(claveInput);
}

function mostrarModal() {
    crearBodyModal();
    $('#myModal').modal({
        show: 'true'
    });
}

function cerrarModal() {
    $('#myModal').modal("hide");
}

function eliminarListarButton() {
    $("#listarUsarios").remove();
}

