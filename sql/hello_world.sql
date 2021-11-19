/*
 Navicat Premium Data Transfer

 Source Server         : wo
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 19/11/2021 10:08:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hello_world
-- ----------------------------
DROP TABLE IF EXISTS `hello_world`;
CREATE TABLE `hello_world`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `say_hello` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `your_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(2) NULL DEFAULT 0 COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '简单演示表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hello_world
-- ----------------------------
INSERT INTO `hello_world` VALUES (1, '2', '2', '2021-11-15 11:22:46', '2021-11-16 11:22:43', 2);

SET FOREIGN_KEY_CHECKS = 1;
