function actualizar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var startDate = document.getElementById("startDate").value;
    var devolutionDate = document.getElementById("devolutionDate").value;
    var orthesis = document.getElementById("orthesis").value;
    var client = document.getElementById("client").value;
    var status = document.getElementById("status").value;

    if (startDate == 0 || startDate == "" || devolutionDate == 0 || devolutionDate == "" || orthesis == 0 || orthesis == "" || client == 0 || client == "" || status == 0 || status == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');

        document.getElementById("startDate").focus();
        document.getElementById("devolutionDate").focus();
        document.getElementById("orthesis").focus();
        document.getElementById("client").focus();

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

    if (status == 0 || status == "" || status == "Seleccione el estado") {
        mostrarMensaje('Selecciona un estado de reserva válido', 'Error');
        document.getElementById("status").focus();
        return false;
    }

    inicial = new Date(document.getElementById("startDate").value);
    final = new Date(document.getElementById("devolutionDate").value);

    if (startDate == "" && devolutionDate !== "") {
        mostrarMensaje('Ambas fechas son requeridas', 'Error');
        document.getElementById("startDate").focus();
        return false;
    }

    if (final < inicial) {
        mostrarMensaje('La fecha de devolución debe ser mayor o igual a la fecha de entrega', 'Error');
        document.getElementById("devolutionDate").focus();
        return false;
    }

    return true;
}

function enviar() {
    let reservation = {
        idReservation: +$("#id").val(),
        startDate: $("#startDate").val(),
        devolutionDate: $("#devolutionDate").val(),
        ortopedic: {
            id: +$("#orthesis").val()
        },
        client: {
            idClient: +$("#client").val()
        },
        status: $("#status").val()
    };

    $.ajax({
        url: "/api/Reservation/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(reservation),
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