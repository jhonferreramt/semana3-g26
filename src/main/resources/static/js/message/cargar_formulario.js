$(document).ready(function () {
    consultarOrthesis();
    consultarClient();
});

function consultarOrthesis() {
    $.ajax({
        url: "/api/Ortopedic/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            mostrarListado(respuesta);
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar las ótesis', 'Error');
        }
    });
}

function mostrarListado(items) {
    var opciones = '';
    for (var i = 0; i < items.length; i++) {
        opciones += `<option value="${items[i].id}">${items[i].name}</option>`;
    }
    $("#orthesis").append(opciones);
}

function consultarClient() {
    $.ajax({
        url: "/api/Client/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            mostrarClient(respuesta);
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar los clientes', 'Error');
        }
    });
}

function mostrarClient(items) {
    var opciones = '';
    for (var i = 0; i < items.length; i++) {
        opciones += `<option value="${items[i].idClient}">${items[i].name}</option>`;
    }
    $("#client").append(opciones);
}