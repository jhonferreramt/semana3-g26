function eliminar(identificador){
  let category = {
    id: +identificador
  };

  $.ajax({
    url: "/api/Category/"+identificador,
    type: 'DELETE',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(category),
    statusCode:{
      204:function(){
        alert('Se ha eliminado el registro');
        window.location="./index.html";
      }
    },
  });
}