function eliminar(identificador) {
    $.ajax({
        url: "/api/Category/" + identificador,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            if (JSON.stringify(respuesta.ortopedics) === "[]") {
                enviar(identificador);
            } else {
                alert('Esta categoría tiene órtesis asociadas, no se puede eliminar');
            }
        },
        error: function (xhr, status) {
            alert('Se ha presentado un problema al consultar el registro');
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
                alert('Se ha eliminado el registro');
                window.location = "./index.html";
            }
        },
    });
}