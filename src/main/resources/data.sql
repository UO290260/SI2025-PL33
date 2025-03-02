--Para giis.demo.tkrun:
delete from Colegiados;
INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion) VALUES
(1, 'Alejandro', 'Torre Llorente', '12345678A', 'Calle Mayor 12', 'Asturias', '1985-10-06', 'ES7621000813610123456789', 'Ingeniería Informática', '2010-01-09'),
(2, 'Pablo', 'Santos Gómez', '23456789B', 'Avenida de la Paz 8', 'Asturias', '1990-10-03', 'ES9820381600140001234567', 'Ingeniería Informática', '2015-10-05'),
(3, 'Alejandro', 'Piñeiro Méndez', '34567890C', 'Calle del Sol 25', 'Asturias', '1988-11-11', 'ES5520481310123456789012', 'Ingeniería Informática', '2012-11-07'),
(4, 'Sara', 'Revolver Revolver', '45678901D', 'Plaza Mayor 5', 'Barcelona', '1993-11-09', 'ES9920002510123456789011', 'Arquitectura', '2017-11-01'),
(5, 'Ramon', 'Suarez del Valle', '56789012E', 'Calle Luna 14', 'Sevilla', '1980-05-04', 'ES2320891510123456789015', 'Deportes', '2008-11-10');
delete from Cursos;
INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, cuota_precolegiado, cuota_colegiado, cuota_otros, apertura_inscripcion, cierre_inscripcion, estado) VALUES
(1, 'Optimización de algoritmos', 'Curso de algoritmos', '2024-01-03', '2024-01-06', 90, 30, 100, 120, 200, '2023-11-10', '2023-12-10', 'Disponible'),
(2, 'Inteligencia artificial', 'Aprendizaje automático de ordenadores', '2024-04-07', '2024-09-10', 90, 25, 300, 400, NULL, '2024-02-05', '2024-03-05', 'Disponible'),
(3, 'Ciberseguridad', 'Principios de seguridad en sistemas operativos', '2024-10-05', '2024-11-08', 120, 20, NULL, 250, 250, '2024-07-20', '2024-08-20', 'Disponible'),
(4, 'Arquitectura urbanística', 'Principios de diseño arquitectónico y urbanismo', '2024-10-06', '2024-10-09', 90, 35, NULL, 200, 220, NULL, NULL, 'Pendiente'),
(5, 'Entrenador', 'Principios de entrenamiento deportivo', '2024-01-07', '2024-01-10', 90, 40, NULL, NULL, 150, NULL, NULL, 'Pendiente');
delete from Inscripciones;
INSERT INTO Inscripciones (id_inscripcion, id_colegiado, id_curso, fecha_inscripcion) VALUES
(1, 1, 1, '2024-02-15'),
(2, 2, 2, '2024-03-01'),
(3, 3, 3, '2024-03-05'),
(4, 4, 4, '2024-04-01'),
(5, 5, 5, '2024-04-10'),
(6, 1, 3, '2024-06-10');