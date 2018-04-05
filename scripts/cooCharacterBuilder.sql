-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 04, 2018 at 03:20 PM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cooCharacterBuilder`
--

-- --------------------------------------------------------

--
-- Table structure for table `cooCharacter`
--

CREATE TABLE `cooCharacter` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `str` int(11) NOT NULL,
  `dex` int(11) NOT NULL,
  `con` int(11) NOT NULL,
  `intel` int(11) NOT NULL,
  `wis` int(11) NOT NULL,
  `cha` int(11) NOT NULL,
  `race` int(11) NOT NULL,
  `profile` int(11) NOT NULL,
  `health` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `equipement` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cooRace`
--

CREATE TABLE `cooRace` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `attributs` varchar(255) NOT NULL,
  `capacity` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `path`
--

CREATE TABLE `path` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idClass` int(11) DEFAULT NULL,
  `idRace` int(11) DEFAULT NULL,
  `powerOne` text,
  `powerTwo` text,
  `powerThree` text,
  `powerFour` text,
  `powerFive` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `path_character`
--

CREATE TABLE `path_character` (
  `id` int(11) NOT NULL,
  `idCharacter` int(11) NOT NULL,
  `idPath` int(11) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Profile`
--

CREATE TABLE `Profile` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `hDice` int(11) NOT NULL,
  `startEquipement` varchar(255) NOT NULL,
  `paths` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cooCharacter`
--
ALTER TABLE `cooCharacter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cooRace`
--
ALTER TABLE `cooRace`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `path`
--
ALTER TABLE `path`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `path_character`
--
ALTER TABLE `path_character`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Profile`
--
ALTER TABLE `Profile`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cooCharacter`
--
ALTER TABLE `cooCharacter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cooRace`
--
ALTER TABLE `cooRace`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `path`
--
ALTER TABLE `path`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Profile`
--
ALTER TABLE `Profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
