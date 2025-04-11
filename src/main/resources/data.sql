--Para giis.demo.tkrun:
delete from Colegiados;
INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion , estado) VALUES
(1, 'Alejandro', 'Torre Llorente', '12345678A', 'Calle Mayor 12', 'Asturias', '1985-10-06', 'ES7621000813610123456789', 'Ingenieria Informatica', '2010-01-09' , 'Aprobada'),
(2, 'Pablo', 'Santos Gomez', '23456789B', 'Avenida de la Paz 8', 'Asturias', '1990-10-03', 'ES9820381600140001234567', 'Ingenieria Informatica', '2015-10-05' , 'Aprobada'),
(3, 'Alejandro', 'Pineiro Mendez', '34567890C', 'Calle del Sol 25', 'Asturias', '1988-11-11', 'ES5520481310123456789012', 'Ingenieria Informatica', '2012-11-07' ,  'Aprobada'),
(4, 'Sara', 'Revolver Revolver', '45678901D', 'Plaza Mayor 5', 'Barcelona', '1993-11-09', 'ES9920002510123456789011', 'Ingenieria Informatica', '2017-11-01' , 'Aprobada'),
(5, 'Ramon', 'Suarez del Valle', '56789012E', 'Calle Luna 14', 'Sevilla', '1980-05-04', 'ES2320891510123456789015', 'Ingenieria Informatica', '2008-11-10', 'Aprobada'),
(6, 'Tommy', 'Miller Fernandez', '58796050F', 'Calle Sol 14', 'Sevilla', '1980-05-04', 'ES9920002510123456789015', 'Master Ingenieria Informatica', '2010-11-01' , 'Aprobada'),
(7, 'Joel', 'Miller Fernandez', '58796050P', 'Calle Sol 14', 'Sevilla', '1980-05-04', 'ES2320891510123456789018', 'Golf', '2010-11-10', 'Pendiente'),
(8, 'Carlos', 'Sainz Vazquez', '51796050P', 'Calle Madrid 14', 'Madrid', '1980-05-04', 'ES2347891510123456789018', 'Licenciatura Informatica', '2012-11-10', 'Pendiente'),
(9, 'Fernando', 'Alonso Diaz', '52796050P', 'Calle Uria 33', 'Oviedo', '1998-05-04', 'ES2320451510123456789018', 'Ingenieria Informatica', '2013-11-10', 'Pendiente');

