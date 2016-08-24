/*
Navicat MySQL Data Transfer

Source Server         : mysql_localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : erp-1

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-18 20:51:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTMENTNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事部');
INSERT INTO `department` VALUES ('2', '技术部');
INSERT INTO `department` VALUES ('3', '宣传部');
INSERT INTO `department` VALUES ('4', '策划部');
INSERT INTO `department` VALUES ('5', '运营部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `BIRTH` datetime DEFAULT NULL,
  `DEPARTMENT` int(11) DEFAULT NULL,
  `CONTACT` varchar(255) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ftc933bcsnkmq6vfufy92j6ro` (`DEPARTMENT`),
  CONSTRAINT `FK_ftc933bcsnkmq6vfufy92j6ro` FOREIGN KEY (`DEPARTMENT`) REFERENCES `department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=473 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('375', 'we', '男', 'eee', '2015-11-11 12:27:26', '4', 'eee', '2015-11-05 13:55:50');
INSERT INTO `employee` VALUES ('389', '1212', '男', '2121', '2015-11-19 12:27:35', '2', '12121', '2015-11-05 14:36:59');
INSERT INTO `employee` VALUES ('391', '1212', '男', '2121', '2015-11-20 12:27:37', '5', '12121', '2015-11-05 14:37:08');
INSERT INTO `employee` VALUES ('392', '1212', '女', '2121', '2015-11-12 00:00:00', '3', '12121', '2016-05-18 10:48:36');
INSERT INTO `employee` VALUES ('393', '1212', '女', '2121', '2015-11-27 12:27:42', '1', '12121', '2015-11-05 14:37:08');
INSERT INTO `employee` VALUES ('394', '1212', '男', '2121', '2015-11-11 00:00:00', '2', '12121', '2016-05-17 17:05:07');
INSERT INTO `employee` VALUES ('395', '1212', '男', '2121', '2015-11-20 00:00:00', '3', '12121', '2016-05-18 16:30:56');
INSERT INTO `employee` VALUES ('396', '1212', '男', '2121', '2015-11-20 12:27:28', '2', '12121', '2015-11-05 14:37:12');
INSERT INTO `employee` VALUES ('398', '1212', '男', '2121', '2015-11-12 12:27:33', '5', '12121', '2015-11-05 14:37:12');
INSERT INTO `employee` VALUES ('399', '1212', '男', '2121', '2015-11-20 12:27:37', '3', '12121', '2015-11-05 14:37:13');
INSERT INTO `employee` VALUES ('400', '1212', '男', '2121', '2015-10-27 00:00:00', '2', '12121', '2016-05-18 16:31:05');
INSERT INTO `employee` VALUES ('401', '1212', '男', '2121', '2015-11-27 12:29:08', '2', '12121', '2015-11-05 14:37:13');
INSERT INTO `employee` VALUES ('402', '1212', '男', '2121', '2015-11-19 00:00:00', '4', '12121', '2016-05-17 14:05:30');
INSERT INTO `employee` VALUES ('403', '1212', '男', '2121', '2015-11-26 12:29:15', '3', '12121', '2015-11-05 14:37:16');
INSERT INTO `employee` VALUES ('404', '1212', '女', '2121', '2015-11-13 00:00:00', '1', '12121', '2016-05-18 16:31:12');
INSERT INTO `employee` VALUES ('405', '1212', '女', '2121', '2015-11-04 00:00:00', '2', '12121', '2016-05-18 11:25:27');
INSERT INTO `employee` VALUES ('406', '1212', '男', '2121', '2015-11-11 12:29:53', '2', '12121', '2015-11-05 14:37:17');
INSERT INTO `employee` VALUES ('407', '1212', '女', '2121', '2015-11-13 00:00:00', '4', '12121', '2016-05-18 16:20:44');
INSERT INTO `employee` VALUES ('408', '1212', '男', '2121', '2015-11-05 14:37:17', '2', '12121', '2015-11-05 14:37:17');
INSERT INTO `employee` VALUES ('409', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('410', '1212', '男', '2121', '2015-11-05 14:37:19', '5', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('411', '1212', '男', '2121', '2015-11-05 14:37:19', '3', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('412', '1212', '男', '2121', '2015-11-05 14:37:19', '1', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('413', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('414', '1212', '男', '2121', '2015-11-05 14:37:19', '4', '12121', '2015-11-05 14:37:19');
INSERT INTO `employee` VALUES ('416', '1212', '男', '2121', '2015-11-05 14:37:17', '2', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('417', '1212', '男', '2121', '2015-11-05 14:37:19', '5', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('418', '1212', '男', '2121', '2015-11-05 14:37:19', '3', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('419', '1212', '男', '2121', '2015-11-05 14:37:19', '1', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('420', '1212', '男', '2121', '2015-11-11 12:30:11', '2', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('421', '1212', '男', '2121', '2015-11-05 14:37:17', '2', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('422', '1212', '男', '2121', '2015-11-05 14:37:19', '4', '12121', '2015-11-05 14:37:20');
INSERT INTO `employee` VALUES ('423', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:21');
INSERT INTO `employee` VALUES ('424', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:21');
INSERT INTO `employee` VALUES ('426', '1212', '男', '2121', '2015-11-04 12:30:19', '3', '12121', '2015-11-05 14:37:21');
INSERT INTO `employee` VALUES ('427', '1212', '男', '2121', '2015-11-26 12:30:21', '1', '12121', '2015-11-05 14:37:22');
INSERT INTO `employee` VALUES ('428', '1212', '男', '2121', '2015-11-05 14:37:17', '4', '12121', '2015-11-05 14:37:22');
INSERT INTO `employee` VALUES ('430', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:22');
INSERT INTO `employee` VALUES ('431', '1212', '男', '2121', '2015-11-05 14:37:19', '5', '12121', '2015-11-05 14:37:22');
INSERT INTO `employee` VALUES ('433', '1212', '男', '2121', '2015-11-04 00:00:00', '1', '12121', '2016-05-13 15:30:58');
INSERT INTO `employee` VALUES ('434', '1212', '男', '2121', '2015-11-26 12:30:21', '4', '12121', '2015-11-05 14:37:23');
INSERT INTO `employee` VALUES ('435', '1212', '男', '2121', '2015-11-11 12:30:11', '2', '12121', '2015-11-05 14:37:23');
INSERT INTO `employee` VALUES ('436', '1212', '男', '2121', '2015-11-05 14:37:17', '2', '12121', '2015-11-05 14:37:23');
INSERT INTO `employee` VALUES ('438', '1212大苏打实打实', '男', '2121', '2015-11-05 00:00:00', '2', '12121', '2015-11-19 16:05:21');
INSERT INTO `employee` VALUES ('439', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:23');
INSERT INTO `employee` VALUES ('440', '1212', '男', '2121', '2015-11-05 14:37:19', '5', '12121', '2015-11-05 14:37:23');
INSERT INTO `employee` VALUES ('441', '1212', '男', '2121', '2015-11-04 12:30:19', '3', '12121', '2015-11-05 14:37:24');
INSERT INTO `employee` VALUES ('442', '1212', '男', '2121', '2015-11-26 12:30:21', '1', '12121', '2015-11-05 14:37:24');
INSERT INTO `employee` VALUES ('443', '1212', '男', '2121', '2015-11-05 14:37:17', '4', '12121', '2015-11-05 14:40:01');
INSERT INTO `employee` VALUES ('444', '1212', '男', '2121', '2015-11-05 00:00:00', '2', '12121', '2016-05-17 11:05:02');
INSERT INTO `employee` VALUES ('445', '1212', '男', '2121', '2015-11-05 14:37:19', '2', '12121', '2015-11-05 14:37:24');
INSERT INTO `employee` VALUES ('446', '1212', '男', '2121', '2015-11-11 12:30:11', '2', '12121', '2015-11-05 14:37:24');
INSERT INTO `employee` VALUES ('447', '1212', '男', '2121', '2015-11-05 14:37:17', '2', '12121', '2015-11-05 14:37:24');
INSERT INTO `employee` VALUES ('454', '23', '男', '3232', '2015-11-05 00:00:00', '4', '323', '2016-05-17 14:05:56');
INSERT INTO `employee` VALUES ('455', '2323', '男', '233', '2015-11-05 14:37:19', '2', '232', '2015-11-05 14:39:53');
INSERT INTO `employee` VALUES ('456', '', '男', '23', '2015-11-05 14:37:19', '2', '', '2015-11-05 14:41:22');
INSERT INTO `employee` VALUES ('457', '232', '男', '2323', '2015-11-05 14:37:19', '5', '32323', '2015-11-05 14:41:27');
INSERT INTO `employee` VALUES ('458', '2323', '女', '3232', '2015-11-04 00:00:00', '3', '232', '2016-05-18 16:21:18');
INSERT INTO `employee` VALUES ('459', '232', '男', '2323', '2015-11-26 00:00:00', '1', '3232', '2016-05-17 14:05:43');
INSERT INTO `employee` VALUES ('460', '', '男', '23', '2015-11-05 14:37:17', '4', '', '2015-11-05 14:42:31');
INSERT INTO `employee` VALUES ('461', 'wewe', '男', 'wew', '2015-11-11 12:30:11', '2', 'wew', '2015-11-05 14:42:36');
INSERT INTO `employee` VALUES ('462', 'AA', null, 'BB', '2016-05-16 00:00:00', '5', 'DD', '2016-05-16 20:05:52');
INSERT INTO `employee` VALUES ('463', 'wewe', '男', 'wewe', '2015-11-05 14:37:19', '4', 'wew', '2015-11-05 14:42:43');
INSERT INTO `employee` VALUES ('465', 'AA', 'CC', 'BB', '2016-05-16 00:00:00', '5', 'DD', '2016-05-16 00:00:00');
INSERT INTO `employee` VALUES ('466', 'AA', '男', '', '2016-05-16 00:00:00', '5', 'DD', '2016-05-17 14:05:20');
INSERT INTO `employee` VALUES ('468', 'AA', '男', 'BB', '2016-05-16 00:00:00', '5', 'DD', '2016-05-17 14:05:51');
