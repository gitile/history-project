/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : desktop

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-02-19 22:31:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_account`
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) NOT NULL COMMENT '姓名',
  `username` varchar(200) NOT NULL COMMENT '用户名',
  `password` varchar(200) NOT NULL COMMENT '加密密码',
  `salt` varchar(200) NOT NULL COMMENT '加密秘钥',
  `avatar` varchar(500) DEFAULT NULL COMMENT '头像',
  `admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是管理员（0：不是，1：是）',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账号状态(1:正常,2:锁定,3:已删除)',
  `created_time` datetime NOT NULL COMMENT '账号创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('1', '涂灵峰', 'tulingfeng', '', '', null, '1', '1', '2016-02-19 14:35:01');

-- ----------------------------
-- Table structure for `user_application`
-- ----------------------------
DROP TABLE IF EXISTS `user_application`;
CREATE TABLE `user_application` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(40) NOT NULL,
  `panel` int(1) NOT NULL DEFAULT '0' COMMENT '所属桌面(10以内,0表示侧边栏)',
  `app_name` varchar(200) NOT NULL COMMENT '应用名称',
  `app_avatar` varchar(500) DEFAULT NULL COMMENT '应用图标',
  `window_url` varchar(500) DEFAULT NULL COMMENT '访问url',
  `window_status` varchar(200) NOT NULL DEFAULT 'regular' COMMENT '打开窗口时显示状态(''regular'', ''maximized'', ''minimized'' )',
  `window_width` int(11) NOT NULL DEFAULT '600' COMMENT '窗口宽度',
  `window_height` int(11) NOT NULL DEFAULT '600' COMMENT '窗口高度',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '应用排序',
  `created_time` datetime NOT NULL COMMENT '安装日期',
  PRIMARY KEY (`id`),
  KEY `user_application_ibfk_1` (`user_id`) USING BTREE,
  CONSTRAINT `user_application_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_application
-- ----------------------------
INSERT INTO `user_application` VALUES ('1', '1', '0', '百度', null, 'http://www.baidu.com', 'regular', '600', '600', '0', '2016-02-19 14:59:46');

-- ----------------------------
-- Table structure for `user_setting`
-- ----------------------------
DROP TABLE IF EXISTS `user_setting`;
CREATE TABLE `user_setting` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(40) NOT NULL COMMENT '用户编号',
  `theme` varchar(200) NOT NULL DEFAULT 'default' COMMENT '主题',
  `background` varchar(500) DEFAULT NULL COMMENT '桌面背景图片',
  `silde_bar` varchar(200) NOT NULL DEFAULT 'left' COMMENT '侧边栏摆放位置(left、right、top）',
  `panel_count` int(1) NOT NULL DEFAULT '5' COMMENT '桌面面板数量（小于10）',
  `default_panel` int(1) NOT NULL DEFAULT '1' COMMENT '默认定位面板',
  `application_limit` int(11) NOT NULL DEFAULT '50' COMMENT '应用个数限制（0表示不限制）',
  `arrange_type` int(1) NOT NULL DEFAULT '1' COMMENT '图标排列类型,1竖排,2横排',
  `icon_margin_left` int(11) NOT NULL DEFAULT '20' COMMENT '图标左边距',
  `icon_margin_top` int(11) NOT NULL DEFAULT '20' COMMENT '图标上边距',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `user_setting_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_setting
-- ----------------------------
INSERT INTO `user_setting` VALUES ('1', '1', 'default', null, 'left', '5', '1', '50', '1', '20', '20');
