# Prácticas de repaso de JavaScript con HTML5 Y CSS3.
- José Luis Obiang Ela Nanguang.
- Antonio Calvo

## Práctica Servlet, JS, HTML5 y CSS3
### Enunciado de Práctica: Sistema de Gestión Bancaria con Servlets y JDBC
Desarrollar una aplicación web utilizando Servlets, JDBC y JSP para gestionar una base de datos de un banco. La aplicación permitirá realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las cuentas bancarias y las transacciones. Además, se implementará autenticación de usuarios administradores para gestionar las cuentas y transacciones.
---
#### Requisitos del Proyecto
**Base de Datos**  

Nombre de la base de datos: Banco

Tablas: Cuentas, transacciones, usuarios y usuarios_cuentas


```sql
CREATE DATABASE BancoGestionDB;

USE BancoGestionDB;

CREATE TABLE cuentas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
  saldo DECIMAL(15, 2) NOT NULL,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transacciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_cuenta INT NOT NULL,
  monto DECIMAL(10, 2) NOT NULL,
  tipo_transaccion VARCHAR(10) NOT NULL,
  fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_cuenta) REFERENCES cuentas(id)
);

CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
  contrasena VARCHAR(50) NOT NULL
);

CREATE TABLE usuarios_cuentas (
  id_usuario INT NOT NULL,
  id_cuenta INT NOT NULL,
  PRIMARY KEY (id_usuario, id_cuenta),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (id_cuenta) REFERENCES cuentas(id)
);

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('juanp', 'password1');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('mariag', 'password2');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('carloss', 'password3');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('anar', 'password4');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('luisf', 'password5');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('martal', 'password6');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('josem', 'password7');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('laurag', 'password8');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('pedrog', 'password9');
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES ('carmend', 'password10');

-- Insertar datos en la tabla cuentas
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('1234567890', 5000.00);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('2345678901', 3000.50);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('3456789012', 1200.75);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('4567890123', 9500.00);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('5678901234', 870.00);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('6789012345', 15000.00);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('7890123456', 2250.25);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('8901234567', 3400.00);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('9012345678', 4100.75);
INSERT INTO cuentas (numero_cuenta, saldo) VALUES ('0123456789', 7600.50);

-- Insertar datos en la tabla transacciones
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (1, 1500.00, 'depósito');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (2, 500.00, 'retiro');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (3, 300.00, 'depósito');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (4, 1000.00, 'retiro');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (5, 250.00, 'depósito');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (6, 5000.00, 'depósito');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (7, 750.00, 'retiro');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (8, 100.00, 'depósito');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (9, 2000.00, 'retiro');
INSERT INTO transacciones (id_cuenta, monto, tipo_transaccion) VALUES (10, 500.00, 'depósito');

-- Insertar datos en la tabla usuarios_cuentas
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (1, 1);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (2, 2);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (3, 3);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (4, 4);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (5, 5);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (6, 6);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (7, 7);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (8, 8);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (9, 9);
INSERT INTO usuarios_cuentas (id_usuario, id_cuenta) VALUES (10, 10);
