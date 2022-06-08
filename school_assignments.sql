CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `A_ID` int NOT NULL AUTO_INCREMENT,
  `as_description` varchar(100) DEFAULT NULL,
  `SubDateTime` datetime DEFAULT NULL,
  `TotalMark` decimal(5,2) DEFAULT NULL,
  `OralMark` decimal(5,2) DEFAULT NULL,
  `Course_ID` int DEFAULT NULL,
  PRIMARY KEY (`A_ID`),
  KEY `Course_ID_idx` (`Course_ID`),
  CONSTRAINT `Course_ID` FOREIGN KEY (`Course_ID`) REFERENCES `courses` (`C_ID`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignments`
--

LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,'assignment1','2022-03-01 23:59:59',100.00,100.00,1),(2,'assignment2','2022-04-01 23:59:59',100.00,100.00,1),(3,'assignment3','2022-05-01 23:59:59',100.00,100.00,1),(4,'IndividualPart1','2022-04-08 23:59:59',100.00,100.00,1),(5,'IndividualPart2','2022-06-08 23:59:59',100.00,100.00,1),(6,'GroupProject','2022-08-01 23:59:59',100.00,100.00,1),(7,'assignment1','2022-03-01 23:59:59',100.00,100.00,2),(8,'assignment2','2022-04-01 23:59:59',100.00,100.00,2),(9,'FinalProject','2022-05-01 23:59:59',100.00,100.00,2),(10,'assignment1','2022-03-01 23:59:59',100.00,100.00,3),(11,'assignment2','2022-04-01 23:59:59',100.00,100.00,3),(12,'assignment3','2022-05-01 23:59:59',100.00,100.00,3),(13,'GroupProject','2022-08-01 23:59:59',100.00,100.00,3),(14,'Project1','2022-03-01 23:59:59',100.00,100.00,5),(15,'Project2','2022-04-01 23:59:59',100.00,100.00,5),(16,'FinalProject','2022-05-01 23:59:59',100.00,100.00,5),(17,'assignment1','2022-03-01 23:59:59',100.00,100.00,6),(18,'assignment2','2022-04-01 23:59:59',100.00,100.00,6),(19,'assignment3','2022-05-01 23:59:59',100.00,100.00,6),(20,'FinalProject','2022-08-01 23:59:59',100.00,100.00,6),(24,'edf','2022-02-02 10:30:30',10.00,10.00,5),(29,'d','2000-02-02 10:02:02',3.00,3.00,1),(31,'asfcc','2022-02-02 10:30:30',10.00,10.00,6),(32,'olololo','2022-02-02 10:30:30',10.00,10.00,7),(33,'ega','2022-02-02 10:30:30',10.00,10.00,1),(34,'sCFAS','2022-02-02 10:30:30',10.00,10.00,1),(35,'aesfv','2022-02-02 10:30:30',1.00,1.00,1),(36,'ds','2022-02-02 10:30:30',1.00,1.00,1);
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-08 11:16:24
