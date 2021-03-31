-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 01, 2020 at 02:29 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mynewdb`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `avilableparts`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `avilableparts`;
CREATE TABLE IF NOT EXISTS `avilableparts` (
`ProductID` varchar(10)
,`ProductName` varchar(100)
,`SUM(``Quantity``)` decimal(32,0)
,`UnitPrice` double
);

-- --------------------------------------------------------

--
-- Table structure for table `customert`
--

DROP TABLE IF EXISTS `customert`;
CREATE TABLE IF NOT EXISTS `customert` (
  `CusVehicleNO` varchar(10) NOT NULL,
  `CusName` varchar(50) NOT NULL,
  `CusEmail` varchar(100) NOT NULL,
  `CusPNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`CusVehicleNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employeet`
--

DROP TABLE IF EXISTS `employeet`;
CREATE TABLE IF NOT EXISTS `employeet` (
  `EmployeeID` varchar(10) NOT NULL,
  `EmployeeName` varchar(50) NOT NULL,
  `EmployeePNum` varchar(10) NOT NULL,
  `EmployeeEmail` varchar(100) NOT NULL,
  `Salary` double NOT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
CREATE TABLE IF NOT EXISTS `income` (
  `VehicleNo` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `RepPayment` double DEFAULT NULL,
  `ResPayment` double DEFAULT NULL,
  PRIMARY KEY (`VehicleNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `joballocation`
--

DROP TABLE IF EXISTS `joballocation`;
CREATE TABLE IF NOT EXISTS `joballocation` (
  `FK_CusVehicleNO` varchar(10) NOT NULL,
  `FK_EmployeeID` varchar(10) NOT NULL,
  `IssueDate` date NOT NULL,
  PRIMARY KEY (`FK_CusVehicleNO`,`FK_EmployeeID`),
  KEY `Foreign Key PastsRes` (`FK_EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `managepartst`
--

DROP TABLE IF EXISTS `managepartst`;
CREATE TABLE IF NOT EXISTS `managepartst` (
  `BillNo` int NOT NULL,
  `SupplierID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `addDate` date NOT NULL,
  `UnitPrice` double NOT NULL,
  `Discount` double NOT NULL,
  `Quantity` int NOT NULL,
  `DiscountedPrice` double NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`BillNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `repairjobst`
--

DROP TABLE IF EXISTS `repairjobst`;
CREATE TABLE IF NOT EXISTS `repairjobst` (
  `FK_CusVehicleNO` varchar(10) NOT NULL,
  `JobName` varchar(500) NOT NULL,
  `Payment` double NOT NULL,
  PRIMARY KEY (`FK_CusVehicleNO`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `restorejobs`
--

DROP TABLE IF EXISTS `restorejobs`;
CREATE TABLE IF NOT EXISTS `restorejobs` (
  `FK_VehicleNO` varchar(10) NOT NULL,
  `FK_PartsID` varchar(10) NOT NULL,
  `PartsName` varchar(50) NOT NULL,
  `Quantity` double NOT NULL,
  `Selling Cost` double NOT NULL,
  `Payment` double NOT NULL,
  PRIMARY KEY (`FK_VehicleNO`,`FK_PartsID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `suppliert`
--

DROP TABLE IF EXISTS `suppliert`;
CREATE TABLE IF NOT EXISTS `suppliert` (
  `SupID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SupBName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SupFName` varchar(30) NOT NULL,
  `SupSName` varchar(30) NOT NULL,
  `supMNum` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `supTNum` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `supMail` varchar(100) NOT NULL,
  `supWeb` varchar(100) NOT NULL,
  `SupAddL1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SupAddL2` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SupCity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SubState` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `SubZip` varchar(10) DEFAULT NULL,
  `SubCountry` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`SupID`,`SupBName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure for view `avilableparts`
--
DROP TABLE IF EXISTS `avilableparts`;

DROP VIEW IF EXISTS `avilableparts`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `avilableparts`  AS  select `managepartst`.`ProductID` AS `ProductID`,`managepartst`.`ProductName` AS `ProductName`,sum(`managepartst`.`Quantity`) AS `SUM(``Quantity``)`,`managepartst`.`UnitPrice` AS `UnitPrice` from `managepartst` group by `managepartst`.`ProductID` ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `joballocation`
--
ALTER TABLE `joballocation`
  ADD CONSTRAINT `Foreign Key` FOREIGN KEY (`FK_CusVehicleNO`) REFERENCES `customert` (`CusVehicleNO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Foreign Key PastsRes` FOREIGN KEY (`FK_EmployeeID`) REFERENCES `employeet` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
