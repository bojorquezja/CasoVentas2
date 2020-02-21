CREATE DATABASE ventas2_3 /*!40100 DEFAULT CHARACTER SET utf8 */;

USE ventas2_3;

CREATE TABLE producto (
  codigoProd varchar(10) NOT NULL,
  descrProd varchar(255) DEFAULT NULL,
  precUnit double DEFAULT NULL,
  PRIMARY KEY (codigoProd)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente (
  rucCliente varchar(11) NOT NULL,
  razSocCliente varchar(255) DEFAULT NULL,
  direcCliente varchar(255) DEFAULT NULL,
  PRIMARY KEY (rucCliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE empresa (
  rucEmpresa varchar(11) NOT NULL,
  razSocEmpresa varchar(255) DEFAULT NULL,
  PRIMARY KEY (rucEmpresa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cabguiarem (
  codGuiaRem varchar(12) NOT NULL,
  fechaEmi date DEFAULT NULL,
  rucEmpresa varchar(11) DEFAULT NULL,
  rucCliente varchar(11) DEFAULT NULL,
  almacenero varchar(255) DEFAULT NULL,
  bultos int(11) DEFAULT NULL,
  PRIMARY KEY (codGuiaRem),
  FOREIGN KEY (rucEmpresa) REFERENCES empresa (rucEmpresa),
  FOREIGN KEY (rucCliente) REFERENCES cliente (rucCliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE detguiarem (
  codGuiaRem varchar(12) NOT NULL,
  codigoProd varchar(10) NOT NULL,
  cantidad int(11) DEFAULT NULL,
  PRIMARY KEY (codGuiaRem, codigoProd),
  FOREIGN KEY (codGuiaRem) REFERENCES cabguiarem (codGuiaRem),
  FOREIGN KEY (codigoProd) REFERENCES producto (codigoProd)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE cabfactura (
  codigoFac varchar(12) NOT NULL,
  fechaEmi date DEFAULT NULL,
  codGuiaRem varchar(12) DEFAULT NULL,
  rucEmpresa varchar(11) DEFAULT NULL,
  rucCliente varchar(11) DEFAULT NULL,
  cajero varchar(255) DEFAULT NULL,
  subTotal double DEFAULT NULL,
  igv double DEFAULT NULL,
  total double DEFAULT NULL,
  PRIMARY KEY (codigoFac),
  FOREIGN KEY (codGuiaRem) REFERENCES cabguiarem (codGuiaRem),
  FOREIGN KEY (rucEmpresa) REFERENCES empresa (rucEmpresa),
  FOREIGN KEY (rucCliente) REFERENCES cliente (rucCliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE detfactura (
  codigoFac varchar(12) NOT NULL,
  codigoProd varchar(10) NOT NULL,
  cantidad int(11) DEFAULT NULL,
  valorVenta double DEFAULT NULL,
  PRIMARY KEY (codigoFac, codigoProd),
  FOREIGN KEY (codigoFac) REFERENCES cabfactura (codigoFac),
  FOREIGN KEY (codigoProd) REFERENCES producto (codigoProd)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
DROP USER 'usuario'@'localhost';
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'contrasena'; 
GRANT ALL PRIVILEGES ON *.* TO 'usuario'@'localhost' WITH GRANT OPTION;
*/