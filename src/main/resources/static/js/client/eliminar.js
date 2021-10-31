function eliminar(identificador) {
    $.ajax({
        url: "/api/Client/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.reservations) === "[]" && JSON.stringify(respuesta.messages) === "[]") {
                enviar(identificador);
            } else {
                mostrarMensaje('Este cliente tiene mensajes y/o reservaciones asociadas, no se puede eliminar', 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function enviar(identificador) {
    let client = {
        idClient: +identificador
    };

    $.ajax({
        url: "/api/Client/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(client),
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