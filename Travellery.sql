-- MySQL dump 10.13  Distrib 8.1.0, for macos13.3 (arm64)
--
-- Host: localhost    Database: Travellery
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination`
--

DROP TABLE IF EXISTS `destination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination`
--

LOCK TABLES `destination` WRITE;
/*!40000 ALTER TABLE `destination` DISABLE KEYS */;
INSERT INTO `destination` VALUES (1,'2024-01-19 05:37:54.176709','집','https://post-phinf.pstatic.net/MjAxNzEyMDFfMTgg/MDAxNTEyMDkyMTA3NTY0.0EofFPIAghw0Ynr15TjEh3WPwHvSH2DVYY93HyOxg0Mg.KgUXctsB415ui1yuIyCh2DwhXk1tTVLzjvw-xIRPjwwg.PNG/image.png?type=w800_q75'),(2,'2024-01-19 05:37:54.176709','청송','https://www.cs.go.kr/CmsMultiFile/view.do?multifileId=tourinfo6&idx=26082'),(3,'2024-01-19 05:37:54.176709','제주도','https://blog.kakaocdn.net/dn/o1KIw/btqu9mflPY6/rGk1mM3iugV1c6jj9Z3E80/img.jpg'),(4,'2024-01-19 05:37:54.176709','분당','https://newsimg.sedaily.com/2020/08/24/1Z6PCHXKKB_2.jpg');
/*!40000 ALTER TABLE `destination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `travel_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `traveler_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKti8gywuf6phkr2r17b6xm7hmq` (`travel_id`),
  KEY `FKi2wo4dyk4rok7v4kak8sgkwx0` (`user_id`),
  KEY `FKg5egy7naky7eth7i8iyntpycr` (`traveler_id`),
  CONSTRAINT `FKg5egy7naky7eth7i8iyntpycr` FOREIGN KEY (`traveler_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKi2wo4dyk4rok7v4kak8sgkwx0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKti8gywuf6phkr2r17b6xm7hmq` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (27,'2024-01-19 06:33:43.104214',46,1,1),(29,'2024-01-20 07:44:04.835909',47,1,1),(31,'2024-01-20 14:58:35.331499',56,1,1),(32,'2024-01-20 14:58:37.993720',55,1,1),(33,'2024-01-20 14:58:39.428207',54,1,1),(34,'2024-01-20 14:58:40.346341',53,1,1),(35,'2024-01-20 14:58:42.808542',52,1,1),(36,'2024-01-20 14:58:43.294333',51,1,1),(37,'2024-01-20 14:58:47.413965',50,1,1),(38,'2024-01-20 14:58:48.028215',49,1,1),(39,'2024-01-20 14:58:49.564640',48,1,1),(40,'2024-01-20 15:23:01.694597',58,1,1),(43,'2024-01-21 03:42:11.456388',57,1,1),(46,'2024-01-21 04:08:07.181461',59,1,1),(65,'2024-01-21 04:08:07.181461',63,1,16),(66,'2024-01-21 04:08:07.181461',63,17,16),(67,'2024-01-21 04:08:07.181461',63,18,16),(68,'2024-01-21 04:08:07.181461',63,19,16),(69,'2024-01-21 04:08:07.181461',63,20,16),(70,'2024-01-21 04:08:07.181461',63,21,16),(71,'2024-01-21 04:08:07.181461',63,22,16),(72,'2024-01-21 04:08:07.181461',63,23,16),(73,'2024-01-21 04:08:07.181461',63,24,16),(74,'2024-01-21 04:08:07.181461',63,25,16),(75,'2024-01-21 04:08:07.181461',63,26,16),(76,'2024-01-21 04:08:07.181461',63,27,16),(77,'2024-01-21 04:08:07.181461',63,28,16),(78,'2024-01-21 04:08:07.181461',64,1,17),(79,'2024-01-21 04:08:07.181461',64,16,17),(80,'2024-01-21 04:08:07.181461',64,18,17),(81,'2024-01-21 04:08:07.181461',64,19,17),(82,'2024-01-21 04:08:07.181461',64,20,17),(83,'2024-01-21 04:08:07.181461',64,21,17),(84,'2024-01-21 04:08:07.181461',64,22,17),(85,'2024-01-21 04:08:07.181461',64,23,17),(86,'2024-01-21 04:08:07.181461',64,24,17),(87,'2024-01-21 04:08:07.181461',65,21,18),(88,'2024-01-21 04:08:07.181461',65,22,18),(89,'2024-01-21 04:08:07.181461',65,23,18),(90,'2024-01-21 04:08:07.181461',66,24,19),(91,'2024-01-21 04:08:07.181461',66,22,19),(92,'2024-01-21 04:08:07.181461',66,21,19),(93,'2024-01-21 04:08:07.181461',66,20,19),(103,'2024-01-26 16:19:34.973369',70,1,19),(104,'2024-01-26 16:19:36.237712',69,1,20),(107,'2024-01-26 16:20:08.863571',61,1,1);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_group`
