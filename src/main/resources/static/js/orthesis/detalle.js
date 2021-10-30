$(document).ready(function () {
  let searchParams = new URLSearchParams(window.location.search)
  if (searchParams.has('id')){
    let id = searchParams.get('id');
    consultarById(id);
  }
});

function consultarById(id){
  $.ajax({
    url: "/api/Ortopedic/"+id,
    type: 'GET',
    dataType: 'json',
    success: function(respuesta){
      if (JSON.stringify(respuesta.name) !== "null"){
        llenarDatos(respuesta);
      }else{
        $("#modificar").hide();
        alert('No se encuentra la órtesis con el id '+id);
      }
    },
    error: function (xhr, status) {
      alert('Se ha presentado un problema al consultar el registro');
    }
  });
}

function llenarDatos(item){
  $("#id").val(item.id);
  $("#name").val(item.name);
  $("#description").val(item.description);
  $("#brand").val(item.brand);
  $("#year").val(item.year);
  //var option = "#category option[text='"+ item.category.id +"']";
  //$(option).attr("selected",true);
  var opciones = `<option value="${item.category.id}" selected>${item.category.name}</option>`;
  $("#category").append(opciones);
}