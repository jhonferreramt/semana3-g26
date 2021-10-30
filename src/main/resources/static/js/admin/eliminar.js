function eliminar(identificador){
  let admin = {
    idAdmin: +identificador
  };

  $.ajax({
    url: "/api/Admin/"+identificador,
    type: 'DELETE',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(admin),
    statusCode:{
      204:function(){
        alert('Se ha eliminado el registro');
        window.location="./index.html";
      }
    },
  });
}