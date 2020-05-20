/*
Navicat MySQL Data Transfer

Source Server         : bishopxiao
Source Server Version : 50727
Source Host           : ************:3306
Source Database       : oblog

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-05-19 12:13:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oblog_db_blog
-- ----------------------------
DROP TABLE IF EXISTS `oblog_db_blog`;
CREATE TABLE `oblog_db_blog` (
  `blogId` int(10) NOT NULL AUTO_INCREMENT COMMENT '博客表ID',
  `title` varchar(32) NOT NULL DEFAULT '' COMMENT '博客标题',
  `content` text COMMENT '博客内容',
  `creatTime` varchar(32) DEFAULT '' COMMENT '博客创建时间',
  `modifyTime` varchar(32) DEFAULT '' COMMENT '博客修改时间',
  `commentNum` int(10) DEFAULT NULL COMMENT '评论数',
  `bloggerId` int(10) NOT NULL COMMENT '博主id',
  `blogType` varchar(32) DEFAULT '' COMMENT '博客类别、标签',
  PRIMARY KEY (`blogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oblog_db_blog
-- ----------------------------

-- ----------------------------
-- Table structure for oblog_db_blogger
-- ----------------------------
DROP TABLE IF EXISTS `oblog_db_blogger`;
CREATE TABLE `oblog_db_blogger` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(64) NOT NULL DEFAULT '' COMMENT '个人博客用户账号',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '账号密码',
  `nickname` varchar(32) DEFAULT '' COMMENT '博主昵称',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '博主邮箱',
  `address` varchar(64) DEFAULT '' COMMENT '博主地址',
  `signature` varchar(255) DEFAULT '' COMMENT '博主个人介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oblog_db_blogger
-- ----------------------------

-- ----------------------------
-- Table structure for oblog_db_comment
-- ----------------------------
DROP TABLE IF EXISTS `oblog_db_comment`;
CREATE TABLE `oblog_db_comment` (
  `commentId` int(10) NOT NULL AUTO_INCREMENT,
  `criticIp` varchar(32) DEFAULT '' COMMENT '评论者IP',
  `content` text COMMENT '评论内容',
  `criticTime` varchar(32) DEFAULT '' COMMENT '评论时间',
  `blogId` int(10) NOT NULL COMMENT '博客ID',
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oblog_db_comment
-- ----------------------------

-- ----------------------------
-- Table structure for oblog_db_log
-- ----------------------------
DROP TABLE IF EXISTS `oblog_db_log`;
CREATE TABLE `oblog_db_log` (
  `logId` int(10) NOT NULL AUTO_INCREMENT,
  `logTime` varchar(32) DEFAULT '' COMMENT '日志记录时间',
  `ip` varchar(16) DEFAULT '' COMMENT '使用者IP',
  `visitUrl` varchar(64) DEFAULT '' COMMENT '访问路径',
  `visitMethod` varchar(64) DEFAULT '' COMMENT '访问方法',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oblog_db_log
-- ----------------------------

-- ----------------------------
-- Table structure for oblog_db_test
-- ----------------------------
DROP TABLE IF EXISTS `oblog_db_test`;
CREATE TABLE `oblog_db_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oblog_db_test
-- ----------------------------
INSERT INTO `oblog_db_test` VALUES ('1', 'bishopxiao');
INSERT INTO `oblog_db_test` VALUES ('2', 'hj');
