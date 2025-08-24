insert into auth.role(name) VALUES ('GERENTE'), ('CAJERO'), ('RECEPCIONISTA'), ('CLIENTE');

-- GERENTE
insert into identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Jaun Miguel Tzunum Batz', '3235492650901', '40966889', 'admin@gmail.com', 'GERENTE', 15000.00, 'Mixco Guatemala', null, null);

-- 5 Cajeros
INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Carlos Enrique López Méndez', '3012456980101', '55236644', 'carlos.lopez@gmail.com', 'CAJERO', 4500.00, 'Zona 11 Ciudad de Guatemala', NULL, 'a56ef36a-1972-4ade-9e73-86a582a523a9');

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('María Fernanda Gómez Ruiz', '3056987410201', '44998877', 'maria.gomez@gmail.com', 'CAJERO', 4600.00, 'Zona 18 Ciudad de Guatemala', NULL, 'b465cbd9-970b-4df0-85c7-97e9fc26a21e');

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('José Alejandro Ramírez Castillo', '3124578960301', '33665544', 'jose.ramirez@gmail.com', 'CAJERO', 4700.00, 'Mixco Guatemala', NULL, 'f57f9529-f21d-489b-884b-7cab4c0afdb5');

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Ana Beatriz Hernández López', '3189654780401', '22557799', 'ana.hernandez@gmail.com', 'CAJERO', 4550.00, 'Antigua Guatemala', NULL, '85060c82-2866-4dc8-9d72-8b42de806dac');

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Luis Eduardo Pérez Soto', '3247896520501', '66889944', 'luis.perez@gmail.com', 'CAJERO', 4800.00, 'Villa Nueva Guatemala', NULL, 'cbb924c3-e685-4de9-a9ff-58627214ac18');


-- 5 Recepcionistas
INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Sofía Daniela Morales Chávez', '3014789650601', '55667788', 'sofia.morales@gmail.com', 'RECEPCIONISTA', 5000.00, 'Zona 10 Ciudad de Guatemala', 'e2de677b-0657-48f9-9063-5cfeca0e4f43', NULL);

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Diego Armando González Ramírez', '3098745210701', '44775566', 'diego.gonzalez@gmail.com', 'RECEPCIONISTA', 5100.00, 'Zona 14 Ciudad de Guatemala', '73769a0b-d8a5-4bd8-8e6a-c90b292aab54', NULL);

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Gabriela Estefanía López Pérez', '3154789620801', '22884455', 'gabriela.lopez@gmail.com', 'RECEPCIONISTA', 4950.00, 'Amatitlán Guatemala', 'c156d9d6-0405-4e5f-aed6-4a8e656fdda0', NULL);

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Ricardo Manuel Castillo Ortiz', '3201478960901', '33446677', 'ricardo.castillo@gmail.com', 'RECEPCIONISTA', 5050.00, 'Zona 5 Ciudad de Guatemala', 'ddeeeb67-67d7-4705-af25-4be2085a1469', NULL);

INSERT INTO identity.employee(full_name, cui, phone, email, job_position, salary, address, hotel_id, restaurant_id)
VALUES('Valeria Paola Martínez Díaz', '3265987411001', '66337788', 'valeria.martinez@gmail.com', 'RECEPCIONISTA', 5000.00, 'Santa Catarina Pinula Guatemala', 'ddeeeb67-67d7-4705-af25-4be2085a1469', NULL);


-- 10 clientes
INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Marcos Antonio López García', '3012456980101', '55447766', 'marcos.lopez@correo.com', 'Zona 7 Ciudad de Guatemala', 120);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Paola Fernanda Ramírez Soto', '3056987410201', '44228899', 'paola.ramirez@correo.com', 'Zona 11 Ciudad de Guatemala', 80);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Andrés Felipe Pérez Castillo', '3124578960301', '33665544', 'andres.perez@correo.com', 'Mixco Guatemala', 150);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Lucía Estefanía González Ruiz', '3189654780401', '22557799', 'lucia.gonzalez@correo.com', 'Antigua Guatemala', 60);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Javier Eduardo Morales Chávez', '3247896520501', '66889944', 'javier.morales@correo.com', 'Zona 16 Ciudad de Guatemala', 200);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Camila Beatriz Hernández López', '3014789650601', '55667788', 'camila.hernandez@correo.com', 'Villa Nueva Guatemala', 90);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Diego Alejandro Castillo Ortiz', '3098745210701', '44775566', 'diego.castillo@correo.com', 'Amatitlán Guatemala', 45);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Sofía Daniela Martínez Díaz', '3154789620801', '22884455', 'sofia.martinez@correo.com', 'Zona 15 Ciudad de Guatemala', 175);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Ricardo Manuel Tzunum Batz', '3201478960901', '33446677', 'ricardo.tzunum@correo.com', 'Santa Catarina Pinula Guatemala', 110);

INSERT INTO identity.customer (full_name, cui, phone, email, address, loyalty_points)
VALUES ('Valeria Paola López Méndez', '3265987411001', '66337788', 'valeria.lopez@correo.com', 'Zona 14 Ciudad de Guatemala', 95);