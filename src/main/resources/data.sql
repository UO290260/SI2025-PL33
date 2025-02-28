--Para giis.demo.tkrun:
delete from Colegiados;
INSERT INTO Colegiados (id_colegiado, nombre, apellidos, DNI, direccion, poblacion, fecha_nacimiento, cuenta_bancaria, titulacion, fecha_colegiacion) VALUES
(1, 'Alejandro', 'Torre Llorente', '12345678A', 'Calle Mayor 12', 'Asturias', '6/10/1985', 'ES7621000813610123456789', 'Ingeniería Informática', '9/1/2010'),
(2, 'Pablo', 'Santos Gómez', '23456789B', 'Avenida de la Paz 8', 'Asturias', '3/10/1990', 'ES9820381600140001234567', 'Ingeniería Informática', '5/10/2015'),
(3, 'Alejandro', 'Piñeiro Méndez', '34567890C', 'Calle del Sol 25', 'Asturias', '11/11/1988', 'ES5520481310123456789012', 'Ingeniería Informática', '7/11/2012'),
(4, 'Sara', 'Revolver Revolver', '45678901D', 'Plaza Mayor 5', 'Barcelona', '9/11/1993', 'ES9920002510123456789011', 'Arquitectura', '1/11/2017'),
(5, 'Ramon', 'Suarez del Valle', '56789012E', 'Calle Luna 14', 'Sevilla', '4/5/1980', 'ES2320891510123456789015', 'Deportes', '10/11/2008');
delete from Cursos;
INSERT INTO Cursos (id_curso, titulo, descripcion, fecha_inicio, fecha_fin, duracion, plazas, cuota_precolegiado, cuota_colegiado, cuota_otros, estado) VALUES
(1000, 'Optimización de algoritmos', 'Curso de algoritmos', '3/1/2024', '6/1/2024', 90, 30, 100, 120, 200, 'Disponible'),
(2000, 'Inteligencia artificial', 'Aprendizaje automático de ordenadores', '7/4/2024', '10/9/2024', 90, 25, 300, 400, NULL, 'Disponible'),
(3000, 'Ciberseguridad', 'Principios de seguridad en sistemas operativos', '5/10/2024', '8/11/2024', 120, 20, NULL, 250, 250, 'Disponible'),
(4000, 'Arquitectura urbanística', 'Principios de diseño arquitectónico y urbanismo', '6/10/2024', '9/10/2024', 90, 35, NULL, 200, 220, 'Pendiente'),
(5000, 'Entrenador', 'Principios de entrenamiento deportivo', '7/1/2024', '10/1/2024', 90, 40, NULL, NULL, 150, 'Pendiente');
delete from Inscripciones;
INSERT INTO Inscripciones (id_inscripcion, id_colegiado, id_curso, fecha_inscripcion) VALUES
(10, 1, 1000, '2/15/2024'),  
(20, 2, 2000, '3/1/2024'),  
(30, 3, 3000, '3/5/2024'),  
(40, 4, 4000, '4/1/2024'),  
(50, 5, 5000, '4/10/2024'),
(60, 1, 3000, '2/26/2024');
