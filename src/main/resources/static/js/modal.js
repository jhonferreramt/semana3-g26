function mostrarMensaje(mensaje,tipo) {
    $("#tituloModalMensaje").html(tipo);
    $("#mensaje").html(mensaje);
    $('#modalMensaje').modal('show');
}

function cerrarModalMensaje(){
    $('#modalMensaje').modal('hide');
}