--

DROP TABLE IF EXISTS `location_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `travel_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `specific_address` varchar(255) DEFAULT NULL,
  `specific_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcfwnh48xwt8fb09ssnngqxenn` (`travel_id`),
  CONSTRAINT `FKcfwnh48xwt8fb09ssnngqxenn` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_group`
--

LOCK TABLES `location_group` WRITE;
/*!40000 ALTER TABLE `location_group` DISABLE KEYS */;
INSERT INTO `location_group` VALUES (66,'2024-01-19 05:37:54.235310','제주특별자치도 제주시 해안동 896','2023-07-18 03:00:35.000000','','2023-07-18 03:00:31.000000',46,'제주도',33.465,126.46,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(67,'2024-01-19 05:37:54.287744','경상북도 청송군 주왕산면 859','2023-08-05 04:01:01.000000','','2023-08-05 04:00:50.000000',46,'청송',36.3768,129.11,NULL,NULL),(68,'2024-01-19 16:56:54.317836','경기도 성남시 분당구 정자동 112','2023-12-31 09:40:25.000000','집집','2023-12-31 09:23:21.000000',47,'집집 만두',37.3658,127.117,NULL,NULL),(69,'2024-01-19 16:56:54.355459','경기도 성남시 분당구 분당동 34','2024-01-19 00:23:45.000000','집','2024-01-19 00:23:45.000000',47,'집집 공부',37.3738,127.13,NULL,NULL),(70,'2024-01-20 08:11:59.109393','경상북도 청송군 주왕산면 859','2023-08-05 04:01:01.000000','','2023-08-05 04:00:50.000000',48,'청송',36.3768,129.11,NULL,NULL),(71,'2024-01-20 14:42:38.043818','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:40.000000',49,'',33.44,126.349,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(72,'2024-01-20 14:47:15.379047','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:38.000000','안달루시아','2023-08-25 00:22:38.000000',50,'안달루시어',33.44,126.349,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(73,'2024-01-20 14:50:05.435628','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:38.000000','안달루시아','2023-08-25 00:22:17.000000',51,'달달루시어',33.44,126.349,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(74,'2024-01-20 14:51:52.375180','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:40.000000',52,'안달',33.44,126.349,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(75,'2024-01-20 14:53:13.271878','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:40.000000',53,'안달루시시아',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(76,'2024-01-20 14:55:04.452623','경기도 성남시 분당구 정자동 112','2023-12-31 09:40:25.000000','한솔마을 주공 5단지','2023-12-31 09:23:21.000000',54,'만듀',37.3658,127.117,'경기도 성남시 분당구 정자동','한솔마을주공5단지아파트상가입구'),(77,'2024-01-20 14:55:04.487139','경기도 성남시 분당구 분당동 34','2024-01-09 03:16:53.000000','샛별마을 라이프아파트','2024-01-08 04:26:08.000000',54,'공부 ㅠ',37.3744,127.13,'경기도 성남시 분당구 분당동','샛별마을라이프아파트정문'),(78,'2024-01-20 14:58:20.016663','경상북도 청송군 주왕산면 859','2023-08-05 04:01:01.000000','청송 소노벨','2023-08-05 04:00:50.000000',56,'청송 소노벨',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(79,'2024-01-20 15:16:14.187826','경기도 성남시 분당구 분당동 34','2024-01-19 00:23:45.000000','샛별마을 라이프아파트','2024-01-19 00:23:45.000000',57,'공부즁',37.3738,127.13,'경기도 성남시 분당구 분당동','샛별마을라이프아파트입구'),(80,'2024-01-20 15:21:47.633836','경기도 성남시 분당구 정자동 112','2023-12-31 09:23:21.000000','한솔마을 주공 5단지','2023-12-31 09:23:21.000000',58,'만두 조아',37.3658,127.117,'경기도 성남시 분당구 정자동 112-1','한솔마을주공5단지아파트상가'),(81,'2024-01-21 03:43:45.564903','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:23:04.000000','안달루시아','2023-08-25 00:23:04.000000',59,'안달',33.4401,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(82,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',60,'안달루시시아',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(83,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',61,'만듀',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(84,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',63,'공부 ㅠ',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(85,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',63,'청송 소노벨',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(86,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',64,'공부즁',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(87,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',64,'만두 조아',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(88,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',65,'안달',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(89,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',65,'안달루시시아',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(90,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',66,'만듀',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(91,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',66,'공부 ㅠ',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(92,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',67,'청송 소노벨',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(93,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',67,'공부즁',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(94,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',68,'만두 조아',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(95,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',68,'안달',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(96,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',69,'안달루시시아',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(97,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',69,'만듀',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(98,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',70,'공부 ㅠ',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(99,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',70,'청송 소노벨',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아'),(100,'2024-01-21 04:16:37.900354','경상북도 청송군 주왕산면 859','2023-08-05 04:00:58.000000','소노벨 청송','2023-08-05 04:00:58.000000',71,'공부즁',36.3768,129.11,'경상북도 청송군 주왕산면 하의리 859','소노벨 청송'),(101,'2024-01-21 04:46:05.916571','제주특별자치도 제주시 애월읍 1480','2023-08-25 00:22:40.000000','안달루시아','2023-08-25 00:22:38.000000',71,'만두 조아',33.44,126.349,'제주특별자치도 제주시 애월읍 상가리 1480','제주 안달루시아');
/*!40000 ALTER TABLE `location_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_group_pictures`
--

DROP TABLE IF EXISTS `location_group_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_group_pictures` (
  `location_group_id` bigint NOT NULL,
  `pictures_id` bigint NOT NULL,
  UNIQUE KEY `UK_m514e1nhy9x189p3jo1b4mxjr` (`pictures_id`),
  KEY `FKtd7ev2onftgdwkqmb8dqux3ml` (`location_group_id`),
  CONSTRAINT `FK5tnpif3bjb39gy3kkxj3twuvg` FOREIGN KEY (`pictures_id`) REFERENCES `picture` (`id`),
  CONSTRAINT `FKtd7ev2onftgdwkqmb8dqux3ml` FOREIGN KEY (`location_group_id`) REFERENCES `location_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_group_pictures`
--

LOCK TABLES `location_group_pictures` WRITE;
/*!40000 ALTER TABLE `location_group_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_group_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `location_group_id` bigint DEFAULT NULL,
  `mime` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdyq8ep8iykrhqqosa90cktbrw` (`location_group_id`),
  KEY `FKfa3htlps9ddix2jx1spmpedko` (`user_id`),
  CONSTRAINT `FKdyq8ep8iykrhqqosa90cktbrw` FOREIGN KEY (`location_group_id`) REFERENCES `location_group` (`id`),
  CONSTRAINT `FKfa3htlps9ddix2jx1spmpedko` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (163,'2024-01-19 05:37:54.237011','2023-07-18 03:00:33.000000','bccbc65e-7a66-4d99-be4a-78f8370dbd6c','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/bccbc65e-7a66-4d99-be4a-78f8370dbd6c',66,'image/jpeg',1),(164,'2024-01-19 05:37:54.238198','2023-07-18 03:00:31.000000','9b2fe33e-e438-4204-b950-c6cb30b11037','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/9b2fe33e-e438-4204-b950-c6cb30b11037',66,'image/jpeg',1),(165,'2024-01-19 05:37:54.239172','2023-07-18 03:00:35.000000','6369d678-6e02-4128-b932-8f82e1d7f700','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/6369d678-6e02-4128-b932-8f82e1d7f700',66,'image/jpeg',1),(166,'2024-01-19 05:37:54.289874','2023-08-05 04:00:50.000000','ae96c6f4-d8e7-443b-a574-e06ebb60bca4','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/ae96c6f4-d8e7-443b-a574-e06ebb60bca4',67,'image/jpeg',1),(167,'2024-01-19 05:37:54.291013','2023-08-05 04:00:58.000000','9bad23a2-1785-4dea-b562-086887282a52','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/9bad23a2-1785-4dea-b562-086887282a52',67,'image/jpeg',1),(168,'2024-01-19 05:37:54.292033','2023-08-05 04:01:01.000000','1496e026-5983-4127-aa8e-203abdefd07b','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/1496e026-5983-4127-aa8e-203abdefd07b',67,'image/jpeg',1),(169,'2024-01-19 16:56:54.322508','2023-12-31 09:23:21.000000','afd213ba-de2c-41e6-8ddf-ec79d7260a7b','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/afd213ba-de2c-41e6-8ddf-ec79d7260a7b',68,'image/jpeg',1),(170,'2024-01-19 16:56:54.324950','2023-12-31 09:40:25.000000','b052fe49-6872-4b0d-af3e-fbfc073bb77d','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/b052fe49-6872-4b0d-af3e-fbfc073bb77d',68,'image/jpeg',1),(171,'2024-01-19 16:56:54.356954','2024-01-19 00:23:45.000000','95ffe4bb-e260-485d-95b4-f9d0485536bc','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/95ffe4bb-e260-485d-95b4-f9d0485536bc',69,'image/jpeg',1),(172,'2024-01-20 08:11:59.114769','2023-08-05 04:00:50.000000','72cf93fa-ca01-4246-a90d-e9206ac9bb31','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/72cf93fa-ca01-4246-a90d-e9206ac9bb31',70,'image/jpeg',1),(173,'2024-01-20 08:11:59.117817','2023-08-05 04:00:58.000000','f40ebe41-2d9c-46d7-a147-eb853f3ea55b','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/f40ebe41-2d9c-46d7-a147-eb853f3ea55b',70,'image/jpeg',1),(174,'2024-01-20 08:11:59.118709','2023-08-05 04:01:01.000000','b6daae15-c18a-46ad-9580-1420d4d06b74','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/b6daae15-c18a-46ad-9580-1420d4d06b74',70,'image/jpeg',1),(175,'2024-01-20 14:42:38.048564','2023-08-25 00:22:40.000000','6e2cb63d-6cfb-4f0a-9a96-7a6f76fc84f0','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/6e2cb63d-6cfb-4f0a-9a96-7a6f76fc84f0',71,'image/jpeg',1),(176,'2024-01-20 14:47:15.382942','2023-08-25 00:22:38.000000','0718b68e-00a8-4fad-9cec-2448e0cdb7d5','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/0718b68e-00a8-4fad-9cec-2448e0cdb7d5',72,'image/jpeg',1),(177,'2024-01-20 14:50:05.437288','2023-08-25 00:22:17.000000','394c70ad-00ba-4877-a720-d165b675a6a9','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/394c70ad-00ba-4877-a720-d165b675a6a9',73,'image/jpeg',1),(178,'2024-01-20 14:50:05.438254','2023-08-25 00:22:21.000000','80febcd0-484c-4b9f-8288-585a12097739','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/80febcd0-484c-4b9f-8288-585a12097739',73,'image/jpeg',1),(179,'2024-01-20 14:50:05.439647','2023-08-25 00:22:23.000000','fa60aacc-afab-45f8-8871-7a17c2d8091c','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/fa60aacc-afab-45f8-8871-7a17c2d8091c',73,'image/jpeg',1),(180,'2024-01-20 14:50:05.440537','2023-08-25 00:22:38.000000','e50b414c-e795-4adc-8979-7d4cfe6b57ae','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/e50b414c-e795-4adc-8979-7d4cfe6b57ae',73,'image/jpeg',1),(181,'2024-01-20 14:51:52.379442','2023-08-25 00:22:40.000000','d4900bae-d8e9-4b1a-bf30-a38de13b3d6d','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/d4900bae-d8e9-4b1a-bf30-a38de13b3d6d',74,'image/jpeg',1),(182,'2024-01-20 14:53:13.276089','2023-08-25 00:22:40.000000','c9f8e92e-c9c5-4e32-bf9c-f4fd7a07f828','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/c9f8e92e-c9c5-4e32-bf9c-f4fd7a07f828',75,'image/jpeg',1),(183,'2024-01-20 14:55:04.454186','2023-12-31 09:23:21.000000','083e85e5-44f3-406f-9a74-142f59404072','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/083e85e5-44f3-406f-9a74-142f59404072',76,'image/jpeg',1),(184,'2024-01-20 14:55:04.455193','2023-12-31 09:40:25.000000','ad967695-07c9-470f-8bf6-092f9160b7be','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/ad967695-07c9-470f-8bf6-092f9160b7be',76,'image/jpeg',1),(185,'2024-01-20 14:55:04.488836','2024-01-08 04:26:08.000000','de077272-13a5-442a-9fb1-42542c78d7fe','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/de077272-13a5-442a-9fb1-42542c78d7fe',77,'image/jpeg',1),(186,'2024-01-20 14:55:04.490065','2024-01-09 03:16:53.000000','074b14f8-32b8-4619-bc74-c6f206caf325','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/074b14f8-32b8-4619-bc74-c6f206caf325',77,'image/jpeg',1),(187,'2024-01-20 14:58:20.018005','2023-08-05 04:00:50.000000','587d6f89-f303-44e7-a0ec-efbaca876fce','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/587d6f89-f303-44e7-a0ec-efbaca876fce',78,'image/jpeg',1),(188,'2024-01-20 14:58:20.018939','2023-08-05 04:00:58.000000','2282949d-cd18-4849-99a0-057cc8fbec05','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/2282949d-cd18-4849-99a0-057cc8fbec05',78,'image/jpeg',1),(189,'2024-01-20 14:58:20.019783','2023-08-05 04:01:01.000000','2086b0e6-2fa1-42c4-a320-10b4d997be17','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/2086b0e6-2fa1-42c4-a320-10b4d997be17',78,'image/jpeg',1),(190,'2024-01-20 15:16:14.190262','2024-01-19 00:23:45.000000','acdd0810-b711-471d-ba5d-284bd236a755','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/acdd0810-b711-471d-ba5d-284bd236a755',79,'image/jpeg',1),(191,'2024-01-20 15:21:47.635915','2023-12-31 09:23:21.000000','329fb900-32f8-4e4c-87ae-42dab06c4cdc','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/329fb900-32f8-4e4c-87ae-42dab06c4cdc',80,'image/jpeg',1),(192,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',81,'image/jpeg',1),(193,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',82,'image/jpeg',1),(194,'2024-01-21 04:46:05.919292','2023-08-25 00:22:38.000000','2de63e3c-88f1-45a9-b024-b8254fb0a593','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/2de63e3c-88f1-45a9-b024-b8254fb0a593',83,'image/jpeg',1),(195,'2024-01-21 04:46:05.920591','2023-08-25 00:22:40.000000','04c7a6d6-c5b9-44c7-945d-e5d621553f58','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/04c7a6d6-c5b9-44c7-945d-e5d621553f58',83,'image/jpeg',1),(215,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',84,'image/jpeg',16),(216,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',85,'image/jpeg',16),(217,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',86,'image/jpeg',17),(218,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',87,'image/jpeg',17),(219,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',88,'image/jpeg',18),(220,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',89,'image/jpeg',18),(221,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',90,'image/jpeg',19),(222,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',91,'image/jpeg',19),(223,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',92,'image/jpeg',20),(224,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',93,'image/jpeg',20),(225,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',94,'image/jpeg',21),(226,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',95,'image/jpeg',21),(227,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',96,'image/jpeg',20),(228,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',97,'image/jpeg',20),(229,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',98,'image/jpeg',19),(230,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',99,'image/jpeg',19),(231,'2024-01-21 03:43:45.569154','2023-08-25 00:23:04.000000','a058d17b-0471-4846-9b94-843446613f4a','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',100,'image/jpeg',18),(232,'2024-01-21 04:16:37.905100','2023-08-05 04:00:58.000000','a093e78b-c356-4547-b495-9f6118442056','https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',101,'image/jpeg',18);
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_history`
--

