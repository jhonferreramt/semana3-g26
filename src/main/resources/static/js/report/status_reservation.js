$(document).ready(function () {
    $.ajax({
        url: "/api/Reservation/report-status",
        type: 'GET',
        dataType: 'json',
        success: function (respuesta) {
            mostrarInformacion(respuesta);
        },
        error: function (xhr, status) {
            mostrarMensaje('Se ha presentado un problema al consultar la información', 'Error');
        }
    });
});

function mostrarInformacion(items) {
    var tabla = `<tr>
        <td>Completadas</td>
        <td>${items.completed}</td>            
        </tr>
        <tr>
        <td>Canceladas</td>            
        <td>${items.cancelled}</td>            
        </tr>`;
    $("#status_reservation").append(tabla);
    
    var ctx = document.getElementById('myStatusChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ["Completadas","Canceladas"],
            datasets: [
                {
                    data: [items.completed,items.cancelled],
                    backgroundColor: [
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(128, 65, 0, 0.2)',
                        'rgba(142, 5, 107, 0.2)',
                        'rgba(153, 192, 64, 0.2)',
                        'rgba(192, 192, 192, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(54, 162, 235, 1)',
                        'rgba(128, 65, 0, 1)',
                        'rgba(142, 5, 107, 1)',
                        'rgba(153, 192, 64, 1)',
                        'rgb(192, 192, 192, 1)',
                        'rgba(255, 99, 132, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }
            ]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                }
            }
        }
    });
}