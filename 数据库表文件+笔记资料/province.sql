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

 Date: 02/06/2022 21:43:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  `jiancheng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简称',
  `shenghui` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES (1, '河北', '冀', '石家庄');
INSERT INTO `province` VALUES (2, '山西', '晋', '太原市');
INSERT INTO `province` VALUES (3, '内蒙古', '蒙', '呼和浩特市	');
INSERT INTO `province` VALUES (4, '辽宁', '辽', '沈阳');
INSERT INTO `province` VALUES (5, '江苏', '苏', '南京');
INSERT INTO `province` VALUES (6, '浙江', '浙', '杭州');
INSERT INTO `province` VALUES (7, '安徽', '皖', '合肥');
INSERT INTO `province` VALUES (8, '福建', '闽', '福州');
INSERT INTO `province` VALUES (9, '江西', '赣', '南昌');

SET FOREIGN_KEY_CHECKS = 1;
