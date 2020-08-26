-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: case_study
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (1,1,1,11,'2019-08-20','2020-09-20',700,1250),(2,2,2,12,'2018-08-20','2020-09-20',700,1200),(3,3,3,10,'2019-08-20','2020-09-20',700,1650),(4,4,4,11,'2018-01-20','2020-09-20',700,1300),(5,5,5,5,'2018-08-20','2020-09-20',700,1450),(6,6,6,6,'2019-10-20','2020-09-20',700,1650),(7,7,7,7,'2019-08-20','2020-09-20',700,1600),(8,8,8,8,'2018-02-20','2020-09-20',700,1100),(9,9,9,9,'2019-12-20','2020-09-20',700,1200),(10,10,10,10,'2018-11-20','2020-09-20',700,1350),(11,1,1,11,'2018-05-20','2020-09-20',700,1150),(12,2,2,12,'2017-08-20','2020-09-20',700,1650),(13,3,3,10,'2018-03-20','2020-09-20',700,1500),(14,4,1,11,'2019-01-20','2020-09-20',700,1350),(15,5,2,5,'2019-04-20','2020-09-20',700,1400),(16,6,4,6,'2018-10-20','2020-09-20',700,1200),(17,7,1,7,'2019-03-20','2020-09-20',700,1700),(18,8,4,8,'2016-02-20','2020-09-20',700,1350),(19,9,9,9,'2019-09-20','2020-09-20',700,1500),(20,10,10,10,'2018-07-20','2020-09-20',700,1500);
/*!40000 ALTER TABLE `contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer_classes`
--

LOCK TABLES `customer_classes` WRITE;
/*!40000 ALTER TABLE `customer_classes` DISABLE KEYS */;
INSERT INTO `customer_classes` VALUES (25,'Diamond'),(35,'Gold'),(55,'Member'),(15,'Platinum'),(45,'Silver');
/*!40000 ALTER TABLE `customer_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,15,'David Beckham','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(2,25,'Leonardo Decaprio','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),(3,15,'John Statham','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Tri'),(4,35,'Steven Seagal','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),(5,25,'Jean Claude','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(6,45,'Richard Gere','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),(7,55,'Keanu Reaves','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),(8,15,'Jennife Laurence','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),(9,25,'Juliet Robert','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai'),(10,25,'Donald Trump','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),(11,35,'Richard Branson','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Tri'),(12,45,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(13,55,'Tom Cruise','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),(14,55,'Sylvester Stallone','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(15,15,'James Bond','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),(16,15,'Emma Waston','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Hue'),(17,45,'Owen Wilson','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(18,35,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Da Nang'),(19,25,'Nicolas Cage','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Vinh'),(20,25,'Will Smith','1987-10-19','197 182 504','084 2345 777','customer@gmail.com','Quang Ngai');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `detailed_contracts`
--

LOCK TABLES `detailed_contracts` WRITE;
/*!40000 ALTER TABLE `detailed_contracts` DISABLE KEYS */;
INSERT INTO `detailed_contracts` VALUES (1,5,1,1),(2,4,2,1),(3,6,3,1),(4,3,4,1),(5,1,5,1),(6,2,2,1),(7,8,2,1),(8,9,1,1),(9,10,4,1),(10,11,5,1),(11,12,1,1),(12,13,1,1),(13,14,2,1),(14,15,4,1),(15,16,3,1),(16,17,5,1),(17,18,5,1),(18,19,3,1),(19,20,3,1),(20,7,2,1);
/*!40000 ALTER TABLE `detailed_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `divisions`
--

LOCK TABLES `divisions` WRITE;
/*!40000 ALTER TABLE `divisions` DISABLE KEYS */;
INSERT INTO `divisions` VALUES (202,'Administration'),(404,'Management'),(101,'Sale-Marketing'),(303,'Service');
/*!40000 ALTER TABLE `divisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Chau Kiet Luan',111,11,303,'1990-07-25','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(2,'Ngo Ngan To',222,22,101,'1988-03-22','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(3,'Tu Nhuoc Tuyen',333,33,202,'1994-09-17','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(4,'Kim Thanh Vu',555,44,404,'1997-11-23','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(5,'Ly Lien Kiet',444,33,101,'1988-12-28','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(6,'Luu Duc Hoa',222,22,202,'1982-10-26','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(7,'Quach Phu Thanh',222,33,202,'1993-07-22','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(8,'Le Minh',333,33,202,'1994-11-25','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(9,'Truong Hoc Huu',333,22,202,'1980-10-19','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(10,'Nham Dat Hoa',444,11,404,'1979-04-16','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(11,'Hong Kim Bao',555,33,404,'1973-07-19','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(12,'Truong Ve Kien',666,44,404,'1992-11-29','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(13,'Ly Gia Han',222,22,101,'1985-05-27','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(14,'Co Thien Lac',333,22,202,'1990-12-12','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi'),(15,'Truong Man Ngoc',333,33,202,'1978-03-18','111 222 333 444','20000000','0905 555 999','employee@gmail.com','Ha Noi');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `extra_services`
--

LOCK TABLES `extra_services` WRITE;
/*!40000 ALTER TABLE `extra_services` DISABLE KEYS */;
INSERT INTO `extra_services` VALUES (1,'Karaoke',150,1,'available'),(2,'Massage',150,1,'available'),(3,'Food',150,1,'available'),(4,'Drink',150,1,'available'),(5,'Car',150,1,'available');
/*!40000 ALTER TABLE `extra_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `levels`
--

LOCK TABLES `levels` WRITE;
/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` VALUES (44,'After-university'),(22,'College'),(11,'Pre-college'),(33,'University');
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (666,'Director'),(555,'Manager'),(111,'Receptionist'),(333,'Staff'),(444,'Supervisor'),(222,'Waiter');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rent_types`
--

LOCK TABLES `rent_types` WRITE;
/*!40000 ALTER TABLE `rent_types` DISABLE KEYS */;
INSERT INTO `rent_types` VALUES (171,'Hourly',1500),(272,'Daily',1500),(373,'Monthly',1500),(474,'Yearly',1500);
/*!40000 ALTER TABLE `rent_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service_types`
--

LOCK TABLES `service_types` WRITE;
/*!40000 ALTER TABLE `service_types` DISABLE KEYS */;
INSERT INTO `service_types` VALUES (200,'House'),(300,'Room'),(100,'Villa');
/*!40000 ALTER TABLE `service_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'King',50,2,'4','10000',272,100,'available'),(2,'Queen',50,2,'4','10000',272,100,'available'),(3,'Prince',50,2,'4','10000',373,100,'available'),(4,'Princess',50,2,'4','10000',474,100,'available'),(5,'Panther',50,2,'4','10000',373,200,'available'),(6,'Lion',50,2,'4','10000',373,200,'available'),(7,'Leopard',50,2,'4','10000',474,200,'available'),(8,'Tiger',50,2,'4','10000',272,200,'available'),(9,'Ant',50,2,'4','10000',171,300,'available'),(10,'Mosquito',50,2,'4','10000',171,300,'available'),(11,'Firefly',50,2,'4','10000',171,300,'available'),(12,'Mantis',50,2,'4','10000',171,300,'available');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-26  8:19:52
