-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: mysqldb.ck5yc6wy2nq7.eu-central-1.rds.amazonaws.com    Database: mysqldb
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `User_Reminders`
--

DROP TABLE IF EXISTS `User_Reminders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Reminders` (
  `reminderId` int(11) NOT NULL AUTO_INCREMENT,
  `event` varchar(255) NOT NULL,
  `event_End_Date` varchar(255) NOT NULL,
  `event_Start_Date` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  PRIMARY KEY (`reminderId`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Reminders`
--

LOCK TABLES `User_Reminders` WRITE;
/*!40000 ALTER TABLE `User_Reminders` DISABLE KEYS */;
INSERT INTO `User_Reminders` VALUES (24,'holiday trip by car','30/08/2017','26/08/2017','new jersey'),(25,'holiday trip by car','30/08/2017','26/08/2017','munich'),(32,'Visiting relatives','3/10/2017','29/9/2017','Paris'),(34,'business trip by car','30/09/2017','28/09/2017','new york'),(35,'Business trip','30/9/2017','27/9/2017','London'),(36,'Holiday','30/9/2017','28/9/2017','Munich'),(37,'Visit','7/10/2017','3/10/2017','Berlin'),(38,'business trip by car','03/10/2017','02/10/2017','new york'),(39,'Business Trip Mumbai','19/10/2017','15/10/2017','Mumbai');
/*!40000 ALTER TABLE `User_Reminders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26  9:40:37
