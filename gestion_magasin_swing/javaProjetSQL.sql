-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 27 Mars 2017 à 21:54
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `javapro`
--

-- --------------------------------------------------------

--
-- Structure de la table `cataloge`
--

CREATE TABLE `cataloge` (
  `idCata` decimal(10,0) NOT NULL,
  `nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cataloge`
--

INSERT INTO `cataloge` (`idCata`, `nom`) VALUES
('1', '2016'),
('2', '2017');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCate` decimal(10,0) NOT NULL,
  `nom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCate`, `nom`) VALUES
('1', 'a'),
('2', 'b'),
('3', 'c'),
('4', 'd');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClt` decimal(10,0) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `tele` varchar(25) DEFAULT NULL,
  `street1` varchar(25) DEFAULT NULL,
  `street2` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `zipcode` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClt`, `nom`, `tele`, `street1`, `street2`, `city`, `zipcode`, `country`) VALUES
('1', 'AJM', '0626', 'abc1', 'abc2', 'jedida', '2400', 'morocco'),
('3', 'AJM', '06261', 'abc11', 'abc21', 'jedida1', '24001', 'morocco'),
('4', 'AJM', '06262', 'abc12', 'abc22', 'jedida2', '24002', 'morocco'),
('5', 'AJM', '06263', 'abc13', 'abc23', 'jedida3', '24003', 'morocco'),
('6', 'AJM', '06264', 'abc14', 'abc24', 'jedida4', '24004', 'morocco'),
('7', 'AJM', '06265', 'abc15', 'abc25', 'jedida5', '24005', 'morocco'),
('8', 'AJM', '06266', 'abc16', 'abc26', 'jedida6', '24006', 'morocco');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idCmd` int(11) NOT NULL,
  `date_command` date DEFAULT NULL,
  `street1` varchar(25) DEFAULT NULL,
  `street2` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `zipcode` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `id_Client` decimal(10,0) DEFAULT NULL,
  `id_Cataloge` decimal(10,0) DEFAULT NULL,
  `nom_des` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`idCmd`, `date_command`, `street1`, `street2`, `city`, `zipcode`, `country`, `status`, `id_Client`, `id_Cataloge`, `nom_des`) VALUES
(14344, '2017-03-27', 'abc12', 'abc22', 'jedida2', '24002', 'morocco', 0, '4', '2', 'AJM'),
(14346, '2017-03-27', 'abc15', 'abc25', 'jedida5', '24005', 'morocco', 0, '7', '2', 'AJM'),
(14347, '2017-03-27', 'abc13', 'abc23', 'jedida3', '24003', 'morocco', 0, '5', '2', 'AJM');

-- --------------------------------------------------------

--
-- Structure de la table `list_produit`
--

CREATE TABLE `list_produit` (
  `Quantitie` decimal(10,0) DEFAULT NULL,
  `idCmd` int(11) NOT NULL,
  `id_Produit` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `list_produit`
--

INSERT INTO `list_produit` (`Quantitie`, `idCmd`, `id_Produit`) VALUES
('15', 14344, '1'),
('1', 14346, '5'),
('14', 14347, '5');

-- --------------------------------------------------------

--
-- Structure de la table `prix_catalog`
--

CREATE TABLE `prix_catalog` (
  `prix_unit` decimal(25,2) DEFAULT NULL,
  `idPro` decimal(10,0) NOT NULL,
  `id_Cataloge` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `prix_catalog`
--

INSERT INTO `prix_catalog` (`prix_unit`, `idPro`, `id_Cataloge`) VALUES
('100.00', '1', '1'),
('150.00', '1', '2'),
('150.00', '2', '1'),
('150.00', '2', '2'),
('300.00', '3', '1'),
('200.00', '3', '2'),
('300.00', '4', '1'),
('400.00', '4', '2'),
('220.00', '5', '1'),
('199.99', '5', '2');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_Pro` decimal(10,0) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `id_Categorie` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id_Pro`, `nom`, `id_Categorie`) VALUES
('1', 'Prod1', '1'),
('2', 'Prod2', '1'),
('3', 'Prod3', '2'),
('4', 'Prod4', '3'),
('5', 'Prod5', '4');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cataloge`
--
ALTER TABLE `cataloge`
  ADD PRIMARY KEY (`idCata`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCate`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClt`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idCmd`),
  ADD KEY `FK_Commande_id_Client` (`id_Client`),
  ADD KEY `FK_Commande_id_Cataloge` (`id_Cataloge`);

--
-- Index pour la table `list_produit`
--
ALTER TABLE `list_produit`
  ADD PRIMARY KEY (`idCmd`,`id_Produit`),
  ADD KEY `FK_List_Produit_id_Produit` (`id_Produit`);

--
-- Index pour la table `prix_catalog`
--
ALTER TABLE `prix_catalog`
  ADD PRIMARY KEY (`idPro`,`id_Cataloge`),
  ADD KEY `FK_Prix_Catalog_id_Cataloge` (`id_Cataloge`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_Pro`),
  ADD KEY `FK_Produit_id_Categorie` (`id_Categorie`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `idCmd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14348;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_Commande_id_Cataloge` FOREIGN KEY (`id_Cataloge`) REFERENCES `cataloge` (`idCata`),
  ADD CONSTRAINT `FK_Commande_id_Client` FOREIGN KEY (`id_Client`) REFERENCES `client` (`idClt`);

--
-- Contraintes pour la table `list_produit`
--
ALTER TABLE `list_produit`
  ADD CONSTRAINT `FK_List_Produit_id` FOREIGN KEY (`idCmd`) REFERENCES `commande` (`idCmd`),
  ADD CONSTRAINT `FK_List_Produit_id_Produit` FOREIGN KEY (`id_Produit`) REFERENCES `produit` (`id_Pro`);

--
-- Contraintes pour la table `prix_catalog`
--
ALTER TABLE `prix_catalog`
  ADD CONSTRAINT `FK_Prix_Catalog_id` FOREIGN KEY (`idPro`) REFERENCES `produit` (`id_Pro`),
  ADD CONSTRAINT `FK_Prix_Catalog_id_Cataloge` FOREIGN KEY (`id_Cataloge`) REFERENCES `cataloge` (`idCata`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_Produit_id_Categorie` FOREIGN KEY (`id_Categorie`) REFERENCES `categorie` (`idCate`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
