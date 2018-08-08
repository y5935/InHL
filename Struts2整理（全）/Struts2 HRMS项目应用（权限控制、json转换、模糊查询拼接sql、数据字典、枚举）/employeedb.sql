/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : employeedb

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2018-08-07 17:14:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `biz_emp_base`
-- ----------------------------
DROP TABLE IF EXISTS `biz_emp_base`;
CREATE TABLE `biz_emp_base` (
  `EmpId` int(11) NOT NULL AUTO_INCREMENT,
  `EmpName` varchar(20) NOT NULL,
  `Gender` bit(1) NOT NULL,
  `BirthDay` date NOT NULL,
  `DeptId` int(11) NOT NULL,
  `PositionId` int(11) NOT NULL,
  `Education` int(11) NOT NULL,
  `Degree` int(11) NOT NULL,
  `State` int(11) NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_emp_base
-- ----------------------------
INSERT INTO `biz_emp_base` VALUES ('1', 'Mike', '', '2018-08-07', '18', '16', '6', '9', '12');

-- ----------------------------
-- Table structure for `sys_dic`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic` (
  `DicId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) NOT NULL,
  `Sort` int(11) NOT NULL,
  `State` int(11) NOT NULL,
  PRIMARY KEY (`DicId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dic
-- ----------------------------
INSERT INTO `sys_dic` VALUES ('1', '小学', '1', '1');
INSERT INTO `sys_dic` VALUES ('2', '初中', '1', '1');
INSERT INTO `sys_dic` VALUES ('3', '高中', '1', '1');
INSERT INTO `sys_dic` VALUES ('4', '中专', '1', '1');
INSERT INTO `sys_dic` VALUES ('5', '大专', '1', '1');
INSERT INTO `sys_dic` VALUES ('6', '本科', '1', '1');
INSERT INTO `sys_dic` VALUES ('7', '硕士研究生', '1', '1');
INSERT INTO `sys_dic` VALUES ('8', '博士研究生', '1', '1');
INSERT INTO `sys_dic` VALUES ('9', '学士', '2', '1');
INSERT INTO `sys_dic` VALUES ('10', '硕士', '2', '1');
INSERT INTO `sys_dic` VALUES ('11', '博士', '2', '1');
INSERT INTO `sys_dic` VALUES ('12', '在职', '3', '1');
INSERT INTO `sys_dic` VALUES ('13', '离职', '3', '1');
INSERT INTO `sys_dic` VALUES ('14', '退休', '3', '1');
INSERT INTO `sys_dic` VALUES ('15', '员工', '4', '1');
INSERT INTO `sys_dic` VALUES ('16', '部门经理', '4', '1');
INSERT INTO `sys_dic` VALUES ('17', '总监', '4', '1');
INSERT INTO `sys_dic` VALUES ('18', '人事部', '5', '1');
INSERT INTO `sys_dic` VALUES ('19', '培训部', '5', '1');
INSERT INTO `sys_dic` VALUES ('20', 'It运维部', '5', '1');
INSERT INTO `sys_dic` VALUES ('21', '财务部', '5', '1');
INSERT INTO `sys_dic` VALUES ('22', '法务部', '5', '1');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `ResId` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) NOT NULL,
  `URL` varchar(50) DEFAULT NULL,
  `Icon` varchar(50) DEFAULT NULL,
  `ParentId` int(11) NOT NULL,
  `Roles` varchar(100) NOT NULL DEFAULT '*',
  `State` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ResId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统设置', null, 'images/coinL1.png', '0', '1/2', '1');
INSERT INTO `sys_resource` VALUES ('2', '用户信息管理', null, null, '1', '1', '1');
INSERT INTO `sys_resource` VALUES ('3', '角色信息管理', null, null, '1', '1', '1');
INSERT INTO `sys_resource` VALUES ('4', '用户角色管理', null, null, '1', '1', '1');
INSERT INTO `sys_resource` VALUES ('5', '友情链接', null, null, '1', '2', '1');
INSERT INTO `sys_resource` VALUES ('6', '人员档案管理', null, 'images/coin07.png', '0', '3/4/5', '1');
INSERT INTO `sys_resource` VALUES ('7', '员工基本信息管理', 'view/emp/list.jsp', null, '6', '3', '1');
INSERT INTO `sys_resource` VALUES ('8', '员工档案管理', null, null, '6', '4', '1');
INSERT INTO `sys_resource` VALUES ('9', '员工履历管理', null, null, '6', '4', '1');
INSERT INTO `sys_resource` VALUES ('10', '员工合同管理', null, null, '6', '4', '1');
INSERT INTO `sys_resource` VALUES ('11', '员工基本信息查询', null, null, '6', '3/4/5', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(50) NOT NULL,
  `State` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '1');
INSERT INTO `sys_role` VALUES ('2', '管理员', '1');
INSERT INTO `sys_role` VALUES ('3', '招聘专员', '1');
INSERT INTO `sys_role` VALUES ('4', '人事管理员', '1');
INSERT INTO `sys_role` VALUES ('5', '人事主管', '1');
INSERT INTO `sys_role` VALUES ('6', '培训专员', '1');
INSERT INTO `sys_role` VALUES ('7', '培训主管', '1');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '1', '2');
INSERT INTO `sys_user_role` VALUES ('3', '2', '3');
INSERT INTO `sys_user_role` VALUES ('4', '2', '4');
INSERT INTO `sys_user_role` VALUES ('5', '2', '5');

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `Account` varchar(20) NOT NULL,
  `Pwd` varchar(20) NOT NULL,
  `State` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '王兆东', 'ZhaoDong', '123', '1');
INSERT INTO `sys_users` VALUES ('2', '黄旭志', 'XuZhi', '123', '1');
