$(document).ready(function () {
    let searchParams = new URLSearchParams(window.location.search)
    if (searchParams.has('id')) {
        let id = searchParams.get('id');
        consultarById(id);
    }
});

function consultarById(id) {
    $.ajax({
        url: "/api/Message/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.name) !== "null") {
                llenarDatos(respuesta);
            } else {
                $("#modificar").hide();
                mostrarMensaje('No se encuentra el mensaje con el id ' + id, 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function llenarDatos(item) {
    $("#id").val(item.idMessage);
    $("#messagetext").val(item.messageText);
    //var optionOr = "#orthesis option[value='"+ item.ortopedic.id +"']";
    //$(optionOr).attr("selected", true);
    //var optionCli = "#client option[value='"+ item.client.idClient +"']";
    //$(optionCli).attr("selected", true);

    var opcionesOr = `<option value="${item.ortopedic.id}" selected>${item.ortopedic.name}</option>`;
    $("#orthesis").append(opcionesOr);

    var opcionesCli = `<option value="${item.client.idClient}">${item.client.name}</option>`;
    $("#client").append(opcionesCli);
}