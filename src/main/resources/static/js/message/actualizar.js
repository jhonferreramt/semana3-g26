function actualizar(){
  if (validar()) {
    enviar();
  }
}
  
function validar() {
  var messagetext = document.getElementById("messagetext").value;
  var orthesis = document.getElementById("orthesis").value;
  var client = document.getElementById("client").value;

  if (messagetext == null || messagetext == "" || orthesis == 0 || orthesis== "" || client == 0 || client== "") {
    alert("Los campos en el formulario son requeridos");
    document.getElementById("messagetext").focus();
    document.getElementById("orthesis").focus();
    document.getElementById("client").focus();

    return false;
  }

  if (messagetext.length > 250) {
    alert("El mensaje debe tener menos de 250 carácteres");
    document.getElementById("messagetext").focus();
    return false;
  }  

  if(orthesis == 0 || orthesis == "" || orthesis == "Seleccione la órtesis") {
    alert("Selecciona una órtesis válida");
    document.getElementById("orthesis").focus();
    return false;
  }
  
  if(client == 0 || client == "" || client == "Seleccione el cliente") {
    alert("Selecciona un cliente válido");
    document.getElementById("client").focus();
    return false;
  }  

  return true;
}

function enviar(){   
  let message = {
    idMessage: +$("#id").val(),
    messageText: $("#messagetext").val(),
    ortopedic: {
      id: +$("#orthesis").val()
    },
    client: {
      idClient: +$("#client").val()
    }
  };
    
  $.ajax({
    url: "/api/Message/update",
    type: 'PUT',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(message),
    statusCode:{
      201:function(){
        alert('Se ha modificado el registro');
        window.location="./index.html";
      }
    },
  });
}