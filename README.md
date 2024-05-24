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

```sql
CREATE DATABASE BankManagementDB;

USE BankManagementDB;

CREATE TABLE accounts (
  id INT PRIMARY KEY AUTO_INCREMENT,
  account_number VARCHAR(20) UNIQUE NOT NULL,
  account_holder VARCHAR(100) NOT NULL,
  balance DECIMAL(15, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  account_id INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  transaction_type VARCHAR(10) NOT NULL,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (account_id) REFERENCES accounts(id)
);

CREATE TABLE admins (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(50) NOT NULL
);

```
