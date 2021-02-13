function login() {
    firebase
      .auth()
      .signInWithEmailAndPassword("usuario@prueba.com", "usuario123456").then(()=>{
        getToken();
      })
      .catch(function (error) {
        // Handle Errors here.
        var errorCode = error.code;
        var errorMessage = error.message;
        // ...
      });
  }

  login();
  

  function getToken(){
  firebase.auth().currentUser.getIdToken(/* forceRefresh */ true).then(function(idToken) {
    console.log(idToken);
    // ...
  }).catch(function(error) {
    console.log(error)
  });
}

  