-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: ventas1
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cabfactura`
--

DROP TABLE IF EXISTS `cabfactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cabfactura` (
  `codigoFac` varchar(12) DEFAULT NULL,
  `fechaEmi` date DEFAULT NULL,
  `codGuiaRem` varchar(12) DEFAULT NULL,
  `rucEmpresa` varchar(11) DEFAULT NULL,
  `razSocEmpresa` varchar(255) DEFAULT NULL,
  `rucCliente` varchar(11) DEFAULT NULL,
  `razSocCliente` varchar(255) DEFAULT NULL,
  `direcCliente` varchar(255) DEFAULT NULL,
  `cajero` varchar(255) DEFAULT NULL,
  `subTotal` double DEFAULT NULL,
  `igv` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabfactura`
--

LOCK TABLES `cabfactura` WRITE;
/*!40000 ALTER TABLE `cabfactura` DISABLE KEYS */;
INSERT INTO `cabfactura` VALUES ('F01005','2018-12-30','GR001','2010245','Emp XYZ','2033245','Cliente 1','av 123','frank',42,7.56,49.559999999999995),('F01004','2019-02-28','GR002','2010245','Empresa 1','2044245','Cliente 2','av 3','frank',115,20.7,135.7);
/*!40000 ALTER TABLE `cabfactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabguiarem`
--

DROP TABLE IF EXISTS `cabguiarem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cabguiarem` (
  `codGuiaRem` varchar(12) DEFAULT NULL,
  `fechaEmi` date DEFAULT NULL,
  `rucEmpresa` varchar(11) DEFAULT NULL,
  `razSocEmpresa` varchar(255) DEFAULT NULL,
  `rucCliente` varchar(11) DEFAULT NULL,
  `razSocCliente` varchar(255) DEFAULT NULL,
  `direcCliente` varchar(255) DEFAULT NULL,
  `almacenero` varchar(255) DEFAULT NULL,
  `bultos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabguiarem`
--

LOCK TABLES `cabguiarem` WRITE;
/*!40000 ALTER TABLE `cabguiarem` DISABLE KEYS */;
INSERT INTO `cabguiarem` VALUES ('GR0001','2019-02-28','2010245','Empresa 1','2044245','Cliente 2','av 3','joe',10),('GR0003','2019-04-28','2018854','Empresa 3','2046677','Clien633','av 3','joe',3),('dddd','2020-01-08','654654','asdasdasd','34565464','vcxvxcv','xcvxcv','eee',4),('werwer','2020-01-09','456456','wer','5464','wer','wer','dfdf',5),('werewr','2020-01-02','45345','dfgdfg','345345','dfgdfg','dfgdfgdfg','fgfg',7);
/*!40000 ALTER TABLE `cabguiarem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detfactura`
--

DROP TABLE IF EXISTS `detfactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detfactura` (
  `codigoFac` varchar(12) DEFAULT NULL,
  `codigoProd` varchar(10) DEFAULT NULL,
  `descrProd` varchar(255) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precUnit` double DEFAULT NULL,
  `valorVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detfactura`
--

LOCK TABLES `detfactura` WRITE;
/*!40000 ALTER TABLE `detfactura` DISABLE KEYS */;
INSERT INTO `detfactura` VALUES ('F01004','eeee','eewqq',67,7,90),('F01004','fdfd','cvc',2,4,20),('F01004','eeee','eewqq',67,7,90),('F01004','fdfd','cvc',2,4,20),('F01004','rr','ttt',5,4,5),('F01005','eeee','rrrrrr',6,7,42);
/*!40000 ALTER TABLE `detfactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detguiarem`
--

DROP TABLE IF EXISTS `detguiarem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detguiarem` (
  `codGuiaRem` varchar(12) DEFAULT NULL,
  `codigoProd` varchar(10) DEFAULT NULL,
  `descrProd` varchar(255) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detguiarem`
--

LOCK TABLES `detguiarem` WRITE;
/*!40000 ALTER TABLE `detguiarem` DISABLE KEYS */;
INSERT INTO `detguiarem` VALUES ('werewr','dfg','dfgd',6),('GR0003','qwqw','erer',7),('GR0003','sd','sdsd',44),('GR0003','wew','qwqw',2),('GR0003','eee','qqq',2),('GR0003','rr','tt',44);
/*!40000 ALTER TABLE `detguiarem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-31  7:08:08
