-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Jul 2020 pada 21.11
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `last_work`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `id` varchar(4) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL,
  `verify_code` varchar(50) NOT NULL,
  `is_active` tinyint(4) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `verify_code`, `is_active`, `is_deleted`) VALUES
('E001', 'yosef', 'yosef', 'twaokoaksld', 1, 0),
('E003', 'danu', 'danu', 'asdasdasd', 1, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `account_role`
--

CREATE TABLE `account_role` (
  `id` varchar(5) NOT NULL,
  `account` varchar(4) NOT NULL,
  `role` varchar(5) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `account_role`
--

INSERT INTO `account_role` (`id`, `account`, `role`, `is_deleted`) VALUES
('AR001', 'E001', 'RO001', 0),
('AR002', 'E003', 'RO002', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `employee`
--

CREATE TABLE `employee` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `leave_quota` int(2) NOT NULL,
  `manager` varchar(4) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `phone_number`, `leave_quota`, `manager`, `is_deleted`) VALUES
('E001', 'Yosef ', 'yosef@gmail.com', '081212345678', 12, NULL, 0),
('E002', 'Dilan', 'dilan@gmail.com', '081223456789', 12, 'E001', 1),
('E003', 'Danu', 'danu@gmail.com', '081233885727', 12, 'E001', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `history`
--

CREATE TABLE `history` (
  `id` varchar(5) NOT NULL,
  `pic` varchar(4) NOT NULL,
  `request` varchar(6) NOT NULL,
  `notes` longtext DEFAULT NULL,
  `date_time` datetime NOT NULL,
  `status` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `history`
--

INSERT INTO `history` (`id`, `pic`, `request`, `notes`, `date_time`, `status`) VALUES
('R001', 'E001', 'REQ001', 'Selamat berlibur', '2020-07-15 16:43:15', 'S001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `parameter`
--

CREATE TABLE `parameter` (
  `id` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `note` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `public_holiday`
--

CREATE TABLE `public_holiday` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `holiday_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `report`
--

CREATE TABLE `report` (
  `id` varchar(255) NOT NULL,
  `date_time` datetime NOT NULL,
  `notes` longtext NOT NULL,
  `pic` varchar(255) NOT NULL,
  `request` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `request`
--

CREATE TABLE `request` (
  `id` varchar(6) NOT NULL DEFAULT '',
  `requester` varchar(4) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `current_status` varchar(4) DEFAULT 'S003',
  `total` int(2) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  `reason` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `request`
--

INSERT INTO `request` (`id`, `requester`, `type`, `current_status`, `total`, `start`, `end`, `reason`) VALUES
('REQ001', 'E002', 'T001', 'S001', 2, '2020-07-15', '2020-07-17', 'Mau Cuti'),
('REQ002', 'E003', 'T001', 'S003', 2, '2020-07-22', '2020-07-24', 'Cuti'),
('REQ003', 'E002', 'T001', 'S003', 2, '2020-07-17', '2020-07-19', 'hehe');

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `id` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
('RO001', 'Manager'),
('RO002', 'Employee');

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
('S001', 'Approved'),
('S002', 'Rejected'),
('S003', 'Waiting');

-- --------------------------------------------------------

--
-- Struktur dari tabel `type`
--

CREATE TABLE `type` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `number_of_days` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `type`
--

INSERT INTO `type` (`id`, `name`, `number_of_days`) VALUES
('T001', 'Cuti', 2),
('T002', 'Sakit', 3),
('T003', 'Cuti Melahirkan', 90);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `verify_code` (`verify_code`);

--
-- Indeks untuk tabel `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account` (`account`,`role`),
  ADD KEY `role` (`role`);

--
-- Indeks untuk tabel `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email` (`email`,`phone_number`),
  ADD KEY `manager` (`manager`);

--
-- Indeks untuk tabel `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status` (`status`),
  ADD KEY `pic` (`pic`),
  ADD KEY `request` (`request`);

--
-- Indeks untuk tabel `parameter`
--
ALTER TABLE `parameter`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `public_holiday`
--
ALTER TABLE `public_holiday`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `current_status` (`current_status`),
  ADD KEY `type` (`type`),
  ADD KEY `requester` (`requester`);

--
-- Indeks untuk tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FKhtvx8f8e174q5d5lqj81ax1fu` FOREIGN KEY (`id`) REFERENCES `employee` (`id`);

--
-- Ketidakleluasaan untuk tabel `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `account_role_ibfk_1` FOREIGN KEY (`account`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `account_role_ibfk_2` FOREIGN KEY (`role`) REFERENCES `role` (`id`);

--
-- Ketidakleluasaan untuk tabel `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`manager`) REFERENCES `employee` (`id`);

--
-- Ketidakleluasaan untuk tabel `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`pic`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `history_ibfk_3` FOREIGN KEY (`request`) REFERENCES `request` (`id`);

--
-- Ketidakleluasaan untuk tabel `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`current_status`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `request_ibfk_2` FOREIGN KEY (`type`) REFERENCES `type` (`id`),
  ADD CONSTRAINT `request_ibfk_3` FOREIGN KEY (`requester`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
