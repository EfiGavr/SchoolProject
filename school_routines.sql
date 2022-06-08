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
-- Temporary view structure for view `assignment_per_course_per_student`
--

DROP TABLE IF EXISTS `assignment_per_course_per_student`;
/*!50001 DROP VIEW IF EXISTS `assignment_per_course_per_student`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `assignment_per_course_per_student` AS SELECT 
 1 AS `St_ID`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `DateOfBirth`,
 1 AS `TuitionFees`,
 1 AS `C_ID`,
 1 AS `Title`,
 1 AS `Course_Stream`,
 1 AS `Course_Type`,
 1 AS `StartDate`,
 1 AS `EndDate`,
 1 AS `A_ID`,
 1 AS `as_description`,
 1 AS `SubDateTime`,
 1 AS `TotalMark`,
 1 AS `OralMark`,
 1 AS `Course_ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `students_that_belongs_to_many_courses`
--

DROP TABLE IF EXISTS `students_that_belongs_to_many_courses`;
/*!50001 DROP VIEW IF EXISTS `students_that_belongs_to_many_courses`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `students_that_belongs_to_many_courses` AS SELECT 
 1 AS `St_ID`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `DateOfBirth`,
 1 AS `TuitionFees`,
 1 AS `Stud_ID`,
 1 AS `Cour_ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `assignment_per_course_per_student`
--

/*!50001 DROP VIEW IF EXISTS `assignment_per_course_per_student`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `assignment_per_course_per_student` AS select `students`.`St_ID` AS `St_ID`,`students`.`firstName` AS `firstName`,`students`.`lastName` AS `lastName`,`students`.`DateOfBirth` AS `DateOfBirth`,`students`.`TuitionFees` AS `TuitionFees`,`courses`.`C_ID` AS `C_ID`,`courses`.`Title` AS `Title`,`courses`.`Course_Stream` AS `Course_Stream`,`courses`.`Course_Type` AS `Course_Type`,`courses`.`StartDate` AS `StartDate`,`courses`.`EndDate` AS `EndDate`,`assignments`.`A_ID` AS `A_ID`,`assignments`.`as_description` AS `as_description`,`assignments`.`SubDateTime` AS `SubDateTime`,`assignments`.`TotalMark` AS `TotalMark`,`assignments`.`OralMark` AS `OralMark`,`assignments`.`Course_ID` AS `Course_ID` from (((`student_per_course` join `courses`) join `students`) join `assignments`) where ((`courses`.`C_ID` = `student_per_course`.`Cour_ID`) and (`student_per_course`.`Stud_ID` = `students`.`St_ID`) and (`assignments`.`Course_ID` = `student_per_course`.`Cour_ID`)) order by `students`.`firstName` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `students_that_belongs_to_many_courses`
--

/*!50001 DROP VIEW IF EXISTS `students_that_belongs_to_many_courses`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `students_that_belongs_to_many_courses` AS select `students`.`St_ID` AS `St_ID`,`students`.`firstName` AS `firstName`,`students`.`lastName` AS `lastName`,`students`.`DateOfBirth` AS `DateOfBirth`,`students`.`TuitionFees` AS `TuitionFees`,`student_per_course`.`Stud_ID` AS `Stud_ID`,`student_per_course`.`Cour_ID` AS `Cour_ID` from (`students` join `student_per_course`) where (`student_per_course`.`Cour_ID` > 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-08 11:16:24
