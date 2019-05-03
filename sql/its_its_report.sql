-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: its
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `its_report`
--

DROP TABLE IF EXISTS `its_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `its_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL COMMENT '举报类型 0-用户 1-话题 2-资源 3-其它',
  `username` varchar(20) DEFAULT NULL COMMENT '被举报用户',
  `link` varchar(500) DEFAULT NULL COMMENT '被举报链接',
  `reportId` int(11) DEFAULT NULL COMMENT '被举报页面ID',
  `reason` varchar(255) NOT NULL COMMENT '举报原因',
  `state` int(1) NOT NULL COMMENT '处理状态 0-待处理 1-已处理',
  `opinion` varchar(255) DEFAULT NULL COMMENT '处理意见',
  `modifyUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifyTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='举报';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `its_report`
--

LOCK TABLES `its_report` WRITE;
/*!40000 ALTER TABLE `its_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `its_report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03 16:54:23
