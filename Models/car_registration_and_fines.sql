-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2022 at 10:50 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car_registration_and_fines`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminaccount`
--

CREATE TABLE `adminaccount` (
  `adminID` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `fines`
--

CREATE TABLE `fines` (
  `carType` varchar(35) NOT NULL,
  `carPlateNumber` int(11) NOT NULL,
  `annualNumber` varchar(35) NOT NULL,
  `finesHistoryDate` varchar(35) NOT NULL,
  `typeOfTrafficViolation` varchar(35) NOT NULL,
  `amountOfTrafficViolationMoney` double NOT NULL,
  `totalNumberOfTrafficViolation` int(11) NOT NULL,
  `totalAmountOfTrafficViolationMoney` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `renewannual`
--

CREATE TABLE `renewannual` (
  `vehiclePlateNumber` int(11) NOT NULL,
  `ownerFullName` varchar(50) NOT NULL,
  `ownerAddress` varchar(75) NOT NULL,
  `carModel` varchar(35) NOT NULL,
  `carType` varchar(35) NOT NULL,
  `Vin` varchar(17) NOT NULL,
  `carColor` varchar(35) NOT NULL,
  `startDate` varchar(35) NOT NULL,
  `endDate` varchar(35) NOT NULL,
  `vheicleSafetyEndDate` varchar(35) NOT NULL,
  `environmentFinesEndDate` varchar(35) NOT NULL,
  `vheicleChainNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleID` int(11) NOT NULL,
  `vehicleModelName` varchar(35) NOT NULL,
  `vehicleYearModel` int(11) NOT NULL,
  `annualNumber` varchar(35) NOT NULL,
  `vehicleColor` varchar(35) NOT NULL,
  `ownerName` varchar(50) NOT NULL,
  `plateNumber` int(11) NOT NULL,
  `vehicleType` varchar(35) NOT NULL,
  `Vin` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminaccount`
--
ALTER TABLE `adminaccount`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `fines`
--
ALTER TABLE `fines`
  ADD KEY `carType` (`carType`),
  ADD KEY `carPlateNumber` (`carPlateNumber`),
  ADD KEY `annualNumber` (`annualNumber`);

--
-- Indexes for table `renewannual`
--
ALTER TABLE `renewannual`
  ADD PRIMARY KEY (`vheicleChainNumber`),
  ADD UNIQUE KEY `vheicleChainNumber` (`vheicleChainNumber`),
  ADD KEY `vehiclePlateNumber` (`vehiclePlateNumber`,`Vin`),
  ADD KEY `ownerFullName` (`ownerFullName`),
  ADD KEY `carModel` (`carModel`),
  ADD KEY `carType` (`carType`),
  ADD KEY `Vin` (`Vin`),
  ADD KEY `carColor` (`carColor`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleID`,`Vin`),
  ADD UNIQUE KEY `annualNumber_2` (`annualNumber`),
  ADD UNIQUE KEY `plateNumber` (`plateNumber`),
  ADD UNIQUE KEY `Vin` (`Vin`),
  ADD KEY `annualNumber` (`annualNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminaccount`
--
ALTER TABLE `adminaccount`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
