let id = "";
$("#editar").hide();

function guardar() {
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
}

leerUsuarios();

function leerUsuarios() {
    let tabla = $("#tabla");
    tabla.html("");
    db.collection("usuarios").get().then((querySnapshot) => {
        querySnapshot.forEach((doc) => {
            console.log(`${doc.id} => ${doc.data().nombre}`);
            tabla.append(`<tr><th scope="row">${doc.id}</th>
            <td>${doc.data().nombre}</td>
            <td>${doc.data().apellido}</td>
            <td>${doc.data().fechaNacimiento}</td>
            <td><button class="btn btn-danger" onclick="borrarUsuario('${doc.id}')">Eliminar</button></td>
            <td><button class="btn btn-warning" onclick="editarUsuario(
                '${doc.id}', '${doc.data().nombre}', '${doc.data().apellido}', '${doc.data().fechaNacimiento}'
                )">Editar</button></td></tr>`);
        });
    });
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

    // Set the "capital" field of the city 'DC'
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

