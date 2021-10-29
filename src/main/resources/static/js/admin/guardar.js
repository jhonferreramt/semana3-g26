function guardar(){
  if (validar()) {
    enviar();
  }
}

function validar() {
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  if (name == null || name == "" || email == null || email == "" || password == null || password == "") {
    alert("Los campos en el formulario son requeridos");
    document.getElementById("name").focus();
    document.getElementById("email").focus();
    document.getElementById("password").focus();
    return false;
  } 
  
  emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

  if (!emailRegex.test(email)) {
    alert("El correo electrónico tiene que ser válido");
    document.getElementById("email").focus();
    return false;
  }
  
  if (name.length > 250) {
    alert("El nombre debe tener menos de 250 carácteres");
    document.getElementById("name").focus();
    return false;
  }

  if (email.length > 45) {
    alert("El correo electrónico debe tener menos de 45 carácteres");
    document.getElementById("email").focus();
    return false;
  }

  if (password.length > 45) {
    alert("La contraseña debe tener menos de 45 carácteres");
    document.getElementById("password").focus();
    return false;
  }

  return true;
}

function enviar(){
  let admin = {
    name: $("#name").val(),
    email: $("#email").val(),
    password: $("#password").val()
  };

  $.ajax({
    url: "/api/Admin/save",
    type: 'POST',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(admin),
    statusCode:{
      201:function(){
        alert('Se ha guardado el registro');
        window.location="./index.html";
      }
    },
  });
}