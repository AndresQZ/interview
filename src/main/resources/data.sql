DROP TABLE IF EXISTS cliente;
 

CREATE TABLE cliente (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(512) NOT NULL,
  apellido_paterno VARCHAR(512) NOT NULL,
  apellido_materno VARCHAR(512) DEFAULT NULL,
  fecha_nacimiento Date DEFAULT NULL,
  ingresos FLOAT4 DEFAULT NULL,
  codigo_postal VARCHAR(6) DEFAULT NULL
);


  
  INSERT INTO cliente (nombre, apellido_paterno, apellido_materno, fecha_nacimiento, ingresos, codigo_postal ) VALUES
  ('Dua', 'Lipa', 'singer', '1995-08-22', 3323, 12343),
  ('Bill', 'Gates', 'microsoft', '1980-01-01', 800000, 90230),
  ('Elon', 'Reeve', 'Musk', '1971-06-28', 800000, 345673),
  ('Madonna', 'Veronica', 'Ciccone', '1958-08-16', 2323, 938382),
  ('Jeff', 'Preston', 'Bezos', '1964-01-12', 338000.9, 121234),
  ('Alice', 'Keys', 'Cook', '1981-01-25', 73723, 123656);