delete from Cursos;
INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, sesiones, cuota_precolegiado, cuota_colegiado, cuota_minusvalido, cuota_desempleado, cuota_empleado, cuota_alumno, cuota_empresa, cuota_otros, apertura_inscripcion, cierre_inscripcion,cancelable, porcentaje_devolucion, fecha_cancelacion, lista_espera, estado) VALUES
(1, 'Optimización de algoritmos', 'Curso de algoritmos', '2024-01-03', '2024-01-06', 90, 30, 10, 120, 200, 80, 100, 100, 100, 100, 100, '2023-11-10', '2023-12-10', TRUE, 100, '2023-12-30', FALSE, 'Disponible'),
(2, 'Inteligencia artificial', 'Aprendizaje automático de ordenadores', '2024-04-07', '2024-09-10', 90, 25, 3, 400, NULL, 100, NULL, 100, NULL, 100, 100, '2024-02-05', '2026-03-05', TRUE, 50, '2024-03-25', TRUE, 'Disponible'),
(3, 'Ciberseguridad', 'Principios de seguridad en sistemas operativos', '2024-10-05', '2024-11-08', 120, 20, 5, 250, 250, 100, NULL, 100, 100, 100, NULL, '2024-07-20', '2024-08-20', TRUE, 80, '2024-09-10', TRUE, 'Disponible'),
(4, 'Arquitectura urbanística', 'Principios de diseño arquitectónico y urbanismo', '2024-10-06', '2024-10-09', 90, 35, 10, 200, 220 ,100, NULL, 100, 100, 100, NULL, NULL, NULL, FALSE, NULL, NULL, TRUE, 'Pendiente'),
(5, 'Entrenador', 'Principios de entrenamiento deportivo', '2024-01-07', '2024-01-10', 90, 40, 6, 100, 100, 70, 100, 120, 100, 400, 150, NULL, NULL, FALSE, NULL, NULL, FALSE, 'Pendiente');
delete from Inscripciones;
INSERT INTO Inscripciones (id_inscripcion, DNI, id_curso, fecha_inscripcion,estado,cantidad_pagar,cantidad_devolver,lista_espera,posicion) VALUES
(1, '12345678A', 1, '2024-02-15','Matriculado',NULL,NULL,FALSE,NULL),
(2, '23456789B', 2, '2024-03-01','Matriculado',NULL,NULL,FALSE,NULL),
(3, '34567890C', 3, '2024-03-05','Matriculado',NULL,NULL,FALSE,NULL),
(4, '45678901D', 4, '2024-04-01','Matriculado',NULL,NULL,FALSE,NULL),
(5, '56789012E', 5, '2024-04-10','Matriculado',NULL,NULL,FALSE,NULL),
(6, '12345678A', 3, '2024-06-10','Matriculado',NULL,NULL,FALSE,NULL);
delete from Sesiones;
INSERT INTO Sesiones (id_sesion, id_curso, fecha, hora_inicio, duracion) VALUES
(1, 1, '2024-01-03', '09:00', 3),
(2, 1, '2024-01-04', '09:00', 3),
(3, 1, '2024-01-05', '09:00', 3),
(4, 1, '2024-01-06', '09:00', 3),
(5, 2, '2024-04-07', '10:00', 3),
(6, 2, '2024-04-08', '10:00', 3);
delete from Externos;
INSERT INTO Externos (id_externo, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria) VALUES
(1, 'Luis', 'Martínez Pérez', '67891234F', 'Calle del Río 10', 'Madrid', '1985-05-20', 'ES9820381600140009876543'),
(2, 'Ana', 'García López', '78901234G', 'Calle Mayor 15', 'Sevilla', '1992-07-12', 'ES1220492345123456789012'),
(3, 'Javier', 'Ruiz López', '90123456J', 'Avenida de Andalucía 30', 'Valencia', '1980-03-22', 'ES3320568712345678901234'),
(4, 'Marta', 'López García', '89012345H', 'Avenida de la Ciencia 20', 'Barcelona', '1995-05-18', 'ES4420231145123456789013');
delete from Peritos;
INSERT INTO Peritos (id_colegiado, correo, telefono, fecha , año , tap ,estado) VALUES
(1, 'alejandro.torre@gmail.com', '600123456', '2012-01-09' , 2011 , 101 , 'Inscrito'),
(3, 'alejandro.pineiro@gmail.com', '623456789', '2019-11-07' , 2018 , 102 , 'Inscrito'),
(4, 'sara.revolver@gmail.com', '634567890', '2018-11-01' , 2017, 103 , 'Inscrito'),
(5, 'ramon.suarez@gmail.com', '654321987', '2019-11-01' , 2018, 104 , 'Inscrito');
delete from Periciales;
INSERT INTO Periciales (id_pericial,id_colegiado,nombre,solicitante,fecha,urgencia,estado) VALUES
(1,1,'Alejandro','Chemaastur','2024-11-01','Grave','Pendiente'),
(2,1,'Alejandro','Uniovi','2025-03-12','Moderada','Pendiente'),
(3,2,'Pablo','Atur Feito','2023-09-25','Moderada','Pendiente');
delete from Asignacion;
INSERT INTO Asignacion (id_perito,id_pericial,fecha,estado) VALUES
(1,1,'2025-04-04','Aceptado'),
(1,2,'2025-05-13','Aceptado'),
(2,3,'20025-11-24','Rechazado');
delete from Recibos;
INSERT INTO Recibos (id_recibo, DNI, cuota_pagar, fecha_recibo, estado) VALUES 
(1, '12345678A', 120, '2024-01-01', 'Emitido'),
(2, '23456789B', 150, '2024-02-01', 'Pendiente'),
(3, '34567890C', 100, '2024-03-01', 'Emitido'),
(4, '45678901D', 200, '2024-04-01', 'Pendiente');