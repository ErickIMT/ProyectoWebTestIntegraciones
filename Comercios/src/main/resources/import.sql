INSERT INTO tipo_integracion(id_tipo_integracion, nombre) VALUE(1, 'Checkout');
INSERT INTO tipo_integracion(id_tipo_integracion, nombre) VALUE(2, 'VPosFlex');

INSERT INTO comercio(id_comercio, nombre, signature, id_tipo_integracion) VALUES(1, 'Prueba 1', '54181sdsad', 1);
INSERT INTO comercio(id_comercio, nombre, signature, id_tipo_integracion) VALUES(2, 'Prueba 2', '54181sdsad', 2);
INSERT INTO comercio(id_comercio, nombre, signature, id_tipo_integracion) VALUES(3, 'Prueba 3', '54181sdsad', 2);
