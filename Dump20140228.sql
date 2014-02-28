CREATE DATABASE  IF NOT EXISTS `Payroll System` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Payroll System`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: Payroll System
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
-- Table structure for table `AdjustmentsAndDeductions`
--

DROP TABLE IF EXISTS `AdjustmentsAndDeductions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AdjustmentsAndDeductions` (
  `amount` decimal(10,2) NOT NULL,
  `type` varchar(30) NOT NULL,
  `PeriodStartDate` date NOT NULL,
  `TIN` varchar(20) NOT NULL,
  PRIMARY KEY (`PeriodStartDate`,`TIN`,`type`,`amount`),
  KEY `PersonnelAdjustmentsAndDeductions_idx` (`TIN`),
  CONSTRAINT `TINAdjustmentsAndDeductions` FOREIGN KEY (`TIN`) REFERENCES `Personnel` (`TIN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Client`
--

DROP TABLE IF EXISTS `Client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Client` (
  `Name` varchar(30) NOT NULL,
  `SHVariable` decimal(10,2) DEFAULT NULL,
  `LHVariable` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DTR`
--

DROP TABLE IF EXISTS `DTR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DTR` (
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
  CONSTRAINT `TINDTR` FOREIGN KEY (`TIN`) REFERENCES `Personnel` (`TIN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Password`
--

DROP TABLE IF EXISTS `Password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Password` (
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Payslip`
--

DROP TABLE IF EXISTS `Payslip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payslip` (
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
  CONSTRAINT `TINPayslip` FOREIGN KEY (`TIN`) REFERENCES `Personnel` (`TIN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Personnel`
--

DROP TABLE IF EXISTS `Personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Personnel` (
  `Name` varchar(50) DEFAULT NULL,
  `Assignment` varchar(30) DEFAULT NULL,
  `Position` varchar(30) DEFAULT NULL,
  `EmployeeStatus` varchar(20) DEFAULT NULL,
  `DailyRate` decimal(10,2) DEFAULT NULL,
  `ColaRate` decimal(10,2) DEFAULT NULL,
  `MonthlyRate` decimal(10,2) DEFAULT NULL,
  `TIN` varchar(20) NOT NULL,
  `TaxStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TIN`),
  KEY `ClientPersonnel_idx` (`Assignment`),
  CONSTRAINT `ClientPersonnel` FOREIGN KEY (`Assignment`) REFERENCES `Client` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TaxTable`
--

DROP TABLE IF EXISTS `TaxTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TaxTable` (
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-28 21:56:23
