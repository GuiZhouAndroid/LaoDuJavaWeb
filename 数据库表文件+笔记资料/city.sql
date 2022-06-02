/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mybatisdemo

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/06/2022 21:43:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `provinceid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '石家庄市', 1);
INSERT INTO `city` VALUES (2, '秦皇岛', 1);
INSERT INTO `city` VALUES (3, '保定市', 1);
INSERT INTO `city` VALUES (4, '张家口', 1);
INSERT INTO `city` VALUES (5, '南昌市', 9);
INSERT INTO `city` VALUES (6, '九江市', 9);
INSERT INTO `city` VALUES (7, '宜春市', 9);
INSERT INTO `city` VALUES (8, '福州市', 8);
INSERT INTO `city` VALUES (9, '厦门市', 8);
INSERT INTO `city` VALUES (10, '泉州市', 8);
INSERT INTO `city` VALUES (11, '龙岩市', 8);
INSERT INTO `city` VALUES (12, '太原', 2);
INSERT INTO `city` VALUES (13, '大同', 2);
INSERT INTO `city` VALUES (14, '呼和浩特', 3);
INSERT INTO `city` VALUES (15, '包头', 3);
INSERT INTO `city` VALUES (16, '呼伦贝尔', 3);

SET FOREIGN_KEY_CHECKS = 1;
