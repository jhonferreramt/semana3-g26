function eliminar(identificador) {
    $.ajax({
        url: "/api/Ortopedic/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.reservations) === "[]" && JSON.stringify(respuesta.messages) === "[]") {
                enviar(identificador);
            } else {
                mostrarMensaje('Esta órtesis tiene mensajes y/o reservaciones asociadas, no se puede eliminar', 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function enviar(identificador) {
    let orthesis = {
        id: +identificador
    };

    $.ajax({
        url: "/api/Ortopedic/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(orthesis),
        statusCode: {
            204: function () {
                mostrarMensaje('Se ha eliminado el registro', 'Operación exitosa');
                setTimeout(() => {
                    window.location = "./index.html";
                }, 2500);
            }
        },
    });
}