function guardar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;
    var brand = document.getElementById("brand").value;
    var year = document.getElementById("year").value;
    var category = document.getElementById("category").value;
    var y = new Date().getFullYear();


    if (name == null || name == "" || description == null || description == "" || brand == null || brand == "" || year == null || year == "" || category == 0 || category == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');
        document.getElementById("name").focus();
        document.getElementById("brand").focus();
        document.getElementById("description").focus();
        document.getElementById("year").focus();
        document.getElementById("category").focus();

        return false;
    }

    if (name.length > 45) {
        mostrarMensaje('El nombre debe tener menos de 45 carácteres');
        document.getElementById("name").focus();
        return false;
    }

    if (brand.length > 45) {
        mostrarMensaje('La marca debe tener menos de 45 carácteres');
        document.getElementById("brand").focus();
        return false;
    }

    if (description.length > 250) {
        mostrarMensaje('La descripción debe tener menos de 250 carácteres');
        document.getElementById("description").focus();
        return false;
    }

    if (year > y) {
        mostrarMensaje('El año debe ser un año calendario (menor o igual a ' + y + ')', 'Error');
        document.getElementById("year").focus();
        return false;
    }

    if (category == 0 || category == "" || category == "Seleccione la categoría") {
        mostrarMensaje('Selecciona una categoría válida', 'Error');
        document.getElementById("category").focus();
        return false;
    }

    return true;
}

function enviar() {
    let orthesis = {
        name: $("#name").val(),
        description: $("#description").val(),
        brand: $("#brand").val(),
        year: +$("#year").val(),
        category: {
            id: +$("#category").val()
        }
    };

    $.ajax({
        url: "/api/Ortopedic/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(orthesis),
        statusCode: {
            201: function () {
                mostrarMensaje('Se ha guardado el registro', 'Operación exitosa');
                setTimeout(() => {
                    window.location = "./index.html";
                }, 2500);
            }
        },
    });
}