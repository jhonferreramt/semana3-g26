function eliminar(identificador){
  let message = {
    idMessage: +identificador
  };

  $.ajax({
    url: "/api/Message/"+identificador,
    type: 'DELETE',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(message),
    statusCode:{
      204:function(){
        alert('Se ha eliminado el registro');
        window.location="./index.html";
      }
    },
  });
}