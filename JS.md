
## Ejercicios

### Ejemplo 1: Temporizador / Cronómetro

```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Temporizador / Cronómetro</title>
</head>
<body>
<div id="display-cronometro">00:00:00</div>
<button id="btn-iniciar">Iniciar</button>
<button id="btn-detener">Detener</button>
<button id="btn-reiniciar">Reiniciar</button>

<script src="script.js"></script>
</body>
</html>
```

```jsx
var cronometro;
var segundos = 0;

function actualizarTiempo() {
    let display = document.getElementById('display-cronometro');
    let horas = Math.floor(segundos / 3600);
    let minutos = Math.floor((segundos - (horas * 3600)) / 60);
    let segundosRestantes = segundos % 60;

    // Formatear el tiempo en HH:MM:SS
    display.textContent =
        (horas < 10 ? '0' : '') + horas + ':' +
        (minutos < 10 ? '0' : '') + minutos + ':' +
        (segundosRestantes < 10 ? '0' : '') + segundosRestantes;
}

document.getElementById('btn-detener').addEventListener('click', function () {
    clearInterval(cronometro);
})

document.getElementById('btn-iniciar').addEventListener('click', function () {
    clearInterval(cronometro);
    cronometro = setInterval(function () {
        segundos++;
        actualizarTiempo();
    }, 1000);
})

document.getElementById('btn-reiniciar').addEventListener('click', function () {
    segundos = 0;
    actualizarTiempo();
})
```

### Ejemplo 2: Búsqueda de término en una lista

```jsx
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Temporizador / Cronómetro</title>
</head>
<body>

<label for="nameFruit">Fruta a buscar:</label>
<input type="text" id="nameFruit" name="fruit">

<ul id="fruits">
    <li>Banana</li>
    <li>Platano</li>
    <li>Manzana</li>
    <li>Limón</li>
    <li>Lima</li>
    <li>Naranja</li>
</ul>
<script src="script.js"></script>
</body>
</html>
```

```jsx
document.getElementById('nameFruit').addEventListener('keyup', function () {
    // Obtener fruta introducida
    let fruit = document.getElementById('nameFruit');
    console.log(fruit.innerText);
    // Obtener lista de frutas
    let fruits = document.getElementById('fruits').getElementsByTagName('li');

    // Recorrer lista de frutas
    for (let i = 0; i < fruits.length; i++) {
        console.log(fruits[i]);
        let newItem = fruits[i].textContent.toLowerCase();
        let newFruit = fruit.value.toLowerCase();

        (newItem.indexOf(newFruit) === -1) ? fruits[i].style.display = 'none' : fruits[i].style.display = '';
    }
})
```

### Ejemplo 3: Cambiar estilos CSS dinámicamente

```jsx
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

</head>
<body>
<div id="miDiv">¡Cámbiame!</div>
<button id="btn-estilo">Cambiar estilo</button>
<script src="script.js"></script>
</body>
</html>
```

```jsx
let miDiv = document.getElementById('miDiv');
document.getElementById('btn-estilo').addEventListener('click', function (){
   miDiv.style.color = 'blue';
   miDiv.style.border = '1px solid red';
   miDiv.style.marginBottom = '12px'
});
```

### Ejemplo 4: Mostrar y ocultar elementos

```html
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

</head>
<body>
<button id="btn-mostrarParrafo">Mostrar parrafo</button>
<p id="parrafo">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum facilis fuga ipsa nam neque nisi possimus quasi suscipit vitae voluptate? A animi culpa deserunt nam nulla, quia reprehenderit tempora temporibus totam unde voluptas voluptatem.</p>

<script src="script.js"></script>
</body>
</html>
```

```jsx
let parrafo = document.getElementById('parrafo')
parrafo.style.display = 'none';
let btn = document.getElementById('btn-mostrarParrafo');

btn.addEventListener('click', function (){
    if(parrafo.style.display === 'none'){
        parrafo.style.display = 'block';
    }else{
        parrafo.style.display = 'none';
    }
})
```

### Ejemplo 5: Añadir, eliminar o vaciar elementos hijo de un elemento padre

```jsx
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

</head>
<body>
<label for="task">Introducir tarea</label><input type="text" id="task">
<button id="btn-addTask">Añadir tarea</button>
<button id="btn-delTask">Eliminar tarea</button>
<button id="btn-clearTasklist">Vaciar lista de tareas</button>

<ul id="taskList"></ul>
<script src="script.js"></script>
</body>
</html>
```

```html
var task;
var taskList = document.getElementById('taskList');

document.getElementById('task').addEventListener('keyup', function (event) {
    task = event.target.value.trim();
})
document.getElementById('btn-addTask').addEventListener('click', function () {
    let exist = false;
    if (taskList.getElementsByTagName('li').length > 0) {
        Array.from(taskList.children).forEach(function (element) {
            if (element.textContent.trim().toLowerCase().indexOf(task.toLowerCase()) !== -1) {
                exist = true;
            }
        })

        if(!exist){
            let item = document.createElement('li');
            item.textContent = task;
            taskList.appendChild(item);
            alert('Añadiendo tarea');

        }else{
            alert('La tarea ya existe');
        }
    } else {
        alert('No hay elementos');
        let item = document.createElement('li');
        item.textContent = task;
        taskList.appendChild(item);
        alert('Añadiendo tarea ' + task);

    }
})

document.getElementById('btn-delTask').addEventListener('click', function () {
    Array.from(taskList.children).forEach(function (element) {
        if (element.textContent.trim().toLowerCase().indexOf(task.toLowerCase()) !== -1) {
            element.remove();
        }
    })
})

document.getElementById('btn-clearTasklist').addEventListener('click', function (){
    taskList.remove();
})
```

### Ejemplo 6: Validar formulario
```html
<!Doctype html>  
  
<html lang="es">  
<head>  
    <title>Repaso de html, css y JS</title>  
    <meta name="author" content="Jose Luis Obiang">  
    <meta charset="UTF-8">  
    <meta name="description" content="Repaso de html, css y JS">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <link rel="stylesheet" href="./styles.css">  
</head>  
  
<body>  
<form action="https://google.com" method="get" id="formulario">  
    <fieldset>  
        <legend>Formulario</legend>  
        <label for="name">Nombre</label>  
        <input type="text" id="name">  
        <span class="error"></span>  
  
        <label for="email">Correo Electrónico</label>  
        <input type="email" id="email">  
        <span class="error"></span>  
  
        <label for="age">Edad</label>  
        <input type="number" id="age">  
        <span class="error"></span>  
        <input type="submit" value="Enviar">  
    </fieldset>  
</form>  
  
<script src="./index.js"></script>  
</body>  
</html>
```

```js
const formulario = document.getElementById("formulario");  
  
formulario.onsubmit = (event) =>{  
    event.preventDefault();  
    const nombre = document.getElementById('name');  
    if(validarInput(nombre, 'nombre')){  
        formulario.submit();  
    }  
}  
  
function validarInput(input, tipo){  
    let valid = true;  
    let mensajeError = '';  
    let valorCampo = input.value.trim();  
    switch (tipo){  
        case "nombre":  
            if(valorCampo === ''){  
                mensajeError = 'El nombre es obligatorio';  
                valid = false;  
            }else if(valorCampo.length < 4){  
                mensajeError = 'El nombre no es valido (debe tener al menos 4 caracteres';  
                valid = false;  
            }  
            break;  
        case 'email':  
            if(valorCampo === ''){  
                mensajeError = 'El email es obligatorio';  
                valid = false;  
            }  
            break;  
        case 'telefono':  
            if(valorCampo === ''){  
                mensajeError = 'El telefono es obligatorio';  
                valid = false;  
            }else if(!/\d{9}/.test(valorCampo)){  
                mensajeError = 'El telefono no es valido (debe tener 9 digitos';  
                valid = false;  
            }  
            break;  
        default:  
            mensajeError = 'Tipo de campo no valido';  
            valid = false;  
    }  
  
    if(!valid){  
        mostrarMensajeError(input, mensajeError);  
    }else{  
        limpiarError(input);  
    }  
  
    return valid;  
}  
  
function mostrarMensajeError(input, mensajeError)  
{  
    const errorElement = input.parentNode.querySelector('.error');  
  
    if(errorElement){  
        errorElement.textContent = mensajeError;  
    }  
}  
  
function limpiarError(input){  
    const errorElement = input.parentNode.querySelector('.error');  
  
  
    if(errorElement){  
        errorElement.textContent = '';  
    }  
}
```
### Ejercicio 7: Aplicar estilos de un archivo css en JS

```jsx
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

</head>
<body>
<link rel="stylesheet" href="estilos.css">
<button id="btn-changeEstilos">Cambiar estilos</button>
<div id="divEstilar">
    <p>Yo solo se que no se nada</p>
</div>
<script src="script.js"></script>
</body>
</html>
```

```css
.container{
    border: 1px solid blue;
    font-weight: bold;
    color: #00bb00;
}
```

```jsx
var btn_changeStyles = document.getElementById('btn-changeEstilos');
var container = document.getElementById('divEstilar');

btn_changeStyles.addEventListener('click', function (){
    container.classList.add('container');
})
```

### Ejemplo 8: Incrementar un contador

```html
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="estilos.css">

</head>
<body>
<div id="displayContador" style="text-align: center; color: blue">0</div>
<div style="text-align: center">
<button id="btn-incrementar">Incrementar</button>
<button id="btn-decrementar">Decrementar</button>
</div>
<script src="script.js"></script>
</body>
</html>
```

```jsx
let contador = 0;
let displayContador = document.getElementById('displayContador');

document.getElementById('btn-incrementar').addEventListener('click', function (){
    contador++;
    displayContador.textContent = Math.pow(contador, 2);
})

document.getElementById('btn-decrementar').addEventListener('click', function (){
    contador--;
    if(contador < 1){
        contador = 0;
    }
    displayContador.textContent = Math.sqrt(contador, 2);
})
```

### Ejemplo 8: Cargar Contenido Asincrónicamente con Fetch API