DROP TABLE IF EXISTS `search_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `search_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5pug3072mbsc7bwdt1mrtbl6` (`user_id`),
  CONSTRAINT `FKp5pug3072mbsc7bwdt1mrtbl6` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_history`
--

LOCK TABLES `search_history` WRITE;
/*!40000 ALTER TABLE `search_history` DISABLE KEYS */;
INSERT INTO `search_history` VALUES (27,'2024-01-26 16:58:48.958960','청송',1),(28,'2024-01-26 17:01:16.961051','청송',1),(29,'2024-01-26 17:01:22.378055','청송',1),(30,'2024-01-26 17:01:34.865924','청송',1),(31,'2024-01-26 17:01:37.092376','청송',1);
/*!40000 ALTER TABLE `search_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specific_location`
--

DROP TABLE IF EXISTS `specific_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specific_location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specific_location`
--

LOCK TABLES `specific_location` WRITE;
/*!40000 ALTER TABLE `specific_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `specific_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'2024-01-21 04:16:37.855208','청송'),(2,'2024-01-20 14:47:15.344917','안달루시아'),(3,'2024-01-19 05:37:54.180682','여행');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `destination_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3g5y4v2l8pvwecaxxoqc9khi3` (`user_id`),
  KEY `FK9863vly7gymh0xkbrfftssx5j` (`destination_id`),
  CONSTRAINT `FK3g5y4v2l8pvwecaxxoqc9khi3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK9863vly7gymh0xkbrfftssx5j` FOREIGN KEY (`destination_id`) REFERENCES `destination` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (46,'2024-01-19 05:37:54.176709','여행 조아2',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/bccbc65e-7a66-4d99-be4a-78f8370dbd6c',3),(47,'2024-01-19 16:56:54.252642','집집집',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/afd213ba-de2c-41e6-8ddf-ec79d7260a7b',1),(48,'2024-01-20 08:11:59.039883','여기가 창송',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/72cf93fa-ca01-4246-a90d-e9206ac9bb31',2),(49,'2024-01-20 14:42:37.998774','안달루시아 조아',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/6e2cb63d-6cfb-4f0a-9a96-7a6f76fc84f0',3),(50,'2024-01-20 14:47:15.341277','안달루시라 조쿠나',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/0718b68e-00a8-4fad-9cec-2448e0cdb7d5',3),(51,'2024-01-20 14:50:05.386875','안달루시아 랍니다',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/80febcd0-484c-4b9f-8288-585a12097739',3),(52,'2024-01-20 14:51:52.313193','안달루시아',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/d4900bae-d8e9-4b1a-bf30-a38de13b3d6d',3),(53,'2024-01-20 14:53:13.214463','안달달루시시아',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/c9f8e92e-c9c5-4e32-bf9c-f4fd7a07f828',3),(54,'2024-01-20 14:55:04.410106','만두',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/083e85e5-44f3-406f-9a74-142f59404072',1),(55,'2024-01-20 14:57:04.561159','없는 위치래요',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/7690f332-dc93-4dbf-aec5-cc65f748833b',3),(56,'2024-01-20 14:58:19.986854','좋앗자',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/587d6f89-f303-44e7-a0ec-efbaca876fce',2),(57,'2024-01-20 15:16:14.146891','헬로',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/acdd0810-b711-471d-ba5d-284bd236a755',4),(58,'2024-01-20 15:21:47.596424','ㅋㅋㅋ',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/329fb900-32f8-4e4c-87ae-42dab06c4cdc',4),(59,'2024-01-21 03:43:45.518918','ㅎㅎ',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a058d17b-0471-4846-9b94-843446613f4a',3),(60,'2024-01-21 04:16:37.851629','청송 소노벨',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(61,'2024-01-21 04:46:05.861725','1',1,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/2de63e3c-88f1-45a9-b024-b8254fb0a593',3),(63,'2024-01-21 04:16:37.851629','청송 소노벨',16,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(64,'2024-01-21 04:16:37.851629','청송 소노벨',17,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(65,'2024-01-21 04:16:37.851629','청송 소노벨',18,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(66,'2024-01-21 04:16:37.851629','청송 소노벨',19,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(67,'2024-01-21 04:16:37.851629','청송 소노벨',20,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(68,'2024-01-21 04:16:37.851629','청송 소노벨',21,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(69,'2024-01-21 04:16:37.851629','청송 소노벨',20,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(70,'2024-01-21 04:16:37.851629','청송 소노벨',19,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2),(71,'2024-01-21 04:16:37.851629','청송 소노벨',18,'https://s3.ap-northeast-2.amazonaws.com/travellery/pictures/a093e78b-c356-4547-b495-9f6118442056',2);
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_tag`
--

DROP TABLE IF EXISTS `travel_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_tag` (
  `travel_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  KEY `FK4bvxug8d6i8xuo2gqgb0bwu2h` (`tag_id`),
  KEY `FKe52cbf15huw7axb55aiyjbebv` (`travel_id`),
  CONSTRAINT `FK4bvxug8d6i8xuo2gqgb0bwu2h` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `FKe52cbf15huw7axb55aiyjbebv` FOREIGN KEY (`travel_id`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_tag`
--

LOCK TABLES `travel_tag` WRITE;
/*!40000 ALTER TABLE `travel_tag` DISABLE KEYS */;
INSERT INTO `travel_tag` VALUES (46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(51,2),(52,2),(53,2),(54,2),(55,2),(56,2),(57,2),(58,2),(59,2),(60,2),(61,2),(59,3),(60,3),(61,3),(63,2),(64,3),(65,2),(66,3),(67,2),(68,3),(69,2),(70,3),(71,2);
/*!40000 ALTER TABLE `travel_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '\0',_binary '\0',_binary '\0',_binary '\0',1,'nbw970508@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','EnvyW6567','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',14,'test001@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','nbw6567','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',15,'test002@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','곽튜브','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',16,'test003@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','보라보라','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',17,'test004@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','제이','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',18,'test005@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','빠니보틀','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',19,'test006@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','하이하이','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',20,'test007@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','바이바이','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',21,'test008@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','헬로헬로','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',22,'test009@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','젤리','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',23,'test010@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','펭키','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',24,'test011@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','Kico','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',25,'test012@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','costa','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',26,'test013@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','안녕로봇','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',27,'test014@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','젤라틴','  새로운 설명'),(_binary '\0',_binary '\0',_binary '\0',_binary '\0',28,'test015@gmail.com',NULL,'https://weekly.hankooki.com/news/photo/202308/7080350_179562_132.jpg','귤귤','  새로운 설명');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authorities`
--

DROP TABLE IF EXISTS `user_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authorities` (
  `authorities_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`authorities_id`,`user_id`),
  UNIQUE KEY `UK_srwncm1s09dkj57s4jjqni9ou` (`authorities_id`),
  KEY `FKmj13d0mnuj4cd8b6htotbf9mm` (`user_id`),
  CONSTRAINT `FKdd8lhvujos470g40gikxj22mb` FOREIGN KEY (`authorities_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKmj13d0mnuj4cd8b6htotbf9mm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authorities`
--

LOCK TABLES `user_authorities` WRITE;
/*!40000 ALTER TABLE `user_authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_authorities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-27 16:58:57
