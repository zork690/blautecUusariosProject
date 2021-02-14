let id = "";
const SERVIDOR = "http://localhost:8080/";
let tieneToken = false;
let token = "";
$("#editar").hide();
$("#mensajeUsuarioDiv").hide();

function guardar() {
    if (tieneToken) {
        console.log("GUARDANDO USUARIO...");
        db.collection("usuarios").add({
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
            fechaNacimiento: $("#fechaNac").val()
        })
            .then(function (docRef) {
                console.log("Document written with ID: ", docRef.id);
                limpiarCampos();
                leerUsuarios();
            })
            .catch(function (error) {
                console.error("Error adding document: ", error);
            });
    } else {
        mostrarModal();
    }
}

function leerUsuarios() {
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
    db.collection("usuarios").doc(idUsuario).delete().then(function () {
        console.log("Document successfully deleted!");
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

    var washingtonRef = db.collection("usuarios").doc(id);

    return washingtonRef.update({
        nombre: $("#nombre").val(),
        apellido: $("#apellido").val(),
        fechaNacimiento: $("#fechaNac").val()
    })
        .then(function () {
            console.log("Document successfully updated!");
            $("#editar").hide();
            $("#guardar").show();
            limpiarCampos();
            leerUsuarios();
        })
        .catch(function (error) {
            // The document probably doesn't exist.
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

