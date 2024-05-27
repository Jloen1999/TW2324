# Prácticas de repaso de JavaScript con HTML5 Y CSS3.
- José Luis Obiang Ela Nanguang.
- Antonio Calvo

## Práctica Servlet, JS, HTML5 y CSS3
### Enunciado de Práctica: Sistema de Gestión Bancaria con Servlets y JDBC
Desarrollar una aplicación web utilizando Servlets, JDBC y JSP para gestionar una base de datos de un banco. La aplicación permitirá realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las cuentas bancarias y las transacciones. Además, se implementará autenticación de usuarios administradores para gestionar las cuentas y transacciones.
---
#### Requisitos del Proyecto
**Base de Datos**  

Nombre de la base de datos: BankManagementDB

Tablas:

**accounts**
id (INT, PRIMARY KEY, AUTO_INCREMENT)  

account_number (VARCHAR(20), UNIQUE, NOT NULL)  

account_holder (VARCHAR(100), NOT NULL)  

balance (DECIMAL(15, 2), NOT NULL)  

created_at (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)  

**transactions**  

id (INT, PRIMARY KEY, AUTO_INCREMENT)  

account_id (INT, NOT NULL, FOREIGN KEY REFERENCES accounts(id))  

amount (DECIMAL(10, 2), NOT NULL)  

transaction_type (VARCHAR(10), NOT NULL)  

transaction_date (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)  

**admins**  

id (INT, PRIMARY KEY, AUTO_INCREMENT)  

username (VARCHAR(50), UNIQUE, NOT NULL)  

password (VARCHAR(50), NOT NULL)  

---
SQL para crear la base de datos y las tablas:

CREATE DATABASE BancoGestionDB;

```sql
use tw;

CREATE TABLE cuentas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
  titular_cuenta VARCHAR(100) NOT NULL,
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

CREATE TABLE administradores (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
  contrasena VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla cuentas
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('1234567890', 'Juan Pérez', 5000.00);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('2345678901', 'María García', 3000.50);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('3456789012', 'Carlos Sánchez', 1200.75);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('4567890123', 'Ana Rodríguez', 9500.00);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('5678901234', 'Luis Fernández', 870.00);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('6789012345', 'Marta López', 15000.00);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('7890123456', 'José Martínez', 2250.25);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('8901234567', 'Laura González', 3400.00);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('9012345678', 'Pedro Gómez', 4100.75);
INSERT INTO cuentas (numero_cuenta, titular_cuenta, saldo) VALUES ('0123456789', 'Carmen Díaz', 7600.50);

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

-- Insertar datos en la tabla administradores
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin1', 'password1');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin2', 'password2');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin3', 'password3');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin4', 'password4');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin5', 'password5');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin6', 'password6');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin7', 'password7');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin8', 'password8');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin9', 'password9');
INSERT INTO administradores (nombre_usuario, contrasena) VALUES ('admin10', 'password10');
´´´
