--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
DROP TABLE IF EXISTS Colegiados;
DROP TABLE IF EXISTS Inscripciones;
DROP TABLE IF EXISTS Cursos;
DROP TABLE IF EXISTS Sesiones;
DROP TABLE IF EXISTS Externos;
DROP TABLE IF EXISTS Peritos;

CREATE TABLE Colegiados (
    id_colegiado INT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    DNI VARCHAR(15) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    poblacion VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE,
    cuenta_bancaria VARCHAR(30),
    titulacion VARCHAR(50),
    fecha_colegiacion DATE,
    estado VARCHAR(20)
);
CREATE TABLE Cursos (
    id_curso INT PRIMARY KEY,
    titulo VARCHAR(30) NOT NULL,
    descripcion VARCHAR(100),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    duracion INT NOT NULL,
    plazas INT NOT NULL,
    sesiones INT NOT NULL,
    cuota_precolegiado INT,
	cuota_colegiado INT,
	cuota_minusvalido INT,
	cuota_desempleado INT,
	cuota_empleado INT,
	cuota_alumno INT,
	cuota_empresa INT,
	cuota_otros INT,
    apertura_inscripcion DATE,
    cierre_inscripcion DATE,
    estado VARCHAR(15) NOT NULL
);

CREATE TABLE Inscripciones (
    id_inscripcion INT PRIMARY KEY,
    id_colegiado INT NOT NULL,
    id_curso INT NOT NULL,
    fecha_inscripcion DATE,
    estado VARCHAR (20),
    cantidad_pagar INT,
    cantidad_devolver INT,
    FOREIGN KEY (id_colegiado) REFERENCES Colegiados(id_colegiado) ON DELETE CASCADE,
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso) ON DELETE CASCADE
);

CREATE TABLE Sesiones (
	id_sesion INT PRIMARY KEY,
	id_curso INT NOT NULL,
	fecha DATE NOT NULL,
	hora_inicio TIME,
	duracion INT NOT NULL,
	FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso) ON DELETE CASCADE
);

CREATE TABLE Externos (
	id_externo INT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    DNI VARCHAR(15) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    poblacion VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE,
    cuenta_bancaria VARCHAR(30)
);

CREATE TABLE Peritos (
	id_colegiado INT PRIMARY KEY,
	correo VARCHAR(50) NOT NULL,
	telefono INT NOT NULL,
	fecha DATE,
	año INT NOT NULL,
	tap INT UNIQUE,
	estado VARCHAR (10) NOT NULL,
	FOREIGN KEY (id_colegiado) REFERENCES Colegiados(id_colegiado) ON DELETE CASCADE
);