$(document).ready(function () {
  let searchParams = new URLSearchParams(window.location.search)
  if (searchParams.has('id')){
    let id = searchParams.get('id');
    consultarById(id);
  }
});

function consultarById(id){
  $.ajax({
    url: "/api/Reservation/" + id,
    type: 'GET',
    dataType: 'json',
    success: function(respuesta){
      if (JSON.stringify(respuesta.name) !== "null"){
        llenarDatos(respuesta);
      }else{
        $("#modificar").hide();
        alert('No se encuentra la reserva con el id '+id);
      }
    },
    error: function (xhr, status) {
      alert('Se ha presentado un problema al consultar el registro');
    }
  });
}

function llenarDatos(item){
  var date1= new Date(item.startDate);
  var date2= new Date(item.devolutionDate);

  var startDate = date1.getUTCFullYear() + "-";
  if ((date1.getUTCMonth()+1) < 10) { 
    startDate += "0";
  }
  startDate += (date1.getUTCMonth()+1) + "-";
  if (date1.getUTCDate()+1 < 10) { 
    startDate += "0";
  }
  startDate += date1.getUTCDate();
      
  var devolutionDate = date2.getUTCFullYear() + "-";
  if ((date2.getUTCMonth()+1) < 10) { 
    devolutionDate += "0";
  }
  devolutionDate += (date2.getUTCMonth()+1) + "-";
  if (date2.getUTCDate()+1 < 10) { 
    devolutionDate += "0";
  }
  devolutionDate += date2.getUTCDate();

  $("#id").val(item.idReservation);
  $("#startDate").val(startDate);
  $("#devolutionDate").val(devolutionDate);
  //var optionOr = "#orthesis option[value='"+ item.ortopedic.id +"']";
  //$(optionOr).attr("selected", true);
  //var optionCli = "#client option[value='"+ item.client.idClient +"']";
  //$(optionCli).attr("selected", true);
  var opcionesOr = `<option value="${item.ortopedic.id}" selected>${item.ortopedic.name}</option>`;
  $("#orthesis").append(opcionesOr);  
  var opcionesCli = `<option value="${item.client.idClient}">${item.client.idClient} - ${item.client.name}</option>`;
  $("#client").append(opcionesCli); 
  var optionSta = "#status option[value='"+ item.status +"']";
  $(optionSta).attr("selected", true);
}