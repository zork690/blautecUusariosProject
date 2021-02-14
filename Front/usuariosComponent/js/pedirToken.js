function login() {
  console.log("ENVIANDO CREDENCIALES ", $("#usuario").val() , $("#clave").val());
  firebase
    .auth()
    .signInWithEmailAndPassword($("#usuario").val(), $("#clave").val()).then(() => {
      getToken();
    })
    .catch(function (error) {
      console.log("ERROR AUTENTICANDO ", error);
      $("#mensajeUsuarioDiv").html(error.message);
      $("#mensajeUsuarioDiv").show();
    });
}


function getToken() {
  firebase.auth().currentUser.getIdToken(true).then(function (idToken) {
    console.log(idToken);

  }).catch(function (error) {
    console.log(error)
  });
}

//"usuario@prueba.com"
//usuario123456
