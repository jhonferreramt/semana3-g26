function actualizar(){
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


  if (name == null || name == "" || description == null || description == "" || brand == null || brand == "" || year == null || year == "" || category == 0|| category== "") {
    alert("Los campos en el formulario son requeridos");
    document.getElementById("name").focus();
    document.getElementById("brand").focus();
    document.getElementById("description").focus();
    document.getElementById("year").focus();
    document.getElementById("category").focus();

    return false;
  }

  if (name.length > 45) {
    alert("El nombre debe tener menos de 45 carácteres");
    document.getElementById("name").focus();
    return false;
  }

  if (brand.length > 45) {
    alert("La marca debe tener menos de 45 carácteres");
    document.getElementById("brand").focus();
    return false;
  }

  if (description.length > 250) {
    alert("La descripción debe tener menos de 250 carácteres");
    document.getElementById("description").focus();
    return false;
  }  
  
  if (year > y) {
    alert("El año debe ser un año calendario (menor o igual a " + y + ")");
    document.getElementById("year").focus();
    return false;
  }

  if(category == 0 || category == "" || category == "Seleccione la categoria") {
    alert("Selecciona una categoria válida");
    document.getElementById("category").focus();
    return false;
  }

  return true;
}

function enviar(){  
  let orthesis = {
    id: +$("#id").val(),
    name: $("#name").val(),
    description: $("#description").val(),
    brand: $("#brand").val(),
    year: +$("#year").val(),
    category: {
      id: +$("#category").val()
    }
  };
    
  $.ajax({
    url: "/api/Ortopedic/update",
    type: 'PUT',
    dataType: 'json',
    headers: {
      "Content-Type": "application/json"
    },
    data: JSON.stringify(orthesis),
    statusCode:{
      201:function(){
        alert('Se ha modificado el registro');
        window.location="./index.html";
      }
    },
  });
}