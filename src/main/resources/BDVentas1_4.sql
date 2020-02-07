CREATE DATABASE ventas1_4 /*!40100 DEFAULT CHARACTER SET utf8 */;

USE ventas1_4;

CREATE TABLE cabguiarem (
  codGuiaRem varchar(12) NOT NULL,
  fechaEmi date DEFAULT NULL,
  rucEmpresa varchar(11) DEFAULT NULL,
  razSocEmpresa varchar(255) DEFAULT NULL,
  rucCliente varchar(11) DEFAULT NULL,
  razSocCliente varchar(255) DEFAULT NULL,
  direcCliente varchar(255) DEFAULT NULL,
  almacenero varchar(255) DEFAULT NULL,
  bultos int(11) DEFAULT NULL,
  PRIMARY KEY (codGuiaRem)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE detguiarem (
  codGuiaRem varchar(12) NOT NULL,
  codigoProd varchar(10) NOT NULL,
  descrProd varchar(255) DEFAULT NULL,
  cantidad int(11) DEFAULT NULL,
  PRIMARY KEY (codGuiaRem, codigoProd),
  FOREIGN KEY (codGuiaRem) REFERENCES cabguiarem (codGuiaRem)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE cabfactura (
  codigoFac varchar(12) NOT NULL,
  fechaEmi date DEFAULT NULL,
  codGuiaRem varchar(12) DEFAULT NULL,
  rucEmpresa varchar(11) DEFAULT NULL,
  razSocEmpresa varchar(255) DEFAULT NULL,
  rucCliente varchar(11) DEFAULT NULL,
  razSocCliente varchar(255) DEFAULT NULL,
  direcCliente varchar(255) DEFAULT NULL,
  cajero varchar(255) DEFAULT NULL,
  subTotal double DEFAULT NULL,
  igv double DEFAULT NULL,
  total double DEFAULT NULL,
  PRIMARY KEY (codigoFac),
  FOREIGN KEY (codGuiaRem) REFERENCES cabguiarem (codGuiaRem)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE detfactura (
  codigoFac varchar(12) NOT NULL,
  codigoProd varchar(10) NOT NULL,
  descrProd varchar(255) DEFAULT NULL,
  cantidad int(11) DEFAULT NULL,
  precUnit double DEFAULT NULL,
  valorVenta double DEFAULT NULL,
  PRIMARY KEY (codigoFac, codigoProd),
  FOREIGN KEY (codigoFac) REFERENCES cabfactura (codigoFac)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

