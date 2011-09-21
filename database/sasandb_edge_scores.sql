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
-- Table structure for table `edge_scores`
--

DROP TABLE IF EXISTS `edge_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edge_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part1` varchar(300) DEFAULT NULL,
  `part2` varchar(300) DEFAULT NULL,
  `score` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1961 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edge_scores`
--

LOCK TABLES `edge_scores` WRITE;
/*!40000 ALTER TABLE `edge_scores` DISABLE KEYS */;
INSERT INTO `edge_scores` VALUES (1668,'BBa_B0010','BBa_B0010','3.2'),(1669,'BBa_B0010','BBa_B0012','3432.4999999997913'),(1670,'BBa_B0011','BBa_R0051','19.4'),(1671,'BBa_B0012','BBa_B0010','6.400000000000001'),(1672,'BBa_B0012','BBa_B0011','100.40000000000015'),(1673,'BBa_B0012','BBa_R0051','76.0000000000002'),(1674,'BBa_B0030','BBa_C0040','7.400000000000001'),(1675,'BBa_B0030','BBa_C0051','17.899999999999995'),(1676,'BBa_B0030','BBa_C0061','16.199999999999996'),(1677,'BBa_B0030','BBa_C0062','18.199999999999996'),(1678,'BBa_B0030','BBa_C0078','11.599999999999998'),(1679,'BBa_B0030','BBa_C0079','10.499999999999998'),(1680,'BBa_B0030','BBa_E0030','6.8'),(1681,'BBa_B0030','BBa_E0040','88.40000000000013'),(1682,'BBa_B0030','BBa_E1010','7.200000000000001'),(1683,'BBa_B0030','BBa_I15009','9.4'),(1684,'BBa_B0030','BBa_I715019','6.0'),(1685,'BBa_B0030','BBa_J31001','13.2'),(1686,'BBa_B0030','BBa_J31007','26.99999999999999'),(1687,'BBa_B0030','BBa_J45014','2.2'),(1688,'BBa_B0030','BBa_J61047','7.7'),(1689,'BBa_B0030','BBa_K142200','2.0'),(1690,'BBa_B0031','BBa_C0012','25.39999999999999'),(1691,'BBa_B0031','BBa_C0040','20.699999999999992'),(1692,'BBa_B0031','BBa_C0051','13.599999999999994'),(1693,'BBa_B0031','BBa_C0052','5.6'),(1694,'BBa_B0031','BBa_C0053','6.2'),(1695,'BBa_B0031','BBa_E0030','9.4'),(1696,'BBa_B0031','BBa_J22056','3.4000000000000004'),(1697,'BBa_B0032','BBa_C0060','5.4'),(1698,'BBa_B0032','BBa_C0061','20.799999999999994'),(1699,'BBa_B0032','BBa_C0062','21.799999999999994'),(1700,'BBa_B0032','BBa_C0600','4.4'),(1701,'BBa_B0032','BBa_C0620','4.4'),(1702,'BBa_B0032','BBa_E0020','7.0'),(1703,'BBa_B0032','BBa_E0030','18.299999999999997'),(1704,'BBa_B0032','BBa_E0032','6.8'),(1705,'BBa_B0032','BBa_E0040','185.59999999999977'),(1706,'BBa_B0032','BBa_E1010','9.900000000000002'),(1707,'BBa_B0032','BBa_J45004','20.599999999999998'),(1708,'BBa_B0032','BBa_J45017','3.6000000000000005'),(1709,'BBa_B0032','BBa_K137112','7.2'),(1710,'BBa_B0032','BBa_K145015','6.800000000000001'),(1711,'BBa_B0033','BBa_C0012','20.2'),(1712,'BBa_B0033','BBa_C0040','11.999999999999996'),(1713,'BBa_B0033','BBa_C0053','11.3'),(1714,'BBa_B0033','BBa_K137004','5.2'),(1715,'BBa_B0034','BBa_C0012','175.5999999999995'),(1716,'BBa_B0034','BBa_C0040','197.09999999999894'),(1717,'BBa_B0034','BBa_C0051','185.79999999999941'),(1718,'BBa_B0034','BBa_C0052','30.999999999999975'),(1719,'BBa_B0034','BBa_C0053','34.40000000000001'),(1720,'BBa_B0034','BBa_C0060','46.70000000000004'),(1721,'BBa_B0034','BBa_C0061','140.7000000000001'),(1722,'BBa_B0034','BBa_C0062','285.4999999999986'),(1723,'BBa_B0034','BBa_C0070','32.39999999999999'),(1724,'BBa_B0034','BBa_C0071','18.099999999999977'),(1725,'BBa_B0034','BBa_C0072','25.599999999999998'),(1726,'BBa_B0034','BBa_C0078','15.79999999999999'),(1727,'BBa_B0034','BBa_C0079','36.10000000000005'),(1728,'BBa_B0034','BBa_C0161','25.599999999999994'),(1729,'BBa_B0034','BBa_C0170','4.4'),(1730,'BBa_B0034','BBa_C0171','17.599999999999994'),(1731,'BBa_B0034','BBa_C0178','19.399999999999995'),(1732,'BBa_B0034','BBa_E0020','100.80000000000014'),(1733,'BBa_B0034','BBa_E0022','84.50000000000023'),(1734,'BBa_B0034','BBa_E0030','227.69999999999942'),(1735,'BBa_B0034','BBa_E0032','136.3999999999997'),(1736,'BBa_B0034','BBa_E0033','11.199999999999992'),(1737,'BBa_B0034','BBa_E0034','23.299999999999986'),(1738,'BBa_B0034','BBa_E0035','15.4'),(1739,'BBa_B0034','BBa_E0040','281.99999999999926'),(1740,'BBa_B0034','BBa_E0044','9.599999999999998'),(1741,'BBa_B0034','BBa_E1010','273.5999999999991'),(1742,'BBa_B0034','BBa_I15008','11.399999999999993'),(1743,'BBa_B0034','BBa_I15009','7.400000000000002'),(1744,'BBa_B0034','BBa_I15010','9.799999999999994'),(1745,'BBa_B0034','BBa_I2032','3.7'),(1746,'BBa_B0034','BBa_I715019','39.60000000000001'),(1747,'BBa_B0034','BBa_I715022','51.40000000000001'),(1748,'BBa_B0034','BBa_I732005','22.099999999999998'),(1749,'BBa_B0034','BBa_I732006','115.8'),(1750,'BBa_B0034','BBa_I732080','9.0'),(1751,'BBa_B0034','BBa_I732100','10.0'),(1752,'BBa_B0034','BBa_I746916','6.2'),(1753,'BBa_B0034','BBa_I746918','6.2'),(1754,'BBa_B0034','BBa_I746919','5.0'),(1755,'BBa_B0034','BBa_I746920','6.0'),(1756,'BBa_B0034','BBa_J04031','59.100000000000044'),(1757,'BBa_B0034','BBa_J06500','6.4'),(1758,'BBa_B0034','BBa_J06501','21.799999999999994'),(1759,'BBa_B0034','BBa_J06504','28.699999999999985'),(1760,'BBa_B0034','BBa_J32004','6.6000000000000005'),(1761,'BBa_B0034','BBa_J32020','4.2'),(1762,'BBa_B0034','BBa_J32021','4.2'),(1763,'BBa_B0034','BBa_J36801','8.1'),(1764,'BBa_B0034','BBa_J36802','6.6000000000000005'),(1765,'BBa_B0034','BBa_J36804','11.100000000000001'),(1766,'BBa_B0034','BBa_J52008','2.4000000000000004'),(1767,'BBa_B0034','BBa_K082003','6.0'),(1768,'BBa_B0034','BBa_K091109','14.399999999999999'),(1769,'BBa_B0034','BBa_K091122','6.800000000000001'),(1770,'BBa_B0034','BBa_K098989','8.4'),(1771,'BBa_B0034','BBa_K098997','14.4'),(1772,'BBa_B0034','BBa_K117001','2.0'),(1773,'BBa_B0034','BBa_K137005','8.0'),(1774,'BBa_B0034','BBa_K137009','10.0'),(1775,'BBa_B0034','BBa_K137011','10.0'),(1776,'BBa_B0034','BBa_K137027','4.0'),(1777,'BBa_B0034','BBa_K137028','3.0'),(1778,'BBa_B0034','BBa_K137069','7.2'),(1779,'BBa_B0034','BBa_K137113','15.4'),(1780,'BBa_B0064','BBa_C0040','1.2'),(1781,'BBa_B1006','BBa_R0051','5.2'),(1782,'BBa_B1006','BBa_R0062','11.0'),(1783,'BBa_B1006','BBa_R0079','5.2'),(1784,'BBa_B1006','BBa_R0082','3.0'),(1785,'BBa_C0012','BBa_B0034','45.09999999999999'),(1786,'BBa_C0040','BBa_B0010','189.39999999999918'),(1787,'BBa_C0040','BBa_B0034','31.999999999999932'),(1788,'BBa_C0040','BBa_B1006','3.0'),(1789,'BBa_C0051','BBa_B0012','29.39999999999999'),(1790,'BBa_C0051','BBa_B0030','13.699999999999996'),(1791,'BBa_C0051','BBa_B0032','2.2'),(1792,'BBa_C0052','BBa_B0034','6.400000000000001'),(1793,'BBa_C0061','BBa_B0034','36.2'),(1794,'BBa_C0061','BBa_B1006','8.0'),(1795,'BBa_C0062','BBa_B0032','9.0'),(1796,'BBa_C0062','BBa_B0034','30.39999999999999'),(1797,'BBa_C0062','BBa_B1006','13.2'),(1798,'BBa_C0078','BBa_B1006','8.2'),(1799,'BBa_C0079','BBa_B1006','7.4'),(1800,'BBa_C0178','BBa_B0034','7.6000000000000005'),(1801,'BBa_C0600','BBa_B0034','4.6000000000000005'),(1802,'BBa_C0620','BBa_B0034','4.4'),(1803,'BBa_E0020','BBa_E0021','0.2'),(1804,'BBa_E0040','BBa_B0010','522.8999999999993'),(1805,'BBa_E0040','BBa_B1006','7.2'),(1806,'BBa_E1010','BBa_B0010','219.39999999999935'),(1807,'BBa_E1010','BBa_B1006','5.0'),(1808,'BBa_E1010','BBa_J22101','3.4000000000000004'),(1809,'BBa_E1010','BBa_K092400','3.2'),(1810,'BBa_E1010','BBa_R0040','2.2'),(1811,'BBa_I0500','BBa_B0030','5.1'),(1812,'BBa_I0500','BBa_B0032','11.899999999999999'),(1813,'BBa_I0500','BBa_B0034','171.09999999999957'),(1814,'BBa_I0500','BBa_I746350','13.399999999999999'),(1815,'BBa_I13453','BBa_B0034','50.00000000000003'),(1816,'BBa_I14032','BBa_B0032','4.2'),(1817,'BBa_I14032','BBa_B0034','33.599999999999994'),(1818,'BBa_I14033','BBa_B0034','10.099999999999994'),(1819,'BBa_I15008','BBa_B0034','5.000000000000002'),(1820,'BBa_I15009','BBa_B1006','6.0'),(1821,'BBa_I712004','BBa_I712019','2.2'),(1822,'BBa_I712004','BBa_I712024','16.599999999999998'),(1823,'BBa_I712004','BBa_K133010','4.0'),(1824,'BBa_I712011','BBa_I712022','5.4'),(1825,'BBa_I712024','BBa_I712011','12.0'),(1826,'BBa_I712074','BBa_I712019','3.2'),(1827,'BBa_I715020','BBa_B0034','6.4'),(1828,'BBa_I715023','BBa_B0034','34.0'),(1829,'BBa_I719005','BBa_B0034','21.2'),(1830,'BBa_I732006','BBa_B0034','75.8'),(1831,'BBa_I742110','BBa_J15001','4.4'),(1832,'BBa_I742153','BBa_I742154','3.0'),(1833,'BBa_I742156','BBa_I742157','3.0'),(1834,'BBa_I742159','BBa_I742160','2.0'),(1835,'BBa_I742163','BBa_I742137','2.2'),(1836,'BBa_I746104','BBa_B0030','5.4'),(1837,'BBa_I746350','BBa_B0034','13.2'),(1838,'BBa_I746361','BBa_B0034','8.600000000000001'),(1839,'BBa_I746365','BBa_B0034','8.600000000000001'),(1840,'BBa_I746916','BBa_B0010','6.2'),(1841,'BBa_I766002','BBa_I766102','4.2'),(1842,'BBa_I766007','BBa_I766101','3.2'),(1843,'BBa_I766007','BBa_I766103','4.0'),(1844,'BBa_I766101','BBa_I766002','4.2'),(1845,'BBa_I766101','BBa_I766007','5.0'),(1846,'BBa_I766101','BBa_I766102','3.2'),(1847,'BBa_I766101','BBa_I766103','8.2'),(1848,'BBa_I766102','BBa_I766101','3.0'),(1849,'BBa_I766102','BBa_I766600','8.4'),(1850,'BBa_I766103','BBa_I766600','12.2'),(1851,'BBa_I766556','BBa_I766007','2.0'),(1852,'BBa_I766556','BBa_I766101','4.0'),(1853,'BBa_I766558','BBa_I766102','2.0'),(1854,'BBa_J15001','BBa_I742107','3.2'),(1855,'BBa_J15001','BBa_I742110','7.6000000000000005'),(1856,'BBa_J15001','BBa_J15103','3.2'),(1857,'BBa_J15001','BBa_K118000','8.600000000000001'),(1858,'BBa_J15001','BBa_K118001','7.4'),(1859,'BBa_J15001','BBa_K118002','5.0'),(1860,'BBa_J15001','BBa_K118003','9.4'),(1861,'BBa_J15001','BBa_K118015','7.2'),(1862,'BBa_J15001','BBa_K118016','7.5'),(1863,'BBa_J22052','BBa_B0031','3.4000000000000004'),(1864,'BBa_J22052','BBa_J22056','3.2'),(1865,'BBa_J22056','BBa_I0500','3.4000000000000004'),(1866,'BBa_J22126','BBa_E1010','7.1000000000000005'),(1867,'BBa_J23100','BBa_B0030','20.999999999999996'),(1868,'BBa_J23100','BBa_B0033','4.2'),(1869,'BBa_J23100','BBa_B0034','74.20000000000007'),(1870,'BBa_J23100','BBa_K079040','3.0'),(1871,'BBa_J23101','BBa_B0032','7.2'),(1872,'BBa_J23105','BBa_B0034','14.200000000000001'),(1873,'BBa_J23106','BBa_B0032','7.000000000000001'),(1874,'BBa_J23113','BBa_B0034','21.999999999999996'),(1875,'BBa_J23114','BBa_B0034','15.799999999999999'),(1876,'BBa_J23116','BBa_B0032','3.2'),(1877,'BBa_J23116','BBa_B0034','40.900000000000006'),(1878,'BBa_J23116','BBa_K112807','4.2'),(1879,'BBa_J23118','BBa_B0034','6.2'),(1880,'BBa_J23118','BBa_K079018','3.2'),(1881,'BBa_J23118','BBa_K079019','5.2'),(1882,'BBa_J23118','BBa_K079040','2.0'),(1883,'BBa_J23151','BBa_B0032','3.0'),(1884,'BBa_J33201','BBa_J33202','4.0'),(1885,'BBa_J33207','BBa_J15001','8.9'),(1886,'BBa_J36801','BBa_R0010','3.7'),(1887,'BBa_J36802','BBa_R0010','6.2'),(1888,'BBa_J36835','BBa_J36837','8.7'),(1889,'BBa_J36837','BBa_J36843','4.5'),(1890,'BBa_J45503','BBa_B0034','3.4000000000000004'),(1891,'BBa_J45992','BBa_B0030','3.2'),(1892,'BBa_J45993','BBa_B0032','2.0'),(1893,'BBa_J52010','BBa_J52035','4.0'),(1894,'BBa_J52034','BBa_J52008','3.2'),(1895,'BBa_K079018','BBa_B0034','3.2'),(1896,'BBa_K079019','BBa_B0034','5.2'),(1897,'BBa_K079040','BBa_B0034','5.0'),(1898,'BBa_K091104','BBa_B0034','4.2'),(1899,'BBa_K091107','BBa_B0034','5.0'),(1900,'BBa_K091112','BBa_B0032','7.4'),(1901,'BBa_K091143','BBa_B0034','3.2'),(1902,'BBa_K098997','BBa_B0012','14.4'),(1903,'BBa_K106694','BBa_K106692','3.0'),(1904,'BBa_K112807','BBa_B0010','4.2'),(1905,'BBa_K116603','BBa_B0032','25.399999999999995'),(1906,'BBa_K117002','BBa_B0034','3.0'),(1907,'BBa_K117002','BBa_K117000','2.0'),(1908,'BBa_K118000','BBa_J15001','5.4'),(1909,'BBa_K118002','BBa_J15001','1.0'),(1910,'BBa_K118011','BBa_J15001','3.0'),(1911,'BBa_K118011','BBa_J33204','4.0'),(1912,'BBa_K118012','BBa_I742151','4.5'),(1913,'BBa_K118012','BBa_K118008','3.0'),(1914,'BBa_K123000','BBa_R0040','3.2'),(1915,'BBa_K125100','BBa_B0030','1.2'),(1916,'BBa_K131017','BBa_B0034','2.0'),(1917,'BBa_K133010','BBa_K133139','11.2'),(1918,'BBa_K133016','BBa_K133071','10.2'),(1919,'BBa_K133061','BBa_K133065','5.2'),(1920,'BBa_K133139','BBa_K133046','10.2'),(1921,'BBa_K133139','BBa_K133061','5.2'),(1922,'BBa_K137004','BBa_B0034','4.2'),(1923,'BBa_K137029','BBa_B0034','5.0'),(1924,'BBa_K137030','BBa_B0034','5.0'),(1925,'BBa_K143012','BBa_K143021','4.0'),(1926,'BBa_K145150','BBa_B0032','3.1'),(1927,'BBa_K152001','BBa_K152002','5.2'),(1928,'BBa_K165000','BBa_K165002','6.0'),(1929,'BBa_K165002','BBa_K165005','1.0'),(1930,'BBa_K165012','BBa_K165031','6.0'),(1931,'BBa_K165031','BBa_K165002','8.0'),(1932,'BBa_I719005','BBa_I719005','0.2'),(1933,'BBa_R0010','BBa_B0030','34.00000000000001'),(1934,'BBa_R0010','BBa_B0032','18.999999999999993'),(1935,'BBa_R0010','BBa_B0034','169.2999999999999'),(1936,'BBa_R0011','BBa_B0032','19.999999999999996'),(1937,'BBa_R0011','BBa_B0034','237.9999999999992'),(1938,'BBa_R0011','BBa_R0062','9.8'),(1939,'BBa_R0040','BBa_B0030','24.199999999999978'),(1940,'BBa_R0040','BBa_B0032','56.40000000000009'),(1941,'BBa_R0040','BBa_B0033','7.400000000000001'),(1942,'BBa_R0040','BBa_B0034','434.0999999999964'),(1943,'BBa_R0040','BBa_K123000','4.2'),(1944,'BBa_R0040','BBa_K123001','4.2'),(1945,'BBa_R0051','BBa_B0030','22.39999999999999'),(1946,'BBa_R0051','BBa_B0032','12.399999999999993'),(1947,'BBa_R0051','BBa_B0034','111.40000000000025'),(1948,'BBa_R0052','BBa_B0034','20.19999999999999'),(1949,'BBa_R0053','BBa_B0034','29.999999999999982'),(1950,'BBa_R0062','BBa_B0032','32.79999999999999'),(1951,'BBa_R0062','BBa_B0033','8.899999999999999'),(1952,'BBa_R0062','BBa_B0034','164.5999999999996'),(1953,'BBa_R0062','BBa_E0040','2.5'),(1954,'BBa_R0062','BBa_J22086','4.2'),(1955,'BBa_R0063','BBa_B0034','46.600000000000044'),(1956,'BBa_R0065','BBa_B0034','48.60000000000006'),(1957,'BBa_R0071','BBa_K092800','3.2'),(1958,'BBa_R0079','BBa_B0032','3.6000000000000005'),(1959,'BBa_R0080','BBa_B0034','12.6'),(1960,'BBa_R0085','BBa_B0034','35.00000000000001');
/*!40000 ALTER TABLE `edge_scores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-09-22  3:17:58
