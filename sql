DROP DATABASE if exists patrones;
CREATE DATABASE if not exists patrones;
USE patrones;
CREATE TABLE persona(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
apellido VARCHAR(100),
edad INT UNSIGNED,
correo VARCHAR(100),
rol enum('Admin','Empleado') ,
password varchar(250)
);
CREATE TABLE producto(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100),
descripcion VARCHAR(100),
fechaCaducidad VARCHAR(100),
cantidad INT UNSIGNED NOT NULL,
precio DOUBLE UNSIGNED NOT NULL,
categoria VARCHAR(50) NOT NULL
);
