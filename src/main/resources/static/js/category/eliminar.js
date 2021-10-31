function eliminar(identificador) {
    $.ajax({
        url: "/api/Category/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.ortopedics) === "[]") {
                enviar(identificador);
            } else {
                mostrarMensaje('Esta categoría tiene órtesis asociadas, no se puede eliminar', 'Error');
            }
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar el registro', 'Error');
        }
    });
}

function enviar(identificador) {
    let category = {
        id: +identificador
    };

    $.ajax({
        url: "/api/Category/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(category),
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