$(document).ready(function () {
    $.ajax({
        url: "/api/Reservation/report-clients",
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
    var data = [];
    var label = [];

    for (var i = 0; i < items.length; i++) {
        tabla += `<tr>
             <td>${i + 1}</td>
             <td>${items[i].client.name}</td>
             <td>${items[i].total}</td>
            </tr>`;
        data.push(items[i].total);
        label.push(items[i].client.name);

    }
    $("#top_client").append(tabla);

    var ctx = document.getElementById('myTopChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: label,
            datasets: [
                {
                    data: data,
                    backgroundColor: [
                        'rgba(192, 192, 192, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(128, 65, 0, 0.2)',
                        'rgba(142, 5, 107, 0.2)',
                        'rgba(153, 192, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgb(192, 192, 192, 1)',
                        'rgba(255, 99, 132, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(128, 65, 0, 1)',
                        'rgba(142, 5, 107, 1)',
                        'rgba(153, 192, 64, 1)'
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