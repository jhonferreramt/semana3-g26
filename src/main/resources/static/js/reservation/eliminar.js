function eliminar(id_reservation, id_score) {
    if (id_score == null) {
        eliminarReservation(id_reservation);
    } else {
        eliminarScore(id_score, id_reservation);
    }
}

function eliminarReservation(id_reservation) {
    let reservation = {
        idReservation: +id_reservation
    };

    $.ajax({
        url: "/api/Reservation/" + id_reservation,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(reservation),
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

function eliminarScore(id_score, id_reservation) {
    let score = {
        idScore: +id_score
    };

    $.ajax({
        url: "/api/Score/" + id_score,
        type: 'DELETE',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(score),
        statusCode: {
            204: function () {
                mostrarMensaje('Se ha eliminado el puntaje', 'Operación exitosa');
                setTimeout(() => {
                    eliminarReservation(id_reservation);
                }, 2500);
            }
        },
    });
}