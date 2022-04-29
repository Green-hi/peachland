/*
 Navicat Premium Data Transfer

 Source Server         : mysql_cloud
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 47.108.176.163:3306
 Source Schema         : peach

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 29/04/2022 19:28:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `dynamic_id` int(11) NOT NULL,
  `comment_content` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_comment_did`(`dynamic_id`) USING BTREE,
  INDEX `FK_comment_uid`(`uid`) USING BTREE,
  CONSTRAINT `FK_comment_did` FOREIGN KEY (`dynamic_id`) REFERENCES `dynamic_` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_comment_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '诗词',
  `title` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `intro` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `author_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_course_uid`(`author_id`) USING BTREE,
  CONSTRAINT `FK_course_uid` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dynamic_
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_`;
CREATE TABLE `dynamic_`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `dynamic_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_count` int(11) NOT NULL DEFAULT 0,
  `love_number` int(11) NULL DEFAULT 0,
  `comment_number` int(11) NULL DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_dynamic_uid`(`uid`) USING BTREE,
  CONSTRAINT `FK_dynamic_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus`  (
  `uid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`uid`, `fid`) USING BTREE,
  INDEX `FK_focus_fid`(`fid`) USING BTREE,
  CONSTRAINT `FK_focus_fid` FOREIGN KEY (`fid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_focus_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for poetry
-- ----------------------------
DROP TABLE IF EXISTS `poetry`;
CREATE TABLE `poetry`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '无题',
  `author` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未知',
  `dynasty` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未知',
  `theme` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未知',
  `difficulty` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '简单',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `transform` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `notes` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `appreciation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `creative_background` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `author_introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `English_translation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `French_translation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Russian_translation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Japanese_translation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Korean_translation` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `occupation` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未知',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未知',
  `brief_introduction` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `love` int(11) NOT NULL DEFAULT 0,
  `funs` int(11) NOT NULL DEFAULT 0,
  `focus` int(11) NOT NULL DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
