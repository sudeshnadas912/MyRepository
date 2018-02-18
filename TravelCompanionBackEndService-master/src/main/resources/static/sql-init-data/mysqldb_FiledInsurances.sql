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
-- Table structure for table `FiledInsurances`
--

DROP TABLE IF EXISTS `FiledInsurances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FiledInsurances` (
  `insurance_Id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`insurance_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FiledInsurances`
--

LOCK TABLES `FiledInsurances` WRITE;
/*!40000 ALTER TABLE `FiledInsurances` DISABLE KEYS */;
INSERT INTO `FiledInsurances` VALUES (5,'Wed Aug 23 13:03:58 UTC 2017','trip','london','Traffic warning service#adds transfer cost for special luggage#adds vehicle return home coverage#Weather forecast Service#adds alternative travel cost reimbursement#','Breakdown Module#',24,'23/8/2017','24/8/2017','michael',23.52,'Overcast'),(6,'Wed Aug 23 13:03:58 UTC 2017','trip','london','Traffic warning service#adds transfer cost for special luggage#adds vehicle return home coverage#Weather forecast Service#adds alternative travel cost reimbursement#','Breakdown Module#',24,'23/8/2017','24/8/2017','michael',23.52,'Overcast'),(7,'Wed Aug 23 16:50:47 UTC 2017','alexa_bangalore_2017-10-25','bangalore','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',16,'25/10/2017','29/10/2017','Michael',50,'Patchy rain possible'),(8,'Thu Aug 24 03:14:20 UTC 2017','Plan 1','London','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','Breakdown Module##',24,'26/8/2017','21/9/2017','michael',23.04,'Clear'),(9,'Thu Aug 24 03:14:20 UTC 2017','Plan 1','London','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','Breakdown Module##',24,'26/8/2017','21/9/2017','michael',23.04,'Clear'),(10,'Thu Aug 24 08:55:16 UTC 2017','alexa_london_24/8/2017','london','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'24/8/2017','31/8/2017','Michael',50,'Sunny'),(11,'Thu Aug 24 17:17:13 UTC 2017','alexa_new jersey_26/08/2017','new jersey','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement','DestinationBusiness Module',18,'26/08/2017','30/08/2017','Michael',18,'Patchy rain possible'),(12,'Fri Aug 25 03:35:40 UTC 2017','Sample','London','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','DestinationBusiness Module##',26,'25/8/2017','30/8/2017','michael',24.7867,'Clear'),(13,'Fri Aug 25 03:35:40 UTC 2017','Sample','London','Traffic warning service##adds transfer cost for special luggage##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','DestinationBusiness Module##',26,'25/8/2017','30/8/2017','michael',24.7867,'Clear'),(14,'Tue Sep 12 14:11:26 UTC 2017','Berlin ravel','Berlin','Traffic warning service##adds transfer cost for special luggage##Weather forecast Service##adds rental car##adds alternative travel cost reimbursement##','DestinationFamily Module##TrainFlight Module##',24,'27/9/2017','2/10/2017','michael',24.96,'Shower In Vicinity, Rain Shower'),(15,'Thu Oct 12 13:11:26 UTC 2017','Sf','San Francisco','Traffic warning service##adds vehicle return home coverage##Weather forecast Service##adds alternative travel cost reimbursement##','DestinationBusiness Module##',18,'19/10/2017','29/10/2017','michael',16.08,'Partly cloudy');
/*!40000 ALTER TABLE `FiledInsurances` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26  9:40:39
