CREATE DATABASE  IF NOT EXISTS `sasandb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sasandb`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: sasandb
-- ------------------------------------------------------
-- Server version	5.1.54-1ubuntu4

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
-- Table structure for table `interactions_wide2`
--

DROP TABLE IF EXISTS `interactions_wide2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interactions_wide2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part1` varchar(300) DEFAULT NULL,
  `type1` varchar(45) DEFAULT NULL,
  `part2` varchar(300) DEFAULT NULL,
  `type2` varchar(45) DEFAULT NULL,
  `promoter_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7906 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interactions_wide2`
--

LOCK TABLES `interactions_wide2` WRITE;
/*!40000 ALTER TABLE `interactions_wide2` DISABLE KEYS */;
INSERT INTO `interactions_wide2` VALUES (7131,'BBa_I0500','P','BBa_B0034','R','^'),(7132,'BBa_B0034','R','BBa_E0022','G','^'),(7133,'BBa_B0010','T','BBa_B0012','T','^'),(7134,'BBa_E0022','G','BBa_B0015','T','^'),(7135,'BBa_B0015','T','BBa_I0500','P','^'),(7136,'BBa_I0500','P','BBa_B0034','R','^'),(7137,'BBa_B0034','R','BBa_C0012','G','^'),(7138,'BBa_C0012','G','BBa_B0015','T','^'),(7139,'BBa_B0015','T','BBa_R0011','P','^'),(7140,'BBa_R0011','P','BBa_B0034','R','^'),(7141,'BBa_B0034','R','BBa_E0032','G','^'),(7142,'BBa_E0032','G','BBa_B0015','T','^'),(7143,'BBa_B0034','R','BBa_C0040','G','^'),(7144,'BBa_C0040','G','BBa_B0015','T','^'),(7145,'BBa_B0015','T','BBa_R0040','P','^'),(7146,'BBa_R0040','P','BBa_B0034','R','^'),(7147,'BBa_B0034','R','BBa_E0032','G','^'),(7148,'BBa_E0032','G','BBa_B0015','T','^'),(7149,'BBa_B0034','R','BBa_J32020','G','^'),(7150,'BBa_J32020  G','AmpR','BBa_O','^','^'),(7151,'BBa_B0034','R','BBa_C0051','G','^'),(7152,'BBa_C0051','G','BBa_B0015','T','^'),(7153,'BBa_B0015','T','BBa_R0051','P','^'),(7154,'BBa_cI  I','R0051','BBa_P','inhibitor','^'),(7155,'BBa_R0051','P','BBa_B0034','R','^'),(7156,'BBa_B0031','R','BBa_C0040','G','^'),(7157,'BBa_C0040','G','BBa_B0015','T','^'),(7158,'BBa_I0500','P','BBa_B0034','R','^'),(7159,'BBa_B0015','T','BBa_R0065','P','^'),(7160,'BBa_R0065','P','BBa_B0034','R','^'),(7161,'BBa_B0033','R','BBa_C0012','G','^'),(7162,'BBa_C0012','G','BBa_B0015','T','^'),(7163,'BBa_B0034','R','BBa_C0052','G','^'),(7164,'BBa_C0052','G','BBa_B0015','T','^'),(7165,'BBa_B0015','T','BBa_R0052','P','^'),(7166,'BBa_R0052','P','BBa_B0034','R','^'),(7167,'BBa_R0052','P','BBa_B0034','R','^'),(7168,'BBa_B0034','R','BBa_C0012','G','^'),(7169,'BBa_C0012','G','BBa_B0015','T','^'),(7170,'BBa_R0011','P','BBa_B0034','R','^'),(7171,'BBa_B0034','R','BBa_E0030','G','^'),(7172,'BBa_E0030','G','BBa_B0015','T','^'),(7173,'BBa_B0033','R','BBa_C0053','G','^'),(7174,'BBa_C0053','G','BBa_B0015','T','^'),(7175,'BBa_B0034','R','BBa_E0020','G','^'),(7176,'BBa_E0020','G','BBa_B0015','T','^'),(7177,'BBa_B0034','R','BBa_C0051','G','^'),(7178,'BBa_C0051','G','BBa_B0015','T','^'),(7179,'BBa_B0015','T','BBa_R0065','P','^'),(7180,'BBa_R0065','P','BBa_B0034','R','^'),(7181,'BBa_B0034','R','BBa_E0030','G','^'),(7182,'BBa_E0030','G','BBa_B0015','T','^'),(7183,'BBa_B0034','R','BBa_C0051','G','^'),(7184,'BBa_C0051','G','BBa_B0015','T','^'),(7185,'BBa_B0034','R','BBa_C0053','G','^'),(7186,'BBa_C0053','G','BBa_B0015','T','^'),(7187,'BBa_B0034','R','BBa_C0053','G','^'),(7188,'BBa_B0015','T','BBa_R0053','P','^'),(7189,'BBa_R0053','P','BBa_B0034','R','^'),(7190,'BBa_R0010','P','BBa_B0034','R','^'),(7191,'BBa_B0034','R','BBa_C0061','G','^'),(7192,'BBa_B0034','R','BBa_C0070','G','^'),(7193,'BBa_LuxR+HSL  I','K145150','BBa_P','activator','^'),(7194,'BBa_C0062','G','BBa_B0015','T','^'),(7195,'BBa_I0500','G','BBa_B0030','R','^'),(7196,'BBa_B0030','R','BBa_J61047','G','^'),(7197,'BBa_B0034','R','BBa_C0062','G','^'),(7198,'BBa_C0062','G','BBa_B0015','T','^'),(7199,'BBa_B0015','T','BBa_R0062','P','^'),(7200,'BBa_R0062','P','BBa_B0034','R','^'),(7201,'BBa_J06504','G','BBa_B0015','T','^'),(7202,'BBa_B0034','R','BBa_I732005','G','^'),(7203,'BBa_I742163','R','BBa_I742137','G','^'),(7204,'BBa_B0015','T','BBa_I746104','P','^'),(7205,'BBa_I746104','P','BBa_B0030','R','^'),(7206,'BBa_B0030','R','BBa_E0040','G','^'),(7207,'BBa_E0040','G','BBa_B0015','T','^'),(7208,'BBa_E0040','G','BBa_GFP O','^','^'),(7209,'BBa_I746100','Y','BBa_B0015','T','^'),(7210,'BBa_R0040','P','BBa_B0032','R','^'),(7211,'BBa_B0032','R','BBa_K145010','G','^'),(7212,'BBa_K145015','G','BBa_B0015','T','^'),(7213,'BBa_R0011','P','BBa_B0032','R','^'),(7214,'BBa_B0032','R','BBa_C0061','G','^'),(7215,'BBa_C0061','G','BBa_B0015','T','^'),(7216,'BBa_J23116','P','BBa_B0034','R','^'),(7217,'BBa_B0034','R','BBa_C0040','G','^'),(7218,'BBa_C0040','G','BBa_B0015','T','^'),(7219,'BBa_B0032','R','BBa_K145015','G','^'),(7220,'BBa_K145015','G','BBa_B0015','T','^'),(7221,'BBa_B0032','R','BBa_E0040','G','^'),(7222,'BBa_E0040','G','BBa_B0015','T','^'),(7223,'BBa_R0011','P','BBa_R0062','P','^'),(7224,'BBa_R0062','P','BBa_J22086','P','^'),(7225,'BBa_J22086','P','BBa_B0015','T','^'),(7226,'BBa_B0015','T','BBa_R0011','P','^'),(7227,'BBa_R0011','P','BBa_R0062','P','^'),(7228,'BBa_R0062','P','BBa_B0032','R','^'),(7229,'BBa_B0032','R','BBa_E0032','G','^'),(7230,'BBa_E0032','G','BBa_B0015','T','^'),(7231,'BBa_B0015','T','BBa_J22052','P','^'),(7232,'BBa_J22052','P','BBa_J22056','G','^'),(7233,'BBa_J22056','G','BBa_I0500','P','^'),(7234,'BBa_I0500','P','BBa_B0032','R','^'),(7235,'BBa_B0032','R','BBa_C0062','G','^'),(7236,'BBa_C0062','G','BBa_B0032','R','^'),(7237,'BBa_B0032','R','BBa_E1010','G','^'),(7238,'BBa_E1010','G','BBa_B0015','T','^'),(7239,'BBa_B0015','T','BBa_R0040','P','^'),(7240,'BBa_R0040','P','BBa_B0032','R','^'),(7241,'BBa_B0032','R','BBa_C0060','G','^'),(7242,'BBa_C0060','G','BBa_B0015','T','^'),(7243,'BBa_E1010','G','BBa_monomeric RFP O','^','^'),(7244,'BBa_K145150','P','BBa_B0032','R','^'),(7245,'BBa_B0032','R','BBa_E0040','G','^'),(7246,'BBa_E0040','G','BBa_B0015','T','^'),(7247,'BBa_B0034','R','BBa_C0051','G','^'),(7248,'BBa_C0051','G','BBa_B0015','T','^'),(7249,'BBa_B0015','T','BBa_R0051','P','^'),(7250,'BBa_R0051','P','BBa_B0034','R','^'),(7251,'BBa_B0034','R','BBa_E0030','G','^'),(7252,'BBa_E0030','G','BBa_B0015','T','^'),(7253,'BBa_B0032','R','BBa_J45004','G','^'),(7254,'BBa_J45004','G','BBa_B0015','T','^'),(7255,'BBa_R0011','P','BBa_B0032','R','^'),(7256,'BBa_B0032','R','BBa_C0600','G','^'),(7257,'BBa_C0600','G','BBa_B0034','R','^'),(7258,'BBa_B0034','R','BBa_E0020','G','^'),(7259,'BBa_E0020','G','BBa_B0015','T','^'),(7260,'BBa_R0040','P','BBa_B0032','R','^'),(7261,'BBa_B0032','R','BBa_C0620','G','^'),(7262,'BBa_C0620','G','BBa_B0034','R','^'),(7263,'BBa_R0040','P','BBa_B0030','R','^'),(7264,'BBa_B0030','R','BBa_J45014','G','^'),(7265,'BBa_J45014','G','BBa_B0015','T','^'),(7266,'BBa_B0034','R','BBa_E0030','G','^'),(7267,'BBa_B0032','R','BBa_J45014','G','^'),(7268,'BBa_J45993','P','BBa_B0032','R','^'),(7269,'BBa_J22052','P','BBa_B0031','R','^'),(7270,'BBa_B0031','R','BBa_J22056','G','^'),(7271,'BBa_R0011','P','BBa_B0032','R','^'),(7272,'BBa_B0032','R','BBa_J45017','G','^'),(7273,'BBa_J45017','G','BBa_B0015','T','^'),(7274,'BBa_R0062','P','BBa_B0033','R','^'),(7275,'BBa_B0033','R','BBa_C0012','G','^'),(7276,'BBa_C0012','G','BBa_B0015','T','^'),(7277,'BBa_B0034','R','BBa_I15010','G','^'),(7278,'BBa_I15010','G','BBa_B0015','T','^'),(7279,'BBa_C0012','G','BBa_B0034','R','^'),(7280,'BBa_B0034','R','BBa_J06504','G','^'),(7281,'BBa_C0040','G','BBa_B0034','R','^'),(7282,'BBa_C0012','G','BBa_B0034','R','^'),(7283,'BBa_R0011','P','BBa_B0034','R','^'),(7284,'BBa_B0034','R','BBa_E1010','G','^'),(7285,'BBa_R0051','P','BBa_B0034','R','^'),(7286,'BBa_B0034','R','BBa_E0034','G','^'),(7287,'BBa_E0034','G','BBa_B0015','T','^'),(7288,'BBa_J23116','P','BBa_B0034','R','^'),(7289,'BBa_B0034','R','BBa_C0040','G','^'),(7290,'BBa_B0015','T','BBa_R0040','P','^'),(7291,'BBa_R0040','P','BBa_B0032','R','^'),(7292,'BBa_B0032','R','BBa_K145015','G','^'),(7293,'BBa_K145015','G','BBa_B0015','T','^'),(7294,'BBa_B0010','T','BBa_B0010','T','^'),(7295,'BBa_B0017','T','^','^','^'),(7296,'BBa_B0021','T','^','^','^'),(7297,'BBa_R0062','P','BBa_E0040','G','^'),(7298,'BBa_B0030','R','BBa_J31007','G','^'),(7299,'BBa_C0061','G','BBa_B0034','R','^'),(7300,'BBa_B0034','R','BBa_E0040','G','^'),(7301,'BBa_C0012','G','BBa_B0034','R','^'),(7302,'BBa_B0034','R','BBa_C0012','G','^'),(7303,'BBa_J45503','P','BBa_B0034','R','^'),(7304,'BBa_B0015','T','BBa_R0011','P','^'),(7305,'BBa_R0011','P','BBa_B0034','R','^'),(7306,'BBa_B0034','R','BBa_J06504','G','^'),(7307,'BBa_J06504','G','BBa_B0015','T','^'),(7308,'BBa_K091112','P','BBa_B0032','R','^'),(7309,'BBa_B0032','R','BBa_E0040','G','^'),(7310,'BBa_J23100','P','BBa_B0034','R','^'),(7311,'BBa_I14032','P','BBa_B0032','R','^'),(7312,'BBa_B0034','R','BBa_J06501','G','^'),(7313,'BBa_J06501','G','BBa_B0015','T','^'),(7314,'BBa_J22126','P','BBa_E1010','G','^'),(7315,'BBa_J22126','P','BBa_E1010','G','^'),(7316,'BBa_E1010','G','BBa_J22101','G','^'),(7317,'BBa_J22101','G','BBa_B0015','T','^'),(7318,'BBa_LasR','P','BBa_K091143','P','activator'),(7319,'BBa_I13453','P','BBa_B0034','R','^'),(7320,'BBa_C0062','G','BBa_B0034','R','^'),(7321,'BBa_B0034','R','BBa_K091122','G','^'),(7322,'BBa_K091122','G','BBa_B0015','T','^'),(7323,'BBa_J23100','P','BBa_B0030','R','^'),(7324,'BBa_I732205','P','^','^','^'),(7325,'BBa_R0051','P','BBa_B0030','R','^'),(7326,'BBa_B0030','R','BBa_C0051','G','^'),(7327,'BBa_B0030','R','BBa_C0061','G','^'),(7328,'BBa_R0010','P','BBa_B0030','R','^'),(7329,'BBa_B0030','R','BBa_I715019','G','^'),(7330,'BBa_B0030','R','BBa_C0078','G','^'),(7331,'BBa_B0030','R','BBa_C0040','G','^'),(7332,'BBa_R0085','P','BBa_B0034','R','^'),(7333,'BBa_B0034','R','BBa_I715022','G','^'),(7334,'BBa_B0030','R','BBa_C0062','G','^'),(7335,'BBa_C0051','G','BBa_B0030','R','^'),(7336,'BBa_B0030','R','BBa_I15009','G','^'),(7337,'BBa_B0030','R','BBa_C0079','G','^'),(7338,'BBa_C0061','G','BBa_B1006','T','^'),(7339,'BBa_B1006','T','BBa_R0062','P','^'),(7340,'BBa_B0030','R','BBa_C0078','G','^'),(7341,'BBa_C0078','G','BBa_B1006','T','^'),(7342,'BBa_B1006','T','BBa_R0079','P','^'),(7343,'BBa_B0030','R','BBa_C0062','G','^'),(7344,'BBa_C0062','G','BBa_B1006','T','^'),(7345,'BBa_B1006','T','BBa_R0062','P','^'),(7346,'BBa_I15009','G','BBa_B1006','T','^'),(7347,'BBa_B1006','T','BBa_R0082','P','^'),(7348,'BBa_I712004','P','BBa_I712024','G','^'),(7349,'BBa_I712024','G','BBa_I712011','G','^'),(7350,'BBa_I712011','G','BBa_I712022','G','^'),(7351,'BBa_I712074','P','BBa_I712019','G','^'),(7352,'BBa_J23105','P','BBa_B0034','R','^'),(7353,'BBa_R0010','P','BBa_B0030','R','^'),(7354,'BBa_K117002','P','BBa_B0034','R','^'),(7355,'BBa_B0034','R','BBa_K117001','G','^'),(7356,'BBa_K117001','G','BBa_B0015','T','^'),(7357,'BBa_K117002','P','BBa_K117000','G','^'),(7358,'BBa_K117000','G','BBa_B0015','T','^'),(7359,'BBa_K117002','P','BBa_K117000','G','^'),(7360,'BBa_B0034','R','BBa_I2032','G','^'),(7361,'BBa_B0034','R','BBa_J36802','G','^'),(7362,'BBa_J36802','G','BBa_R0010','P','^'),(7363,'BBa_B0034','R','BBa_J36804','G','^'),(7364,'BBa_B0032','R','BBa_J45004','G','^'),(7365,'BBa_J45004','G','BBa_B0015','T','^'),(7366,'BBa_B0015','T','BBa_R0011','P','^'),(7367,'BBa_B0032','R','BBa_J45017','G','^'),(7368,'BBa_J45992','P','BBa_B0064','R','^'),(7369,'BBa_B0064','R','BBa_C0040','G','^'),(7370,'BBa_R0040','P','BBa_B0030','R','^'),(7371,'BBa_B0030','R','BBa_E0040','G','^'),(7372,'BBa_J52034','P','BBa_J52008','G','^'),(7373,'BBa_J15001','R','BBa_K118000','G','^'),(7374,'BBa_J15001','R','BBa_K118003','G','^'),(7375,'BBa_B0034','R','BBa_C0078','G','^'),(7376,'BBa_C0078','G','BBa_B0015','T','^'),(7377,'BBa_J15001','R','BBa_K118002','G','^'),(7378,'BBa_J15001','R','BBa_K118001','G','^'),(7379,'BBa_R0085','P','BBa_B0034','R','^'),(7380,'BBa_B0034','R','BBa_I715022','G','^'),(7381,'BBa_I715023','G','BBa_B0034','R','^'),(7382,'BBa_B0034','R','BBa_I715019','G','^'),(7383,'BBa_I715020','G','BBa_B0015','T','^'),(7384,'BBa_I715023','G','BBa_B0015','T','^'),(7385,'BBa_J23151','P','BBa_B0032','R','^'),(7386,'BBa_B0032','R','BBa_E0040','G','^'),(7387,'BBa_E0040','G','BBa_B0015','T','^'),(7388,'BBa_J23116','P','BBa_B0032','R','^'),(7389,'BBa_J23101','P','BBa_B0032','R','^'),(7390,'BBa_R0040','P','BBa_B0034','R','^'),(7391,'BBa_B0034','R','BBa_E0035','G','^'),(7392,'BBa_E0035','G','BBa_B0015','T','^'),(7393,'BBa_R0085','P','BBa_B0034','R','^'),(7394,'BBa_I715023','G','BBa_B0015','T','^'),(7395,'BBa_I715020','G','BBa_B0015','T','^'),(7396,'BBa_I715020','G','BBa_B0015','T','^'),(7397,'BBa_J31001','G','BBa_B0015','T','^'),(7398,'BBa_B0030','R','BBa_J31001','G','^'),(7399,'BBa_B0015','T','BBa_R0085','P','^'),(7400,'BBa_K118012','R','BBa_K118008','G','^'),(7401,'BBa_I766558','P','BBa_I766102','G','^'),(7402,'BBa_I766102','G','BBa_I766101','G','^'),(7403,'BBa_I766101','G','BBa_I766103','G','^'),(7404,'BBa_I766103','G','BBa_I766600','T','^'),(7405,'BBa_I766556','P','BBa_I766101','G','^'),(7406,'BBa_I766101','G','BBa_I766002','G','^'),(7407,'BBa_I766002','G','BBa_I766102','G','^'),(7408,'BBa_I766102','G','BBa_I766600','T','^'),(7409,'BBa_I766556','P','BBa_I766007','G','^'),(7410,'BBa_I766007','G','BBa_I766101','G','^'),(7411,'BBa_I766101','G','BBa_I766102','G','^'),(7412,'BBa_I766102','G','BBa_I766600','T','^'),(7413,'BBa_J15001','R','BBa_K118015','G','^'),(7414,'BBa_J15001','R','BBa_K118016','G','^'),(7415,'BBa_I766556','P','BBa_I766101','G','^'),(7416,'BBa_I766101','G','BBa_I766007','G','^'),(7417,'BBa_I766007','G','BBa_I766103','G','^'),(7418,'BBa_I766103','G','BBa_I766600','T','^'),(7419,'BBa_I715020','G','BBa_B0034','R','^'),(7420,'BBa_B0034','R','BBa_I715022','G','^'),(7421,'BBa_I715020','G','BBa_B0015','T','^'),(7422,'BBa_B0034','R','BBa_C0060','G','^'),(7423,'BBa_J33207','G','BBa_J15001','R','^'),(7424,'BBa_J15001','R','BBa_K118015','G','^'),(7425,'BBa_I742159','R','BBa_I742160','G','^'),(7426,'BBa_J15001','R','BBa_I742110','G','^'),(7427,'BBa_J15001','R','BBa_K118000','G','^'),(7428,'BBa_K118000','G','BBa_J15001','R','^'),(7429,'BBa_J15001','R','BBa_I742110','G','^'),(7430,'BBa_I742110','G','BBa_J15001','R','^'),(7431,'BBa_J15001','R','BBa_K118001','G','^'),(7432,'BBa_K118011','P','BBa_J15001','R','^'),(7433,'BBa_J15001','R','BBa_J15103','G','^'),(7434,'BBa_R0063','P','BBa_B0034','R','^'),(7435,'BBa_B0034','R','BBa_C0052','G','^'),(7436,'BBa_C0052','G','BBa_B0034','R','^'),(7437,'BBa_B0034','R','BBa_C0078','G','^'),(7438,'BBa_I14033','P','BBa_B0034','R','^'),(7439,'BBa_B0034','R','BBa_C0171','G','^'),(7440,'BBa_C0171','G','BBa_B0015','T','^'),(7441,'BBa_B0015','T','BBa_R0071','P','^'),(7442,'BBa_R0071','P','BBa_K092800','Y','^'),(7443,'BBa_B0034','R','BBa_I15010','G','^'),(7444,'BBa_E1010','G','BBa_K092400','W','^'),(7445,'BBa_J45017','G','BBa_B0015','T','^'),(7446,'BBa_B0012','T','BBa_B0011','T','^'),(7447,'BBa_B0014','T','^','^','^'),(7448,'BBa_C0070','G','BBa_B0015','T','^'),(7449,'BBa_B0034','R','BBa_K082003','G','^'),(7450,'BBa_K082003','G','BBa_B0015','T','^'),(7451,'BBa_J23118','P','BBa_K079019','P','^'),(7452,'BBa_K079019','P','BBa_B0034','R','^'),(7453,'BBa_B0034','R','BBa_C0012','G','^'),(7454,'BBa_C0012','G','BBa_B0034','R','^'),(7455,'BBa_B0034','R','BBa_J04031','G','^'),(7456,'BBa_J04031','G','BBa_B0015','T','^'),(7457,'BBa_J23118','P','BBa_K079018','P','^'),(7458,'BBa_K079018','P','BBa_B0034','R','^'),(7459,'BBa_J23118','P','BBa_K079040','P','^'),(7460,'BBa_K079040','P','BBa_B0034','R','^'),(7461,'BBa_K118011','P','BBa_J33204','Y','^'),(7462,'BBa_I14032','P','BBa_B0034','R','^'),(7463,'BBa_B0034','R','BBa_I732080','G','^'),(7464,'BBa_B0030','R','BBa_E0040','G','^'),(7465,'BBa_E0040','G','BBa_B0015','T','^'),(7466,'BBa_J23100','P','BBa_J61100','R','^'),(7467,'BBa_J61100','R','BBa_K398001','G','^'),(7468,'BBa_K398001','G','BBa_J61100','R','^'),(7469,'BBa_J61100','R','BBa_K398002','G','^'),(7470,'BBa_J61100','R','BBa_K398003','G','^'),(7471,'BBa_J61100','R','BBa_K398004','G','^'),(7472,'BBa_J23100','P','BBa_K398000','G','^'),(7473,'BBa_J23100','P','BBa_J61101','R','^'),(7474,'BBa_J61101','R','BBa_K398005','G','^'),(7475,'BBa_J61100','P','BBa_K398000','G','^'),(7476,'BBa_B0034','R','BBa_E0032','G','^'),(7477,'BBa_E0032','G','BBa_B0015','T','^'),(7478,'BBa_J13002','P','BBa_K398100','G','^'),(7479,'BBa_K398100','G','BBa_B0015','T','^'),(7480,'BBa_R0040','P','BBa_B0034','R','^'),(7481,'BBa_R0011','P','BBa_B0032','R','^'),(7482,'BBa_B0032','R','BBa_K398200','G','^'),(7483,'BBa_K398200','G','BBa_B0015','T','^'),(7484,'BBa_K398326','P','BBa_B0032','R','^'),(7485,'BBa_B0032','R','BBa_E0040','G','^'),(7486,'BBa_E0040','G','BBa_B0015','T','^'),(7487,'BBa_J23100','P','BBa_J61100','R','^'),(7488,'BBa_J23100','P','BBa_J61107','R','^'),(7489,'BBa_J61107','P','BBa_E0040','G','^'),(7490,'BBa_B0034','R','BBa_J04631','G','^'),(7491,'BBa_J04031','G','BBa_B0015','T','^'),(7492,'BBa_R0010','P','BBa_l732019','G','^'),(7493,'BBa_B0034','R','BBa_l732005','G','^'),(7494,'BBa_I732005','G','BBa_B0015','T','^'),(7495,'BBa_I746361','P','BBa_B0034','R','^'),(7496,'BBa_B0034','R','BBa_C0012','G','^'),(7497,'BBa_C0012','G','BBa_B0015','T','^'),(7498,'BBa_B0034','R','BBa_J04031','G','^'),(7499,'BBa_J04031','G','BBa_B0015','T','^'),(7500,'BBa_J23100','P','BBa_J61127','R','^'),(7501,'BBa_J61127','R','BBa_E0040','G','^'),(7502,'BBa_K314110','Y','BBa_J23100','P','^'),(7503,'BBa_K314110','Y','BBa_J23114','P','^'),(7504,'BBa_J23114','P','BBa_B0034','R','^'),(7505,'BBa_K314111','Y','BBa_R0011','P','^'),(7506,'BBa_R0011','P','BBa_B0034','R','^'),(7507,'BBa_l719005','P','BBa_B0034','R','^'),(7508,'BBa_B0034','R','BBa_I746920','G','^'),(7509,'BBa_I746920','G','BBa_B0015','T','^'),(7510,'BBa_K165002','R','BBa_K165005','G','^'),(7511,'BBa_R0040','P','BBa_I0462','G','^'),(7512,'BBa_K346003','Y','BBa_B0015','T','^'),(7513,'BBa_K346034','Z','BBa_B0015','T','^'),(7514,'BBa_K346033','Z','BBa_B0015','T','^'),(7515,'BBa_B0015','T','BBa_I719005','P','^'),(7516,'BBa_B0015','T','BBa_K346034','Z','^'),(7517,'BBa_K346034','Z','BBa_B0015','T','^'),(7518,'BBa_I719005','P','BBa_K346003','Y','^'),(7519,'BBa_K346034','Z','BBa_B0015','T','^'),(7520,'BBa_E1010','G','BBa_B0015','T','^'),(7521,'BBa_I712004','P','BBa_I712019','G','^'),(7522,'BBa_I732017','Y','BBa_B0015','T','^'),(7523,'BBa_B0034','R','BBa_I732005','G','^'),(7524,'BBa_I732005','G','BBa_B0015','T','^'),(7525,'BBa_B0034','R','BBa_C0079','G','^'),(7526,'BBa_C0079','G','BBa_B0015','T','^'),(7527,'BBa_B0015','T','BBa_R0079','P','^'),(7528,'BBa_R0079','P','BBa_B0032','R','^'),(7529,'BBa_B0032','R','BBa_E0040','G','^'),(7530,'BBa_J33204','Y','BBa_B0014','T','^'),(7531,'BBa_J15001','R','BBa_K395700','G','^'),(7532,'BBa_I0500','P','BBa_I742156','R','^'),(7533,'BBa_I742156','R','BBa_I742157','G','^'),(7534,'BBa_I742157','G','BBa_J15001','R','^'),(7535,'BBa_J15001','R','BBa_K395700','G','^'),(7536,'BBa_I742156','R','BBa_I742156','G','^'),(7537,'BBa_J15001','R','BBa_K395700','G','^'),(7538,'BBa_K395600','Z','BBa_K395601','T','^'),(7539,'BBa_R0062','P','BBa_K395160','Y','^'),(7540,'BBa_R0040','P','BBa_B0034','R','^'),(7541,'BBa_B0034','R','BBa_C0062','G','^'),(7542,'BBa_J15001','R','BBa_K118002','G','^'),(7543,'BBa_K118002','G','BBa_J15001','R','^'),(7544,'BBa_J15001','R','BBa_K118003','G','^'),(7545,'BBa_C0062','G','BBa_B0015','T','^'),(7546,'BBa_R0010','P','BBa_B0030','R','^'),(7547,'BBa_B0030','R','BBa_K191006','G','^'),(7548,'BBa_K191006','G','BBa_B0015','T','^'),(7549,'BBa_I0500','P','BBa_K325211','Y','^'),(7550,'BBa_I0500','P','BBa_K118012','R','^'),(7551,'BBa_K118012','R','BBa_K118008','G','^'),(7552,'BBa_K118012','R','BBa_I742151','G','^'),(7553,'BBa_I0500','P','BBa_K325100','G','^'),(7554,'BBa_I0500','P','BBa_K325210','G','^'),(7555,'BBa_I0500','P','BBa_K325101','Y','^'),(7556,'BBa_I0500','P','BBa_K216005','U','^'),(7557,'BBa_K118003','G','BBa_K118012','R','^'),(7558,'BBa_K118012','R','BBa_k118008','G','^'),(7559,'BBa_I0500','P','BBa_K325905','Y','^'),(7560,'BBa_K143012','P','BBa_K143021','R','^'),(7561,'BBa_R0062','P','BBa_B0034','R','^'),(7562,'BBa_K143031','G','BBa_B0015','T','^'),(7563,'BBa_K143033','G','BBa_B0015','T','^'),(7564,'BBa_B0034','R','BBa_K314202','G','^'),(7565,'BBa_K316001','P','BBa_K316047','Y','^'),(7566,'BBa_B0034','R','BBa_K415124','G','^'),(7567,'BBa_K316047','Y','BBa_B0014','T','^'),(7568,'BBa_R0065','P','BBa_B0034','R','^'),(7569,'BBa_B0034','R','BBa_J06504','G','^'),(7570,'BBa_J06504','G','BBa_B0015','T','^'),(7571,'BBa_B0015','T','BBa_R0040','P','^'),(7572,'BBa_R0040','P','BBa_B0034','R','^'),(7573,'BBa_B0034','R','BBa_C0062','G','^'),(7574,'BBa_C0062','G','BBa_B0015','T','^'),(7575,'BBa_B0015','T','BBa_R0065','P','^'),(7576,'BBa_B0034','R','BBa_K314202','G','^'),(7577,'BBa_B0034','R','BBa_K415124','G','^'),(7578,'BBa_I0500','P','BBa_K329018','Y','^'),(7579,'BBa_I0500','P','BBa_I746350','Y','^'),(7580,'BBa_I746350','Y','BBa_B0034','R','^'),(7581,'BBa_B0034','R','BBa_E1010','G','^'),(7582,'BBa_B0015','T','BBa_I746365','P','^'),(7583,'BBa_I746365','P','BBa_B0034','R','^'),(7584,'BBa_I751502','P','BBa_B0030','R','^'),(7585,'BBa_B0030','R','BBa_E0040','G','^'),(7586,'BBa_E0040','G','BBa_B0015','T','^'),(7587,'BBa_B0015','T','BBa_R0065','P','^'),(7588,'BBa_R0065','P','BBa_B0034','R','^'),(7589,'BBa_B0034','R','BBa_C0061','G','^'),(7590,'BBa_J23100','P','BBa_K079040','P','^'),(7591,'BBa_K079040','P','BBa_B0034','R','^'),(7592,'BBa_B0010','T','BBa_B0012','T','^'),(7593,'BBa_R0051','P','BBa_B0032','R','^'),(7594,'BBa_B0032','R','BBa_E0040','G','^'),(7595,'BBa_E0040','G','BBa_B0010','T','^'),(7596,'BBa_B0010','T','BBa_B0012','T','^'),(7597,'BBa_R0051','P','BBa_B0032','R','^'),(7598,'BBa_B0032','R','BBa_E0040','G','^'),(7599,'BBa_E0040','G','BBa_B0010','T','^'),(7600,'BBa_B0010','T','BBa_B0012','T','^'),(7601,'BBa_J23114','P','BBa_B0034','R','^'),(7602,'BBa_B0034','R','BBa_K098997','G','^'),(7603,'BBa_K098997','G','BBa_B0012','T','^'),(7604,'BBa_B0012','T','BBa_B0011','T','^'),(7605,'BBa_B0012','T','BBa_R0051','P','^'),(7606,'BBa_J23113','P','BBa_B0034','R','^'),(7607,'BBa_B0034','R','BBa_K098997','G','^'),(7608,'BBa_K098997','G','BBa_B0012','T','^'),(7609,'BBa_B0012','T','BBa_B0011','T','^'),(7610,'BBa_B0011','T','BBa_R0051','P','^'),(7611,'BBa_R0011','P','BBa_B0034','R','^'),(7612,'BBa_B0034','R','BBa_C0040','G','^'),(7613,'BBa_C0040','G','BBa_B0010','T','^'),(7614,'BBa_B0010','T','BBa_B0012','T','^'),(7615,'BBa_B0033','R','BBa_C0012','G','^'),(7616,'BBa_R0010','P','BBa_B0034','R','^'),(7617,'BBa_B0034','R','BBa_C0051','G','^'),(7618,'BBa_C0051','G','BBa_B0032','R','^'),(7619,'BBa_B0032','R','BBa_E0040','G','^'),(7620,'BBa_E0040','G','BBa_B0010','T','^'),(7621,'BBa_B0010','T','BBa_B0012','T','^'),(7622,'BBa_B0012','T','BBa_R0051','P','^'),(7623,'BBa_R0051','P','BBa_B0034','R','^'),(7624,'BBa_B0034','R','BBa_E1010','G','^'),(7625,'BBa_E1010','G','BBa_B0010','T','^'),(7626,'BBa_B0010','T','BBa_B0012','T','^'),(7627,'BBa_I0500','P','BBa_B0034','R','^'),(7628,'BBa_B0034','R','BBa_I746916','G','^'),(7629,'BBa_I746916','G','BBa_B0010','T','^'),(7630,'BBa_B0010','T','BBa_B0012','T','^'),(7631,'BBa_K106694','P','BBa_K106692','G','^'),(7632,'BBa_I719005','P','BBa_B0034','R','^'),(7633,'BBa_B0034','R','BBa_I746916','G','^'),(7634,'BBa_I746916','G','BBa_B0010','T','^'),(7635,'BBa_B0010','T','BBa_B0012','T','^'),(7636,'BBa_R0062','P','BBa_B0034','R','^'),(7637,'BBa_B0034','R','BBa_E0040','G','^'),(7638,'BBa_E0040','G','BBa_B0010','T','^'),(7639,'BBa_B0010','T','BBa_B0012','T','^'),(7640,'BBa_K165012','P','BBa_K165031','P','^'),(7641,'BBa_K165031','P','BBa_K165002','R','^'),(7642,'BBa_B0034','R','BBa_K091109','G','^'),(7643,'BBa_K125100','P','BBa_B0030','R','^'),(7644,'BBa_K165018','T','^','^','^'),(7645,'BBa_K125500','G','^','^','^'),(7646,'BBa_J52008','G','BBa_B0015','T','^'),(7647,'BBa_R0010','P','BBa_B0030','R','^'),(7648,'BBa_B0030','R','BBa_K142200','G','^'),(7649,'BBa_K142200','G','BBa_B0015','T','^'),(7650,'BBa_K165012','P','BBa_K165031','P','^'),(7651,'BBa_K165000','P','BBa_K165002','R','^'),(7652,'BBa_K165043','P','BBa_K165054','G','^'),(7653,'BBa_K098999','Y','BBa_B0014','T','^'),(7654,'BBa_B0034','R','BBa_K098989','G','^'),(7655,'BBa_K098989','G','BBa_B0014','T','^'),(7656,'BBa_J23100','P','BBa_B0033','R','^'),(7657,'BBa_B0033','R','BBa_K137004','G','^'),(7658,'BBa_K137004','G','BBa_B0034','R','^'),(7659,'BBa_B0034','R','BBa_I732005','G','^'),(7660,'BBa_I732005','G','BBa_B0015','T','^'),(7661,'BBa_R0011','P','BBa_B0034','R','^'),(7662,'BBa_B0034','R','BBa_C0062','G','^'),(7663,'BBa_C0062','G','BBa_B0015','T','^'),(7664,'BBa_B0015','T','BBa_R0062','P','^'),(7665,'BBa_R0062','P','BBa_B0034','R','^'),(7666,'BBa_B0034','R','BBa_K137113','G','^'),(7667,'BBa_K137113','G','BBa_B0015','T','^'),(7668,'BBa_B0015','T','BBa_J23113','P','^'),(7669,'BBa_J23113','P','BBa_B0034','R','^'),(7670,'BBa_B0034','R','BBa_C0051','G','^'),(7671,'BBa_C0051','G','BBa_B0015','T','^'),(7672,'BBa_B0034','R','BBa_K137069','G','^'),(7673,'BBa_K137069','G','BBa_B0015','T','^'),(7674,'BBa_J23100','P','BBa_B0034','R','^'),(7675,'BBa_B0034','R','BBa_K137027','G','^'),(7676,'BBa_K137027','G','BBa_B0015','T','^'),(7677,'BBa_B0034','R','BBa_K137028','G','^'),(7678,'BBa_K137028','G','BBa_B0015','T','^'),(7679,'BBa_K137029','P','BBa_B0034','R','^'),(7680,'BBa_B0034','R','BBa_E0040','G','^'),(7681,'BBa_E0040','G','BBa_B0015','T','^'),(7682,'BBa_K152001','Y','BBa_K152002','Y','^'),(7683,'BBa_K152002','Y','BBa_K118005','Y','^'),(7684,'BBa_K118005','Y','BBa_K152003','Y','^'),(7685,'BBa_K152003','Y','BBa_E0240','G','^'),(7686,'BBa_K118005','G','BBa_K112806','G','^'),(7687,'BBa_K112806','G','BBa_B0015','T','^'),(7688,'BBa_B0015','T','BBa_J23116','P','^'),(7689,'BBa_J23116','P','BBa_K112807','G','^'),(7690,'BBa_K112807','G','BBa_B0010','T','^'),(7691,'BBa_K118014','Y','BBa_K118006','Y','^'),(7692,'BBa_K118006','Y','BBa_K118005','Y','^'),(7693,'BBa_R0011','P','BBa_K118012','R','^'),(7694,'BBa_K118012','R','BBa_I742151','G','^'),(7695,'BBa_I742151','G','BBa_J15001','R','^'),(7696,'BBa_J15001','R','BBa_K118002','G','^'),(7697,'BBa_K118002','G','BBa_J15001','R','^'),(7698,'BBa_J15001','R','BBa_K118003','G','^'),(7699,'BBa_K118005','Y','BBa_K118013','Y','^'),(7700,'BBa_K118003','G','BBa_K118912','R','^'),(7701,'BBa_K118012','R','BBa_K118008','G','^'),(7702,'BBa_B0034','R','BBa_C0012','G','^'),(7703,'BBa_C0012','G','BBa_B0015','T','^'),(7704,'BBa_K137030','P','BBa_B0034','R','^'),(7705,'BBa_E0040','G','BBa_B0015','T','^'),(7706,'BBa_R0062','P','BBa_B0034','R','^'),(7707,'BBa_C0040','G','BBa_B0015','T','^'),(7708,'BBa_B0015','T','BBa_R0040','P','^'),(7709,'BBa_R0062','P','BBa_K137068','G','^'),(7710,'BBa_K137068','G','BBa_B0015','T','^'),(7711,'BBa_J23106','P','BBa_B0032','R','^'),(7712,'BBa_B0032','R','BBa_K137112','G','^'),(7713,'BBa_K137112','G','BBa_B0015','T','^'),(7714,'BBa_B0015','T','BBa_P1005','Z','^'),(7715,'BBa_P1005','Z','BBa_B0015','T','^'),(7716,'BBa_K131017','P','BBa_B0034','R','^'),(7717,'BBa_B0034','R','BBa_K091109','G','^'),(7718,'BBa_R0040','P','BBa_I0462','G','^'),(7719,'BBa_I0462','G','BBa_R0062','P','^'),(7720,'BBa_K091104','P','BBa_B0034','R','^'),(7721,'BBa_B0034','R','BBa_C0178','G','^'),(7722,'BBa_C0178','G','BBa_B0034','R','^'),(7723,'BBa_K091107','P','BBa_B0034','R','^'),(7724,'BBa_B0034','R','BBa_C0072','G','^'),(7725,'BBa_C0072','G','BBa_B0015','T','^'),(7726,'BBa_B0015','T','BBa_R0011','P','^'),(7727,'BBa_B0034','R','BBa_C0161','G','^'),(7728,'BBa_B0034','R','BBa_C0170','G','^'),(7729,'BBa_R0040','P','BBa_B0033','R','^'),(7730,'BBa_B0033','R','BBa_C0053','G','^'),(7731,'BBa_C0053','G','BBa_B0015','T','^'),(7732,'BBa_I13453','P','BBa_B0034','R','^'),(7733,'BBa_B0034','R','BBa_C0079','G','^'),(7734,'BBa_C0079','G','BBa_B0015','T','^'),(7735,'BBa_B0015','T','BBa_R0011','P','^'),(7736,'BBa_K091143','P','BBa_B0034','R','^'),(7737,'BBa_B0034','R','BBa_C0061','G','^'),(7738,'BBa_C0061','G','BBa_B0034','R','^'),(7739,'BBa_K091101','P','BBa_B0034','R','^'),(7740,'BBa_C0051','G','BBa_B0012','T','^'),(7741,'BBa_B0012','T','BBa_B0011','T','^'),(7742,'BBa_B0030','R','BBa_E0040','G','^'),(7743,'BBa_E0040','G','BBa_B1006','T','^'),(7744,'BBa_B0030','R','BBa_E1010','G','^'),(7745,'BBa_E1010','G','BBa_B1006','T','^'),(7746,'BBa_B0034','R','BBa_K137009','G','^'),(7747,'BBa_K137009','G','BBa_B0015','T','^'),(7748,'BBa_K105001','G','^','^','^'),(7749,'BBa_J23118','P','BBa_B0034','R','^'),(7750,'BBa_K116603','P','BBa_B0032','R','^'),(7751,'BBa_B0032','R','BBa_C0061','G','^'),(7752,'BBa_B0030','R','BBa_C0061','G','^'),(7753,'BBa_C0061','G','BBa_B1006','T','^'),(7754,'BBa_J45992','P','BBa_B0030','R','^'),(7755,'BBa_B0030','R','BBa_J45014','G','^'),(7756,'BBa_J45014','G','BBa_B0015','T','^'),(7757,'BBa_B0030','R','BBa_C0078','G','^'),(7758,'BBa_C0078','G','BBa_B1006','T','^'),(7759,'BBa_J23100','P','BBa_B0030','R','^'),(7760,'BBa_B0030','R','BBa_C0040','G','^'),(7761,'BBa_C0040','G','BBa_B1006','T','^'),(7762,'BBa_R0051','P','BBa_B0030','R','^'),(7763,'BBa_B0030','R','BBa_C0062','G','^'),(7764,'BBa_C0062','G','BBa_B1006','T','^'),(7765,'BBa_I13453','P','BBa_B0034','R','^'),(7766,'BBa_B0034','R','BBa_I15008','G','^'),(7767,'BBa_I15008','G','BBa_B0034','R','^'),(7768,'BBa_B0034','R','BBa_I15009','G','^'),(7769,'BBa_I15009','G','BBa_B0015','T','^'),(7770,'BBa_B0015','T','BBa_R0040','P','^'),(7771,'BBa_B0034','R','BBa_I15010','G','^'),(7772,'BBa_I15010','G','BBa_B0015','T','^'),(7773,'BBa_B0030','R','BBa_I15009','G','^'),(7774,'BBa_I15009','G','BBa_B1006','T','^'),(7775,'BBa_B0030','R','BBa_C0051','P','^'),(7776,'BBa_C0051','G','BBa_B0030','R','^'),(7777,'BBa_B0030','R','BBa_C0079','G','^'),(7778,'BBa_C0079','G','BBa_B1006','T','^'),(7779,'BBa_B1006','T','BBa_R0051','P','^'),(7780,'BBa_B1006','T','BBa_R0062','P','^'),(7781,'BBa_B0032','R','BBa_C0062','G','^'),(7782,'BBa_R0010','P','BBa_B0032','R','^'),(7783,'BBa_R0040','P','BBa_B0032','R','^'),(7784,'BBa_B0034','R','BBa_E0033','G','^'),(7785,'BBa_E0033','G','BBa_B0015','T','^'),(7786,'BBa_K098999','Y','BBa_B0014','T','^'),(7787,'BBa_B0034','R','BBa_K098989','G','^'),(7788,'BBa_B0034','R','BBa_K137011','G','^'),(7789,'BBa_K137011','G','BBa_B0015','T','^'),(7790,'BBa_B0034','R','BBa_I746918','G','^'),(7791,'BBa_I746918','G','BBa_B0015','T','^'),(7792,'BBa_B0034','R','BBa_K137005','G','^'),(7793,'BBa_K137005','G','BBa_B0015','T','^'),(7794,'BBa_I719005','P','BBa_B0034','R','^'),(7795,'BBa_B0034','R','BBa_I746919','G','^'),(7796,'BBa_I746919','G','BBa_B0015','T','^'),(7797,'BBa_K091109','G','BBa_B0015','T','^'),(7798,'BBa_R0040','P','BBa_K123000','G','^'),(7799,'BBa_K123000','G','BBa_R0040','P','^'),(7800,'BBa_R0040','P','BBa_K123001','G','^'),(7801,'BBa_E1010','G','BBa_R0040','P','^'),(7802,'BBa_K143012','P','BBa_K143021','R','^'),(7803,'BBa_J31005','G','BBa_B0015','T','^'),(7804,'BBa_K143021','R','BBa_J31005','G','^'),(7805,'BBa_B0015','T','BBa_K143012','P','^'),(7806,'BBa_K143021','R','BBa_E0040','G','^'),(7807,'BBa_K143021','R','BBa_E1010','G','^'),(7808,'BBa_B0034','R','BBa_E0035','G','^'),(7809,'BBa_E0035','G','BBa_B0015','T','^'),(7810,'BBa_K106018','T','^','^','^'),(7811,'BBa_K191006','G','BBa_B0015','T','^'),(7812,'BBa_B0030','R','BBa_K191006','G','^'),(7813,'BBa_R0010','P','BBa_B0030','R','^'),(7814,'BBa_I0500','P','BBa_K118012','R','^'),(7815,'BBa_K118012','R','BBa_K118008','G','^'),(7816,'BBa_I0500','P','BBa_K118013','Y','^'),(7817,'BBa_I712004','X','BBa_K133010','G','^'),(7818,'BBa_K133010','G','BBa_K133139','G','^'),(7819,'BBa_K133139','G','BBa_K133046','G','^'),(7820,'BBa_K133016','G','BBa_K133071','G','^'),(7821,'BBa_K133061','G','BBa_K133065','G','^'),(7822,'BBa_K133139','G','BBa_K133061','G','^'),(7823,'BBa_R0080','P','BBa_B0034','R','^'),(7824,'BBa_B0034','R','BBa_J52008','G','^'),(7825,'BBa_J52008','G','BBa_B0015','T','^'),(7826,'BBa_K112903','T','^','^','^'),(7827,'BBa_K112903','T','^','^','^'),(7828,'BBa_R0010','P','BBa_B0034','R','^'),(7829,'BBa_B0034','R','BBa_E1010','G','^'),(7830,'BBa_E1010','G','BBa_B0015','T','^'),(7831,'BBa_B0030','R','^','^','^'),(7832,'BBa_J44001','R','^','^','^'),(7833,'BBa_B0011','T','^','^','^'),(7834,'BBa_B0024','P','^','^','^'),(7835,'BBa_B0012','T','BBa_B0010','T','^'),(7836,'BBa_B0025','T','^','^','^'),(7837,'BBa_B0012','T','BBa_B0011','T','^'),(7838,'BBa_J52010','P','BBa_J52035','G','^'),(7839,'BBa_B0032','R','^','^','^'),(7840,'BBa_B0033','R','^','^','^'),(7841,'BBa_B0034','R','BBa_J32004','G','^'),(7842,'BBa_B0034','R','BBa_J32021','G','^'),(7843,'BBa_B1001','T','^','^','^'),(7844,'BBa_R0040','P','BBa_B0034','R','^'),(7845,'BBa_B0034','R','BBa_C0061','G','^'),(7846,'BBa_B0034','R','BBa_C0061','G','^'),(7847,'BBa_C0061','G','BBa_B0015','T','^'),(7848,'BBa_B1002','T','^','^','^'),(7849,'BBa_B1003','T','^','^','^'),(7850,'BBa_B1005','T','^','^','^'),(7851,'BBa_B1006','T','^','^','^'),(7852,'BBa_B1007','T','^','^','^'),(7853,'BBa_B1008','T','^','^','^'),(7854,'BBa_B1009','T','^','^','^'),(7855,'BBa_B1010','T','^','^','^'),(7856,'BBa_J61048','T','^','^','^'),(7857,'BBa_J61101','R','^','^','^'),(7858,'BBa_J61107','R','^','^','^'),(7859,'BBa_J61100','R','^','^','^'),(7860,'BBa_B0034','R','BBa_C0040','G','^'),(7861,'BBa_B0034','R','BBa_C0012','G','^'),(7862,'BBa_B0033','R','BBa_C0012','G','^'),(7863,'BBa_B0034','R','BBa_E0020','G','^'),(7864,'BBa_E0020','G','BBa_B0015','T','^'),(7865,'BBa_B0034','R','BBa_E0030','G','^'),(7866,'BBa_E0030','G','BBa_B0015','T','^'),(7867,'BBa_B0034','R','BBa_E0022','G','^'),(7868,'BBa_E0022','G','BBa_B0015','T','^'),(7869,'BBa_B0034','R','BBa_C0062','G','^'),(7870,'BBa_C0062','G','BBa_B0015','T','^'),(7871,'BBa_B0032','R','BBa_E0030','G','^'),(7872,'BBa_B0031','R','BBa_E0030','G','^'),(7873,'BBa_B0030','R','BBa_E0030','G','^'),(7874,'BBa_J33201','G','BBa_J33202','G','^'),(7875,'BBa_B0034','R','BBa_I732006','G','^'),(7876,'BBa_I732006','G','BBa_B0034','R','^'),(7877,'BBa_B0034','R','BBa_E0044','G','^'),(7878,'BBa_E0044','G','BBa_B0015','T','^'),(7879,'BBa_I732084','G','BBa_B0015','T','^'),(7880,'BBa_B0034','R','BBa_I732100','G','^'),(7881,'BBa_I732100','G','BBa_B0015','T','^'),(7882,'BBa_B0032','R','BBa_E0020','G','^'),(7883,'BBa_B0034','R','BBa_J06501','G','^'),(7884,'BBa_J06501','G','BBa_B0015','T','^'),(7885,'BBa_B0034','R','BBa_J06500','G','^'),(7886,'BBa_C0161','G','BBa_B0015','T','^'),(7887,'BBa_B0033','R','BBa_C0012','G','^'),(7888,'BBa_B0031','R','BBa_C0012','G','^'),(7889,'BBa_J15001','R','BBa_I742107','G','^'),(7890,'BBa_I742156','R','BBa_I742157','G','^'),(7891,'BBa_I742153','R','BBa_I742154','G','^'),(7892,'BBa_B0033','R','BBa_C0040','G','^'),(7893,'BBa_B0031','R','BBa_C0051','G','^'),(7894,'BBa_B0034','R','BBa_C0071','G','^'),(7895,'BBa_C0071','G','BBa_B0015','T','^'),(7896,'BBa_B0031','R','BBa_C0053','G','^'),(7897,'BBa_B0031','R','BBa_C0052','G','^'),(7898,'BBa_B0031','R','BBa_C0051','G','^'),(7899,'BBa_B0030','R','BBa_J45014','G','^'),(7900,'BBa_J45014','G','BBa_B0015','T','^'),(7901,'BBa_R0010','P','BBa_B0034','R','^'),(7902,'BBa_B0034','R','BBa_J36801','G','^'),(7903,'BBa_J36801','G','BBa_R0010','P','^'),(7904,'BBa_J36835','G','BBa_J36837','G','^'),(7905,'BBa_J36837','G','BBa_J36843','G','^');
/*!40000 ALTER TABLE `interactions_wide2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-09-22  3:17:49
