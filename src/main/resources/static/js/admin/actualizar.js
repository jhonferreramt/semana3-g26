function actualizar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    if (name == null || name == "" || email == null || email == "" || password == null || password == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');
        document.getElementById("name").focus();
        document.getElementById("email").focus();
        document.getElementById("password").focus();
        return false;
    }

    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

    if (!emailRegex.test(email)) {
        mostrarMensaje('El correo electrónico tiene que ser válido', 'Error');
        document.getElementById("email").focus();
        return false;
    }

    if (name.length > 250) {
        mostrarMensaje('El nombre debe tener menos de 250 carácteres', 'Error');
        document.getElementById("name").focus();
        return false;
    }

    if (email.length > 45) {
        mostrarMensaje('El correo electrónico debe tener menos de 45 carácteres', 'Error');
        document.getElementById("email").focus();
        return false;
    }

    if (password.length > 45) {
        mostrarMensaje('La contraseña debe tener menos de 45 carácteres', 'Error');
        document.getElementById("password").focus();
        return false;
    }

    return true;
}

function enviar() {
    let admin = {
        idAdmin: +$("#id").val(),
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val()
    };

    $.ajax({
        url: "/api/Admin/update",
        type: 'PUT',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(admin),
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