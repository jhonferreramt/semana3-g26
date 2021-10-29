$(document).ready(function () {
  let searchParams = new URLSearchParams(window.location.search)
  if (searchParams.has('id')){
    let id = searchParams.get('id');
    consultarById(id);
  }
});

function consultarById(id){
  $.ajax({
    url: "/api/Client/"+id,
    type: 'GET',
    dataType: 'json',
    success: function(respuesta){
      if (JSON.stringify(respuesta.name) !== "null"){
        llenarDatos(respuesta);
      }else{
        $("#modificar").hide();
        alert('No se encuentra el cliente con el id '+id);
      }
    },
    error: function (xhr, status) {
      alert('Se ha presentado un problema al consultar el registro');
    }
  });
}

function llenarDatos(item){
  $("#id").val(item.idClient);
  $("#name").val(item.name);
  $("#email").val(item.email);
  $("#age").val(item.age);
  $("#password").val(item.password);
}