$(document).ready(function () {
    $.ajax({
        url: "/api/Reservation/all",
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
});

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
             <td>${items[i].client.idClient}</td>
             <td>${items[i].client.name}</td>
             <td>${items[i].client.email}</td>`;
        if (JSON.stringify(items[i].score) !== "null") {
            tabla += `<td>${items[i].score.score}</td>
               <td>
               <a onclick="eliminar(${items[i].idReservation},${items[i].score.idScore})" data-toggle="tooltip" data-placement="top" title="Eliminar reserva" class="btn btn-danger">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
               <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
               </svg>
               </a>
               <a href="./reservation_detail.html?id=${items[i].idReservation}" data-toggle="tooltip" data-placement="top" title="Ver detalles" class="btn btn-primary">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
               <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
               <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
               </svg>
               </a>
               <a href="../score/score_detail.html?id=${items[i].score.idScore}" data-toggle="tooltip" data-placement="top" title="Editar calificación" class="btn btn-secondary">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-square-fill" viewBox="0 0 16 16">
               <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm10.03 4.97a.75.75 0 0 1 .011 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.75.75 0 0 1 1.08-.022z"/>
               </svg>
               </a>                            
               </td>`;
        } else {
            tabla += `<td></td>
               <td>
               <a onclick="eliminar(${items[i].idReservation},null)" data-toggle="tooltip" data-placement="top" title="Eliminar órtesis" class="btn btn-danger">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
               <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
               </svg>
               </a>
               <a href="./reservation_detail.html?id=${items[i].idReservation}" data-toggle="tooltip" data-placement="top" title="Ver reserva" class="btn btn-primary">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
               <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
               <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
               </svg>
               </a> 
               <a href="../score/create_score.html?id=${items[i].idReservation}" data-toggle="tooltip" data-placement="top" title="Calificar reserva" class="btn btn-warning">
               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
               <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
               </svg>
               </a>                          
               </td>`;
        }
        tabla += `</tr>`;
    }
    $("#reservation").append(tabla);
}