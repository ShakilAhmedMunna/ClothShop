-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2017 at 11:35 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clothemanagementsshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `manufacture_country`
--

CREATE TABLE IF NOT EXISTS `manufacture_country` (
`m_c_id` int(11) NOT NULL,
  `m_c_name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacture_country`
--

INSERT INTO `manufacture_country` (`m_c_id`, `m_c_name`) VALUES
(1, 'Bangladeshi');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
`order_id` int(11) NOT NULL,
  `order_code` varchar(255) NOT NULL,
  `order_qty` int(14) NOT NULL,
  `order_price` int(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `sales_code` varchar(255) NOT NULL,
  `bill` int(14) NOT NULL,
  `discount` float NOT NULL,
  `vat` float NOT NULL,
  `payment` int(14) NOT NULL,
  `payment_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `code` varchar(255) NOT NULL,
  `product_info_id` int(14) NOT NULL,
  `purchase` float NOT NULL,
  `price` float NOT NULL,
  `qty` int(11) NOT NULL,
  `current_qty` int(14) NOT NULL,
  `p_date` date NOT NULL,
  `stock_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`code`, `product_info_id`, `purchase`, `price`, `qty`, `current_qty`, `p_date`, `stock_id`) VALUES
('MW16-1211133092441924', 48, 23, 23, 23, 737, '2016-12-11', 1),
('MW16-1211134039838398', 47, 1, 2, 2, 0, '2016-12-11', 1),
('MW16-1211134069924699', 45, 12, 16, 3, 1087, '2016-12-11', 2),
('XL316-1211134839434394', 46, 22, 55, 2, 343, '2016-12-11', 1),
('XLC16-1211122518026180', 43, 120, 150, 12, 1184, '2016-12-11', 1),
('XLS16-128004315747157', 42, 12, 22, 100, 7093, '2016-12-08', 1),
('XLW16-12111224193019', 44, 12, 16, 4, 41124, '2016-12-11', 2);

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE IF NOT EXISTS `product_info` (
`product_info_id` int(11) NOT NULL,
  `m_c_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `size_id` int(11) NOT NULL,
  `thread_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`product_info_id`, `m_c_id`, `type_id`, `size_id`, `thread_id`) VALUES
(45, 1, 1, 1, 1),
(47, 1, 1, 1, 1),
(48, 1, 1, 1, 1),
(42, 1, 1, 2, 1),
(43, 1, 1, 2, 1),
(44, 1, 1, 2, 1),
(46, 1, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
`id` int(11) NOT NULL,
  `sales_code` varchar(255) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `qty` int(14) NOT NULL,
  `price` int(14) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `sales_code`, `product_code`, `qty`, `price`, `date`) VALUES
(2, '16-129204022112212040', 'XLS16-128004315747157', 2, 44, '2016-12-09'),
(3, '16-1292014445214452014', 'XLS16-128004315747157', 1, 22, '2016-12-09'),
(4, '16-1292014445214452014', 'XLS16-128004315747157', 3, 66, '2016-12-09'),
(5, '16-12101242663386631242', 'XLS16-128004315747157', 2, 44, '2016-12-10'),
(6, '16-12101242663386631242', 'XLS16-128004315747157', 12, 264, '2016-12-10'),
(7, '16-12101203336433361203', 'XLS16-128004315747157', 10, 220, '2016-12-10'),
(8, '16-1217235499399932354', 'XLW16-12111224193019', 3, 48, '2016-12-17'),
(9, '16-1217235499399932354', 'XLW16-12111224193019', 10, 160, '2016-12-17'),
(10, '16-12172305692126922305', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(11, '16-12172305692126922305', 'XLW16-12111224193019', 12, 192, '2016-12-17'),
(12, '16-12172346252122522346', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(13, '16-12172346252122522346', 'XLW16-12111224193019', 23, 368, '2016-12-17'),
(14, '16-12172301274332742301', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(15, '16-12172301274332742301', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(16, '16-12172319212342122319', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(17, '16-12172314234352342314', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(18, '16-12172338762377622338', 'XLW16-12111224193019', 1, 16, '2016-12-17'),
(19, '16-12172338762377622338', 'XLW16-12111224193019', 22, 352, '2016-12-17'),
(20, '16-12172321400394002321', 'XLW16-12111224193019', 12, 192, '2016-12-17'),
(21, '16-121800083632363008', 'MW16-1211133092441924', 1, 23, '2016-12-18'),
(22, '16-121800083632363008', 'MW16-1211133092441924', 12, 276, '2016-12-18'),
(23, '16-121800411947194041', 'MW16-1211134039838398', 1, 2, '2016-12-18'),
(24, '16-121800411947194041', 'MW16-1211134039838398', 100, 200, '2016-12-18'),
(25, '16-121800538919891053', 'MW16-1211134039838398', 10, 20, '2016-12-18'),
(26, '16-1218002210613106022', 'XLC16-1211122518026180', 1, 150, '2016-12-18'),
(27, '16-1218002210613106022', 'XLC16-1211122518026180', 11, 1650, '2016-12-18'),
(28, '16-1218001020119201010', 'XLC16-1211122518026180', 1, 150, '2016-12-18'),
(29, '16-1218001020119201010', 'XLC16-1211122518026180', 1, 150, '2016-12-18'),
(30, '16-12181000114531141000', 'XLC16-1211122518026180', 12, 1800, '2016-12-18'),
(31, '16-12181000114531141000', 'XLC16-1211122518026180', 12, 1800, '2016-12-18'),
(32, '16-12181554855188551554', 'MW16-1211133092441924', 12, 276, '2016-12-18'),
(33, '16-12181554855188551554', 'MW16-1211133092441924', 1, 23, '2016-12-18'),
(34, '16-12181554855188551554', 'MW16-1211133092441924', 5, 115, '2016-12-18'),
(35, '16-12181554855188551554', 'MW16-1211133092441924', 12, 276, '2016-12-18'),
(36, '16-12181554855188551554', 'MW16-1211133092441924', 8, 184, '2016-12-18'),
(37, '17-0141736576175761736', 'XLS16-128004315747157', 12, 264, '2017-01-04'),
(38, '17-0141736576175761736', 'XLS16-128004315747157', 1, 22, '2017-01-04'),
(39, '17-0141733274472741733', 'MW16-1211133092441924', 22, 506, '2017-01-04'),
(40, '17-0141733274472741733', 'MW16-1211133092441924', 1, 23, '2017-01-04'),
(41, '17-0117111392609261113', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(42, '17-0117113740564051137', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(43, '17-011711027411741102', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(44, '17-01171101708127081101', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(45, '17-01171151128501281151', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(46, '17-0117123759625961237', 'MW16-1211134069924699', 1, 16, '2017-01-17'),
(47, '17-01171313296562961313', 'XLS16-128004315747157', 1, 22, '2017-01-17'),
(48, '17-01171320716587161320', 'XLS16-128004315747157', 1, 22, '2017-01-17'),
(49, '17-01171407441124411407', 'XLS16-128004315747157', 1, 22, '2017-01-17'),
(50, '17-01171407441124411407', 'XLS16-128004315747157', 3, 66, '2017-01-17'),
(51, '17-011801431877187143', 'MW16-1211134069924699', 1, 16, '2017-01-18'),
(52, '17-011801431877187143', 'MW16-1211134069924699', 1, 16, '2017-01-18'),
(53, '17-01181137238392381137', 'MW16-1211134069924699', 1, 16, '2017-01-18'),
(54, '17-01181113758527581113', 'MW16-1211134069924699', 1, 16, '2017-01-18'),
(55, '17-01181123858578581123', 'MW16-1211134069924699', 1, 16, '2017-01-18'),
(56, '17-0118122366716671223', 'MW16-1211134069924699', 5, 80, '2017-01-18'),
(57, '17-0118124712971291247', 'MW16-1211134069924699', 4, 64, '2017-01-18'),
(58, '17-01201833610366101833', 'MW16-1211134069924699', 1, 16, '2017-01-20');

-- --------------------------------------------------------

--
-- Table structure for table `size`
--

CREATE TABLE IF NOT EXISTS `size` (
`size_id` int(11) NOT NULL,
  `size_name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `size`
--

INSERT INTO `size` (`size_id`, `size_name`) VALUES
(1, 'M'),
(2, 'XL');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
`stock_id` int(11) NOT NULL,
  `location` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_id`, `location`, `date`, `description`) VALUES
(1, 'Shop', '2016-12-03', 'null'),
(2, 'Inventory', '2016-12-03', '');

-- --------------------------------------------------------

--
-- Table structure for table `thread`
--

CREATE TABLE IF NOT EXISTS `thread` (
`thread_id` int(11) NOT NULL,
  `thread_name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thread`
--

INSERT INTO `thread` (`thread_id`, `thread_name`) VALUES
(1, 'Cotton');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
`type_id` int(11) NOT NULL,
  `type_name` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`type_id`, `type_name`) VALUES
(1, '3p');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `manufacture_country`
--
ALTER TABLE `manufacture_country`
 ADD PRIMARY KEY (`m_c_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
 ADD PRIMARY KEY (`order_id`), ADD KEY `order_code` (`order_code`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
 ADD UNIQUE KEY `sales_code` (`sales_code`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`code`), ADD KEY `product_info_id` (`product_info_id`,`stock_id`), ADD KEY `stock_id` (`stock_id`);

--
-- Indexes for table `product_info`
--
ALTER TABLE `product_info`
 ADD PRIMARY KEY (`product_info_id`), ADD KEY `m_c_id` (`m_c_id`,`type_id`,`size_id`,`thread_id`), ADD KEY `type_id` (`type_id`), ADD KEY `size_id` (`size_id`), ADD KEY `thread_id` (`thread_id`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `size`
--
ALTER TABLE `size`
 ADD PRIMARY KEY (`size_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
 ADD PRIMARY KEY (`stock_id`);

--
-- Indexes for table `thread`
--
ALTER TABLE `thread`
 ADD PRIMARY KEY (`thread_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
 ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `manufacture_country`
--
ALTER TABLE `manufacture_country`
MODIFY `m_c_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product_info`
--
ALTER TABLE `product_info`
MODIFY `product_info_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT for table `size`
--
ALTER TABLE `size`
MODIFY `size_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
MODIFY `stock_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `thread`
--
ALTER TABLE `thread`
MODIFY `thread_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`),
ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`product_info_id`) REFERENCES `product_info` (`product_info_id`);

--
-- Constraints for table `product_info`
--
ALTER TABLE `product_info`
ADD CONSTRAINT `product_info_ibfk_1` FOREIGN KEY (`m_c_id`) REFERENCES `manufacture_country` (`m_c_id`),
ADD CONSTRAINT `product_info_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`),
ADD CONSTRAINT `product_info_ibfk_3` FOREIGN KEY (`size_id`) REFERENCES `size` (`size_id`),
ADD CONSTRAINT `product_info_ibfk_4` FOREIGN KEY (`thread_id`) REFERENCES `thread` (`thread_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
