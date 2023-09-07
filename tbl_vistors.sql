/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 08/01/2023 15:16:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_vistors
-- ----------------------------
DROP TABLE IF EXISTS `tbl_vistors`;
CREATE TABLE `tbl_vistors`  (
  `vistorsname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `psw` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_vistors
-- ----------------------------
INSERT INTO `tbl_vistors` VALUES ('root', '123456');

SET FOREIGN_KEY_CHECKS = 1;
