function guardar(){
  if (validar()) {
    enviar();
  }
}

function validar() {
  var name = document.getElementById("name").value;
  var description = document.getElementById("description").value;

  if (name == null || name == "" || description == null || description == "") {
    alert("Los campos en el formulario son requeridos");
    document.getElementById("name").focus();
    document.getElementById("description").focus();
    return false;
  } 
  
  if (name.length > 45) {
    alert("El nombre debe tener menos de 45 carácteres");
    document.getElementById("name").focus();
    return false;
  }

  if (description.length > 250) {
    alert("La descripción debe tener menos de 250 carácteres");
    document.getElementById("description").focus();
    return false;
  }

  return true;
}

function enviar(){  
  let category = {
    name: $("#name").val(),
    description: $("#description").val()
  };

  $.ajax({
    url: "/api/Category/save",
    type: 'POST',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(category),
    statusCode:{
      201:function(){
        alert('Se ha guardado el registro');
        window.location="./index.html";
      }
    },
  });
}