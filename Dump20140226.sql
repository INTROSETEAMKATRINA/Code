CREATE DATABASE  IF NOT EXISTS `payroll system` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `payroll system`;
-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: payroll system
-- ------------------------------------------------------
-- Server version	5.6.12

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
-- Table structure for table `adjustmentsanddeductions`
--

DROP TABLE IF EXISTS `adjustmentsanddeductions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adjustmentsanddeductions` (
  `amount` decimal(10,2) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `PeriodStartDate` date NOT NULL,
  `TIN` varchar(20) NOT NULL,
  PRIMARY KEY (`PeriodStartDate`,`TIN`),
  KEY `PersonnelAdjustmentsAndDeductions_idx` (`TIN`),
  CONSTRAINT `TINAdjustmentsAndDeductions` FOREIGN KEY (`TIN`) REFERENCES `personnel` (`TIN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adjustmentsanddeductions`
--

LOCK TABLES `adjustmentsanddeductions` WRITE;
/*!40000 ALTER TABLE `adjustmentsanddeductions` DISABLE KEYS */;
/*!40000 ALTER TABLE `adjustmentsanddeductions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `Name` varchar(30) NOT NULL,
  `SHVariable` decimal(10,2) DEFAULT NULL,
  `LHVariable` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dtr`
--

DROP TABLE IF EXISTS `dtr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dtr` (
  `RHW` decimal(10,2) DEFAULT NULL,
  `ROT` decimal(10,2) DEFAULT NULL,
  `RNSD` decimal(10,2) DEFAULT NULL,
  `SH` decimal(10,2) DEFAULT NULL,
  `SHOT` decimal(10,2) DEFAULT NULL,
  `SHNSD` decimal(10,2) DEFAULT NULL,
  `LH` decimal(10,2) DEFAULT NULL,
  `LHOT` decimal(10,2) DEFAULT NULL,
  `LHNSD` decimal(10,2) DEFAULT NULL,
  `PeriodStartDate` date NOT NULL,
  `TIN` varchar(20) NOT NULL,
  PRIMARY KEY (`TIN`,`PeriodStartDate`),
  CONSTRAINT `TINDTR` FOREIGN KEY (`TIN`) REFERENCES `personnel` (`TIN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dtr`
--

LOCK TABLES `dtr` WRITE;
/*!40000 ALTER TABLE `dtr` DISABLE KEYS */;
/*!40000 ALTER TABLE `dtr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
INSERT INTO `password` VALUES ('gallant2010');
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payslip`
--

DROP TABLE IF EXISTS `payslip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payslip` (
  `Assignment` varchar(30) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `PeriodStartDate` date NOT NULL,
  `TIN` varchar(20) NOT NULL,
  `Position` varchar(30) DEFAULT NULL,
  `RHW` decimal(10,2) unsigned DEFAULT NULL,
  `DailyRate` decimal(10,2) DEFAULT NULL,
  `GrossPay` decimal(10,2) DEFAULT NULL,
  `Late` int(11) DEFAULT NULL,
  `RegularPay` decimal(10,2) DEFAULT NULL,
  `ROT` decimal(10,2) DEFAULT NULL,
  `ROTPay` decimal(10,2) DEFAULT NULL,
  `RNSD` decimal(10,2) DEFAULT NULL,
  `RNSDPay` decimal(10,2) DEFAULT NULL,
  `LH` decimal(10,2) DEFAULT NULL,
  `LHPay` decimal(10,2) DEFAULT NULL,
  `LHOT` decimal(10,2) DEFAULT NULL,
  `LHOTPay` decimal(10,2) DEFAULT NULL,
  `LHNSD` decimal(10,2) DEFAULT NULL,
  `LHNSDPay` decimal(10,2) DEFAULT NULL,
  `SH` decimal(10,2) DEFAULT NULL,
  `SHPay` decimal(10,2) DEFAULT NULL,
  `SHOT` decimal(10,2) DEFAULT NULL,
  `SHOTPay` decimal(10,2) DEFAULT NULL,
  `SHNSD` decimal(10,2) DEFAULT NULL,
  `SHNSDPay` decimal(10,2) DEFAULT NULL,
  `TranspoAllow` decimal(10,2) DEFAULT NULL,
  `Adjustments` decimal(10,2) DEFAULT NULL,
  `WTax` decimal(10,2) DEFAULT NULL,
  `SSS` decimal(10,2) DEFAULT NULL,
  `PHIC` decimal(10,2) DEFAULT NULL,
  `HDMF` decimal(10,2) DEFAULT NULL,
  `SSSLoan` decimal(10,2) DEFAULT NULL,
  `Savings` decimal(10,2) DEFAULT NULL,
  `PayrollAdvance` decimal(10,2) DEFAULT NULL,
  `HouseRental` decimal(10,2) DEFAULT NULL,
  `UniformAndOthers` decimal(10,2) DEFAULT NULL,
  `NetPay` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`TIN`,`PeriodStartDate`),
  KEY `TIN_idx` (`TIN`),
  CONSTRAINT `TINPayslip` FOREIGN KEY (`TIN`) REFERENCES `personnel` (`TIN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payslip`
--

LOCK TABLES `payslip` WRITE;
/*!40000 ALTER TABLE `payslip` DISABLE KEYS */;
INSERT INTO `payslip` VALUES ('KING AIR',' Araojo, Edmar ','2012-07-31',' ','Station Loader ',NULL,NULL,NULL,NULL,5592.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,127.80,NULL,NULL,NULL,3.00,4.79,NULL,NULL,NULL,366.70,137.50,100.00,NULL,NULL,NULL,NULL,NULL,5156.75),('KING AIR','ARCA, REGINAL REALON','2012-07-31','263-568-290','STATION LOADER',NULL,436.00,5592.00,NULL,5592.00,NULL,NULL,31.00,165.08,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,366.70,137.50,100.00,NULL,NULL,NULL,NULL,NULL,4987.80);
/*!40000 ALTER TABLE `payslip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personnel` (
  `Name` varchar(50) DEFAULT NULL,
  `Assignment` varchar(30) NOT NULL,
  `Position` varchar(30) DEFAULT NULL,
  `EmployeeStatus` varchar(20) DEFAULT NULL,
  `DailyRate` decimal(10,2) DEFAULT NULL,
  `ColaRate` decimal(10,2) DEFAULT NULL,
  `MonthlyRate` decimal(10,2) DEFAULT NULL,
  `TIN` varchar(20) NOT NULL,
  `TaxStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personnel`
--

LOCK TABLES `personnel` WRITE;
/*!40000 ALTER TABLE `personnel` DISABLE KEYS */;
INSERT INTO `personnel` VALUES ('TA-A, MARK ANGELO BLISS','Gallant','CARGO OFFICER','Contractual',426.00,785.00,0.00,'',''),('GADDI, RODEL CHUA','Gallant','AIR CRAFT CLEANER','Contractual',426.00,785.00,0.00,'139-670-731',''),('TURALDE, WILLBRIAN FRONDA','Gallant','EQUIPMENT OPERATOR','Contractual',426.00,785.00,0.00,'190-957-277',''),('CALUSIN, RUEL JR MAGNIFICO','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'205-437-452',''),('GUJELDE, KENNETH ACASIO','Gallant','EQUIPMENT OPERATOR','Contractual',426.00,785.00,0.00,'225-096-399',''),('VITAN, MARK ROMMEL SAN JOSE ','Gallant','COMMISSARY','Contractual',426.00,785.00,0.00,'233-507-293',''),('VASQUEZ, RAFAEL SANDRINO','Gallant','EQUIPMENT OPERATOR','Contractual',426.00,785.00,0.00,'239-255-901',''),('DE JESSUS, ANA KATRINA MENDOZA','Gallant','GROUND ATTENDANT','Contractual',426.00,785.00,0.00,'251-033-070',''),('BALCENA, ARNEL GARMACHA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'251-073-286',''),('JAVIER, DYNNA MARIEJANE AGUILLA','Gallant','COMMISSARY','Contractual',426.00,785.00,0.00,'259-412-912',''),('ARCA, REGINAL REALON','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'263-568-290',''),('DE LEON, KATHERINE SANTOS`','Gallant','CARGO OFFICER','Contractual',426.00,785.00,0.00,'266-439-841',''),('FEDERE, DARWIN AZURIN','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'276-986-836',''),('BALBOA, GLEN ASONG','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'283-832-176',''),('CASIMIRO, JAMES CONCEPCION','Gallant','COMMISSARY','Contractual',426.00,785.00,0.00,'291-584-470',''),('ROMERO, DARWIN ARENO','Gallant','COMMISSARY','Contractual',426.00,785.00,0.00,'303-651-743',''),('MANZALA, ROWELL SOLERA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'341-859-950',''),('ENDUMA, DARIUS FIRMALAN','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'403-958-283',''),('MARIALO, ELMER DE GUZMAN','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'409-536-856',''),('BONGALBAL, RENE RODRIGUEZ','Gallant','EQUIPMENT OPERATOR','Contractual',426.00,785.00,0.00,'417-550-755',''),('OCA, MAUREEN JOY QUIONES','Gallant','GROUND ATTENDANT','Contractual',426.00,785.00,0.00,'422-295-663',''),('SALONGA, MARY GRACE BAUTISTA','Gallant','GROUND ATTENDANT','Contractual',426.00,785.00,0.00,'424-241-505',''),('CABACABA, RENATO ILOVAR','Gallant','EQUIPMENT OPERATOR','Contractual',426.00,785.00,0.00,'425-077-951',''),('RAMOS, ANTHONY AZURIN','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'425-387-405',''),('VILLARANTE, ANTHONY DE GUZMAN','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'425-812-949',''),('LONGJAS, MICHAEL ALADIN BUSALLA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'429-767-596',''),('JAPZON, IAN MADRICK ','Gallant','COMMISSARY','Contractual',426.00,785.00,0.00,'430-499-520',''),('TULAY, CELSO TABIRAO','Gallant','CARGO LOADER','Contractual',426.00,785.00,0.00,'431-860-108',''),('MALAZARTE, NORIELLE ','Gallant','GROUND ATTENDANT','Contractual',426.00,785.00,0.00,'431-877-069',''),('CAJEBEN, JONARIE ALEMANIA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'442-472-438',''),('MAGBATA, FRANCIS FALCUTILA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'7431-657-001',''),('AMPA, ANTONIO RAMOS','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'912-144-512',''),('BALITE, ANTONIO BELZA','Gallant','STATION LOADER','Contractual',426.00,785.00,0.00,'913-787-360','');
/*!40000 ALTER TABLE `personnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxtable`
--

DROP TABLE IF EXISTS `taxtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxtable` (
  `Length` varchar(20) DEFAULT NULL,
  `TaxStatus` varchar(20) DEFAULT NULL,
  `Bracket1` decimal(10,2) DEFAULT NULL,
  `Bracket2` decimal(10,2) DEFAULT NULL,
  `Bracket3` decimal(10,2) DEFAULT NULL,
  `Bracket4` decimal(10,2) DEFAULT NULL,
  `Bracket5` decimal(10,2) DEFAULT NULL,
  `Bracket6` decimal(10,2) DEFAULT NULL,
  `Bracket7` decimal(10,2) DEFAULT NULL,
  `Bracket8` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxtable`
--

LOCK TABLES `taxtable` WRITE;
/*!40000 ALTER TABLE `taxtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxtable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-26  0:20:30
