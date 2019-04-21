/*
Navicat MySQL Data Transfer

Source Server         : MyLocalhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-11-21 20:14:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '0', 'admin', '13623651458', '1');
INSERT INTO `t_admin` VALUES ('2', 'admin03', '0', '123', '13612345678', '2');

-- ----------------------------
-- Table structure for t_bid
-- ----------------------------
DROP TABLE IF EXISTS `t_bid`;
CREATE TABLE `t_bid` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bidMoney` varchar(255) DEFAULT NULL,
  `bidTime` varchar(255) DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `car_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r85cin00v5lb9e2l07qnk08sh` (`car_id`),
  KEY `FK_qrjnplnap40bqger3370tnn0g` (`customer_id`),
  CONSTRAINT `FK_qrjnplnap40bqger3370tnn0g` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_r85cin00v5lb9e2l07qnk08sh` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bid
-- ----------------------------
INSERT INTO `t_bid` VALUES ('1', '31', '2016-11-16', '0', '2', '1', '1');
INSERT INTO `t_bid` VALUES ('2', '35', '2016-11-16', '0', '1', '1', '2');
INSERT INTO `t_bid` VALUES ('3', '31', '2016-11-16', '0', '0', '4', '2');
INSERT INTO `t_bid` VALUES ('4', '12', '2016-11-16', '0', '2', '10', '1');
INSERT INTO `t_bid` VALUES ('5', '13', '2016-11-16', '0', '1', '10', '4');
INSERT INTO `t_bid` VALUES ('6', '30', '2016-11-18', '0', '1', '9', '1');
INSERT INTO `t_bid` VALUES ('7', '60', '2016-11-18', '0', '0', '5', '1');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carColr` varchar(255) DEFAULT NULL,
  `carDisplacement` varchar(255) DEFAULT NULL,
  `carImage` varchar(255) DEFAULT NULL,
  `carOilConsumption` varchar(255) DEFAULT NULL,
  `carPrice` varchar(255) NOT NULL,
  `isDelete` int(11) NOT NULL,
  `car_category_id` int(11) DEFAULT NULL,
  `carName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1a6pqndequjgtklnv0bvl6mvy` (`car_category_id`),
  CONSTRAINT `FK_1a6pqndequjgtklnv0bvl6mvy` FOREIGN KEY (`car_category_id`) REFERENCES `t_car_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '白色', '2.0', '\\upload\\ad4d4f90ab0511e6d7a09d2d94da0dad3.jpg', '20', '30', '0', '1', '奥迪A3');
INSERT INTO `t_car` VALUES ('2', '黑色', '2.0', '\\upload\\0af78320ab0811e648e5023b1d002ca42.jpg', '20', '40', '0', '1', '奥迪A4');
INSERT INTO `t_car` VALUES ('3', '红色', '2.0', '\\upload\\90eb5a40ab2d11e68a169aba2893fa0772.jpg', '20', '60', '0', '1', '奥迪A6');
INSERT INTO `t_car` VALUES ('4', '白色', '2.0', '\\upload\\9610cbb0ab0811e66de6dde27590fcce5.jpg', '20', '30', '0', '3', '宝马X3');
INSERT INTO `t_car` VALUES ('5', '红色', '2.0', '\\upload\\e2881a60ab2c11e68a169aba2893fa0766.jpg', '20', '60', '0', '3', '宝马X5');
INSERT INTO `t_car` VALUES ('6', '蓝色', '2.0', '\\upload\\eb6fa770ab0811e66de6dde27590fcce7.jpg', '50', '80', '0', '3', '宝马跑车');
INSERT INTO `t_car` VALUES ('7', '白色', '2.0', '\\upload\\05471a20ab0911e66de6dde27590fcce8.jpg', '20', '20', '0', '2', '起亚K3');
INSERT INTO `t_car` VALUES ('8', '红色', '2.0', '\\upload\\f25f2050ab2c11e68a169aba2893fa0767.jpg', '20', '20', '0', '2', '起亚K3');
INSERT INTO `t_car` VALUES ('9', '银色', '2.0', '\\upload\\599b8060ab2d11e68a169aba2893fa0770.jpg', '30', '30', '0', '2', '起亚K5');
INSERT INTO `t_car` VALUES ('10', '黄色', '1.8', '\\upload\\524cc610abf111e649cc24e7d14cb6ff74.jpg', '20', '10', '0', '4', '科鲁兹');

-- ----------------------------
-- Table structure for t_car_category
-- ----------------------------
DROP TABLE IF EXISTS `t_car_category`;
CREATE TABLE `t_car_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car_category
-- ----------------------------
INSERT INTO `t_car_category` VALUES ('1', '奥迪', '0', '11');
INSERT INTO `t_car_category` VALUES ('2', '锐达起亚', '0', '12');
INSERT INTO `t_car_category` VALUES ('3', '宝马', '0', '13');
INSERT INTO `t_car_category` VALUES ('4', '雪佛兰', '0', '11');

-- ----------------------------
-- Table structure for t_car_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_car_customer`;
CREATE TABLE `t_car_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5bs6l6dy4942uyqjoe5soi8mj` (`car_id`),
  KEY `FK_1eojfjgewni7bvklrmrpjk6xl` (`customer_id`),
  CONSTRAINT `FK_1eojfjgewni7bvklrmrpjk6xl` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_5bs6l6dy4942uyqjoe5soi8mj` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car_customer
-- ----------------------------
INSERT INTO `t_car_customer` VALUES ('1', '1', '2');
INSERT INTO `t_car_customer` VALUES ('2', '10', '4');
INSERT INTO `t_car_customer` VALUES ('3', '9', '1');

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '张三', 'zs', '123', '13945678954', '0');
INSERT INTO `t_customer` VALUES ('2', '李四', 'lisi', '123', '13212345678', '0');
INSERT INTO `t_customer` VALUES ('3', '王五', 'wangwu', '123', '13612345678', '0');
INSERT INTO `t_customer` VALUES ('4', '张大', 'zhangda', '123', '13612345678', '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `car_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `bid_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2wb0k1l10ccrh5s1n6e4agmh7` (`car_id`),
  KEY `FK_h8jfaovysk9s5fln3thk5jici` (`customer_id`),
  KEY `FK_jfj4fwwlk8xv6su1ggvrragqj` (`bid_id`),
  CONSTRAINT `FK_2wb0k1l10ccrh5s1n6e4agmh7` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`),
  CONSTRAINT `FK_h8jfaovysk9s5fln3thk5jici` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_jfj4fwwlk8xv6su1ggvrragqj` FOREIGN KEY (`bid_id`) REFERENCES `t_bid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1479295458405', '2016-11-16', '0', '1', '1', '2', '2');
INSERT INTO `t_order` VALUES ('2', '1479296582994', '2016-11-16', '0', '1', '10', '4', '5');
INSERT INTO `t_order` VALUES ('3', '1479467257742', '2016-11-18', '0', '1', '9', '1', '6');
