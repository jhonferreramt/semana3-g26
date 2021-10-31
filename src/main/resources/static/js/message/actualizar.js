function actualizar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var messagetext = document.getElementById("messagetext").value;
    var orthesis = document.getElementById("orthesis").value;
    var client = document.getElementById("client").value;

    if (messagetext == null || messagetext == "" || orthesis == 0 || orthesis == "" || client == 0 || client == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');
        document.getElementById("messagetext").focus();
        document.getElementById("orthesis").focus();
        document.getElementById("client").focus();

        return false;
    }

    if (messagetext.length > 250) {
        mostrarMensaje('El mensaje debe tener menos de 250 carácteres', 'Error');
        document.getElementById("messagetext").focus();
        return false;
    }

    if (orthesis == 0 || orthesis == "" || orthesis == "Seleccione la órtesis") {
        mostrarMensaje('Selecciona una órtesis válida', 'Error');
        document.getElementById("orthesis").focus();
        return false;
    }

    if (client == 0 || client == "" || client == "Seleccione el cliente") {
        mostrarMensaje('Selecciona un cliente válido', 'Error');
        document.getElementById("client").focus();
        return false;
    }

    return true;
}

function enviar() {
    let message = {
        idMessage: +$("#id").val(),
        messageText: $("#messagetext").val(),
        ortopedic: {
            id: +$("#orthesis").val()
        },
        client: {
            idClient: +$("#client").val()
        }
    };

    $.ajax({
        url: "/api/Message/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(message),
        statusCode: {
            201: function () {
                mostrarMensaje('Se ha modificado el registro', 'Operación exitosa');
                setTimeout(() => {
                    window.location = "./index.html";
                }, 2500);
            }
        },
    });
}