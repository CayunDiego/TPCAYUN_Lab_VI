function validarAltaCliente() {
    var txtNombre = document.getElementById('txtNombre');
    var txtApellido = document.getElementById('txtApellido');
    var txtDoc = document.getElementById('txtDoc');



    if(txtNombre.value ===""){
        alert("DEBE INGRESAR EL NOMBRE");
        txtNombre.focus();
        return false;
    }

     
    if(txtApellido.value ===""){
        alert("DEBE INGRESAR EL APELLIDO");
        txtApellido.focus();
        return false;
    }


    if (isNaN(parseInt(txtDoc.value))) {
        alert('El campo debe ser un número');
        txtDoc.focus();
        return false;
    }
    return true;
}


function validarAltaArticulo() {
    var txtNombre = document.getElementById('txtNombre');
    var txtPrecio = document.getElementById('txtPrecio');
    var txtStock = document.getElementById('txtStock');

    if(txtPrecio.value ===""){
        alert("DEBE INGRESAR EL PRECIO");
        txtPrecio.focus();
        return false;
    }

    if(txtNombre.value ===""){
        alert("DEBE INGRESAR EL NOMBRE");
        txtNombre.focus();
        return false;
    }

    if (isNaN(parseInt(txtStock.value))) {
        alert('El campo debe ser un número');
        txtStock.focus();
        return false;
    }
    return true;
}


function validarAltaRubro() {
    var txtNombre = document.getElementById('txtNombre');

    if(txtNombre.value ===""){
        alert("DEBE INGRESAR EL NOMBRE RUBRO");
        txtNombre.focus();
        return false;
    }
    return true;
}

function validarAltaVenta() {
    var txtFecha1 = document.getElementById('txtFecha1');
    

    if(txtFecha1.value ===""){
        alert("DEBE INGRESAR EL NOMBRE");
        txtFecha1.focus();
        return false;
    }

     
    return true;
}


function validarAltaVenta(){
    var date  = document.getElementById('txtFecha1');
    var x=new Date();
    var fecha = date.split("/");
    x.setFullYear(fecha[2],fecha[1]-1,fecha[0]);
    var today = new Date();

    if (x >= today)
      return false;
    else
      return true;
}