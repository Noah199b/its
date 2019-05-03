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
-- Table structure for table `its_teacher_auth`
--

DROP TABLE IF EXISTS `its_teacher_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `its_teacher_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `email` varchar(50) NOT NULL COMMENT '邮箱 ',
  `tel` varchar(11) NOT NULL COMMENT '手机号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `idNo` varchar(19) NOT NULL COMMENT '身份证号',
  `edu` varchar(255) NOT NULL COMMENT '学历',
  `speciality` varchar(255) NOT NULL COMMENT '专业',
  `school` varchar(255) NOT NULL COMMENT '毕业院校',
  `workspace` varchar(255) NOT NULL COMMENT '单位',
  `qq` varchar(15) NOT NULL COMMENT 'QQ',
  `wechat` varchar(50) NOT NULL COMMENT '微信',
  `frontPath` varchar(255) NOT NULL COMMENT '身份证正面',
  `backPath` varchar(255) NOT NULL COMMENT '身份证反面',
  `aidPath1` varchar(255) NOT NULL COMMENT '辅助材料1',
  `aidPath2` varchar(255) DEFAULT NULL COMMENT '辅助材料2',
  `aidPath3` varchar(255) DEFAULT NULL COMMENT '辅助材料3',
  `state` int(1) NOT NULL COMMENT '审核状态0-待审核，1-通过，2-未通过',
  `opinion` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `auditTime` datetime DEFAULT NULL COMMENT '审核时间',
  `auditUser` varchar(50) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `its_teacher_auth`
--

LOCK TABLES `its_teacher_auth` WRITE;
/*!40000 ALTER TABLE `its_teacher_auth` DISABLE KEYS */;
/*!40000 ALTER TABLE `its_teacher_auth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03 16:54:17
