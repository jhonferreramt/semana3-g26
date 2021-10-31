function actualizar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var score = document.getElementById("score").value;
    var message = document.getElementById("message").value;
    var idReservation = document.getElementById("idReservation").value;

    if (score == null || score == "" || message == null || message == "" || idReservation == null || idReservation == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');
        document.getElementById("score").focus();
        document.getElementById("message").focus();
        document.getElementById("idReservation").focus();
        return false;
    }

    if (message.length > 250) {
        mostrarMensaje('El mensaje debe tener menos de 250 carácteres', 'Error');
        document.getElementById("message").focus();
        return false;
    }

    if (idReservation == 0 || idReservation == "" || idReservation == "Seleccione la reservación") {
        mostrarMensaje('Selecciona una reservación válida', 'Error');
        document.getElementById("idReservation").focus();
        return false;
    }

    if (score > 5 || score < 0) {
        mostrarMensaje('La calificación debe estar en el rando de 0 a 5', 'Error');
        document.getElementById("score").focus();
        return false;
    }

    return true;
}

function enviar() {
    let score = {
        idScore: +$("#id").val(),
        score: +$("#score").val(),
        message: $("#message").val(),
        reservation: {
            idReservation: +$("#idReservation").val()
        }
    };

    $.ajax({
        url: "/api/Score/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(score),
        statusCode: {
            201: function () {
                mostrarMensaje('Se ha modificado el registro', 'Operación exitosa');
                setTimeout(() => {
                    window.location = "../reservation/index.html";
                }, 2500);
            }
        },
    });
}