```html
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="estilos.css">

</head>
<body>
<button id="cargarContenido">Cargar Contenido</button>
<div id="contenido"></div>

<script src="script.js"></script>
</body>
</html>
```

```jsx
document.getElementById('cargarContenido').addEventListener('click', function () {
    fetch('file.txt')
        .then(function (response) {
            return response.text();
        })
        .then(function (texto) {
            let lineas = texto.split('\\n');
            let contenidoConSaltoLinea = lineas.join('<br>');
            document.getElementById('contenido').innerHTML = contenidoConSaltoLinea;

        })
        .catch(function (err) {
            console.error('Error al cargar el contenido: ', err);
        });
});
```

### Ejercicio 9: Convertir un número a una suma y multiplicación de valores

```jsx
function encontrarSolucion(objetivo) {
    function encontrar(actual, historial) {
        if (actual === objetivo) {
            return historial;
        } else if (actual > objetivo) {
            return null;
        } else {
            return encontrar(actual + 5, `(${historial} + 5)`) ||
                encontrar(actual * 3, `(${historial} * 3)`)
        }
    }

    return encontrar(1, '1');
}

console.log(encontrarSolucion(24));
```

### Ejercicio 10: Mostrar usuarios de la api PlaceHolder con procedimientos asíncronos: async/await, callback and Promise.

```html
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="estilos.css">

</head>
<body>
<ul id="usuarios">

</ul>
<script src="script.js"></script>
</body>
</html>
```

```jsx
const listUsers = document.getElementById('usuarios');
async function showUsers(){

        const respuesta = await fetch('<https://jsonplaceholder.typicode.com/users>');
        if(!respuesta.ok){
            throw new Error('Error de conexión a la API. Código de estado: ' + respuesta.statusText);
        }

        const users = await respuesta.json();
        // Recorrer el arreglo de usuarios con iterator
       let usersIterator = users[Symbol.iterator]();
       let next = usersIterator.next();
       while(!next.done){
           let item = document.createElement('li');
           item.textContent = next.value.name;
           listUsers.append(item);
           console.log(next.value.name);
           next = usersIterator.next();
       }

}
showUsers()
.then(success => console.log('Exitoso'))
.catch(error => console.log('Error en la solicitud: ', error.message));
```

```jsx
const listUsers = document.getElementById('usuarios');

function showUsers() {
    fetch('<https://jsonplaceholder.typicode.com/users>')
        .then(response => response.json())
        .then(users => {
            users.forEach((user) => {
                let item = document.createElement('li');
                item.textContent = user.name;
                listUsers.appendChild(item);
            })
        })
        .catch(error => {
            console.log('Error en el fetch: ' + error.message);
        })

}

showUsers();
```

```jsx
const listUsers = document.getElementById('usuarios');

function showUsers(callback) {
    fetch('<https://jsonplaceholder.typicode.com/users>')
        .then(response => response.json())
        .then(users => callback(null, users))
        .catch(error => callback(error, null))

}

showUsers((error, users) =>{
    if(error){
        console.log('Error en el fetch: ', error.message);
    }

    users.forEach((user) => {
        let item = document.createElement('li');
        item.textContent = user.name;
        listUsers.appendChild(item);
    })

    console.log(users);
});
```

### Ejercicio 11: Cambiar color de fondo y borde de un container a través de estilos css de un archivo .css.

```html
<!doctype html>
<html lang="es">
<head>
    <title>repaso</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta name="description" content="Website of review">
    <meta name="keywords" content="html, repaso, css, javaScript">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0,, minimum-scale=1.0,, maximum-scale=1.0">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="estilos.css">

</head>
<body>
<div id="div-container" class="container container1">
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta est hic incidunt nihil non porro, quasi quidem rerum totam veniam? Adipisci asperiores at culpa debitis ea eos id, iusto laudantium nesciunt officiis repellendus velit.</p>
</div>

<button id="cambiarColor" onclick="cambiarColor()">Cambiar color</button>
<script src="script.js"></script>
</body>
</html>
```

```css
.container{
    border: 1px solid blue;
    background-color: darkgoldenrod;
}

.container1{
    border: 2px dashed red;
    background-color: darkgreen;
}
```

```jsx
function cambiarColor() {
    const div_container = document.getElementById('div-container');

    div_container.style.border = div_container.style.border === '1px solid blue' ? '2px dashed red' : '1px solid blue';
    div_container.style.backgroundColor = div_container.style.backgroundColor === 'darkgoldenrod' ? 'darkgreen' : 'darkgoldenrod';

}
```

```jsx
function cambiarColor() {
    const div_container = document.getElementById('div-container');

    if(div_container.classList.contains('container')){
        div_container.classList.remove('container');
        div_container.classList.add('container1');

    }else{
        div_container.classList.remove('container1');
        div_container.classList.add('container');
    }

}
```

### Ejercicio 12: LocalStorage

```jsx

async function getData() {

    const respuesta = await fetch('<https://jsonplaceholder.typicode.com/users>');
    if (!respuesta.ok) {
        throw new Error('Error, no se pudo realizar la petición');
    }

    let users = await respuesta.json();
    localStorage.setItem('Usuarios', JSON.stringify(users));

    // search for a user
    const foundUser = users.find(user => user.id === 1);
    if(foundUser) {
        console.log('User found:', foundUser);
        // remove user from local storage
				users = users.filter(user => user.id !== 1);
        localStorage.setItem('Usuarios', JSON.stringify(users));
    }

}

getData()
    .then(data => {
        console.log('Data saved in local storage')
    })
    .catch(error => console.log(error));
```

```jsx
const response = fetch('<https://jsonplaceholder.typicode.com/users>', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(usuarios => {

        localStorage.setItem('Usuarios', JSON.stringify(usuarios));
        
        const list = document.getElementById('users');
        usuarios.forEach((user) => {
            const listItem = document.createElement('li');
            listItem.append(document.createTextNode(user.name));
            list.appendChild(listItem);
        });

        // search for a user
        const foundUser = usuarios.find(user => user.id === 1);
        if (foundUser) {
            console.log('User found:', foundUser);
            // remove user from local storage
            usuarios = usuarios.filter(user => user.id !== 1);
            localStorage.setItem('Usuarios', JSON.stringify(usuarios));
        } else {
            console.log('Usuario :>> ', foundUser, ' not found');
        }

    })
    .catch(error => {
        console.log('Error: ', error);
    });
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e86d20c9-71fa-4f84-9d30-6b9e890d5f7c/10ee4e5b-9494-459c-8699-54032d33c75c/Untitled.png)

### Ejemplo 13: Mostrar usuarios de la API jsonplaceholder en forma de tabla en el navegador haciendo uso de las dependencias axios(para hacer la solicitud get a la API) y express(para crear el servidor web)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/e86d20c9-71fa-4f84-9d30-6b9e890d5f7c/064a8ec4-ded3-427e-a214-33d0a55b8f3b/Untitled.png)

```jsx
// Importar las librerías necesarias
const axios = require('axios');
const express = require('express');

// Crear una instancia de express
const app = express();

// Definir el puerto
const PORT = 3000;

// Definir una función asíncrona para obtener los usuarios y generar la tabla HTML
async function fetchUsersAndGenerateTable() {
    try {
        // Realizar la solicitud GET a la API
        const response = await axios.get('<https://jsonplaceholder.typicode.com/users>');
        const users = response.data; // Obtener los datos de la respuesta

        // Iniciar la creación de la tabla HTML
        let table = '<table style="border-collapse: collapse; border: 1px solid blue;">';
        table += '<tr><th>Nombre</th><th>Usuario</th><th>Email</th></tr>';

        // Agregar filas a la tabla por cada usuario
        users.forEach(user => {
            table += `<tr><td>${user.name}</td><td>${user.username}</td><td>${user.email}</td></tr>`;
        });

        table += '</table>'; // Cerrar la tabla

        return table; // Devolver la tabla HTML generada
    } catch (error) {
        console.error('Error al obtener los usuarios:', error.message);
        throw error; // Lanzar el error para manejarlo más adelante
    }
}

// Definir la ruta /users y usar la función async directamente en el manejador de ruta
app.get('/users', async (req, res) => {
    try {
        const table = await fetchUsersAndGenerateTable(); // Esperar a que la tabla sea generada
        res.send(table); // Enviar la tabla al cliente
    } catch (error) {
        res.status(500).send('Error al obtener los usuarios'); // Enviar respuesta de error
    }
});

// Iniciar el servidor
app.listen(PORT, () => {
    console.log(`Servidor iniciado en el puerto ${PORT}`);
});
```

```jsx
// Importar las librerías necesarias
const axios = require('axios');
const express = require('express');

// Crear una instancia de express
const app = express();

// Definir el puerto
const PORT = 3000;

// Definir una función para obtener los usuarios y generar la tabla HTML
function fetchUsersAndGenerateTable() {
    return axios.get('<https://jsonplaceholder.typicode.com/users>')
        .then(response => {
            const users = response.data; // Obtener los datos de la respuesta

            // Iniciar la creación de la tabla HTML
            let table = '<table style="border-collapse: collapse; border: 1px solid blue;">';
            table += '<tr><th>Nombre</th><th>Usuario</th><th>Email</th></tr>';

            // Agregar filas a la tabla por cada usuario
            users.forEach(user => {
                table += `<tr><td>${user.name}</td><td>${user.username}</td><td>${user.email}</td></tr>`;
            });

            table += '</table>'; // Cerrar la tabla

            return table; // Devolver la tabla HTML generada
        })
        .catch(error => {
            console.error('Error al obtener los usuarios:', error.message);
            throw new Error('Error al obtener los usuarios'); // Lanzar un nuevo error para manejarlo más adelante
        });
}

// Definir la ruta /users y usar la función que retorna una promesa en el manejador de ruta
app.get('/users', (req, res) => {
    fetchUsersAndGenerateTable()
        .then(table => {
            res.send(table); // Enviar la tabla al cliente
        })
        .catch(error => {
            res.status(500).send(error.message); // Enviar respuesta de error
        });
});

