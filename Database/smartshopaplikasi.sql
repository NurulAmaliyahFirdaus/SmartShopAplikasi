-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 05:22 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartshopaplikasi`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbbeli`
--

CREATE TABLE `tbbeli` (
  `notrans` varchar(8) NOT NULL,
  `tgl` date NOT NULL,
  `nmsupplier` varchar(20) NOT NULL,
  `kdbrng` varchar(8) NOT NULL,
  `nmbrng` varchar(40) NOT NULL,
  `hbeli` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbbeli`
--

INSERT INTO `tbbeli` (`notrans`, `tgl`, `nmsupplier`, `kdbrng`, `nmbrng`, `hbeli`, `jumlah`, `subtotal`, `total`) VALUES
('P001', '2017-07-24', 'nike inc', 'B001', 'Nike Air Zoom Pegasus 33 iD', 500, 40, 20000, 24000),
('P001', '2017-07-24', 'nike inc', 'B002', 'Nike Jordan Eclipse Chukka', 100, 40, 4000, 24000),
('P002', '2017-07-24', 'nike inc', 'B003', 'Nike Jordan Formula 23', 100, 40, 4000, 11600),
('P002', '2017-07-24', 'nike inc', 'B004', 'Nike Free Run 2 iD', 110, 40, 4400, 11600),
('P002', '2017-07-24', 'nike inc', 'B005', 'Nike Mercurial Victory VI SG', 80, 40, 3200, 11600),
('P003', '2017-07-25', 'nn', 'B006', 'Adidas Lucas Puig', 800, 6, 4800, 4800),
('P004', '2017-08-19', 'Malda Karawaang', 'B006', 'Bola Voley', 150, 40, 6000, 6000),
('P005', '2020-06-06', 'Microsoft Indonesia', 'B004', 'Jam Tangan', 45000, 10, 450000, 5450000),
('P005', '2020-06-06', 'Microsoft Indonesia', 'B001', 'Beras Rajawali', 50000, 100, 5000000, 5450000);

--
-- Triggers `tbbeli`
--
DELIMITER $$
CREATE TRIGGER `beli_barang` AFTER INSERT ON `tbbeli` FOR EACH ROW BEGIN
UPDATE tbbrng 
SET stock = stock + NEW.jumlah
WHERE
 kdbrng = NEW.kdbrng;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbbrng`
--

CREATE TABLE `tbbrng` (
  `kdbrng` varchar(8) NOT NULL,
  `nmbrng` varchar(40) NOT NULL,
  `jenis` varchar(15) DEFAULT NULL,
  `hjual` int(11) DEFAULT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbbrng`
--

INSERT INTO `tbbrng` (`kdbrng`, `nmbrng`, `jenis`, `hjual`, `stock`) VALUES
('B001', 'Beras Rajawali', 'Kebutuhan Pokok', 52000, 150),
('B002', 'Tas Slempang', 'Aksesoris', 35000, 10),
('B003', 'Gulaku', 'Kebutuhan Pokok', 16000, 38),
('B004', 'Jam Tangan', 'Aksesoris', 50000, 50),
('B005', 'Balon', 'Mainan Anak', 10000, 40),
('B006', 'Sepatu Sekolah', 'Kebutuhan Pokok', 150000, 100),
('B007', 'Holahop', 'Mainan Anak', 15000, 15),
('B008', 'Minyak Goreng', 'Kebutuhan Pokok', 23000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbjual`
--

CREATE TABLE `tbjual` (
  `notrans` varchar(8) NOT NULL,
  `tgl` date NOT NULL,
  `pembeli` varchar(20) NOT NULL,
  `kdbrng` varchar(8) NOT NULL,
  `nmbrng` varchar(40) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `ubay` int(11) NOT NULL,
  `ukem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbjual`
--

INSERT INTO `tbjual` (`notrans`, `tgl`, `pembeli`, `kdbrng`, `nmbrng`, `harga`, `jumlah`, `subtotal`, `total`, `ubay`, `ukem`) VALUES
('S001', '2017-07-24', 'Kuyhaa', 'B001', 'Nike Air Zoom Pegasus 33 iD', 600, 2, 1200, 1330, 2000, 670),
('S001', '2017-07-24', 'Kuyhaa', 'B002', 'Nike Jordan Eclipse Chukka', 130, 1, 130, 1330, 2000, 670),
('S002', '2017-08-19', 'sinta', 'B003', 'Nike Jordan Formula 23', 120, 2, 240, 840, 900, 60),
('S002', '2017-08-19', 'sinta', 'B001', 'Nike Air Zoom Pegasus 33 iD', 600, 1, 600, 840, 900, 60);

--
-- Triggers `tbjual`
--
DELIMITER $$
CREATE TRIGGER `jual_barang` AFTER INSERT ON `tbjual` FOR EACH ROW BEGIN
 UPDATE tbbrng
 SET stock = stock - NEW.jumlah
 WHERE
 kdbrng = NEW.kdbrng;
 END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbjurnal`
--

CREATE TABLE `tbjurnal` (
  `nojur` varchar(8) NOT NULL,
  `notrans` varchar(8) NOT NULL,
  `tgl` date NOT NULL,
  `kdakun` varchar(8) NOT NULL,
  `nmakun` varchar(20) NOT NULL,
  `debet` int(11) NOT NULL,
  `kredit` int(11) NOT NULL,
  `ket` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbsupplier`
--

CREATE TABLE `tbsupplier` (
  `kdsupplier` varchar(8) NOT NULL,
  `nmsupplier` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbsupplier`
--

INSERT INTO `tbsupplier` (`kdsupplier`, `nmsupplier`, `alamat`, `telp`) VALUES
('S001', 'Zalfa', 'Indonesia', '085715699775'),
('S002', 'Shindi', 'Indonesia', '089630158851'),
('S003', 'Vival', 'Indonesia', '088214244402'),
('S004', 'Arsy', 'selokambang', '08977950049'),
('S005', 'Aneka Tuna Indonesia', 'Indonesia', '089432345678'),
('S006', 'Bpk. Herman', 'Bangil', '08587534567'),
('S007', 'Siska', 'Jawa Timur', '08123576543');

-- --------------------------------------------------------

--
-- Table structure for table `tbuser`
--

CREATE TABLE `tbuser` (
  `noid` varchar(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `hakakses` enum('Pemilik','Kasir','Persediaan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbuser`
--

INSERT INTO `tbuser` (`noid`, `username`, `nama`, `password`, `hakakses`) VALUES
('U001', 'admin', 'Nurul Amaliyah', '1234', 'Pemilik'),
('U002', 'admin', 'Fabian Zohar', 'abcde', 'Kasir'),
('U003', 'admin', 'Fahira Razkya', '098765', 'Persediaan'),
('U004', 'admin', 'Yuwinda', '220900', 'Kasir'),
('U005', 'admin', 'Jhon Yamand', '260701', 'Persediaan'),
('U006', 'admin', 'Alfan Salim', 'mnbv', 'Kasir');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbbrng`
--
ALTER TABLE `tbbrng`
  ADD PRIMARY KEY (`kdbrng`);

--
-- Indexes for table `tbjurnal`
--
ALTER TABLE `tbjurnal`
  ADD PRIMARY KEY (`nojur`);

--
-- Indexes for table `tbsupplier`
--
ALTER TABLE `tbsupplier`
  ADD PRIMARY KEY (`kdsupplier`);

--
-- Indexes for table `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`noid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
