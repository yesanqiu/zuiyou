/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : zuiyou

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 07/04/2020 20:19:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_price` double(14, 4) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_type_id` int(11) NULL DEFAULT NULL COMMENT '商品类型id',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '圆珠笔', 1.5000, 1);
INSERT INTO `goods` VALUES (2, '乐事薯片', 3.0000, 2);
INSERT INTO `goods` VALUES (3, '华为手机', 1.5000, 3);
INSERT INTO `goods` VALUES (4, '不锈钢脸盆', 25.0000, 4);
INSERT INTO `goods` VALUES (14, '34', 3.0000, 1);

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type`  (
  `goods_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goods_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES (1, '学习用品');
INSERT INTO `goods_type` VALUES (2, '食品');
INSERT INTO `goods_type` VALUES (3, '电子产品');
INSERT INTO `goods_type` VALUES (4, '生活用品');

SET FOREIGN_KEY_CHECKS = 1;
