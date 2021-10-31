function guardar() {
    if (validar()) {
        enviar();
    }
}

function validar() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var age = document.getElementById("age").value;

    if (name == null || name == "" || email == null || email == "" || password == null || password == "" || age == null || age == "") {
        mostrarMensaje('Los campos en el formulario son requeridos', 'Error');
        document.getElementById("name").focus();
        document.getElementById("email").focus();
        document.getElementById("password").focus();
        document.getElementById("age").focus();
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

    if (age > 120 || age < 1) {
        mostrarMensaje('La edad debe ser válida', 'Error');
        document.getElementById("age").focus();
        return false;
    }

    return true;
}

function enviar() {
    let client = {
        name: $("#name").val(),
        email: $("#email").val(),
        age: +$("#age").val(),
        password: $("#password").val()
    };

    $.ajax({
        url: "/api/Client/save",
        type: 'POST',
        dataType: 'json',
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(client),
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