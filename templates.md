# TEMPLATES PARA JAX-RS, SERVLET Y JSP CON BOOTSTRAP

## Servicios JAX-RS:

### Clase Base Rest

```java
package es.unex.cum.tw.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.naming.NamingException;

@Path("/$clase$")
@Produces(MediaType.APPLICATION_JSON)
public class $clase$RestController {

    private final $claseSer$Service $claseSer$Service;

    public $clase$RestController() throws SQLException, NamingException {
        this.$claseSer$Service = new $claseSer$ServiceJDBCImpl();
    }
}
```

- ### Servicio para eliminar un recurso a través de parámetros(DELETE)

```java
@DELETE
    @Path("/{$param1$}-{$param2$}")
    public Response $metodo$(@PathParam("$param1$") int $param1$, @PathParam("$param2$") int $param2$) {
        try {
            if ($metodoServicio$) {
                return Response.ok("Correcto").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

- ### Servicio para obtener todos los datos de una tabla(GET)

```java
@GET
    public Response getAllCartas() {
        try {
            List<CartaData> cartas = cartaService.findAll();
            if (cartas != null && !cartas.isEmpty()) {
                return Response.ok(cartas).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron cartas").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

- ### Servicio para obtener un recurso a través de un campo pasado como parámetro(GET)

```java
@GET
    @Path("/{id}")
    public Response getCartaByIdUser(@PathParam("id") int id) {
        try {
            CartaData carta = cartaService.findCartaByIdUser(id).orElse(null);
            if (carta != null) {
                return Response.ok(carta).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Carta no encontrada").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

- ### Servicio para hacer añadir un nuevo recurso a la base de datos(POST) a través de un JSON

```java
@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser($clase$ $clase$) {
        try {
            if ($service$) {
                return Response.ok("Agregado exitosamente").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error al agregar").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

- ### Servicio para ``autenticarse`` a través de `FormParam y RequestParam`(POST)

```java
@POST
    @Path("/authenticate")
    public Response authenticateUser(@FormParam("username") String formUsername, @FormParam("password") String formPassword,
                                     @QueryParam("username") String queryUsername, @QueryParam("password") String queryPassword) {
        try {
            String username = formUsername != null ? formUsername : queryUsername;
            String password = formPassword != null ? formPassword : queryPassword;

            if (username == null || password == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Falta el nombre de usuario o la contraseña").build();
            }

            if (service.authenticate(username, password)) {
                return Response.ok("Usuario autenticado correctamente").build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Error, usuario no autenticado").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

- ### Servicio para añadir un recurso a la base de datos mediante uno o varios parámetros(POST)

```java
 @POST
    @Path("/{$param1$}-{$param2$}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response $metodo$(@PathParam("$param1$") int $param1$, @PathParam("$param2$") int $param2$) {
        try {
            if ($metodoServicio$) {
                return Response.ok("Correcto").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

### Servicio para actualizar un recurso(PUT)

```java
@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser($clase$ $clase$) {
        try {
            if ($service$) {
                return Response.ok("Actualizado correctamente").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error al actualizar").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
```

## Repository

- ### Repository General

```java
package es.unex.cum.tw.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean save(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean deleteById(int id) throws SQLException;

    boolean delete(T t) throws SQLException;
}
```

- ### Repository Class

```java
package es.unex.cum.tw.repositories;

public interface $clase$Repository extends Repository<$clase$>{
    
}
```

- ### Repository Implementado

```java
package es.unex.cum.tw.repositories;

import es.unex.cum.tw.util.ConexionBD_DSPool;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public class $clase$RepositoryJDBCImpl implements $clase$Repository {

    private final Connection conn;

    public $clase$RepositoryJDBCImpl() throws SQLException, NamingException {
        conn = ConexionBD_DSPool.getConexionBD();
    }

   
}
```

### Template para cargar datos de un archivo CSV en una tabla

```java
@Override
	public void cargar$clase$ABD() {

		if ($lista$ == null) {
			$lista$ = new ArrayList<>();
			try {
				URL stream = ProductoServiceMemoryImpl.class.getClassLoader().getResource("$lista$.csv");
				if (stream == null) {
					throw new IllegalArgumentException("No se ha encontrado el archivo $lista$.csv");
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(stream.getFile())));
				String stringRead = br.readLine();

				Connection connection = ConexionBD_DSPool.getConexionBD();
				String query = "INSERT INTO $lista$ (idProducto, nombreProd, pathImagen, comentarios) VALUES (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				while (stringRead != null) {
					StringTokenizer st = new StringTokenizer(stringRead, ",");
					// Elimina las comillas dobles
					int id = Integer.parseInt(st.nextToken().replace("\"", ""));
					String nombre = st.nextToken().replace("\"", "");
					String path = st.nextToken().replace("\"", "");
					String Comentarios = st.nextToken().replace("\"", "");

					$lista$.add(new $clase$(id, nombre, path, Comentarios));

					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, nombre);
					preparedStatement.setString(3, path);
					preparedStatement.setString(4, Comentarios);
					preparedStatement.executeUpdate();

					stringRead = br.readLine();
				}
				br.close();
				connection.close();
			} catch (IOException | SQLException | NamingException e) {
				e.printStackTrace();
			}
		}
	}
```

- ### Service

```java
package es.unex.cum.tw.services;

public interface $carta$Service {

}

```

- ### Service Implentado

```java
package es.unex.cum.tw.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.NamingException;

public class $clase$ServiceJDBCImpl implements $clase$Service{

    private final $clase$Repository $clase$Repository;

    public $clase$ServiceJDBCImpl() throws SQLException, NamingException{
        this.$clase$Repository = new $clase$RepositoryJDBCImpl();
    }


    @Override
    public boolean addProductoToCarta(int idUser, int idProducto) {
        return cartaRepository.addProductoToCarta(idUser, idProducto);
    }
}
```

### Url pattern application

```java
package es.unex.cum.tw.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/rest")
public class UrlPatternResource extends Application {

}
```

## Vista JSP con Bootstrap

- ### Página base de JSP con Bootstrap

```html
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>$title$</title>
    
    <!-- Metadatos -->
    <meta name="author" content="Jose Luis Obiang Ela Nanguang">
    <meta name="description" content="$description$">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>
<header>
    <h1>$title$</h1>
<header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
```

- ### Head Bootstrap

```html
<head>
    <title>$title$</title>
    
    <!-- Metadatos -->
    <meta name="author" content="Jose Luis Obiang Ela Nanguang">
    <meta name="description" content="$description$">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
```

- ### Carousel Bootstrap

```html
<section id="carouselExampleDark" class="carousel carousel-dark slide">
    <div class="carousel-indicators">
        <%
            List<$clase$> $lista$ = (List<$clase$>) application.getAttribute("$objeto$"); // Application|session|request
            if ($lista$ != null && !$lista$.isEmpty()) {
                for (int i = 0; i < $lista$.size(); i++) {%>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="<%=i%>" class="<%=i == 0 ? "active" : ""%>" aria-current="<%=i == 0 ? "true" : ""%>" aria-label="Slide <%=(i+1)%>"></button>
        <%}%>
        <%} else {%>
        <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <%}%>
    </div>

    <div class="carousel-inner">
        <%
            if ($lista$ != null && !$lista$.isEmpty()) {
                for (int i = 0; i < $lista$.size(); i++) {%>
        <div class="carousel-item <%= i == 0 ? "active" : ""%>" data-bs-interval="2000">
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400"
                 xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: First slide"
                 preserveAspectRatio="xMidYMid slice" focusable="false"><title><%=$lista$.get(i).%></title>
                <rect width="100%" height="100%" fill="#f5f5f5"></rect>
                <text x="50%" y="16%" fill="#aaa" dy=".3em"><%=libros.get(i).getTitulo()%>
                </text>
            </svg>
            <div class="carousel-caption">
                <img src="<%=$lista$.get(i).%>" alt="Imagen del libro de <%=$lista$.get(i).%>">
                <p><%=$lista$.get(i).%>
                </p>
            </div>
        </div>

        <%}%>
        <%} else {%>
        <div class="carousel-item active" data-bs-interval="2000">
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400"
                 xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: First slide"
                 preserveAspectRatio="xMidYMid slice" focusable="false"><title>Vacío</title>
                <rect width="100%" height="100%" fill="#f5f5f5"></rect>
                <text x="50%" y="50%" fill="#aaa" dy=".3em">No hay nada
                </text>
            </svg>
            <div class="carousel-caption d-none d-md-block">
                <p>No hay nada</p>
            </div>
        </div>
        <%}%>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Anterior</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Siguiente</span>
    </button>
</section>
```

- ### Footer Boostrap

```html
<div class="mt-5 bg-secondary position-relative top-100 d-flex justify-content-center w-100">
    <footer class="text-white py-3">
        <p class="small m-0">&copy; 2024 - Jose Luis Obiang Ela Nanguang</p>
    </footer>
</div>
```

- ### Tabla Bootstrap para mostrar datos de una tabla

```html
<form action="${pageContext.request.contextPath}/" method="get">
    <a href="${pageContext.request.contextPath}/" class="btn btn-primary d-flex justify-content-center align-items-center mt-3"></a>

    <!-- Tabla -->
    <table class="table table-hover table-dark table-striped my-3">
        <thead>
        <tr>
            <th scope="col">$campo1$</th>
            <th scope="col">$campo2$</th>
            <th scope="col">$campo3$</th>
            <th scope="col">$campo4$</th>
            <th scope="col">$operacion$</th>
        </tr>
        </thead>
        <tbody>
        <% List<$clase$> $lista$ = (List<$clase$>) session.getAttribute("$lista$"); %> <!-- Recuperamos la lista -->
        <% for ($clase$ $item$ : $lista$) { %> <!-- Iterar -->
        <tr> <!-- Mostramos datos -->
            <td class="table-active"><%= $item$.getNombre() %>
            </td>
            <td><%= $item$.getApellidos() %>
            </td>
            <td><%= $item$.getEmail() %>
            </td>
            <td><%= $item$.getUsername() %>
            </td>
            <td>
                <label for="delUser" class="visually-hidden"></label> <!-- Creamos un checkbox para eliminar usuarios -->
                <input type="checkbox" id="delUser" name="$eliminarElementos$" value="<%=$item$.getId()%>"> <!-- Pasamos el id del item -->
            </td>

        </tr>
        <% } %>
        </tbody>
    </table>

    <button type="submit" class="btn btn-primary">$operacion$</button>

</form>
```

- ### Script Bootstrap

```html
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
```

- ### Script validation de formulario con bootstrap

```html
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const form = document.getElementById('formulario');

        // Agregar un evento de escucha para el envío del formulario
        form.addEventListener('input', function (event) {
            const inputs = form.querySelectorAll('input'); // Obtener todos los elementos input dentro del formulario

            // Iterar sobre cada input para validarlos
            inputs.forEach(function (input) {
                // Si el input es del campo del username, validar que tenga al menos 3 caracteres
                if (input.name === 'username') {
                    if (input.value.length < 3) {
                        // Si el campo no tiene al menos 3 caracteres, establecer el mensaje de error
                        input.setCustomValidity('El campo debe tener al menos 3 caracteres');
                        input.classList.remove('is-valid');
                        input.classList.add('is-invalid');
                    } else {
                        // Si el campo tiene al menos 3 caracteres, establecer el mensaje de éxito
                        input.setCustomValidity('');
                        input.classList.remove('is-invalid');
                        input.classList.add('is-valid');
                    }
                }

                // Si el input es del campo de la contraseña, validar que tenga al menos 6 caracteres
                if (input.name === 'password') {
                    if (input.value.length < 6) {
                        // Si el campo no tiene al menos 6 caracteres, establecer el mensaje de error
                        input.setCustomValidity('La contraseña debe tener al menos 6 caracteres');
                        input.classList.remove('is-valid');
                        input.classList.add('is-invalid');
                    } else {
                        // Si el campo tiene al menos 6 caracteres, establecer el mensaje de éxito
                        input.setCustomValidity('');
                        input.classList.remove('is-invalid');
                        input.classList.add('is-valid');
                    }
                }


            });

            // Evitar que se envíe el formulario si hay campos inválidos
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        });

        // Agregar eventos de escucha para los cambios en los inputs
        const inputs = form.querySelectorAll('input');
        inputs.forEach(function (input) {
            input.addEventListener('input', function () {
                if (input.checkValidity()) {
                    input.classList.remove('is-invalid');
                    input.classList.add('is-valid');
                } else {
                    input.classList.remove('is-valid');
                    input.classList.add('is-invalid');
                }
            });
        });
    });

</script>
```

- ### Login con Bootstrap Model

```html
<a class="text-decoration-none" data-bs-toggle="modal" href="#staticBackdrop" role="button" aria-controls="staticBackdrop">
                        Inicio de sesión
                    </a>

<div class="modal fade text-black" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title fs-5" id="staticBackdropLabel">Inicio de sesión</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body small">
                <form class="row g-3" id="formulario1" action="${pageContext.request.contextPath}/login" method="post">

                    <div class="col-md-12" id="campo-username">
                        <label for="username1" class="form-label">Usuario</label>
                        <input type="text" class="form-control" id="username1" name="username" required aria-describedby="usernameHelp">
                        <div class="valid-feedback">
                            Genial!
                        </div>
                        <div id="usernameHelp" class="form-text">Debe tener al menos 3 caracteres</div>
                    </div>

                    <div class="col-md-12">
                        <label for="password1" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password1" required>
                        <div class="valid-feedback">
                            Genial!
                        </div>
                        <div id="passwordHelp" class="form-text">Debe tener al menos 6 caracteres</div>
                    </div>
                    <div class="col-12">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="invalidCheck1">
                            <label class="form-check-label" for="invalidCheck1">
                                Acepta los términos y condiciones
                            </label>
                            <div class="invalid-feedback">
                                Debes aceptar antes de enviar.
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer row">
                        <div class="col-3">
                            <button class="btn btn-primary" type="submit" value="login" name="accion" id="login1">
                                Iniciar
                                sesión
                            </button>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>
```

- ### Login con Bootstrap OffCanva

```html
 <a class="text-decoration-none" data-bs-toggle="offcanvas" href="#offcanvasRight" role="button" aria-controls="offcanvasExample">
                        Inicio de sesión
                    </a>
                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight"
                         aria-labelledby="offcanvasRightLabel">

                        <div class="offcanvas-header">
                            <h5 class="offcanvas-title" id="offcanvasRightLabel">Inicio de sesión</h5> <!-- Mostrar el título de inicio de sesión -->
                            <button type="button" class="btn-close d-lg-none" data-bs-dismiss="offcanvas"
                                    aria-label="Close"></button>
                        </div>

                        <div class="offcanvas-body small">
                            <form class="row g-3"

                                  id="formulario" action="${pageContext.request.contextPath}/login"
                                  method="post">

                                <!-- Mostrar el campo de nombre de usuario y contraseña tanto en inicio de sesión como en registro -->
                                <div class="col-md-12" id="campo-username">
                                    <label for="username" class="form-label">Usuario</label>
                                    <input type="text" class="form-control" id="username" name="username" required aria-describedby="usernameHelp">
                                    <div class="valid-feedback">
                                        Genial!
                                    </div>
                                    <div id="usernameHelp" class="form-text">Debe tener al menos 3 caracteres</div>
                                </div>

                                <div class="col-md-12">
                                    <label for="password" class="form-label">Contraseña</label>
                                    <input type="password" class="form-control" id="password" name="password" required aria-describedby="passwordHelp">
                                    <div class="valid-feedback">
                                        Genial!
                                    </div>
                                    <div id="passwordHelp" class="form-text">Debe tener al menos 6 caracteres</div>
                                </div>

                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="invalidCheck">
                                        <label class="form-check-label" for="invalidCheck">
                                            Acepta los términos y condiciones
                                        </label>
                                        <div class="invalid-feedback">
                                            Debes aceptar antes de enviar.
                                        </div>
                                    </div>
                                </div>

                                <div class="col-6">
                                    <button class="btn btn-primary" type="submit" value="login" name="accion" id="login">Iniciar
                                        sesión
                                    </button>
                                </div>

                            </form>
                        </div>
                    </div>
```

- ### Dropdown Bootstrap

```html
<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" type="button" href="#" role="button"
       data-bs-toggle="dropdown" aria-expanded="false">
        Libros reservados
    </a>
    <ul class="dropdown-menu dropdown-menu-dark">
        
            if (session.getAttribute("$existe$") != null) { // Si existe
                List<$clase$> $lista$ = (List<$clase$>) session.getAttribute("$atribute$"); // Obtener
                for ($clase$ $item$ : $lista$) { // Iterar
        <!-- Si el libro está reservado, mostramos el título -->
        <li><a href="#"
               class="dropdown-item"><%=$item$%></a></li>
                <%}%>
            <%} else {%>
                    <li><a class="dropdown-item" href="#">
                        No hay elementos
                    </a></li>
            <%}%>
       
    </ul>

</li>
```
