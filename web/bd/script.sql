create database ReealoDB2019;
Use ReealoDB2019;
create table productos (
	codProd char(4) primary key,
	descripcion varchar(30) not null,
	detalle varchar(300) not null,
	stock int not null,
	precio numeric (8,2) not null,
	imagen varchar (30) not null
);
       

-- En SQL Server, esto funcionaria pero en MySQL NO
INSERT INTO productos (codProd, descripcion, detalle, stock, precio, imagen)
VALUES ( 
	(SELECT 'P' + RIGHT('000' + CONVERT(varchar(3), MAX(CONVERT(int, RIGHT(codProd, 3))) + 1), 3) FROM productos), 
	'Thor 2', 
        'Colección 2020', 
        10, 
        20, 
        'imagen.jpg'
)
 
-- Para MySQL debemos hacer lo siguiente, ya que no se permite hacer un SELECT a la misma tabla que se inserta
INSERT INTO productos (codProd, descripcion, detalle, stock, precio, imagen)
SELECT CONCAT('P', LPAD(MAX(RIGHT(codProd, 1)+1), 3, '0')),
       'Thor 2', 
       'Colección 2020', 
       10, 
       20, 
       'imagen.jpg' 
FROM productos;