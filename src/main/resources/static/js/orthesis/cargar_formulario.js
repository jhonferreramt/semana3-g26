$(document).ready(function () {
    var y = new Date().getFullYear();
    $("#year").attr("max", y);

    consultarCategory();
});

function consultarCategory() {
    $.ajax({
        url: "/api/Category/all",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            mostrarListado(respuesta);
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar las categorías', 'Error');
        }
    });
}

function mostrarListado(items) {
    var opciones = '';
    for (var i = 0; i < items.length; i++) {
        opciones += `<option value="${items[i].id}">${items[i].name}</option>`;
    }
    $("#category").append(opciones);
}