function consultar() {
    if (validar()) {
        var startDate = document.getElementById("startDate").value;
        var devolutionDate = document.getElementById("devolutionDate").value;
        enviar(startDate, devolutionDate);
    }
}

function validar() {
    var startDate = document.getElementById("startDate").value;
    var devolutionDate = document.getElementById("devolutionDate").value;
    var inicial, final;

    if (startDate == 0 || startDate == "" || devolutionDate == 0 || devolutionDate == "") {
        mostrarMensaje('Ambas fechas son requeridas', 'Error');
        document.getElementById("startDate").focus();
        document.getElementById("devolutionDate").focus();
        return false;
    }

    if (startDate == "" && devolutionDate !== "") {
        mostrarMensaje('Ambas fechas son requeridas', 'Error');
        document.getElementById("startDate").focus();
        return false;
    }

    inicial = new Date(document.getElementById("startDate").value);
    final = new Date(document.getElementById("devolutionDate").value);

    if (final < inicial) {
        mostrarMensaje('La fecha de devolución debe ser mayor o igual a la fecha de entrega', 'Error');
        document.getElementById("devolutionDate").focus();
        return false;
    }

    return true;
}

function enviar(inicio, fin) {
    $.ajax({
        url: "/api/Reservation/report-dates/" + inicio + "/" + fin,
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            console.log(respuesta);
            mostrarInformacion(respuesta);
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar la información', 'Error');
        }
    });
}

function mostrarInformacion(items) {
    var tabla = '';
    for (var i = 0; i < items.length; i++) {
        var date1 = new Date(items[i].startDate);
        var date2 = new Date(items[i].devolutionDate);

        var startDate = date1.getUTCFullYear() + "-";
        if ((date1.getUTCMonth() + 1) < 10) {
            startDate += "0";
        }
        startDate += (date1.getUTCMonth() + 1) + "-";
        if (date1.getUTCDate() + 1 < 10) {
            startDate += "0";
        }
        startDate += date1.getUTCDate();

        var devolutionDate = date2.getUTCFullYear() + "-";
        if ((date2.getUTCMonth() + 1) < 10) {
            devolutionDate += "0";
        }
        devolutionDate += (date2.getUTCMonth() + 1) + "-";
        if (date2.getUTCDate() + 1 < 10) {
            devolutionDate += "0";
        }
        devolutionDate += date2.getUTCDate();

        var status = "";
        if (items[i].status === "created") {
            status = "Creada";
        } else if (items[i].status === "programmed") {
            status = "Programada";
        } else if (items[i].status === "cancelled") {
            status = "Cancelada";
        } else if (items[i].status === "completed") {
            status = "Realizada";
        }

        tabla += `<tr>
             <td>${items[i].idReservation}</td>
             <td>${items[i].ortopedic.name}</td>
             <td>${startDate}</td>
             <td>${devolutionDate}</td>
             <td>${status}</td>
             <td>${items[i].client.name}</td>
            </tr>`;
    }
    $("#count_reservation").html(tabla);
    $("#total").html(items.length);
}