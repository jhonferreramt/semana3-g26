function eliminar(identificador) {
    let admin = {
        idAdmin: +identificador
    };

    $.ajax({
        url: "/api/Admin/" + identificador,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(admin),
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