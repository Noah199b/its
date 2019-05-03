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
-- Table structure for table `sys_menus`
--

DROP TABLE IF EXISTS `sys_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menus`
--

LOCK TABLES `sys_menus` WRITE;
/*!40000 ALTER TABLE `sys_menus` DISABLE KEYS */;
INSERT INTO `sys_menus` VALUES (3,'网站管理','请求路径',1,3,NULL,NULL,'product:list','2017-07-12 15:15:59','2018-04-09 16:42:42','admin','admin'),(8,'系统管理','请求路径',1,8,NULL,NULL,'sys:list','2017-07-12 15:15:59','2017-07-21 11:16:00','admin','admin'),(11,'活动信息','project/listUI.do',1,11,NULL,3,'product:project:view','2017-07-12 15:15:59','2018-04-09 16:43:09','admin','admin'),(24,'系统配置','请求路径',1,24,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(25,'日志管理','请求路径',1,25,NULL,8,NULL,'2017-07-12 15:15:59','2017-07-12 15:15:59','admin','admin'),(45,'用户管理','user/listUI.do',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2017-07-21 17:36:01','admin','admin'),(46,'菜单管理','menu/listUI.do',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2017-07-21 17:36:16','admin','admin'),(47,'角色管理','role/listUI.do',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2017-07-21 17:38:03','admin','admin'),(48,'组织管理','请求路径',1,48,NULL,8,'sys:org:view','2017-07-12 15:15:59','2017-07-21 18:37:57','admin','admin'),(115,'查看','',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2017-07-21 11:09:05',NULL,NULL),(116,'新增','',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2017-07-21 11:09:22',NULL,NULL),(117,'修改','',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2017-07-21 11:09:45',NULL,NULL),(118,'删除','',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2017-07-21 11:10:12',NULL,NULL),(119,'查看','',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2017-07-21 11:12:46',NULL,NULL),(120,'查看','',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2017-07-21 11:13:43',NULL,NULL),(126,'新增','',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2017-07-21 11:11:34',NULL,NULL),(127,'修改','',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2017-07-21 11:11:56',NULL,NULL),(128,'新增','',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2017-07-21 11:14:24',NULL,NULL),(129,'修改','',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2017-07-21 11:14:48',NULL,NULL),(130,'删除','',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2017-07-21 11:15:09',NULL,NULL),(135,'查询','',2,1,NULL,11,'product:project:view','2017-07-21 17:21:40','2017-07-21 17:21:40',NULL,NULL),(136,'新增','',2,2,NULL,11,'product:project:add','2017-07-21 17:22:02','2017-07-21 17:22:02',NULL,NULL),(137,'启用','',2,3,NULL,11,'product:project:valid','2017-07-21 17:22:23','2017-07-21 17:22:23',NULL,NULL),(138,'禁用','',2,4,NULL,11,'product:project:invalid','2017-07-21 17:22:44','2017-07-21 17:22:44',NULL,NULL),(139,'修改','',2,5,NULL,11,'product:project:update','2017-07-21 17:25:20','2017-07-21 17:25:20',NULL,NULL),(140,'公告管理','notice/listUI.do',1,12,NULL,3,'manage:notice:view','2018-04-10 13:15:38','2018-04-10 13:17:26',NULL,NULL),(141,'查询','notice/doFindObjects.do',2,1,NULL,140,'manage:notice:view','2018-04-10 13:18:24','2018-04-10 13:23:56',NULL,NULL),(142,'新增','notice/doSaveObject.do',2,2,NULL,140,'manage:notice:add','2018-04-10 13:23:02','2018-04-10 13:24:04',NULL,NULL);
/*!40000 ALTER TABLE `sys_menus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-03 16:54:18
