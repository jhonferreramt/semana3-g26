function eliminar(identificador){
    $.ajax({
        url: "/api/Ortopedic/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.reservations) === "[]" && JSON.stringify(respuesta.messages) === "[]") {
                enviar(identificador);
            } else {
                alert('Esta órtesis tiene mensajes y/o reservaciones asociadas, no se puede eliminar');
            }
        },
        error: function (xhr, status) {
            alert('Se ha presentado un problema al consultar el registro');
        }
    });
}    
    
function enviar(identificador) {
  let orthesis = {
    id: +identificador
  };

  $.ajax({
    url: "/api/Ortopedic/"+identificador,
    type: 'DELETE',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(orthesis),
    statusCode:{
      204:function(){
        alert('Se ha eliminado el registro');
        window.location="./index.html";
      }
    },
  });
}