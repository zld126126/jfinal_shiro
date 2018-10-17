/*
Navicat MySQL Data Transfer

Source Server         : mysql3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : jfinal_shiro

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-10-17 16:06:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sec_auths
-- ----------------------------
DROP TABLE IF EXISTS `sec_auths`;
CREATE TABLE `sec_auths` (
  `ID` int(11) NOT NULL,
  `AUTHNAME` varchar(255) DEFAULT NULL,
  `AUTHDESC` varchar(255) DEFAULT NULL,
  `AUTHURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_auths
-- ----------------------------
INSERT INTO `sec_auths` VALUES ('1', 'searchUser', '查询用户', '/user');
INSERT INTO `sec_auths` VALUES ('2', 'addUser', '增加用户', '/user/add');
INSERT INTO `sec_auths` VALUES ('3', 'edtiUser', '编辑用户', '/user/update');
INSERT INTO `sec_auths` VALUES ('4', 'deleteUser', '删除用户', '/user/delete');

-- ----------------------------
-- Table structure for sec_roles
-- ----------------------------
DROP TABLE IF EXISTS `sec_roles`;
CREATE TABLE `sec_roles` (
  `ID` int(11) NOT NULL,
  `ROLENAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_roles
-- ----------------------------
INSERT INTO `sec_roles` VALUES ('1', 'normal');
INSERT INTO `sec_roles` VALUES ('2', 'system');

-- ----------------------------
-- Table structure for sec_roles_auths
-- ----------------------------
DROP TABLE IF EXISTS `sec_roles_auths`;
CREATE TABLE `sec_roles_auths` (
  `ID` int(11) NOT NULL,
  `ROLEID` int(11) DEFAULT NULL,
  `AUTHID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_roles_auths
-- ----------------------------
INSERT INTO `sec_roles_auths` VALUES ('1', '1', '1');
INSERT INTO `sec_roles_auths` VALUES ('2', '2', '1');
INSERT INTO `sec_roles_auths` VALUES ('3', '2', '2');
INSERT INTO `sec_roles_auths` VALUES ('4', '2', '3');
INSERT INTO `sec_roles_auths` VALUES ('5', '2', '4');

-- ----------------------------
-- Table structure for sec_roles_users
-- ----------------------------
DROP TABLE IF EXISTS `sec_roles_users`;
CREATE TABLE `sec_roles_users` (
  `ID` int(11) NOT NULL,
  `ROLEID` int(11) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_roles_users
-- ----------------------------
INSERT INTO `sec_roles_users` VALUES ('1', '1', '1');
INSERT INTO `sec_roles_users` VALUES ('2', '1', '2');
INSERT INTO `sec_roles_users` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for sec_users
-- ----------------------------
DROP TABLE IF EXISTS `sec_users`;
CREATE TABLE `sec_users` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sec_users
-- ----------------------------
INSERT INTO `sec_users` VALUES ('1', 'user', 'user');
INSERT INTO `sec_users` VALUES ('2', 'sys', 'sys');
