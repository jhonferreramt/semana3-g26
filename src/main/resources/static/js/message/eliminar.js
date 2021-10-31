function eliminar(identificador) {
    let message = {
        idMessage: +identificador
    };

    $.ajax({
        url: "/api/Message/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(message),
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