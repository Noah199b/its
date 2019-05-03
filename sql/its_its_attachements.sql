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
-- Table structure for table `its_attachements`
--

DROP TABLE IF EXISTS `its_attachements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `its_attachements` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称 ',
  `contentType` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `filePath` varchar(200) DEFAULT NULL COMMENT '备注',
  `fileDisgest` varchar(200) DEFAULT NULL COMMENT '文件摘要',
  `athType` int(3) DEFAULT NULL COMMENT '附件归属类型',
  `belongId` int(11) DEFAULT NULL COMMENT '归属对象id',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `its_attachements`
--

LOCK TABLES `its_attachements` WRITE;
/*!40000 ALTER TABLE `its_attachements` DISABLE KEYS */;
/*!40000 ALTER TABLE `its_attachements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03 16:54:22
