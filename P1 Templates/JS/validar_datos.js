// validation.js

document.getElementById('signupForm').addEventListener('submit', function(event) {
    // Limpiar errores anteriores
    const errorList = document.getElementById('errorList');
    errorList.innerHTML = '';

    let isValid = true;

    // Función para agregar errores a la lista
    function addError(message) {
        const li = document.createElement('li');
        li.textContent = message;
        errorList.appendChild(li);
    }

    // Validar username
    const username = document.getElementById('username').value;
    if (username.length < 3) {
        addError('Username must be at least 3 characters long.');
        isValid = false;
    }

    // Validar nombre
    const nombre = document.getElementById('nombre').value;
    if (nombre.length < 3) {
        addError('Name must be at least 3 characters long.');
        isValid = false;
    }

    // Validar apellidos
    const apellidos = document.getElementById('apellidos').value;
    if (apellidos.length < 4) {
        addError('Surname must be at least 4 characters long.');
        isValid = false;
    }

    // Validar email
    const email = document.getElementById('email').value;
    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        addError('Please enter a valid email address.');
        isValid = false;
    }

    // Validar password
    const password = document.getElementById('password').value;
    if (password.length < 6) {
        addError('Password must be at least 6 characters long.');
        isValid = false;
    }

    // Validar repeat password
    const r_password = document.getElementById('r_password').value;
    if (r_password !== password) {
        addError('Passwords do not match.');
        isValid = false;
    }

    // Si el formulario no es válido, prevenir el envío
    if (!isValid) {
        event.preventDefault();
        document.getElementsByClassName('container2')[0].style.display = 'block';
    } else {
        document.getElementsByClassName('container2')[0].style.display = 'none';
    }
});
