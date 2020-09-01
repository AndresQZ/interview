DROP TABLE IF EXISTS billionaires;
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
  ('dua', 'lipa', 'singer', '1890-01-01', 3323, 12343),
  ('Bill', 'Gates', 'microsoft', '1980-01-01', 800000, 90230),
  ('Elon', 'Musk', 'x-space', '1971-10-01', 800000, 345673),
  ('Bono', '', 'u2', '1980-01-01', 2323, 938382),
  ('jeff', 'Bezoz', 'amazon', '1964-01-01', 33800000, 121234),
  ('Alice', 'Keys', 'singer', '1984-01-01', 73723, 123656);


