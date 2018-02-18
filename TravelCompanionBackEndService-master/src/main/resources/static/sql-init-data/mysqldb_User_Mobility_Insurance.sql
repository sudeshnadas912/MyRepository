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
-- Table structure for table `User_Mobility_Insurance`
--

DROP TABLE IF EXISTS `User_Mobility_Insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Mobility_Insurance` (
  `user_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `File_Date` varchar(255) DEFAULT NULL,
  `Package_Title` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  `selected_Module` varchar(255) NOT NULL,
  `selected_Package` varchar(255) NOT NULL,
  `Total_Price` int(11) NOT NULL,
  `travel_date` varchar(255) DEFAULT NULL,
  `travelEndDate` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `varied_price` float NOT NULL,
  `weather` varchar(255) NOT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Mobility_Insurance`
--

LOCK TABLES `User_Mobility_Insurance` WRITE;
/*!40000 ALTER TABLE `User_Mobility_Insurance` DISABLE KEYS */;
INSERT INTO `User_Mobility_Insurance` VALUES (46,'Fri Aug 25 03:39:48 UTC 2017','alexa_new york_2017-10-25','new york','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'25/10/2017','28/10/2017','Michael',21.6,'Sunny'),(47,'Fri Aug 25 03:43:12 UTC 2017','alexa_new jersey_26/08/2017','new jersey','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'26/08/2017','30/08/2017','Michael',26,'Patchy rain possible'),(49,'Wed Aug 30 07:10:19 UTC 2017','alexa_new york_31/08/2017','new york','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'31/08/2017','30/08/2017','Michael',26,'Sunny'),(53,'Wed Sep 13 09:58:23 UTC 2017','alexa_new york_14/9/2017','new york','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'14/9/2017','20/9/2017','Michael',18,'Overcast'),(57,'Tue Sep 26 14:15:41 UTC 2017','alexa_berlin_2017-10-08','berlin','Traffic warning service##adds transfer cost for special luggage##Weather forecast Service##adds rental car','DestinationFamily Module',17,'08/10/2017','12/10/2017','Michael',20.4,'Light rain shower'),(58,'Tue Sep 26 14:19:34 UTC 2017','alexa_paris_2017-09-29','paris','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'29/09/2017','03/10/2017','Michael',31.2,'Partly cloudy'),(59,'Tue Sep 26 14:22:07 UTC 2017','alexa_paris_29/9/2017','paris','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'29/9/2017','3/10/2017','Michael',18,'Partly cloudy'),(60,'Tue Sep 26 14:39:38 UTC 2017','alexa_paris_2017-09-29','paris','Traffic warning service##Weather forecast Service##adds alternative travel cost reimbursement','TrainFlight Module',9,'29/09/2017','03/10/2017','Michael',10.8,'Partly cloudy'),(61,'Tue Sep 26 14:41:09 UTC 2017','alexa_paris_29/9/2017','paris','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'29/9/2017','3/10/2017','Michael',18,'Partly cloudy'),(62,'Tue Sep 26 14:56:29 UTC 2017','alexa_london_2017-09-28','london','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'28/09/2017','26/09/2017','Michael',18,'Sunny'),(63,'Tue Sep 26 15:40:56 UTC 2017','alexa_paris_29/9/2017','paris','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'29/9/2017','3/10/2017','Michael',26,'Light rain'),(64,'Wed Sep 27 09:39:12 UTC 2017','alexa_london_27/9/2017','london','Traffic warning service##Weather forecast Service##adds alternative travel cost reimbursement','TrainFlight Module',9,'27/9/2017','30/9/2017','Michael',9,'Cloudy'),(65,'Wed Sep 27 09:55:56 UTC 2017','alexa_london_27/9/2017','london','Traffic warning service##Weather forecast Service##adds alternative travel cost reimbursement','TrainFlight Module',9,'27/9/2017','30/9/2017','Michael',9,'Cloudy'),(66,'Wed Sep 27 09:56:48 UTC 2017','alexa_london_27/9/2017','london','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'27/9/2017','30/9/2017','Michael',26,'Cloudy'),(67,'Wed Sep 27 12:13:03 UTC 2017','alexa_london_27/9/2017','london','Traffic warning service##Weather forecast Service##adds alternative travel cost reimbursement','TrainFlight Module',9,'27/9/2017','30/9/2017','Michael',9,'Cloudy'),(68,'Wed Sep 27 13:58:36 UTC 2017','alexa_london_27/9/2017','london','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','Breakdown Module',26,'27/9/2017','30/9/2017','Michael',26,'Overcast'),(69,'Sun Oct 01 08:47:39 UTC 2017','alexa_new york_02/10/2017','new york','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'02/10/2017','03/10/2017','Michael',18,'Sunny'),(70,'Thu Oct 12 13:11:26 UTC 2017','Sf','San Francisco','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','DestinationBusiness Module##',18,'19/10/2017','29/10/2017','michael',16.08,'Partly cloudy'),(71,'Fri Oct 13 09:18:17 UTC 2017','alexa_stuttgart_2017-10-16','stuttgart','Traffic warning service##adds transfer cost for special luggage##Weather forecast Service##adds rental car','DestinationFamily Module',17,'16/10/2017','20/10/2017','Michael',20.4,'Sunny'),(72,'Fri Oct 13 09:24:44 UTC 2017','alexa_mumbai_15/10/2017','mumbai','Traffic warning service##Weather forecast Service##adds alternative travel cost reimbursement','TrainFlight Module',9,'15/10/2017','19/10/2017','Michael',9,'Sunny');
/*!40000 ALTER TABLE `User_Mobility_Insurance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26  9:40:23
