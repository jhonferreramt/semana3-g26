$(document).ready(function () {
    let searchParams = new URLSearchParams(window.location.search)
    if (searchParams.has('id')) {
        let id = searchParams.get('id');
        consultarById(id);
    }
});

function consultarById(id) {
    $.ajax({
        url: "/api/Score/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.name) !== "null") {
                llenarDatos(respuesta);
            } else {
                $("#modificar").hide();
                mostrarMensaje('No se encuentra el puntaje con el id ' + id, 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function llenarDatos(item) {
    $("#id").val(item.idScore);
    $("#idReservation").val(item.reservation.idReservation);
    $("#message").val(item.message);
    $("#score").val(item.score);
}