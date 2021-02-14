function login() {
  firebase
    .auth()
    .signInWithEmailAndPassword("usuario@prueba.com", "usuario123456").then(() => {
      getToken();
    })
    .catch(function (error) {
      console.log("ERROR AUTENTICANDO ", error);
    });
}


function getToken() {
  firebase.auth().currentUser.getIdToken(true).then(function (idToken) {
    console.log(idToken);

  }).catch(function (error) {
    console.log(error)
  });
}

