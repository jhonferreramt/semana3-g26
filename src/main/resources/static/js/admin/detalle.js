$(document).ready(function () {
    let searchParams = new URLSearchParams(window.location.search)
    if (searchParams.has('id')) {
        let id = searchParams.get('id');
        consultarById(id);
    }
});

function consultarById(id) {
    $.ajax({
        url: "/api/Admin/" + id,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.name) !== "null") {
                llenarDatos(respuesta);
            } else {
                $("#modificar").hide();
                mostrarMensaje('No se encuentra el cliente con el id ' + id, 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function llenarDatos(item) {
    $("#id").val(item.idAdmin);
    $("#name").val(item.name);
    $("#email").val(item.email);
    $("#password").val(item.password);
}