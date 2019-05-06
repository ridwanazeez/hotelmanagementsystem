-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 06, 2019 at 12:37 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms_db`
--
CREATE DATABASE IF NOT EXISTS `hms_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hms_db`;

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
CREATE TABLE IF NOT EXISTS `bookings` (
  `BID` int(3) NOT NULL AUTO_INCREMENT,
  `RID` int(3) NOT NULL,
  `GID` int(3) NOT NULL,
  `CheckIn` date NOT NULL,
  `CheckOut` date NOT NULL,
  PRIMARY KEY (`BID`),
  KEY `RID` (`RID`),
  KEY `GID` (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

DROP TABLE IF EXISTS `guests`;
CREATE TABLE IF NOT EXISTS `guests` (
  `GID` int(3) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `DateofBirth` date NOT NULL,
  `Number` varchar(13) NOT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `guests`
--

INSERT INTO `guests` (`GID`, `FirstName`, `LastName`, `Address`, `DateofBirth`, `Number`) VALUES
(1, 'Marvin', 'Dolo', 'Green Street', '1985-05-05', '555-111-1234'),
(2, 'Aubrey', 'Graham', '6th Street', '1986-10-24', '416-666-6666');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
CREATE TABLE IF NOT EXISTS `rooms` (
  `RID` int(3) NOT NULL AUTO_INCREMENT,
  `RoomNumber` varchar(3) NOT NULL,
  `NumberOfBeds` int(1) NOT NULL,
  `NumberOfBathrooms` int(1) NOT NULL,
  `Price` int(5) NOT NULL,
  `Status` varchar(10) NOT NULL,
  PRIMARY KEY (`RID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`RID`, `RoomNumber`, `NumberOfBeds`, `NumberOfBathrooms`, `Price`, `Status`) VALUES
(1, 'A1', 1, 1, 14000, 'FREE'),
(2, 'A2', 2, 1, 20000, 'FREE'),
(3, 'A3', 3, 1, 25000, 'FREE'),
(4, 'A4', 2, 1, 20000, 'FREE'),
(5, 'A5', 1, 1, 14000, 'FREE');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `UID` int(3) NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UID`, `Username`, `Password`) VALUES
(1, 'ridwan', 'ridwan');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`RID`) REFERENCES `rooms` (`RID`),
  ADD CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`GID`) REFERENCES `guests` (`GID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
