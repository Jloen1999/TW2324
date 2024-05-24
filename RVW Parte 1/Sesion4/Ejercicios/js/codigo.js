var errores = "";

function validacion(){
    // Reiniciar la variable errores
    errores = "";
    
    var valor = document.getElementById("name").value;
    var date = document.getElementById("datetime").value;
    var dni = document.getElementById("dni").value;
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    var apellidos = document.getElementById("apellido").value; // Aquí debería ser "var apellidos" en lugar de solo "apellidos"
    
    //name
    if (valor == null || valor.length == 0 || /^\s+$/.test(valor)) {
        errores = errores + "| Nombre no introducido";
    }
    //date
    if (date.trim() === "") {
        errores = errores + " | Por favor, introduzca su fecha de nacimiento.";
    } else if (!/^\d{2}-\d{2}-\d{2}$/.test(date)) {
        errores = errores + " | El formato de la fecha de nacimiento debe ser dd-mm-yy.";
    }
    //dni
    if (!(/^\d{8}[A-Z]$/.test(dni))) {
        errores = errores + " | Formato de DNI incorrecto";
    } else if (dni.charAt(8) != letras[(dni.substring(0, 8)) % 23]) {
        errores = errores + " | DNI incorrecto";
    }
    //apellido
    var apellidos2 = apellidos.trim().split(" ");
    if (apellidos.trim() === "" || apellidos2.length < 2){
        errores = errores + "| Debe ingresar al menos dos apellidos.";
    }
    
    if(errores != ""){
        console.log(errores);
        alert(errores);
        return false;
    }
    return true;
}