// Iniciar el servidor
app.listen(PORT, () => {
    console.log(`Servidor iniciado en el puerto ${PORT}`);
});
```

### Ejemplo 14: Uso de regex para validación

- Email

```jsx
 

const emailRegex = /^(([^<>()[\\]\\\\.,;:\\s@\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\"]+)*)|(\\".+\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;
const email = 'correoelectronico@gmail.ko';
const matched = email.match(emailRegex);

if(matched === null) {
    console.log('El correo electrónico no es válido');
} else {
    console.log('El correo electrónico es válido');
}
```

```jsx
const emailRegex = /^(([^<>()[\\]\\\\.,;:\\s@\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\"]+)*)|(\\".+\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;

const email = 'correoelectronico@gmail.ko';
const matched = emailRegex.exec(email);
if(!matched) {
    console.log('El correo electrónico no es válido');
} else {
    console.log('El correo electrónico es válido');
}
```

```jsx

function validatePassword(password){
    var regex = /^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,}$/; // Al menos 8 caracteres, 1 mayuscula, 1 minuscula, 1 numero
    return regex.test(password);
}
```

- Form

```jsx
/* eslint-disable no-useless-escape */
document.getElementById('formulario').onsubmit = function (e) {
    e.preventDefault();
    let nameUser = document.getElementById('name');
    let email = document.getElementById('email');
    let password = document.getElementById('password');

    validateForm(nameUser, email, password);
};

function validateForm(nameUser, email, password) {
    if(validateNameUser(nameUser) && validateEmail(email) && validatePassword(password)){
        alert('Formulario enviado');
    }else{
        alert('Formulario no enviado');
        document.getElementById('formulario').classList.add('error');
    }
}

function validateNameUser(username){
    console.log(username.value.length);
    var regex = /^[a-zA-Z].{7,}$/;
    if(regex.test(username.value)){
        username.classList.add('success');
        return true;
    }else{
        console.log('El nombre de usuario solo puede contener letras');
        username.classList.add('error');
    }

    return false;

}

function validateEmail(email){
    var regex = /^(([^<>()[\\]\\\\.,;:\\s@\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\"]+)*)|(\\".+\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;
    if(regex.test(email.value)){
        email.classList.add('success');
        return true;
    }else{
        console.log('El email no es valido');
        email.classList.add('error');
    }

    return false;
}

function validatePassword(password){
    var regex = /^(?=.*[A-Z])(?=.*\\d).{7,}$/; // 8 caracteres, 1 mayuscula, 1 minuscula, 1 numero
    if(regex.test(password.value)){
        password.classList.add('success');
        return true;
    }else{
        console.log('La contraseña no es valida');
        password.classList.add('error');
    }

    return false;
}
```

- Replace

```jsx
let text = 'El perro es marrón, marrón y blanco.';

let replacedText = text.replace(/marrón/, 'negro');

console.log(replacedText); // Salida: "El perro es negro, marrón y blanco."

text = 'El perro es marrón, marrón y blanco.';
replacedText = text.replace(/marrón/g, 'negro');
console.log(replacedText);  // Salida: "El perro es negro, negro y blanco."
```

- Url

```jsx
const url = '<https://www.ejemplo.com/producto/1234?param1=valor1&param2=valor2>';

const urlRegex = /^(?:https?:\\/\\/)?(?:www\\.)?(.*?)(?:\\/.*)?$/;

const matches = urlRegex.exec(url);

if (matches) {
  console.log('Dominio:', matches[1]);
} else {
  console.log('No se pudo extraer el dominio');
}

```

- Fecha

```jsx
const moment = require('moment');
const fecha = '2020-12-31';
let ressult = moment(fecha, 'YYYY-MM-DD', true).isValid();
console.log(ressult);
```

```jsx
const fecha = '2021-12-31';
const validarFecha = (fecha) => isNaN(Date.parse(fecha)) ? 'Fecha no válida' : 'Fecha válida';
console.log(validarFecha(fecha));
```

- Teléfono

```jsx
const regex = /^\\+\\d{2,3}-\\d{3}-\\d{3}-\\d{3}$/;
console.log(regex.test('+34-456-789-012')); // true
console.log(regex.test('123-456-7890')); // false
```

- Número entero

```jsx
**const regex = /^\\d+$/;
console.log(regex.test("123")); // true
console.log(regex.test("abc")); // false**
```

- Número decimal

```jsx
const regex = /^\\d+(\\.\\d+)?$/;
console.log(regex.test("123.45")); // true
console.log(regex.test("abc")); // false
```

### Ejemplo 15: Añadir, eliminar y limpiar lista de usuarios con fetch async usando la API `jsonplaceholder`.

```html
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Repaso de html, css and js</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <meta name="description" content="repaso de html, css and js">
    <link rel="stylesheet" href="estilos.css">

</head>

<body>
    <ul id="listUsers">

    </ul>
    <div class="botones">
        <button class="btn" id="btn-addUser">Añadir Usuario</button>
        <button class="btn" id="btn-dropUser">Eliminar Usuario</button>
        <button class="btn" id="btn-clearUsers">Limpiar lista de Usuarios</button>
    </div>
    <script src="script.js"></script>

</body>

</html>
```

```css
body{
    display: flex;
    

}
#listUsers {
    width: fit-content;
    border-collapse: collapse;
    border-spacing: 0;
    font-size: 1.2em;
    font-family: sans-serif;
    list-style-image: url(ok.svg);
    border: 1px dashed #ccc;
}

.botones{
   display: flex;
   margin-top: 20px;
}

.btn{
    margin: 0 auto;
    border-color: blue;
    cursor: pointer;
    transition: border-color 0.3s ease-in-out;
}

.btn:hover{
    border-color: red;
}

.lineThrough{
    text-decoration: line-through;
    text-decoration-color: red;
}

.newUser{
    color: green;
}
```

```jsx
let listUsers = document.getElementById('listUsers');
async function showUsers() {
    try {
        const users = await fetch('<https://jsonplaceholder.typicode.com/users>');
        const data = await users.json();
        let dataIterator = data[Symbol.iterator]();
        let user = dataIterator.next();
        while (!user.done) {
            let li = document.createElement('li');
            li.appendChild(document.createTextNode(user.value.name));
            listUsers.appendChild(li);
            user = dataIterator.next();
        }

        console.log(data);
    } catch (error) {
        console.log('Error fetching users', error);
    }

}

showUsers();

document.getElementById('btn-addUser').onclick = function () {
    let li = document.createElement('li');
    let nameUser = prompt('Enter user name');
    if (nameUser) {
        li.appendChild(document.createTextNode(nameUser));
        listUsers.appendChild(li);
        li.classList.add('newUser');
    }

};

document.getElementById('btn-dropUser').onclick = function () {
    let nameUser = prompt('Enter user name to remove');
    if (listUsers.children.length > 0) {
        Array.from(listUsers.children).forEach(user => {
            if (user.textContent.toLowerCase() === nameUser.toLowerCase()) {
                user.classList.add('lineThrough');
                setTimeout(() => {
                    listUsers.removeChild(user);
                }, 1000);
            }
        });
    } else {
        console.log('No users to remove');
    }
};

document.getElementById('btn-clearUsers').onclick = function () {
    listUsers.innerHTML = '';
};
```

### Ejemplo 16: Carousel solo con css

```html
<div id="novedades-container">
            <section id="novedades-carousel-slide">
                <h2 class="link-h2">Novedades</h2>
                <div id="carousel">
                    <a href="#libro1"><img src="images/libro-elquijote.jpg" alt="Portada de El Quijote"></a>
                    <a href="">
                        <img src="images/libro-orgulloyprejuicio.png" alt="Portada de Orgullo y Prejuicio"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro2"><img src="images/libro-1984.png" alt="Portada de 1984"></a>
                    <a href="#libro3">
                        <img src="images/libro-El-Señor-de-los-Anillos.png" alt="Portada de El Señor de los Anillos"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro4">
                        <img src="images/libro-El-Codigo-Da-Vinci.png" alt="Portada de El Código Da Vinci"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro5"><img src="images/libro-El-Perfume.png" alt="Portada de El Perfume" aspect-ratio="16/9"></a>
                    <a href="#libro6"><img src="images/libro-El-Hobbit.png" alt="Portada de El Hobbit" aspect-ratio="16/9"></a>
                    <a href="#libro7"><img src="images/libro-El-Alquimista.png" alt="Portada de El Alquimista" aspect-ratio="16/9"></a>
                    <a href="#libro8"><img src="images/libro-El-Circulo.png" alt="Portada de El Círculo" aspect-ratio="16/9"></a>
                    <a href="#libro9"><img src="images/libro-El-Silmarillion.png" alt="Portada de El Silmarillion" aspect-ratio="16/9"></a>
                </div>
            </section>
        </div>
```

```css
#carousel {
    display: flex;
    animation: slide 10s infinite;
}

#carousel img {
    width: 20vw;
    height: 20vh;
    object-fit: cover;
}

#novedades-container {
    position: relative;
    width: 100vw;
    max-width: 80vw;
    overflow: hidden;
    margin: 0 auto;
}

@keyframes slide {
    0% {
        transform: translateX(0);
    }

    100% {
        transform: translateX(-100%);
    }
}

```

### Ejemplo 17: Carousel con js.

```html
<div id="novedades-container">
            <section id="novedades-carousel-slide">
                <h2 class="link-h2">Novedades</h2>
                <div id="carousel">
                    <a href="#libro1"><img src="images/libro-elquijote.jpg" alt="Portada de El Quijote"></a>
                    <a href="">
                        <img src="images/libro-orgulloyprejuicio.png" alt="Portada de Orgullo y Prejuicio"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro2"><img src="images/libro-1984.png" alt="Portada de 1984"></a>
                    <a href="#libro3">
                        <img src="images/libro-El-Señor-de-los-Anillos.png" alt="Portada de El Señor de los Anillos"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro4">
                        <img src="images/libro-El-Codigo-Da-Vinci.png" alt="Portada de El Código Da Vinci"
                            aspect-ratio="16/9">
                    </a>
                    <a href="#libro5"><img src="images/libro-El-Perfume.png" alt="Portada de El Perfume" aspect-ratio="16/9"></a>
                    <a href="#libro6"><img src="images/libro-El-Hobbit.png" alt="Portada de El Hobbit" aspect-ratio="16/9"></a>
                    <a href="#libro7"><img src="images/libro-El-Alquimista.png" alt="Portada de El Alquimista" aspect-ratio="16/9"></a>
                    <a href="#libro8"><img src="images/libro-El-Circulo.png" alt="Portada de El Círculo" aspect-ratio="16/9"></a>
                    <a href="#libro9"><img src="images/libro-El-Silmarillion.png" alt="Portada de El Silmarillion" aspect-ratio="16/9"></a>
                </div>
            </section>
        </div>
```

```css
#carousel {
    display: flex;
    animation: slide 10s infinite;
}

#carousel img {
    width: 20vw;
    height: 20vh;
    object-fit: cover;
}

#novedades-container {
    position: relative;
    width: 100vw;
    max-width: 80vw;
    overflow: hidden;
    margin: 0 auto;
}

@keyframes slide {
    0% {
        transform: translateX(0);
    }

    100% {
        transform: translateX(-100%);
    }
}
```

```jsx
let slideIndex = 0;
const slides = document.querySelectorAll('.carousel-slide img');

function showSlides() {
  for (let i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slideIndex++;
  if (slideIndex > slides.length) {
    slideIndex = 1;
  }
  slides[slideIndex - 1].style.display = 'block';
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}

showSlides();

```

### Ejemplo 17: Animaciones.

```html
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Review html</title>
    <meta name="author" content="Jose Luis Obiang Ela Nanguan">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos.css">
</head>

<body>
    <h1>Review html</h1> 
    <nav>
        <div class="navbar">
          <a
            class="bear-link"
            href="<https://twitter.com/intent/follow?screen_name=jh3yy>"
            target="_blank"
            rel="noreferrer noopener"
          >
            <svg
              class="w-9"
              viewBox="0 0 969 955"
              fill="none"
              xmlns="<http://www.w3.org/2000/svg>"
            >
              <circle
                cx="161.191"
                cy="320.191"
                r="133.191"
                stroke="currentColor"
                stroke-width="20"
              ></circle>
              <circle
                cx="806.809"
                cy="320.191"
                r="133.191"
                stroke="currentColor"
                stroke-width="20"
              ></circle>
              <circle
                cx="695.019"
                cy="587.733"
                r="31.4016"
                fill="currentColor"
              ></circle>
              <circle
                cx="272.981"
                cy="587.733"
                r="31.4016"
                fill="currentColor"
              ></circle>
              <path
                d="M564.388 712.083C564.388 743.994 526.035 779.911 483.372 779.911C440.709 779.911 402.356 743.994 402.356 712.083C402.356 680.173 440.709 664.353 483.372 664.353C526.035 664.353 564.388 680.173 564.388 712.083Z"
                fill="currentColor"
              ></path>
              <rect
                x="310.42"
                y="448.31"
                width="343.468"
                height="51.4986"
                fill="#FF1E1E"
              ></rect>
              <path
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="M745.643 288.24C815.368 344.185 854.539 432.623 854.539 511.741H614.938V454.652C614.938 433.113 597.477 415.652 575.938 415.652H388.37C366.831 415.652 349.37 433.113 349.37 454.652V511.741L110.949 511.741C110.949 432.623 150.12 344.185 219.845 288.24C289.57 232.295 384.138 200.865 482.744 200.865C581.35 200.865 675.918 232.295 745.643 288.24Z"
                fill="currentColor"
              ></path>
            </svg>
          </a>
        </div>
      </nav>
      <header>
        <div class="hero">
          <div class="content">
            <h1>Step up your CSS game,<br /><span>today</span></h1>
            <p>Start your journey and join thousands of others.</p>
            <a
              href="<https://twitter.com/intent/follow?screen_name=jh3yy>"
              target="_blank"
              rel="noreferrer noopener"
              >Start now</a
            >
          </div>
        </div>
        <div class="sticker">
          <div class="content">
            <div class="panel">
              <div class="panel__row">
                <div class="card card--one">
                  <!-- In here we have various moving section on scroll -->
                  <!-- 1. Two side columns and a shifting middle -->
                  <div class="card__column">
                    <div class="card__avatar">
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/526.jpg>"
                        alt=""
                      />
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image headspace">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>Headspace</title>
                          <path
                            d="M23.9711 11.8612c.279 3.8878-1.5272 6.0933-2.6155 7.6357-1.694 1.7856-3.8397 4.2203-9.291 4.3565-4.6237.1827-6.8957-1.8508-8.8034-3.617-2.487-2.7336-3.1366-4.3512-3.261-8.3752-.0118-2.467.9397-4.9292 2.6025-7.0954C4.934 1.4736 8.6408.3699 12.0646.1426c3.5923-.1392 6.4493 1.6723 8.3993 3.624 2.4963 2.632 3.2629 4.8923 3.5054 8.0946Z"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                      <div class="card__dummy">
                        <div class="text-wrap">
                          <div class="text"></div>
                          <div class="text"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company alexa">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Amazon Alexa</title>
                        <path
                          d="M12 0C5.37 0 0 5.37 0 12C0 18.09 4.53 23.11 10.4 23.9V21.5A1.59 1.59 0 0 0 9.32 19.97A8.41 8.41 0 0 1 3.6 11.8A8.37 8.37 0 0 1 12.09 3.6A8.4 8.4 0 0 1 20.4 12.31L20.39 12.38A8.68 8.68 0 0 1 20.36 12.76C20.36 12.83 20.35 12.9 20.34 12.96C20.34 13.04 20.33 13.12 20.32 13.19L20.3 13.29C19.27 20.07 10.45 23.87 10.4 23.9C10.92 23.97 11.46 24 12 24C18.63 24 24 18.63 24 12S18.63 0 12 0Z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel__row">
                <div class="card card--three">
                  <!-- In here we have various moving section on scroll -->
                  <!-- 1. Two side columns and a shifting middle -->
                  <div class="card__column">
                    <div class="card__avatar">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Google Chrome</title>
                        <path
                          fill="#4285F4"
                          d="M12 0C8.21 0 4.831 1.757 2.632 4.501l3.953 6.848A5.454 5.454 0 0 1 12 6.545h10.691A12 12 0 0 0 12 0zM1.931 5.47A11.943 11.943 0 0 0 0 12c0 6.012 4.42 10.991 10.189 11.864l3.953-6.847a5.45 5.45 0 0 1-6.865-2.29zm13.342 2.166a5.446 5.446 0 0 1 1.45 7.09l.002.001h-.002l-5.344 9.257c.206.01.413.016.621.016 6.627 0 12-5.373 12-12 0-1.54-.29-3.011-.818-4.364zM12 16.364a4.364 4.364 0 1 1 0-8.728 4.364 4.364 0 0 1 0 8.728Z"
                        />
                      </svg>
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/430.jpg>"
                        alt=""
                      />
                    </div>
                    <div class="card__dummy">
                      <div class="text-wrap">
                        <div class="text"></div>
                        <div class="text"></div>
                      </div>
                      <div class="cta"></div>
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image youtube">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>YouTube</title>
                          <path
                            d="M23.498 6.186a3.016 3.016 0 0 0-2.122-2.136C19.505 3.545 12 3.545 12 3.545s-7.505 0-9.377.505A3.017 3.017 0 0 0 .502 6.186C0 8.07 0 12 0 12s0 3.93.502 5.814a3.016 3.016 0 0 0 2.122 2.136c1.871.505 9.376.505 9.376.505s7.505 0 9.377-.505a3.015 3.015 0 0 0 2.122-2.136C24 15.93 24 12 24 12s0-3.93-.502-5.814zM9.545 15.568V8.432L15.818 12l-6.273 3.568z"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company slack">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Slack</title>
                        <path
                          d="M5.042 15.165a2.528 2.528 0 0 1-2.52 2.523A2.528 2.528 0 0 1 0 15.165a2.527 2.527 0 0 1 2.522-2.52h2.52v2.52zM6.313 15.165a2.527 2.527 0 0 1 2.521-2.52 2.527 2.527 0 0 1 2.521 2.52v6.313A2.528 2.528 0 0 1 8.834 24a2.528 2.528 0 0 1-2.521-2.522v-6.313zM8.834 5.042a2.528 2.528 0 0 1-2.521-2.52A2.528 2.528 0 0 1 8.834 0a2.528 2.528 0 0 1 2.521 2.522v2.52H8.834zM8.834 6.313a2.528 2.528 0 0 1 2.521 2.521 2.528 2.528 0 0 1-2.521 2.521H2.522A2.528 2.528 0 0 1 0 8.834a2.528 2.528 0 0 1 2.522-2.521h6.312zM18.956 8.834a2.528 2.528 0 0 1 2.522-2.521A2.528 2.528 0 0 1 24 8.834a2.528 2.528 0 0 1-2.522 2.521h-2.522V8.834zM17.688 8.834a2.528 2.528 0 0 1-2.523 2.521 2.527 2.527 0 0 1-2.52-2.521V2.522A2.527 2.527 0 0 1 15.165 0a2.528 2.528 0 0 1 2.523 2.522v6.312zM15.165 18.956a2.528 2.528 0 0 1 2.523 2.522A2.528 2.528 0 0 1 15.165 24a2.527 2.527 0 0 1-2.52-2.522v-2.522h2.52zM15.165 17.688a2.527 2.527 0 0 1-2.52-2.523 2.526 2.526 0 0 1 2.52-2.52h6.313A2.527 2.527 0 0 1 24 15.165a2.528 2.528 0 0 1-2.522 2.523h-6.313z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel__row">
                <div class="card card--two">
                  <!-- In here we have various moving section on scroll -->
                  <!-- 1. Two side columns and a shifting middle -->
                  <div class="card__column">
                    <div class="card__avatar">
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/535.jpg>"
                        alt=""
                      />
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image messenger">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>Messenger</title>
                          <path
                            d="M.001 11.639C.001 4.949 5.241 0 12.001 0S24 4.95 24 11.639c0 6.689-5.24 11.638-12 11.638-1.21 0-2.38-.16-3.47-.46a.96.96 0 00-.64.05l-2.39 1.05a.96.96 0 01-1.35-.85l-.07-2.14a.97.97 0 00-.32-.68A11.39 11.389 0 01.002 11.64zm8.32-2.19l-3.52 5.6c-.35.53.32 1.139.82.75l3.79-2.87c.26-.2.6-.2.87 0l2.8 2.1c.84.63 2.04.4 2.6-.48l3.52-5.6c.35-.53-.32-1.13-.82-.75l-3.79 2.87c-.25.2-.6.2-.86 0l-2.8-2.1a1.8 1.8 0 00-2.61.48z"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company notion">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Notion</title>
                        <path
                          d="M4.459 4.208c.746.606 1.026.56 2.428.466l13.215-.793c.28 0 .047-.28-.046-.326L17.86 1.968c-.42-.326-.981-.7-2.055-.607L3.01 2.295c-.466.046-.56.28-.374.466zm.793 3.08v13.904c0 .747.373 1.027 1.214.98l14.523-.84c.841-.046.935-.56.935-1.167V6.354c0-.606-.233-.933-.748-.887l-15.177.887c-.56.047-.747.327-.747.933zm14.337.745c.093.42 0 .84-.42.888l-.7.14v10.264c-.608.327-1.168.514-1.635.514-.748 0-.935-.234-1.495-.933l-4.577-7.186v6.952L12.21 19s0 .84-1.168.84l-3.222.186c-.093-.186 0-.653.327-.746l.84-.233V9.854L7.822 9.76c-.094-.42.14-1.026.793-1.073l3.456-.233 4.764 7.279v-6.44l-1.215-.139c-.093-.514.28-.887.747-.933zM1.936 1.035l13.31-.98c1.634-.14 2.055-.047 3.082.7l4.249 2.986c.7.513.934.653.934 1.213v16.378c0 1.026-.373 1.634-1.68 1.726l-15.458.934c-.98.047-1.448-.093-1.962-.747l-3.129-4.06c-.56-.747-.793-1.306-.793-1.96V2.667c0-.839.374-1.54 1.447-1.632z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel__row">
                <div class="card card--six">
                  <!-- In here we have various moving section on scroll -->
                  <!-- 1. Two side columns and a shifting middle -->
                  <div class="card__column">
                    <div class="card__avatar">
                      <svg
                        role="img"
                        style="background: white"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Twilio</title>
                        <path
                          fill="#F22F46"
                          d="M12 0C5.381-.008.008 5.352 0 11.971V12c0 6.64 5.359 12 12 12 6.64 0 12-5.36 12-12 0-6.641-5.36-12-12-12zm0 20.801c-4.846.015-8.786-3.904-8.801-8.75V12c-.014-4.846 3.904-8.786 8.75-8.801H12c4.847-.014 8.786 3.904 8.801 8.75V12c.015 4.847-3.904 8.786-8.75 8.801H12zm5.44-11.76c0 1.359-1.12 2.479-2.481 2.479-1.366-.007-2.472-1.113-2.479-2.479 0-1.361 1.12-2.481 2.479-2.481 1.361 0 2.481 1.12 2.481 2.481zm0 5.919c0 1.36-1.12 2.48-2.481 2.48-1.367-.008-2.473-1.114-2.479-2.48 0-1.359 1.12-2.479 2.479-2.479 1.361-.001 2.481 1.12 2.481 2.479zm-5.919 0c0 1.36-1.12 2.48-2.479 2.48-1.368-.007-2.475-1.113-2.481-2.48 0-1.359 1.12-2.479 2.481-2.479 1.358-.001 2.479 1.12 2.479 2.479zm0-5.919c0 1.359-1.12 2.479-2.479 2.479-1.367-.007-2.475-1.112-2.481-2.479 0-1.361 1.12-2.481 2.481-2.481 1.358 0 2.479 1.12 2.479 2.481z"
                        />
                      </svg>
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/332.jpg>"
                        alt=""
                      />
                    </div>
                    <div class="card__dummy">
                      <div class="text-wrap">
                        <div class="text"></div>
                        <div class="text"></div>
                      </div>
                      <div class="grid">
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                      </div>
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image paypal">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>PayPal</title>
                          <path
                            d="M7.016 19.198h-4.2a.562.562 0 0 1-.555-.65L5.093.584A.692.692 0 0 1 5.776 0h7.222c3.417 0 5.904 2.488 5.846 5.5-.006.25-.027.5-.066.747A6.794 6.794 0 0 1 12.071 12H8.743a.69.69 0 0 0-.682.583l-.325 2.056-.013.083-.692 4.39-.015.087zM19.79 6.142c-.01.087-.01.175-.023.261a7.76 7.76 0 0 1-7.695 6.598H9.007l-.283 1.795-.013.083-.692 4.39-.134.843-.014.088H6.86l-.497 3.15a.562.562 0 0 0 .555.65h3.612c.34 0 .63-.249.683-.585l.952-6.031a.692.692 0 0 1 .683-.584h2.126a6.793 6.793 0 0 0 6.707-5.752c.306-1.95-.466-3.744-1.89-4.906z"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company password">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>1Password</title>
                        <path
                          d="M12 .007C5.373.007 0 5.376 0 11.999c0 6.624 5.373 11.994 12 11.994S24 18.623 24 12C24 5.376 18.627.007 12 .007Zm-.895 4.857h1.788c.484 0 .729.002.914.096a.86.86 0 0 1 .377.377c.094.185.095.428.095.912v6.016c0 .12 0 .182-.015.238a.427.427 0 0 1-.067.137.923.923 0 0 1-.174.162l-.695.564c-.113.092-.17.138-.191.194a.216.216 0 0 0 0 .15c.02.055.078.101.191.193l.695.565c.094.076.14.115.174.162.03.042.053.087.067.137a.936.936 0 0 1 .015.238v2.746c0 .484-.001.727-.095.912a.86.86 0 0 1-.377.377c-.185.094-.43.096-.914.096h-1.788c-.484 0-.726-.002-.912-.096a.86.86 0 0 1-.377-.377c-.094-.185-.095-.428-.095-.912v-6.016c0-.12 0-.182.015-.238a.437.437 0 0 1 .067-.139c.034-.047.08-.083.174-.16l.695-.564c.113-.092.17-.138.191-.194a.216.216 0 0 0 0-.15c-.02-.055-.078-.101-.191-.193l-.695-.565a.92.92 0 0 1-.174-.162.437.437 0 0 1-.067-.139.92.92 0 0 1-.015-.236V6.25c0-.484.001-.727.095-.912a.86.86 0 0 1 .377-.377c.186-.094.428-.096.912-.096z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel__row">
                <div class="card card--five">
                  <div class="card__column">
                    <div class="card__avatar">
                      <svg
                        style="background: white"
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Spotify</title>
                        <path
                          fill="#1DB954"
                          d="M12 0C5.4 0 0 5.4 0 12s5.4 12 12 12 12-5.4 12-12S18.66 0 12 0zm5.521 17.34c-.24.359-.66.48-1.021.24-2.82-1.74-6.36-2.101-10.561-1.141-.418.122-.779-.179-.899-.539-.12-.421.18-.78.54-.9 4.56-1.021 8.52-.6 11.64 1.32.42.18.479.659.301 1.02zm1.44-3.3c-.301.42-.841.6-1.262.3-3.239-1.98-8.159-2.58-11.939-1.38-.479.12-1.02-.12-1.14-.6-.12-.48.12-1.021.6-1.141C9.6 9.9 15 10.561 18.72 12.84c.361.181.54.78.241 1.2zm.12-3.36C15.24 8.4 8.82 8.16 5.16 9.301c-.6.179-1.2-.181-1.38-.721-.18-.601.18-1.2.72-1.381 4.26-1.26 11.28-1.02 15.721 1.621.539.3.719 1.02.419 1.56-.299.421-1.02.599-1.559.3z"
                        />
                      </svg>
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1011.jpg>"
                        alt=""
                      />
                    </div>
                    <div class="card__dummy">
                      <div class="text-wrap">
                        <div class="text"></div>
                        <div class="text"></div>
                      </div>
                      <div class="grid">
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                        <div class="grid__panel"></div>
                      </div>
                      <div class="cta"></div>
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image calendly">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>Calendly</title>
                          <path
                            d="M19.655 14.262c.281 0 .557.023.828.064 0 .005-.005.01-.005.014-.105.267-.234.534-.381.786l-1.219 2.106c-1.112 1.936-3.177 3.127-5.411 3.127h-2.432c-2.23 0-4.294-1.191-5.412-3.127l-1.218-2.106a6.251 6.251 0 0 1 0-6.252l1.218-2.106C6.736 4.832 8.8 3.641 11.035 3.641h2.432c2.23 0 4.294 1.191 5.411 3.127l1.219 2.106c.147.252.271.519.381.786 0 .004.005.009.005.014-.267.041-.543.064-.828.064-1.816 0-2.501-.607-3.291-1.306-.764-.676-1.711-1.517-3.44-1.517h-1.029c-1.251 0-2.387.455-3.2 1.278-.796.805-1.233 1.904-1.233 3.099v1.411c0 1.196.437 2.295 1.233 3.099.813.823 1.949 1.278 3.2 1.278h1.034c1.729 0 2.676-.841 3.439-1.517.791-.703 1.471-1.306 3.287-1.301Zm.005-3.237c.399 0 .794-.036 1.179-.11-.002-.004-.002-.01-.002-.014-.073-.414-.193-.823-.349-1.218.731-.12 1.407-.396 1.986-.819 0-.004-.005-.013-.005-.018-.331-1.085-.832-2.101-1.489-3.03-.649-.915-1.435-1.719-2.331-2.395-1.867-1.398-4.088-2.138-6.428-2.138-1.448 0-2.855.28-4.175.841-1.273.543-2.423 1.315-3.407 2.299S2.878 6.552 2.341 7.83c-.557 1.324-.842 2.726-.842 4.175 0 1.448.281 2.855.842 4.174.542 1.274 1.314 2.423 2.298 3.407s2.129 1.761 3.407 2.299c1.324.556 2.727.841 4.175.841 2.34 0 4.561-.74 6.428-2.137a10.815 10.815 0 0 0 2.331-2.396c.652-.929 1.158-1.949 1.489-3.03 0-.004.005-.014.005-.018-.579-.423-1.255-.699-1.986-.819.161-.395.276-.804.349-1.218.005-.009.005-.014.005-.023.869.166 1.692.506 2.404 1.035.685.505.552 1.075.446 1.416C22.184 20.437 17.619 24 12.221 24c-6.625 0-12-5.375-12-12s5.37-12 12-12c5.398 0 9.963 3.563 11.471 8.464.106.341.239.915-.446 1.421-.717.529-1.535.873-2.404 1.034.128.716.128 1.45 0 2.166-.387-.074-.782-.11-1.182-.11-4.184 0-3.968 2.823-6.736 2.823h-1.029c-1.899 0-3.15-1.357-3.15-3.095v-1.411c0-1.738 1.251-3.094 3.15-3.094h1.034c2.768 0 2.552 2.823 6.731 2.827Z"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company bluesky">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>Bluesky</title>
                        <path
                          d="M12 10.8c-1.087-2.114-4.046-6.053-6.798-7.995C2.566.944 1.561 1.266.902 1.565.139 1.908 0 3.08 0 3.768c0 .69.378 5.65.624 6.479.815 2.736 3.713 3.66 6.383 3.364.136-.02.275-.039.415-.056-.138.022-.276.04-.415.056-3.912.58-7.387 2.005-2.83 7.078 5.013 5.19 6.87-1.113 7.823-4.308.953 3.195 2.05 9.271 7.733 4.308 4.267-4.308 1.172-6.498-2.74-7.078a8.741 8.741 0 0 1-.415-.056c.14.017.279.036.415.056 2.67.297 5.568-.628 6.383-3.364.246-.828.624-5.79.624-6.478 0-.69-.139-1.861-.902-2.206-.659-.298-1.664-.62-4.3 1.24C16.046 4.748 13.087 8.687 12 10.8Z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
              <div class="panel__row">
                <div class="card card--four">
                  <!-- In here we have various moving section on scroll -->
                  <!-- 1. Two side columns and a shifting middle -->
                  <div class="card__column">
                    <div class="card__avatar">
                      <img
                        src="<https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/47.jpg>"
                        alt=""
                      />
                    </div>
                  </div>
                  <!-- Inside the content you have two sliding panels -->
                  <div class="card__content">
                    <div class="card__details">
                      <div class="text"></div>
                      <div class="image instagram">
                        <svg
                          role="img"
                          viewBox="0 0 24 24"
                          xmlns="<http://www.w3.org/2000/svg>"
                        >
                          <title>Instagram</title>
                          <path
                            d="M7.0301.084c-1.2768.0602-2.1487.264-2.911.5634-.7888.3075-1.4575.72-2.1228 1.3877-.6652.6677-1.075 1.3368-1.3802 2.127-.2954.7638-.4956 1.6365-.552 2.914-.0564 1.2775-.0689 1.6882-.0626 4.947.0062 3.2586.0206 3.6671.0825 4.9473.061 1.2765.264 2.1482.5635 2.9107.308.7889.72 1.4573 1.388 2.1228.6679.6655 1.3365 1.0743 2.1285 1.38.7632.295 1.6361.4961 2.9134.552 1.2773.056 1.6884.069 4.9462.0627 3.2578-.0062 3.668-.0207 4.9478-.0814 1.28-.0607 2.147-.2652 2.9098-.5633.7889-.3086 1.4578-.72 2.1228-1.3881.665-.6682 1.0745-1.3378 1.3795-2.1284.2957-.7632.4966-1.636.552-2.9124.056-1.2809.0692-1.6898.063-4.948-.0063-3.2583-.021-3.6668-.0817-4.9465-.0607-1.2797-.264-2.1487-.5633-2.9117-.3084-.7889-.72-1.4568-1.3876-2.1228C21.2982 1.33 20.628.9208 19.8378.6165 19.074.321 18.2017.1197 16.9244.0645 15.6471.0093 15.236-.005 11.977.0014 8.718.0076 8.31.0215 7.0301.0839m.1402 21.6932c-1.17-.0509-1.8053-.2453-2.2287-.408-.5606-.216-.96-.4771-1.3819-.895-.422-.4178-.6811-.8186-.9-1.378-.1644-.4234-.3624-1.058-.4171-2.228-.0595-1.2645-.072-1.6442-.079-4.848-.007-3.2037.0053-3.583.0607-4.848.05-1.169.2456-1.805.408-2.2282.216-.5613.4762-.96.895-1.3816.4188-.4217.8184-.6814 1.3783-.9003.423-.1651 1.0575-.3614 2.227-.4171 1.2655-.06 1.6447-.072 4.848-.079 3.2033-.007 3.5835.005 4.8495.0608 1.169.0508 1.8053.2445 2.228.408.5608.216.96.4754 1.3816.895.4217.4194.6816.8176.9005 1.3787.1653.4217.3617 1.056.4169 2.2263.0602 1.2655.0739 1.645.0796 4.848.0058 3.203-.0055 3.5834-.061 4.848-.051 1.17-.245 1.8055-.408 2.2294-.216.5604-.4763.96-.8954 1.3814-.419.4215-.8181.6811-1.3783.9-.4224.1649-1.0577.3617-2.2262.4174-1.2656.0595-1.6448.072-4.8493.079-3.2045.007-3.5825-.006-4.848-.0608M16.953 5.5864A1.44 1.44 0 1 0 18.39 4.144a1.44 1.44 0 0 0-1.437 1.4424M5.8385 12.012c.0067 3.4032 2.7706 6.1557 6.173 6.1493 3.4026-.0065 6.157-2.7701 6.1506-6.1733-.0065-3.4032-2.771-6.1565-6.174-6.1498-3.403.0067-6.156 2.771-6.1496 6.1738M8 12.0077a4 4 0 1 1 4.008 3.9921A3.9996 3.9996 0 0 1 8 12.0077"
                          />
                        </svg>
                      </div>
                      <div class="text"></div>
                      <div class="card__dummy">
                        <div class="text-wrap">
                          <div class="text"></div>
                          <div class="text"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card__column">
                    <div class="card__company x">
                      <svg
                        role="img"
                        viewBox="0 0 24 24"
                        xmlns="<http://www.w3.org/2000/svg>"
                      >
                        <title>X</title>
                        <path
                          d="M18.901 1.153h3.68l-8.04 9.19L24 22.846h-7.406l-5.8-7.584-6.638 7.584H.474l8.6-9.83L0 1.154h7.594l5.243 6.932ZM17.61 20.644h2.039L6.486 3.24H4.298Z"
                        />
                      </svg>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="scroller">
          <div class="content">
            <div class="panel">
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
              <div></div>
            </div>
          </div>
        </div>
        <div class="ring ring--under">
          <img src="<https://assets.codepen.io/605876/portal-ring.png?format=auto&quality=2>" alt="" />
        </div>
        <div class="ring ring--over">
          <img src="<https://assets.codepen.io/605876/portal-ring.png?format=auto&quality=2>" alt="" />
        </div>
      </header>
      <main>
        <section>
          <h2>Pretty rad.</h2>
        </section>
      </main>
      <footer>ʕ•ᴥ•ʔ jhey &copy; 2024</footer>
    <script src="server.js"></script>
</body>

</html>
```

```css
*,
*:after,
*:before {
  box-sizing: border-box;
}

:root {
  --border: hsl(0 0% 80%);
  --card: hsl(0 0% 98%);
  --element: hsl(0 0% 90%);
  --accent: hsl(240 38% 60%);
  --panel: hsl(240 38% 98%);
}

html {
  color-scheme: light only;
}

body {
  min-height: 100vh;
  font-family: 'SF Pro Text', 'SF Pro Icons', 'AOS Icons', 'Helvetica Neue',
    Helvetica, Arial, sans-serif, system-ui;
  timeline-scope: --scroller;
  overflow-x: hidden;
}

body::before {
  --size: 60px;
  --line: hsl(0 0% 0% / 0.15);
  content: '';
  height: 100vh;
  width: 100vw;
  position: fixed;
  background: linear-gradient(
        90deg,
        var(--line) 1px,
        transparent 1px var(--size)
      )
      50% 50% / var(--size) var(--size),
    linear-gradient(var(--line) 1px, transparent 1px var(--size)) 50% 50% /
      var(--size) var(--size);
  mask: linear-gradient(-15deg, transparent 30%, white);
  top: 0;
  transform-style: flat;
  pointer-events: none;
  z-index: -1;
}

header {
  min-height: 200vh;
  position: relative;
  width: 100%;
}

footer {
  padding: 1rem;
  display: grid;
  place-items: center;
}

h1 {
  margin: 0;
  font-size: clamp(3rem, 4.5vw + 1rem, 10rem);
  width: 20ch;
  max-width: 100vw;
  font-weight: 800;
  text-wrap: balance;
  text-align: center;
}

h1 span {
  color: hsl(260 80% 50%);
}

h2 {
  margin: 0;
  font-size: clamp(1.5rem, 3vw + 1rem, 8rem);
}

section {
  display: grid;
  place-items: center;
  min-height: 100vh;
}

nav {
  position: fixed;
  top: 0;
  padding: 0.25rem;
  width: 100%;
  backdrop-filter: blur(10px);
  z-index: 20;
}

.navbar {
  justify-content: center;
  margin: 0 auto;
  display: flex;
  width: 80ch;
  max-width: 100%;
}

nav button {
  width: 44px;
  aspect-ratio: 1;
}

.hero {
  top: 0;
  left: 0;
  right: 0;
  min-height: 100vh;
  width: 100vw;
  display: grid;
  place-items: center;
  z-index: 3;
  padding-top: 2rem;
}

@supports(animation-timeline: scroll()) {
  .hero {
    position: absolute;
  }
}

.sticker {
  width: 100%;
  min-height: 100vh;
  position: sticky;
  top: 0;
  z-index: 2;
}

.scroller {
  position: relative;
  min-height: 200vh;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  view-timeline: --scroller;
}

.content {
  width: 100%;
  min-height: 100vh;
  display: flex;
  place-items: center;
  justify-content: center;
  flex-direction: column;
  gap: 1rem;
}

.hero p {
  font-size: 1.25rem;
  max-width: 75%;
  text-align: center;
  margin: 0 auto;
}

.hero a {
  color: canvas;
  background: var(--accent);
  text-decoration: none;
  padding: 1rem 2rem;
  border-radius: 100px;
  font-weight: bold;
  position: relative;
}

.hero a::after {
  content: "";
  position: absolute;
  inset: 0;
  background: hsl(0 0% 100% / 0);
}

.hero a:is(:hover, :focus-visible)::after {
  background: hsl(0 0% 100% / 0.1);
}

.panel {
  width: clamp(320px, 50vw, 750px);
/*  width: 680px;*/
  max-width: calc(100vw - 2rem);
  border-radius: 18px;
  border: 2px solid var(--accent);
  display: grid;
  grid-template-rows: repeat(6, 60px);
  gap: 1rem;
  text-align: center;
  padding: 2rem;
  box-shadow: 0 32px 32px rgba(23,22,24,.04),0 16px 16px rgba(23,22,24,.04),0 8px 8px rgba(23,22,24,.04);
}

.scroller .panel {
  background: var(--panel);
}

/*@media (max-width: 768px) {
  .panel {
    padding: 1rem;
  }
}*/

.panel__row {
  container-type: size;
  display: flex;
  justify-content: center;
}

.panel {
  --span: max(45vw, 260px);
}

.scroller .panel div {
  display: none;
}

main {
  height: 100vh;
}

h1 {
  margin: 0;
  line-height: 1;
}

.sticker .panel {
  border-color: transparent;
  background: transparent;
  box-shadow: none;
}

/* Card wizardry */
:root {
  --entity-size: 30px;
}

.card {
  display: flex;
  align-items: start;
  height: 100%;
  width: 100%;
  border-radius: 12px;
  overflow: hidden;
  height: 100cqh;
  background: var(--card);
  border: 1px solid var(--border);
  box-shadow:
    0 3px 4px rgba(23,22,24,.04),
    0 1px 2px rgba(23,22,24,.04);
}

.card__column {
  width: 100cqh;
  height: 100cqh;
  display: grid;
  place-items: center;
  position: relative;
}

.card__column:last-of-type {
  align-self: flex-end;
}

.card__avatar {
  height: var(--entity-size);
  aspect-ratio: 1;
  background: var(--element);
  border-radius: 50%;
  position: relative;
  overflow: hidden;
}

.card__avatar * {
  position: absolute;
  inset: 0;
  width: 100%;
  object-fit: cover;
}

.card__avatar img {
  z-index: 2;
  animation: fade-in both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

.image svg {
  width: 50%;
}

@keyframes fade-in {
  0%, 50% { opacity: 0; }
}

.card--one .card__column:first-of-type,
.card--four .card__column:first-of-type,
.card--two .card__column:first-of-type {
  align-self: center;
}
.card__content {
  flex: 1;
}

.card__details {
  height: 100cqh;
  display: flex;
  align-items: center;
  gap: 1rem;
  max-width: 58cqi;
  position: relative;
}

.card__dummy .text {
  flex: 0 1 auto;
}

.card--one .card__dummy,
.card--four .card__dummy {
  padding-left: 2rem;
}

.card--one .card__dummy .text:first-of-type,
.card--four .card__dummy .text:first-of-type {
  width: 85%;
}
.card--one .card__dummy .text:last-of-type,
.card--four .card__dummy .text:last-of-type {
  width: 55%;
}

.card__dummy {
  height: 160cqh;
  width: 100%;
  position: absolute;
  top: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 0.5rem;
}

.text {
  height: 0.8rem;
  background: var(--element);
  border-radius: 100px;
  flex: 1;
}

.image {
  height: var(--entity-size);
  aspect-ratio: 1;
  background: var(--element);
  border-radius: 50%;
  overflow: hidden;
  display: grid;
  place-items: center;
}

.card__company {
  height: var(--entity-size);
  aspect-ratio: 1;
  background: var(--element);
  border-radius: 50%;
  overflow: hidden;
  display: grid;
  place-items: center;
}

.youtube {
  background: #FF0000;
}
.slack {
  background: #4A154B;
}
.headspace {
  background: #F47D31;
}
.alexa {
  background: #00CAFF;
}
.messenger {
  background: #00B2FF;
}
.notion {
  background: #000000;
}
.paypal {
  background: #003087;
}
.password {
  background: #3B66BC;
}
.password svg {
  animation: fade-in both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}
.bluesky {
  background: #0285FF;
}
.calendly {
  background: #006BFF;
}
.instagram {
  background: #E4405F;
}
.x {
  background: #000000;
}

:where(.image, .card__company) path {
  fill: white;
}

/*.card__content div:*/

.card__company svg {
  width: 50%;
}

/* Animations */
@supports (animation-timeline: scroll()) {
  .card--one {
    --x: calc(var(--span) * -1);
    --y: -10%;
    --r: -8deg;
    --h: 160%;
    --w: max(55cqi, 320px);
  }

  .card--two {
    --x: calc(var(--span) * -1);
    --y: -30%;
    --r: 6deg;
    --h: 300%;
    --w: max(55cqi, 330px);
  }

  .card--three {
    --x: calc(var(--span) * 1);
    --y: -50%;
    --r: 15deg;
    --h: 360%;
    --w: max(30cqi, 220px);
  }

  .card--four {
    --x: calc(var(--span) * 1);
    --y: 10%;
    --r: 10deg;
    --h: 160%;
    --w: max(55cqi, 320px);
  }

  .card--five {
    --x: calc(var(--span) * -1);
    --y: -45%;
    --r: -20deg;
    --h: 525%;
    --w: max(30cqi, 160px);
  }

  .card--six {
    --x: calc(var(--span) * 1);
    --y: -30%;
    --r: -5deg;
    --h: 400%;
    --w: max(45cqi, 305px);
  }
  
  .card {
    animation: grow both linear;
    animation-timeline: --scroller;
    animation-range: entry 0% exit 0%;
  }
}

.card__content {
  animation: slide both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

.card--one .card__avatar,
.card--four .card__avatar {
  --s: 2;
  transform-origin: 0 50%;
  animation: morph both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

.card--two .card__avatar {
  position: absolute;
  z-index: 4;
  left: 1rem;
  animation: shrink both linear;
  width: var(--entity-size);
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
  max-width: calc(100cqi - 2rem);
}

.card--two .card__column:last-of-type,
.card--three .card__column:last-of-type,
.card--five .card__column:last-of-type {
  align-self: flex-start;
  animation: slide both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

.card--six .card__column:last-of-type {
  align-self: start;
  width: auto;
  min-width: 60px;
}
.card--six .card__column:last-of-type .card__company {
  animation: cta-morph both linear, color-in both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
  border-radius: 100px;
  width: var(--entity-size);
}
@keyframes cta-morph {
  0%, 30% {
    translate: -1rem 0;
    width: 120px;
  }
}
@keyframes color-in {
  0%, 50% {
    background: var(--element);
  }
}

/*.card--five {
  overflow: visible;
}*/

/*.card--five .cta {
  animation: none;
  scale: 1;
}*/

.card--three .card__dummy,
.card--five .card__dummy,
.card--six .card__dummy {
  width: 30cqi;
  min-width: 220px;
  position: absolute;
  left: 0;
  top: 100%;
  height: 260%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 1rem;
}

.card--five .card__dummy {
  height: 425%;
}

.card--six .card__dummy {
  height: 280%;
}

.card--three .text:last-of-type {
  width: 45%;
}

.card--five .card__dummy,
.card--six .card__dummy {
  gap: 1rem;
  width: 34cqi;
  animation: expand both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

.card--six .card__dummy {
  --w: 250px;
}

.card--six .grid__panel {
  aspect-ratio: 2 / 1;
}

@keyframes expand {
  0%, 30% {
    width: var(--w, 26cqi);
  }
}

.text-wrap {
  display: grid;
  gap: 0.5rem;
  max-width: 65%;
}

.text-wrap :first-child { width: 100%; }
.text-wrap :last-child { width: 80%; }

.grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 0.75rem;
  width: calc(100% - 4rem);
}

.grid__panel {
  aspect-ratio: 1;
  background: var(--element);
  border-radius: 12px;
}

.cta {
  height: var(--entity-size);
  width: 60%;
  background: var(--accent);
  border-radius: 100px;
  scale: 0;
  --s: 1;
  animation: morph both linear;
  animation-timeline: --scroller;
  animation-range: entry 0% exit 0%;
}

@keyframes shrink {
  0%, 30% {
    width: calc(var(--w) - 2rem);
    border-radius: 12px;
    height: calc(300cqh - 2rem);
  }
  85% {
    height: var(--entity-size);
    width: var(--entity-size);
  }
}

.ring {
  position: absolute;
  top: 50%;
  left: 0;
  width: 100%;
  translate: 0 0%;
}

.ring--over {
  z-index: 10;
}

.ring--over img {
  clip-path: inset(50% 0 0 0);
}

.ring img {
  filter: hue-rotate(30deg);
  width: 100%;
  min-width: 700px;
  max-width: 1400px;
  position: absolute;
  top: 0;
  left: 50%;
  translate: -50% -50%;
  object-fit: cover;
}

@keyframes grow {
  0% {
    translate: var(--x, 0) var(--y, 0);
    height: var(--h, 100%);
    rotate: var(--r, 0);
    width: var(--w, 10cqi);
  }
  15% {
    rotate: var(--r, 0);
  }
  30% {
    rotate: 0deg;
    height: var(--h, 100%);
    width: calc(var(--w, 10cqi));
    translate: 0 var(--y, 0);
  }
}

@keyframes morph {
  0% {
    scale: var(--s);
  }
}

@keyframes slide {
  0%,
  30% {
    translate: 0 -100cqh;
  }
  100% {
    translate: 0 0;
  }
}

.bear-link {
  color: canvasText;
  width: 48px;
  aspect-ratio: 1;
  display: grid;
  place-items: center;
  opacity: 0.8;
}

:where(.x-link, .bear-link):is(:hover, :focus-visible) {
  opacity: 1;
}
.bear-link svg {
  width: 75%;
}
```

### Ejemplo de uso de la API de [google books](https://developers.google.com/books/docs/v1/using?hl=es-419)

```html
<html>
  <head>
    <title>Books API Example</title>
  </head>
  <body>
    <div id="content"></div>
    <script>
      function handleResponse(response) {
      for (var i = 0; i < response.items.length; i++) {
        var item = response.items[i];
        // in production code, item.text should have the HTML entities escaped.
        document.getElementById("content").innerHTML += "<br>" + item.volumeInfo.title;
        // Obtener la imagen de la portada
        document.getElementById("content").innerHTML += "<br><img src='" + item.volumeInfo.imageLinks.thumbnail + "'/>";

      }
    }
    </script>
    <script src="<https://www.googleapis.com/books/v1/volumes?q=3+ficcion&callback=handleResponse>"></script>
  </body>
</html>
```

```jsx
async function fetchBooks(searchTerm) {
  const baseUrl = "<https://www.googleapis.com/books/v1/volumes?q=>";
  const url = `${baseUrl}${searchTerm}`; // Replace HANDLE_RESPONSE with a unique identifier (avoid conflicts)

  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Error fetching books: ${response.status}`);
    }

    const data = await response.json();
    if(!data.items) {
        // modificar searchTerms a "getRandomInt(100)+ficcion" para obtener libros aleatorios
        fetchBooks(`${getRandomInt(100)}+ficcion`);
    }

    handleBooks(data.items[getRandomInt(data.items.length)]); // Call the function to handle the data
  } catch (error) {
    console.error("Error:", error);
  }
}

function handleBooks(item) {
  const content = document.getElementById("content");
  content.innerHTML = ""; // Clear previous content

  const title = item.volumeInfo.title;
  const imageUrl = item.volumeInfo.imageLinks?.thumbnail; // Use optional chaining to handle missing image link

  content.innerHTML += `<br><h3>${title}</h3>`;
  if (imageUrl) {
    content.innerHTML += `<br><img src="${imageUrl}" alt="${title} book cover" />`;
  }

}

// Obtener número aleatorio
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

// Call the function with your search term (escape special characters if needed)
fetchBooks("wqdf intitle:keyes&maxResoults=1"); // Example search term

// Crea una función que dado un nombre de libro obtenido a través del input de id inputSearch, realice una búsqueda de libros en la API de Google y muestre los resultados en la página. El nombre del libro no tiene por qué ser exacto, puede ser parcial o incluso una palabra clave.

```

```jsx
async function fetchBooks() {
  clearBooks();

  const inputSearch = document.getElementById("buscarLibro");
  const searchTerm = inputSearch.value; // Get the value from the input element

  const baseUrl = "<https://www.googleapis.com/books/v1/volumes?q=>";
  const url = `${baseUrl}${searchTerm}`; // Replace HANDLE_RESPONSE with a unique identifier (avoid conflicts)

  try {
    const response = await fetch(url);
    if (!response.ok) {
      throw new Error(`Error fetching books: ${response.status}`);
    }

    const data = await response.json();
    if (!data.items) {
      // Si no hay libros, obtener libro aleatorio
      // Lista de categorías de libros
      const categories = ["fiction", "history", "science", "mystery"];
      fetchBooks(
        `${getRandomInt(100)}${categories[getRandomInt(categories.length)]}`
      );
    }

    handleBooks(data.items); // Call the function to handle the data
  } catch (error) {
    console.error("Error:", error);
  }
}

// Función para limpiar los libros
function clearBooks() {
  const libros = document.getElementById("libros");
  libros.innerHTML = "";
}

function handleBooks(items) {
  const libros = document.getElementById("libros");
  // Recorrer los libros y crear un elemento para cada uno con la información relevante como el titulo, la description y la imagen
  items.forEach((item) => {
    const book = document.createElement("div");

    const title = document.createElement("h2");
    title.textContent = "Titulo:" + item.volumeInfo.title;
    book.appendChild(title);

    const description = document.createElement("p");
    description.textContent = "Descripcion:" + item.volumeInfo.description;
    book.appendChild(description);

    const image = document.createElement("img");
    image.src = item.volumeInfo.imageLinks?.thumbnail;
    book.appendChild(image);

    libros.appendChild(book);
  });
}

// Obtener número aleatorio
function getRandomInt(max) {
  return Math.floor(Math.random() * max);
}

```

```html
<html>

<head>
  <title>Books API Example</title>
</head>

<body>
  <div>
    <label for="buscarLibro">Busca un libro</label>
    <input type="text" id="buscarLibro">
    <button onclick="fetchBooks()">Buscar</button>
  </div>
  <div id="libros"></div>
  <script src="script.js"></script>
</body>

</html>
```

- Obtener url de imagen de un libro de google libros y almacenarla en el valor de un input y al hacer submit no enviar el formulario.
    
    ```jsx
    async function fetchBooks() {
      const inputLibro = document.getElementById("inputLibro");
      const searchTerm = inputLibro.value;
    
      const baseUrl = "<https://www.googleapis.com/books/v1/volumes?q=>";
      const url = `${baseUrl}${searchTerm}`;
    
      try {
        const response = await fetch(url);
        if (!response.ok) {
          throw new Error(`Error fetching books: ${response.status}`);
        }
    
        const data = await response.json();
    
        console.log(inputLibro.value);
        handleBooks(data.items[0]); // Call the function to handle the data
      } catch (error) {
        console.error("Error:", error);
      }
    }
    
    function handleBooks(item) {
      const inputLibro = document.getElementById("inputLibro");
    
      const urlImg = item.volumeInfo.imageLinks?.thumbnail;
    
      inputLibro.value = urlImg;
    
      console.log(inputLibro.value);
    }
    
    // Obtener número aleatorio
    function getRandomInt(max) {
      return Math.floor(Math.random() * max);
    }
    
    async function submitForm(event) {
      event.preventDefault();
      await fetchBooks();
    
      return false;
    }
    ```
    
- Obtener url de imagen de un libro de google libros y almacenarla en el valor de un input y al hacer submit enviar el formulario
    
    ```jsx
    async function fetchBooks() {
      const inputLibro = document.getElementById("inputLibro");
      const searchTerm = inputLibro.value;
    
      const baseUrl = "<https://www.googleapis.com/books/v1/volumes?q=>";
      const url = `${baseUrl}${searchTerm}`;
    
      try {
        const response = await fetch(url);
        if (!response.ok) {
          throw new Error(`Error fetching books: ${response.status}`);
        }
    
        const data = await response.json();
        return data.items[0]; // Devolver el primer elemento de los resultados
      } catch (error) {
        console.error("Error:", error);
      }
    }
    
    async function submitForm(event) {
      event.preventDefault(); // Prevenir el envío estándar del formulario
    
      const form = document.getElementById("formulario");
      const isValid = form.checkValidity(); // Verificar la validez del formulario
    
      if (isValid) {
        const bookData = await fetchBooks(); // Obtener datos del libro
    
        if (bookData) {
          const inputLibro = document.getElementById("inputLibro");
          const urlImg = bookData.volumeInfo.imageLinks?.thumbnail;
          inputLibro.value = urlImg; // Establecer el valor del campo de imagen con la URL de la imagen del libro
        }
    
        form.submit(); // Enviar el formulario después de obtener y procesar los datos
      }
    
      return false; // Evitar el envío estándar del formulario
    }
    ```
    
- Obtener la url de imagen de un libro de google books y mostrarla en una lista
    
    - html
        
        ```html
        <html>
        
        <head>
          <title>Books API Example</title>
          <!-- Bootstrap CSS -->
          <link href="<https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css>" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
          <link href="<https://getbootstrap.com/docs/5.3/assets/css/docs.css>" rel="stylesheet">
        
          <!-- Bootstrap Icons -->
          <link rel="stylesheet" href="<https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css>">
        </head>
        
        <body class="bg-dark text-white">
          <form class="container mt-5" id="form" onsubmit="return submitForm(event)" action="<https://doodles.google/>">
            <div class="row">
              <div class="col-8">
                <input type="text" class="form-control" id="inputLibro" placeholder="Search for a book" name="" />
              </div>
              <div class="col-4">
                <button type="submit" class="btn btn-primary w-100">
                  Search
                </button>
              </div>
        
            </div>
          </form>
        
          <ul id="lista"></ul>
          <script src="obtenerLibroGoogleBooks.js"></script>
        </body>
        
        </html>
        
        ```
        
    - js
        
        ```jsx
        async function fetchBooks() {
          const inputLibro = document.getElementById("inputLibro");
          const searchTerm = inputLibro.value;
        
          const baseUrl = "<https://www.googleapis.com/books/v1/volumes?q=>";
          const url = `${baseUrl}${searchTerm}`;
        
          try {
            const response = await fetch(url);
            if (!response.ok) {
              throw new Error(`Error fetching books: ${response.status}`);
            }
        
            const data = await response.json();
        
            console.log(inputLibro.value);
            handleBooks(data.items[0]); // Call the function to handle the data
          } catch (error) {
            console.error("Error:", error);
          }
        }
        
        function handleBooks(item) {
          const inputLibro = document.getElementById("inputLibro");
        
          const urlImg = item.volumeInfo.imageLinks?.thumbnail;
        
          // Crear una lista para almacenar inputLibro.value en cada elemento
          const lista = document.getElementById("lista");
          const li = document.createElement("li");
          li.appendChild(document.createTextNode(urlImg));
          lista.appendChild(li);
          inputLibro.value = "";
        
        }
        
        async function submitForm(event) {
          event.preventDefault();
          await fetchBooks();
        
          return false;
        }
        ```