-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2022 at 03:43 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hr`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `date` date DEFAULT NULL,
  `deviceUserId` varchar(255) DEFAULT NULL,
  `govtHoliday` bit(1) NOT NULL,
  `homeOffice` bit(1) NOT NULL,
  `intime` varchar(255) DEFAULT NULL,
  `late` bigint(20) NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  `outtime` varchar(255) DEFAULT NULL,
  `overTime` bigint(20) NOT NULL,
  `personalLeave` bit(1) NOT NULL,
  `personalLeaveReason` varchar(255) DEFAULT NULL,
  `personalLeaveType` varchar(255) DEFAULT NULL,
  `present` bit(1) NOT NULL,
  `publicHoliday` bit(1) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`, `status`) VALUES
(1, 'Software', b'1'),
(2, 'Marketing', b'1'),
(3, 'HR', b'1'),
(4, 'BD Electric', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE `designation` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation` (`id`, `name`, `status`) VALUES
(1, 'Senior Software Engineer', b'1'),
(2, 'Software Developer', b'0'),
(3, 'ERP Head', b'1'),
(4, 'Marketing Executive', b'1'),
(5, 'HR Manager', b'1'),
(6, 'Maid', b'1'),
(7, 'BD Electric', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE `document` (
  `id` bigint(20) NOT NULL,
  `bucketName` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `fileDir` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `bankAccount` varchar(255) DEFAULT NULL,
  `bankAmount` decimal(19,2) DEFAULT NULL,
  `bankName` varchar(255) DEFAULT NULL,
  `cashAmount` decimal(19,2) DEFAULT NULL,
  `checkAmount` decimal(19,2) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  `designationId` bigint(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `gradeId` bigint(20) DEFAULT NULL,
  `joiningDate` date DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `paymentType` varchar(255) DEFAULT NULL,
  `permanentDate` date DEFAULT NULL,
  `photo` longblob DEFAULT NULL,
  `provisionPeriod` int(11) NOT NULL,
  `resignDate` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `tin` varchar(255) DEFAULT NULL,
  `totalSalary` decimal(19,2) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `bankAccount`, `bankAmount`, `bankName`, `cashAmount`, `checkAmount`, `departmentId`, `designationId`, `dob`, `fullName`, `gender`, `gradeId`, `joiningDate`, `mobile`, `paymentType`, `permanentDate`, `photo`, `provisionPeriod`, `resignDate`, `status`, `tin`, `totalSalary`, `userId`) VALUES
(1, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Mozammel', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 1),
(2, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Zubayer', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 2),
(3, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Kajol khandoker', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 3),
(4, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Abbu Bakkar siddik', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 4),
(5, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Shamim hossain', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 5),
(6, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Asif bissaw', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 6),
(7, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Shimul mollik', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 7),
(8, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Md:Rakubul isalm', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 8),
(9, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Tawhid islam', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, NULL, b'1', '', NULL, 9),
(10, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Adnan ', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 10),
(11, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'M.S kayum', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 11),
(12, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Bithi', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 12),
(13, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Keya', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 13),
(14, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Hasibul', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 14),
(15, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Imran', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 15),
(16, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Maliha', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 16),
(17, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Sharar Mehadi', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 17),
(18, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Sulmain', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 18),
(19, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Shoumik', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 19),
(20, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'LIMON ', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 20),
(21, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Azad Sir', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 21),
(22, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'kamaruzzaman', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 23),
(23, '', NULL, '', NULL, NULL, 1, 1, '2022-09-02', 'Rayed', 'MALE', 1, '2022-09-02', '', 'BANK', '2022-09-02', NULL, 0, '2022-09-02', b'1', '', NULL, 22);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `present` bit(1) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `date`, `month`, `present`, `userId`, `year`) VALUES
(1, '2022-08-01', 'AUG', b'1', 1, '2022'),
(2, '2022-08-01', 'AUG', b'0', 2, '2022'),
(3, '2022-08-01', 'AUG', b'1', 3, '2022'),
(4, '2022-08-01', 'AUG', b'0', 4, '2022'),
(5, '2022-08-01', 'AUG', b'0', 5, '2022'),
(6, '2022-08-01', 'AUG', b'1', 6, '2022'),
(7, '2022-08-01', 'AUG', b'0', 7, '2022'),
(8, '2022-08-01', 'AUG', b'1', 8, '2022'),
(9, '2022-08-01', 'AUG', b'1', 9, '2022'),
(10, '2022-08-01', 'AUG', b'1', 10, '2022'),
(11, '2022-08-01', 'AUG', b'1', 11, '2022'),
(12, '2022-08-01', 'AUG', b'1', 12, '2022'),
(13, '2022-08-01', 'AUG', b'0', 13, '2022'),
(14, '2022-08-01', 'AUG', b'0', 14, '2022'),
(15, '2022-08-01', 'AUG', b'1', 15, '2022'),
(16, '2022-08-01', 'AUG', b'1', 16, '2022'),
(17, '2022-08-01', 'AUG', b'1', 17, '2022'),
(18, '2022-08-01', 'AUG', b'1', 18, '2022'),
(19, '2022-08-01', 'AUG', b'1', 19, '2022'),
(20, '2022-08-01', 'AUG', b'0', 20, '2022'),
(21, '2022-08-01', 'AUG', b'1', 21, '2022'),
(22, '2022-08-01', 'AUG', b'1', 22, '2022'),
(23, '2022-08-01', 'AUG', b'1', 23, '2022'),
(24, '2022-08-02', 'AUG', b'0', 1, '2022'),
(25, '2022-08-02', 'AUG', b'0', 2, '2022'),
(26, '2022-08-02', 'AUG', b'1', 3, '2022'),
(27, '2022-08-02', 'AUG', b'0', 4, '2022'),
(28, '2022-08-02', 'AUG', b'1', 5, '2022'),
(29, '2022-08-02', 'AUG', b'1', 6, '2022'),
(30, '2022-08-02', 'AUG', b'0', 7, '2022'),
(31, '2022-08-02', 'AUG', b'0', 8, '2022'),
(32, '2022-08-02', 'AUG', b'1', 9, '2022'),
(33, '2022-08-02', 'AUG', b'0', 10, '2022'),
(34, '2022-08-02', 'AUG', b'1', 11, '2022'),
(35, '2022-08-02', 'AUG', b'1', 12, '2022'),
(36, '2022-08-02', 'AUG', b'0', 13, '2022'),
(37, '2022-08-02', 'AUG', b'0', 14, '2022'),
(38, '2022-08-02', 'AUG', b'1', 15, '2022'),
(39, '2022-08-02', 'AUG', b'1', 16, '2022'),
(40, '2022-08-02', 'AUG', b'1', 17, '2022'),
(41, '2022-08-02', 'AUG', b'1', 18, '2022'),
(42, '2022-08-02', 'AUG', b'0', 19, '2022'),
(43, '2022-08-02', 'AUG', b'0', 20, '2022'),
(44, '2022-08-02', 'AUG', b'1', 21, '2022'),
(45, '2022-08-02', 'AUG', b'0', 22, '2022'),
(46, '2022-08-02', 'AUG', b'1', 23, '2022'),
(47, '2022-08-03', 'AUG', b'0', 4, '2022'),
(48, '2022-08-03', 'AUG', b'0', 10, '2022'),
(49, '2022-08-03', 'AUG', b'1', 6, '2022'),
(50, '2022-08-03', 'AUG', b'1', 21, '2022'),
(51, '2022-08-03', 'AUG', b'1', 12, '2022'),
(52, '2022-08-03', 'AUG', b'0', 14, '2022'),
(53, '2022-08-03', 'AUG', b'1', 15, '2022'),
(54, '2022-08-03', 'AUG', b'1', 3, '2022'),
(55, '2022-08-03', 'AUG', b'0', 13, '2022'),
(56, '2022-08-03', 'AUG', b'0', 20, '2022'),
(57, '2022-08-03', 'AUG', b'1', 11, '2022'),
(58, '2022-08-03', 'AUG', b'1', 16, '2022'),
(59, '2022-08-03', 'AUG', b'1', 8, '2022'),
(60, '2022-08-03', 'AUG', b'0', 1, '2022'),
(61, '2022-08-03', 'AUG', b'0', 22, '2022'),
(62, '2022-08-03', 'AUG', b'1', 5, '2022'),
(63, '2022-08-03', 'AUG', b'1', 17, '2022'),
(64, '2022-08-03', 'AUG', b'0', 7, '2022'),
(65, '2022-08-03', 'AUG', b'0', 19, '2022'),
(66, '2022-08-03', 'AUG', b'1', 18, '2022'),
(67, '2022-08-03', 'AUG', b'1', 9, '2022'),
(68, '2022-08-03', 'AUG', b'0', 2, '2022'),
(69, '2022-08-03', 'AUG', b'1', 23, '2022'),
(70, '2022-08-04', 'AUG', b'0', 4, '2022'),
(71, '2022-08-04', 'AUG', b'1', 10, '2022'),
(72, '2022-08-04', 'AUG', b'1', 6, '2022'),
(73, '2022-08-04', 'AUG', b'1', 21, '2022'),
(74, '2022-08-04', 'AUG', b'1', 12, '2022'),
(75, '2022-08-04', 'AUG', b'0', 14, '2022'),
(76, '2022-08-04', 'AUG', b'1', 15, '2022'),
(77, '2022-08-04', 'AUG', b'1', 3, '2022'),
(78, '2022-08-04', 'AUG', b'0', 13, '2022'),
(79, '2022-08-04', 'AUG', b'0', 20, '2022'),
(80, '2022-08-04', 'AUG', b'1', 11, '2022'),
(81, '2022-08-04', 'AUG', b'1', 16, '2022'),
(82, '2022-08-04', 'AUG', b'1', 8, '2022'),
(83, '2022-08-04', 'AUG', b'1', 1, '2022'),
(84, '2022-08-04', 'AUG', b'0', 22, '2022'),
(85, '2022-08-04', 'AUG', b'0', 5, '2022'),
(86, '2022-08-04', 'AUG', b'1', 17, '2022'),
(87, '2022-08-04', 'AUG', b'0', 7, '2022'),
(88, '2022-08-04', 'AUG', b'1', 19, '2022'),
(89, '2022-08-04', 'AUG', b'1', 18, '2022'),
(90, '2022-08-04', 'AUG', b'1', 9, '2022'),
(91, '2022-08-04', 'AUG', b'0', 2, '2022'),
(92, '2022-08-04', 'AUG', b'1', 23, '2022'),
(93, '2022-08-06', 'AUG', b'0', 4, '2022'),
(94, '2022-08-06', 'AUG', b'1', 10, '2022'),
(95, '2022-08-06', 'AUG', b'1', 6, '2022'),
(96, '2022-08-06', 'AUG', b'1', 21, '2022'),
(97, '2022-08-06', 'AUG', b'1', 12, '2022'),
(98, '2022-08-06', 'AUG', b'0', 14, '2022'),
(99, '2022-08-06', 'AUG', b'1', 15, '2022'),
(100, '2022-08-06', 'AUG', b'1', 3, '2022'),
(101, '2022-08-06', 'AUG', b'0', 13, '2022'),
(102, '2022-08-06', 'AUG', b'0', 20, '2022'),
(103, '2022-08-06', 'AUG', b'0', 11, '2022'),
(104, '2022-08-06', 'AUG', b'1', 16, '2022'),
(105, '2022-08-06', 'AUG', b'1', 8, '2022'),
(106, '2022-08-06', 'AUG', b'0', 1, '2022'),
(107, '2022-08-06', 'AUG', b'0', 22, '2022'),
(108, '2022-08-06', 'AUG', b'1', 5, '2022'),
(109, '2022-08-06', 'AUG', b'1', 17, '2022'),
(110, '2022-08-06', 'AUG', b'0', 7, '2022'),
(111, '2022-08-06', 'AUG', b'1', 19, '2022'),
(112, '2022-08-06', 'AUG', b'1', 18, '2022'),
(113, '2022-08-06', 'AUG', b'1', 9, '2022'),
(114, '2022-08-06', 'AUG', b'1', 2, '2022'),
(115, '2022-08-06', 'AUG', b'1', 23, '2022'),
(116, '2022-08-08', 'AUG', b'0', 4, '2022'),
(117, '2022-08-08', 'AUG', b'1', 10, '2022'),
(118, '2022-08-08', 'AUG', b'1', 6, '2022'),
(119, '2022-08-08', 'AUG', b'1', 21, '2022'),
(120, '2022-08-08', 'AUG', b'1', 12, '2022'),
(121, '2022-08-08', 'AUG', b'0', 14, '2022'),
(122, '2022-08-08', 'AUG', b'1', 15, '2022'),
(123, '2022-08-08', 'AUG', b'1', 3, '2022'),
(124, '2022-08-08', 'AUG', b'0', 13, '2022'),
(125, '2022-08-08', 'AUG', b'0', 20, '2022'),
(126, '2022-08-08', 'AUG', b'0', 11, '2022'),
(127, '2022-08-08', 'AUG', b'1', 16, '2022'),
(128, '2022-08-08', 'AUG', b'1', 8, '2022'),
(129, '2022-08-08', 'AUG', b'1', 1, '2022'),
(130, '2022-08-08', 'AUG', b'0', 22, '2022'),
(131, '2022-08-08', 'AUG', b'1', 5, '2022'),
(132, '2022-08-08', 'AUG', b'1', 17, '2022'),
(133, '2022-08-08', 'AUG', b'0', 7, '2022'),
(134, '2022-08-08', 'AUG', b'1', 19, '2022'),
(135, '2022-08-08', 'AUG', b'1', 18, '2022'),
(136, '2022-08-08', 'AUG', b'1', 9, '2022'),
(137, '2022-08-08', 'AUG', b'0', 2, '2022'),
(138, '2022-08-08', 'AUG', b'1', 23, '2022'),
(139, '2022-08-10', 'AUG', b'0', 4, '2022'),
(140, '2022-08-10', 'AUG', b'0', 10, '2022'),
(141, '2022-08-10', 'AUG', b'1', 6, '2022'),
(142, '2022-08-10', 'AUG', b'1', 21, '2022'),
(143, '2022-08-10', 'AUG', b'1', 12, '2022'),
(144, '2022-08-10', 'AUG', b'0', 14, '2022'),
(145, '2022-08-10', 'AUG', b'1', 15, '2022'),
(146, '2022-08-10', 'AUG', b'1', 3, '2022'),
(147, '2022-08-10', 'AUG', b'0', 13, '2022'),
(148, '2022-08-10', 'AUG', b'0', 20, '2022'),
(149, '2022-08-10', 'AUG', b'0', 11, '2022'),
(150, '2022-08-10', 'AUG', b'1', 16, '2022'),
(151, '2022-08-10', 'AUG', b'0', 8, '2022'),
(152, '2022-08-10', 'AUG', b'0', 1, '2022'),
(153, '2022-08-10', 'AUG', b'0', 22, '2022'),
(154, '2022-08-10', 'AUG', b'1', 5, '2022'),
(155, '2022-08-10', 'AUG', b'1', 17, '2022'),
(156, '2022-08-10', 'AUG', b'0', 7, '2022'),
(157, '2022-08-10', 'AUG', b'0', 19, '2022'),
(158, '2022-08-10', 'AUG', b'1', 18, '2022'),
(159, '2022-08-10', 'AUG', b'1', 9, '2022'),
(160, '2022-08-10', 'AUG', b'0', 2, '2022'),
(161, '2022-08-10', 'AUG', b'1', 23, '2022'),
(162, '2022-08-11', 'AUG', b'0', 4, '2022'),
(163, '2022-08-11', 'AUG', b'0', 10, '2022'),
(164, '2022-08-11', 'AUG', b'1', 6, '2022'),
(165, '2022-08-11', 'AUG', b'1', 21, '2022'),
(166, '2022-08-11', 'AUG', b'1', 12, '2022'),
(167, '2022-08-11', 'AUG', b'0', 14, '2022'),
(168, '2022-08-11', 'AUG', b'1', 15, '2022'),
(169, '2022-08-11', 'AUG', b'0', 3, '2022'),
(170, '2022-08-11', 'AUG', b'0', 13, '2022'),
(171, '2022-08-11', 'AUG', b'0', 20, '2022'),
(172, '2022-08-11', 'AUG', b'0', 11, '2022'),
(173, '2022-08-11', 'AUG', b'1', 16, '2022'),
(174, '2022-08-11', 'AUG', b'0', 8, '2022'),
(175, '2022-08-11', 'AUG', b'0', 1, '2022'),
(176, '2022-08-11', 'AUG', b'0', 22, '2022'),
(177, '2022-08-11', 'AUG', b'1', 5, '2022'),
(178, '2022-08-11', 'AUG', b'1', 17, '2022'),
(179, '2022-08-11', 'AUG', b'0', 7, '2022'),
(180, '2022-08-11', 'AUG', b'0', 19, '2022'),
(181, '2022-08-11', 'AUG', b'1', 18, '2022'),
(182, '2022-08-11', 'AUG', b'1', 9, '2022'),
(183, '2022-08-11', 'AUG', b'0', 2, '2022'),
(184, '2022-08-11', 'AUG', b'1', 23, '2022'),
(185, '2022-08-13', 'AUG', b'0', 4, '2022'),
(186, '2022-08-13', 'AUG', b'1', 10, '2022'),
(187, '2022-08-13', 'AUG', b'1', 6, '2022'),
(188, '2022-08-13', 'AUG', b'1', 21, '2022'),
(189, '2022-08-13', 'AUG', b'1', 12, '2022'),
(190, '2022-08-13', 'AUG', b'0', 14, '2022'),
(191, '2022-08-13', 'AUG', b'1', 15, '2022'),
(192, '2022-08-13', 'AUG', b'1', 3, '2022'),
(193, '2022-08-13', 'AUG', b'0', 13, '2022'),
(194, '2022-08-13', 'AUG', b'0', 20, '2022'),
(195, '2022-08-13', 'AUG', b'0', 11, '2022'),
(196, '2022-08-13', 'AUG', b'1', 16, '2022'),
(197, '2022-08-13', 'AUG', b'1', 8, '2022'),
(198, '2022-08-13', 'AUG', b'1', 1, '2022'),
(199, '2022-08-13', 'AUG', b'0', 22, '2022'),
(200, '2022-08-13', 'AUG', b'1', 5, '2022'),
(201, '2022-08-13', 'AUG', b'1', 17, '2022'),
(202, '2022-08-13', 'AUG', b'0', 7, '2022'),
(203, '2022-08-13', 'AUG', b'1', 19, '2022'),
(204, '2022-08-13', 'AUG', b'1', 18, '2022'),
(205, '2022-08-13', 'AUG', b'1', 9, '2022'),
(206, '2022-08-13', 'AUG', b'1', 2, '2022'),
(207, '2022-08-13', 'AUG', b'1', 23, '2022'),
(208, '2022-08-14', 'AUG', b'0', 4, '2022'),
(209, '2022-08-14', 'AUG', b'0', 10, '2022'),
(210, '2022-08-14', 'AUG', b'0', 6, '2022'),
(211, '2022-08-14', 'AUG', b'0', 21, '2022'),
(212, '2022-08-14', 'AUG', b'0', 12, '2022'),
(213, '2022-08-14', 'AUG', b'0', 14, '2022'),
(214, '2022-08-14', 'AUG', b'0', 15, '2022'),
(215, '2022-08-14', 'AUG', b'0', 3, '2022'),
(216, '2022-08-14', 'AUG', b'0', 13, '2022'),
(217, '2022-08-14', 'AUG', b'0', 20, '2022'),
(218, '2022-08-14', 'AUG', b'0', 11, '2022'),
(219, '2022-08-14', 'AUG', b'0', 16, '2022'),
(220, '2022-08-14', 'AUG', b'0', 8, '2022'),
(221, '2022-08-14', 'AUG', b'0', 1, '2022'),
(222, '2022-08-14', 'AUG', b'1', 22, '2022'),
(223, '2022-08-14', 'AUG', b'0', 5, '2022'),
(224, '2022-08-14', 'AUG', b'1', 17, '2022'),
(225, '2022-08-14', 'AUG', b'0', 7, '2022'),
(226, '2022-08-14', 'AUG', b'0', 19, '2022'),
(227, '2022-08-14', 'AUG', b'0', 18, '2022'),
(228, '2022-08-14', 'AUG', b'0', 9, '2022'),
(229, '2022-08-14', 'AUG', b'0', 2, '2022'),
(230, '2022-08-14', 'AUG', b'0', 23, '2022'),
(231, '2022-08-15', 'AUG', b'0', 4, '2022'),
(232, '2022-08-15', 'AUG', b'0', 10, '2022'),
(233, '2022-08-15', 'AUG', b'0', 6, '2022'),
(234, '2022-08-15', 'AUG', b'0', 21, '2022'),
(235, '2022-08-15', 'AUG', b'0', 12, '2022'),
(236, '2022-08-15', 'AUG', b'0', 14, '2022'),
(237, '2022-08-15', 'AUG', b'0', 15, '2022'),
(238, '2022-08-15', 'AUG', b'0', 3, '2022'),
(239, '2022-08-15', 'AUG', b'0', 13, '2022'),
(240, '2022-08-15', 'AUG', b'0', 20, '2022'),
(241, '2022-08-15', 'AUG', b'0', 11, '2022'),
(242, '2022-08-15', 'AUG', b'0', 16, '2022'),
(243, '2022-08-15', 'AUG', b'0', 8, '2022'),
(244, '2022-08-15', 'AUG', b'0', 1, '2022'),
(245, '2022-08-15', 'AUG', b'0', 22, '2022'),
(246, '2022-08-15', 'AUG', b'0', 5, '2022'),
(247, '2022-08-15', 'AUG', b'0', 17, '2022'),
(248, '2022-08-15', 'AUG', b'0', 7, '2022'),
(249, '2022-08-15', 'AUG', b'0', 19, '2022'),
(250, '2022-08-15', 'AUG', b'0', 18, '2022'),
(251, '2022-08-15', 'AUG', b'0', 9, '2022'),
(252, '2022-08-15', 'AUG', b'0', 2, '2022'),
(253, '2022-08-15', 'AUG', b'0', 23, '2022'),
(254, '2022-08-16', 'AUG', b'0', 4, '2022'),
(255, '2022-08-16', 'AUG', b'0', 10, '2022'),
(256, '2022-08-16', 'AUG', b'1', 6, '2022'),
(257, '2022-08-16', 'AUG', b'1', 21, '2022'),
(258, '2022-08-16', 'AUG', b'1', 12, '2022'),
(259, '2022-08-16', 'AUG', b'0', 14, '2022'),
(260, '2022-08-16', 'AUG', b'1', 15, '2022'),
(261, '2022-08-16', 'AUG', b'1', 3, '2022'),
(262, '2022-08-16', 'AUG', b'0', 13, '2022'),
(263, '2022-08-16', 'AUG', b'0', 20, '2022'),
(264, '2022-08-16', 'AUG', b'0', 11, '2022'),
(265, '2022-08-16', 'AUG', b'0', 16, '2022'),
(266, '2022-08-16', 'AUG', b'1', 8, '2022'),
(267, '2022-08-16', 'AUG', b'1', 1, '2022'),
(268, '2022-08-16', 'AUG', b'1', 22, '2022'),
(269, '2022-08-16', 'AUG', b'1', 5, '2022'),
(270, '2022-08-16', 'AUG', b'1', 17, '2022'),
(271, '2022-08-16', 'AUG', b'0', 7, '2022'),
(272, '2022-08-16', 'AUG', b'0', 19, '2022'),
(273, '2022-08-16', 'AUG', b'1', 18, '2022'),
(274, '2022-08-16', 'AUG', b'0', 9, '2022'),
(275, '2022-08-16', 'AUG', b'0', 2, '2022'),
(276, '2022-08-16', 'AUG', b'1', 23, '2022'),
(277, '2022-08-17', 'AUG', b'0', 4, '2022'),
(278, '2022-08-17', 'AUG', b'1', 10, '2022'),
(279, '2022-08-17', 'AUG', b'1', 6, '2022'),
(280, '2022-08-17', 'AUG', b'1', 21, '2022'),
(281, '2022-08-17', 'AUG', b'1', 12, '2022'),
(282, '2022-08-17', 'AUG', b'0', 14, '2022'),
(283, '2022-08-17', 'AUG', b'1', 15, '2022'),
(284, '2022-08-17', 'AUG', b'1', 3, '2022'),
(285, '2022-08-17', 'AUG', b'0', 13, '2022'),
(286, '2022-08-17', 'AUG', b'0', 20, '2022'),
(287, '2022-08-17', 'AUG', b'0', 11, '2022'),
(288, '2022-08-17', 'AUG', b'0', 16, '2022'),
(289, '2022-08-17', 'AUG', b'1', 8, '2022'),
(290, '2022-08-17', 'AUG', b'1', 1, '2022'),
(291, '2022-08-17', 'AUG', b'1', 22, '2022'),
(292, '2022-08-17', 'AUG', b'1', 5, '2022'),
(293, '2022-08-17', 'AUG', b'1', 17, '2022'),
(294, '2022-08-17', 'AUG', b'0', 7, '2022'),
(295, '2022-08-17', 'AUG', b'0', 19, '2022'),
(296, '2022-08-17', 'AUG', b'1', 18, '2022'),
(297, '2022-08-17', 'AUG', b'1', 9, '2022'),
(298, '2022-08-17', 'AUG', b'0', 2, '2022'),
(299, '2022-08-17', 'AUG', b'1', 23, '2022'),
(300, '2022-08-18', 'AUG', b'0', 4, '2022'),
(301, '2022-08-18', 'AUG', b'1', 10, '2022'),
(302, '2022-08-18', 'AUG', b'1', 6, '2022'),
(303, '2022-08-18', 'AUG', b'1', 21, '2022'),
(304, '2022-08-18', 'AUG', b'0', 12, '2022'),
(305, '2022-08-18', 'AUG', b'0', 14, '2022'),
(306, '2022-08-18', 'AUG', b'1', 15, '2022'),
(307, '2022-08-18', 'AUG', b'1', 3, '2022'),
(308, '2022-08-18', 'AUG', b'0', 13, '2022'),
(309, '2022-08-18', 'AUG', b'0', 20, '2022'),
(310, '2022-08-18', 'AUG', b'0', 11, '2022'),
(311, '2022-08-18', 'AUG', b'1', 16, '2022'),
(312, '2022-08-18', 'AUG', b'1', 8, '2022'),
(313, '2022-08-18', 'AUG', b'1', 1, '2022'),
(314, '2022-08-18', 'AUG', b'1', 22, '2022'),
(315, '2022-08-18', 'AUG', b'1', 5, '2022'),
(316, '2022-08-18', 'AUG', b'1', 17, '2022'),
(317, '2022-08-18', 'AUG', b'0', 7, '2022'),
(318, '2022-08-18', 'AUG', b'1', 19, '2022'),
(319, '2022-08-18', 'AUG', b'1', 18, '2022'),
(320, '2022-08-18', 'AUG', b'1', 9, '2022'),
(321, '2022-08-18', 'AUG', b'0', 2, '2022'),
(322, '2022-08-18', 'AUG', b'1', 23, '2022'),
(323, '2022-08-20', 'AUG', b'0', 4, '2022'),
(324, '2022-08-20', 'AUG', b'1', 10, '2022'),
(325, '2022-08-20', 'AUG', b'1', 6, '2022'),
(326, '2022-08-20', 'AUG', b'1', 21, '2022'),
(327, '2022-08-20', 'AUG', b'1', 12, '2022'),
(328, '2022-08-20', 'AUG', b'0', 14, '2022'),
(329, '2022-08-20', 'AUG', b'1', 15, '2022'),
(330, '2022-08-20', 'AUG', b'1', 3, '2022'),
(331, '2022-08-20', 'AUG', b'0', 13, '2022'),
(332, '2022-08-20', 'AUG', b'0', 20, '2022'),
(333, '2022-08-20', 'AUG', b'0', 11, '2022'),
(334, '2022-08-20', 'AUG', b'1', 16, '2022'),
(335, '2022-08-20', 'AUG', b'1', 8, '2022'),
(336, '2022-08-20', 'AUG', b'1', 1, '2022'),
(337, '2022-08-20', 'AUG', b'1', 22, '2022'),
(338, '2022-08-20', 'AUG', b'1', 5, '2022'),
(339, '2022-08-20', 'AUG', b'1', 17, '2022'),
(340, '2022-08-20', 'AUG', b'0', 7, '2022'),
(341, '2022-08-20', 'AUG', b'1', 19, '2022'),
(342, '2022-08-20', 'AUG', b'1', 18, '2022'),
(343, '2022-08-20', 'AUG', b'1', 9, '2022'),
(344, '2022-08-20', 'AUG', b'1', 2, '2022'),
(345, '2022-08-20', 'AUG', b'1', 23, '2022'),
(346, '2022-08-21', 'AUG', b'0', 4, '2022'),
(347, '2022-08-21', 'AUG', b'1', 10, '2022'),
(348, '2022-08-21', 'AUG', b'1', 6, '2022'),
(349, '2022-08-21', 'AUG', b'1', 21, '2022'),
(350, '2022-08-21', 'AUG', b'0', 12, '2022'),
(351, '2022-08-21', 'AUG', b'0', 14, '2022'),
(352, '2022-08-21', 'AUG', b'1', 15, '2022'),
(353, '2022-08-21', 'AUG', b'1', 3, '2022'),
(354, '2022-08-21', 'AUG', b'0', 13, '2022'),
(355, '2022-08-21', 'AUG', b'0', 20, '2022'),
(356, '2022-08-21', 'AUG', b'0', 11, '2022'),
(357, '2022-08-21', 'AUG', b'1', 16, '2022'),
(358, '2022-08-21', 'AUG', b'1', 8, '2022'),
(359, '2022-08-21', 'AUG', b'1', 1, '2022'),
(360, '2022-08-21', 'AUG', b'1', 22, '2022'),
(361, '2022-08-21', 'AUG', b'1', 5, '2022'),
(362, '2022-08-21', 'AUG', b'1', 17, '2022'),
(363, '2022-08-21', 'AUG', b'0', 7, '2022'),
(364, '2022-08-21', 'AUG', b'0', 19, '2022'),
(365, '2022-08-21', 'AUG', b'1', 18, '2022'),
(366, '2022-08-21', 'AUG', b'1', 9, '2022'),
(367, '2022-08-21', 'AUG', b'0', 2, '2022'),
(368, '2022-08-21', 'AUG', b'1', 23, '2022'),
(369, '2022-08-22', 'AUG', b'0', 4, '2022'),
(370, '2022-08-22', 'AUG', b'1', 10, '2022'),
(371, '2022-08-22', 'AUG', b'1', 6, '2022'),
(372, '2022-08-22', 'AUG', b'1', 21, '2022'),
(373, '2022-08-22', 'AUG', b'1', 12, '2022'),
(374, '2022-08-22', 'AUG', b'0', 14, '2022'),
(375, '2022-08-22', 'AUG', b'1', 15, '2022'),
(376, '2022-08-22', 'AUG', b'1', 3, '2022'),
(377, '2022-08-22', 'AUG', b'0', 13, '2022'),
(378, '2022-08-22', 'AUG', b'0', 20, '2022'),
(379, '2022-08-22', 'AUG', b'0', 11, '2022'),
(380, '2022-08-22', 'AUG', b'1', 16, '2022'),
(381, '2022-08-22', 'AUG', b'1', 8, '2022'),
(382, '2022-08-22', 'AUG', b'1', 1, '2022'),
(383, '2022-08-22', 'AUG', b'1', 22, '2022'),
(384, '2022-08-22', 'AUG', b'1', 5, '2022'),
(385, '2022-08-22', 'AUG', b'1', 17, '2022'),
(386, '2022-08-22', 'AUG', b'0', 7, '2022'),
(387, '2022-08-22', 'AUG', b'0', 19, '2022'),
(388, '2022-08-22', 'AUG', b'1', 18, '2022'),
(389, '2022-08-22', 'AUG', b'1', 9, '2022'),
(390, '2022-08-22', 'AUG', b'0', 2, '2022'),
(391, '2022-08-22', 'AUG', b'1', 23, '2022'),
(392, '2022-08-23', 'AUG', b'0', 4, '2022'),
(393, '2022-08-23', 'AUG', b'0', 10, '2022'),
(394, '2022-08-23', 'AUG', b'1', 6, '2022'),
(395, '2022-08-23', 'AUG', b'1', 21, '2022'),
(396, '2022-08-23', 'AUG', b'1', 12, '2022'),
(397, '2022-08-23', 'AUG', b'0', 14, '2022'),
(398, '2022-08-23', 'AUG', b'0', 15, '2022'),
(399, '2022-08-23', 'AUG', b'1', 3, '2022'),
(400, '2022-08-23', 'AUG', b'0', 13, '2022'),
(401, '2022-08-23', 'AUG', b'0', 20, '2022'),
(402, '2022-08-23', 'AUG', b'0', 11, '2022'),
(403, '2022-08-23', 'AUG', b'0', 16, '2022'),
(404, '2022-08-23', 'AUG', b'1', 8, '2022'),
(405, '2022-08-23', 'AUG', b'1', 1, '2022'),
(406, '2022-08-23', 'AUG', b'1', 22, '2022'),
(407, '2022-08-23', 'AUG', b'0', 5, '2022'),
(408, '2022-08-23', 'AUG', b'1', 17, '2022'),
(409, '2022-08-23', 'AUG', b'0', 7, '2022'),
(410, '2022-08-23', 'AUG', b'0', 19, '2022'),
(411, '2022-08-23', 'AUG', b'1', 18, '2022'),
(412, '2022-08-23', 'AUG', b'0', 9, '2022'),
(413, '2022-08-23', 'AUG', b'0', 2, '2022'),
(414, '2022-08-23', 'AUG', b'1', 23, '2022'),
(415, '2022-08-24', 'AUG', b'0', 4, '2022'),
(416, '2022-08-24', 'AUG', b'0', 10, '2022'),
(417, '2022-08-24', 'AUG', b'1', 6, '2022'),
(418, '2022-08-24', 'AUG', b'1', 21, '2022'),
(419, '2022-08-24', 'AUG', b'1', 12, '2022'),
(420, '2022-08-24', 'AUG', b'0', 14, '2022'),
(421, '2022-08-24', 'AUG', b'0', 15, '2022'),
(422, '2022-08-24', 'AUG', b'1', 3, '2022'),
(423, '2022-08-24', 'AUG', b'0', 13, '2022'),
(424, '2022-08-24', 'AUG', b'0', 20, '2022'),
(425, '2022-08-24', 'AUG', b'0', 11, '2022'),
(426, '2022-08-24', 'AUG', b'1', 16, '2022'),
(427, '2022-08-24', 'AUG', b'1', 8, '2022'),
(428, '2022-08-24', 'AUG', b'1', 1, '2022'),
(429, '2022-08-24', 'AUG', b'1', 22, '2022'),
(430, '2022-08-24', 'AUG', b'1', 5, '2022'),
(431, '2022-08-24', 'AUG', b'1', 17, '2022'),
(432, '2022-08-24', 'AUG', b'0', 7, '2022'),
(433, '2022-08-24', 'AUG', b'0', 19, '2022'),
(434, '2022-08-24', 'AUG', b'1', 18, '2022'),
(435, '2022-08-24', 'AUG', b'1', 9, '2022'),
(436, '2022-08-24', 'AUG', b'0', 2, '2022'),
(437, '2022-08-24', 'AUG', b'1', 23, '2022');

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `id` bigint(20) NOT NULL,
  `allocatedLeave` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `allocatedLeave`, `code`, `status`) VALUES
(1, 22, 'General', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `grade_detail`
--

CREATE TABLE `grade_detail` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `gradeId` bigint(20) DEFAULT NULL,
  `percentOfTransactionId` bigint(20) DEFAULT NULL,
  `transactionId` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade_detail`
--

INSERT INTO `grade_detail` (`id`, `amount`, `gradeId`, `percentOfTransactionId`, `transactionId`, `type`) VALUES
(1, '50.00', 1, NULL, 1, 'PERCENT'),
(2, '35.00', 1, NULL, 2, 'PERCENT'),
(3, '6.00', 1, NULL, 3, 'PERCENT'),
(4, '8.00', 1, NULL, 4, 'PERCENT'),
(5, '1.00', 1, NULL, 5, 'PERCENT'),
(6, '5.00', 1, NULL, 6, 'PERCENT');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `leave_manager`
--

CREATE TABLE `leave_manager` (
  `id` bigint(20) NOT NULL,
  `alreadyTaken` int(11) NOT NULL,
  `annual` int(11) NOT NULL,
  `approved` int(11) NOT NULL,
  `carryFromPrevYear` int(11) NOT NULL,
  `casual` int(11) NOT NULL,
  `notApproved` int(11) NOT NULL,
  `sick` int(11) NOT NULL,
  `totalAllocatedLeave` int(11) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `date` date DEFAULT NULL,
  `foodBillInMonth` decimal(19,2) DEFAULT NULL,
  `leaveTakenInMonth` int(11) NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  `netPayable` decimal(19,2) DEFAULT NULL,
  `payableAfterBreakDown` decimal(19,2) DEFAULT NULL,
  `totalAttendInMonth` int(11) NOT NULL,
  `totalFoodDaysInMonth` int(11) NOT NULL,
  `totalLateInMonth` int(11) NOT NULL,
  `totalLeaveTakenInYear` int(11) NOT NULL,
  `totalSalary` decimal(19,2) DEFAULT NULL,
  `totalUndeclearedTaskInMonth` int(11) NOT NULL,
  `totalUnpaidLeaveInMonth` int(11) NOT NULL,
  `totalWorkingDaysInMonth` int(11) NOT NULL,
  `unpaidLeaveAmount` decimal(19,2) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `salary_breakdown`
--

CREATE TABLE `salary_breakdown` (
  `id` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `amountType` varchar(255) DEFAULT NULL,
  `gradeName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salaryId` bigint(20) DEFAULT NULL,
  `trnType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `salary_increment`
--

CREATE TABLE `salary_increment` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `deviation` decimal(19,2) DEFAULT NULL,
  `newSalary` decimal(19,2) DEFAULT NULL,
  `previousSalary` decimal(19,2) DEFAULT NULL,
  `startFromMonth` varchar(255) DEFAULT NULL,
  `startFromYear` varchar(255) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `settings`
--

CREATE TABLE `settings` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `allocatedLeave` int(11) NOT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `foodBill` decimal(19,2) DEFAULT NULL,
  `fri` bit(1) NOT NULL,
  `maxCarryLeaveFromPrevYear` int(11) NOT NULL,
  `mobile1` varchar(255) DEFAULT NULL,
  `mobile2` varchar(255) DEFAULT NULL,
  `mobile3` varchar(255) DEFAULT NULL,
  `mon` bit(1) NOT NULL,
  `officeHour` int(11) NOT NULL,
  `officeInTime` varchar(255) DEFAULT NULL,
  `officeOutTime` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `photo` longblob DEFAULT NULL,
  `sat` bit(1) NOT NULL,
  `sun` bit(1) NOT NULL,
  `thu` bit(1) NOT NULL,
  `tue` bit(1) NOT NULL,
  `wed` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `settings`
--

INSERT INTO `settings` (`id`, `address`, `allocatedLeave`, `companyName`, `foodBill`, `fri`, `maxCarryLeaveFromPrevYear`, `mobile1`, `mobile2`, `mobile3`, `mon`, `officeHour`, `officeInTime`, `officeOutTime`, `phone1`, `phone2`, `photo`, `sat`, `sun`, `thu`, `tue`, `wed`) VALUES
(1, '', 22, 'ASL', '35.00', b'1', 0, '', '', '', b'0', 540, '09:30', '18:30', '', '', NULL, b'0', b'0', b'0', b'0', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `transactionType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `name`, `status`, `transactionType`) VALUES
(1, 'Basic Salary', b'1', 'ADDITION'),
(2, 'House Allowance', b'1', 'ADDITION'),
(3, 'Medical Allowance', b'1', 'ADDITION'),
(4, 'Transportation Allowance', b'1', 'ADDITION'),
(5, 'Mobile Allowance', b'1', 'ADDITION'),
(6, 'Provident Fund', b'1', 'DEDUCTION');

-- --------------------------------------------------------

--
-- Table structure for table `us`
--

CREATE TABLE `us` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `us`
--

INSERT INTO `us` (`id`, `email`, `password`, `status`, `username`) VALUES
(1, '', '', b'1', 'Mozammel'),
(2, '', '', b'1', 'Zubayer'),
(3, '', '', b'1', 'Kajol khandoker'),
(4, '', '', b'1', 'Abbu Bakkar siddik'),
(5, '', '', b'1', 'Shamim hossain'),
(6, '', '', b'1', 'Asif bissaw'),
(7, '', '', b'1', 'Shimul mollik'),
(8, '', '', b'1', 'Md:Rakubul isalm'),
(9, '', '', b'1', 'Tawhid islam'),
(10, '', '', b'1', 'Adnan '),
(11, '', '', b'1', 'M.S kayum'),
(12, '', '', b'1', 'Bithi'),
(13, '', '', b'1', 'Keya'),
(14, '', '', b'1', 'Hasibul'),
(15, '', '', b'1', 'Imran'),
(16, '', '', b'1', 'Maliha'),
(17, '', '', b'1', 'Sharar Mehadi'),
(18, '', '', b'1', 'Sulmain'),
(19, '', '', b'1', 'Shoumik'),
(20, '', '', b'1', 'LIMON '),
(21, '', '', b'1', 'Azad Sir'),
(22, '', '', b'1', 'Rayed'),
(23, '', '', b'1', 'kamaruzzaman');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `designation`
--
ALTER TABLE `designation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grade_detail`
--
ALTER TABLE `grade_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leave_manager`
--
ALTER TABLE `leave_manager`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary_breakdown`
--
ALTER TABLE `salary_breakdown`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary_increment`
--
ALTER TABLE `salary_increment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `settings`
--
ALTER TABLE `settings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `us`
--
ALTER TABLE `us`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `designation`
--
ALTER TABLE `designation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=438;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `grade_detail`
--
ALTER TABLE `grade_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `leave_manager`
--
ALTER TABLE `leave_manager`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `salary_breakdown`
--
ALTER TABLE `salary_breakdown`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `salary_increment`
--
ALTER TABLE `salary_increment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `settings`
--
ALTER TABLE `settings`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `us`
--
ALTER TABLE `us`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
