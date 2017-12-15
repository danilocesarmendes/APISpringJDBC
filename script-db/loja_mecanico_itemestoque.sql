-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: loja_mecanico
-- ------------------------------------------------------
-- Server version	5.6.37-log

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
-- Table structure for table `itemestoque`
--

DROP TABLE IF EXISTS `itemestoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemestoque` (
  `codigoEstabelecimento` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `dataDisponivel` date DEFAULT NULL,
  `prazoDisponivel` int(11) DEFAULT NULL,
  `quantidadeFisica` int(11) DEFAULT NULL,
  `quantidadeAtenuada` int(11) DEFAULT NULL,
  `item` int(11) DEFAULT NULL,
  KEY `fk_item_idx` (`item`),
  CONSTRAINT `fk_item` FOREIGN KEY (`item`) REFERENCES `item` (`codigoItem`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemestoque`
--

LOCK TABLES `itemestoque` WRITE;
/*!40000 ALTER TABLE `itemestoque` DISABLE KEYS */;
INSERT INTO `itemestoque` VALUES (1,37,NULL,1,48,0,935260),(1,20,NULL,1,20,0,120319),(7,37,NULL,1,37,0,120319),(4,37,NULL,1,37,0,120319),(1,186,NULL,1,198,2,14753),(1,0,NULL,1,8,1,14735),(1,20,NULL,1,20,0,10694),(1,20,NULL,1,20,0,15024),(1,95,NULL,1,98,0,249038);
/*!40000 ALTER TABLE `itemestoque` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-15 15:28:40
