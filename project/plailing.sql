/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : plailing

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2018-12-28 08:45:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_administrator`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_administrator`;
CREATE TABLE `tbl_administrator` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_administrator
-- ----------------------------
INSERT INTO `tbl_administrator` VALUES ('1', 'liangyaru', '123');
INSERT INTO `tbl_administrator` VALUES ('2', 'liushanshan', '123');
INSERT INTO `tbl_administrator` VALUES ('3', 'guoqiuxia', '123');

-- ----------------------------
-- Table structure for `tbl_applicationsite`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_applicationsite`;
CREATE TABLE `tbl_applicationsite` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `siteType` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `useTime` datetime DEFAULT NULL,
  `useLang` int(11) DEFAULT NULL,
  `applicationTime` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`siteId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_applicationsite
-- ----------------------------
INSERT INTO `tbl_applicationsite` VALUES ('6', '四方广场', '2018-05-06 08:00:00', '2', '2018-12-05 20:30:51', null);
INSERT INTO `tbl_applicationsite` VALUES ('7', '公教楼', '2015-08-01 10:10:00', '2', '2018-12-06 09:23:51', null);
INSERT INTO `tbl_applicationsite` VALUES ('8', '四方广场', '2018-12-01 10:10:00', '2', '2018-12-06 10:13:20', null);
INSERT INTO `tbl_applicationsite` VALUES ('9', '四方广场', '2018-12-01 10:10:02', '3', '2018-12-06 10:17:02', null);
INSERT INTO `tbl_applicationsite` VALUES ('10', '四方广场', '2018-12-07 10:10:57', '2', '2018-12-06 22:20:57', null);
INSERT INTO `tbl_applicationsite` VALUES ('11', '四方广场', '2018-12-08 10:10:57', '2', '2018-12-06 22:50:57', null);
INSERT INTO `tbl_applicationsite` VALUES ('12', '公教楼', '2018-12-10 01:01:18', '1', '2018-12-07 22:44:18', null);
INSERT INTO `tbl_applicationsite` VALUES ('13', '四方广场', '2018-12-16 01:01:08', '1', '2018-12-07 22:50:08', null);
INSERT INTO `tbl_applicationsite` VALUES ('14', '公教楼', '2018-12-16 01:01:05', '1', '2018-12-07 22:52:05', null);
INSERT INTO `tbl_applicationsite` VALUES ('15', '风雨操场', '2018-12-16 01:01:27', '1', '2018-12-07 22:55:27', null);
INSERT INTO `tbl_applicationsite` VALUES ('16', '公教楼', '2018-12-09 00:10:46', '2', '2018-12-07 22:55:46', null);
INSERT INTO `tbl_applicationsite` VALUES ('17', '风雨操场', '2018-12-09 10:10:13', '2', '2018-12-08 11:13:13', null);
INSERT INTO `tbl_applicationsite` VALUES ('18', '风雨操场', '2018-12-09 10:10:21', '2', '2018-12-08 11:13:21', null);
INSERT INTO `tbl_applicationsite` VALUES ('19', '四方广场', '2018-12-09 10:10:49', '2', '2018-12-08 11:28:49', null);
INSERT INTO `tbl_applicationsite` VALUES ('20', '四方广场', '2018-12-09 10:10:00', '2', '2018-12-08 11:31:00', null);
INSERT INTO `tbl_applicationsite` VALUES ('21', '四方广场', '2018-12-09 10:10:04', '2', '2018-12-08 11:33:04', null);
INSERT INTO `tbl_applicationsite` VALUES ('22', '四方广场', '2018-12-09 10:10:19', '2', '2018-12-08 11:34:19', null);
INSERT INTO `tbl_applicationsite` VALUES ('23', '四方广场', '2018-12-09 10:10:30', '2', '2018-12-08 11:41:30', null);
INSERT INTO `tbl_applicationsite` VALUES ('24', '四方广场', '2018-12-09 10:10:19', '2', '2018-12-08 12:37:19', null);
INSERT INTO `tbl_applicationsite` VALUES ('25', '四方广场', '2018-12-12 10:10:10', '2', '2018-12-08 12:42:10', null);
INSERT INTO `tbl_applicationsite` VALUES ('26', '四方广场', '2018-12-16 10:10:04', '3', '2018-12-08 12:43:04', null);
INSERT INTO `tbl_applicationsite` VALUES ('27', '四方广场', '2018-12-09 10:10:20', '2', '2018-12-08 12:43:20', null);
INSERT INTO `tbl_applicationsite` VALUES ('28', '风雨操场', '2018-12-08 20:00:00', '2', '2018-12-08 12:45:00', null);
INSERT INTO `tbl_applicationsite` VALUES ('29', '风雨操场', '2018-12-09 10:10:01', '2', '2018-12-08 13:03:01', null);
INSERT INTO `tbl_applicationsite` VALUES ('30', '风雨操场', '2018-12-09 10:10:08', '2', '2018-12-08 15:32:08', null);
INSERT INTO `tbl_applicationsite` VALUES ('31', '风雨操场', '2018-12-09 10:10:22', '2', '2018-12-08 18:13:22', null);
INSERT INTO `tbl_applicationsite` VALUES ('32', '风雨操场', '2018-12-09 10:10:58', '3', '2018-12-08 18:17:58', null);
INSERT INTO `tbl_applicationsite` VALUES ('33', '四方广场', '2018-12-09 10:10:24', '2', '2018-12-08 18:19:24', null);
INSERT INTO `tbl_applicationsite` VALUES ('34', '公教楼', '2018-12-21 01:01:17', '1', '2018-12-17 12:57:17', '1');
INSERT INTO `tbl_applicationsite` VALUES ('35', '四方广场', '2018-12-28 01:01:01', '1', '2018-12-17 16:11:01', '3');
INSERT INTO `tbl_applicationsite` VALUES ('36', '公教楼', '2018-12-28 01:01:18', '1', '2018-12-27 21:50:18', '2');

-- ----------------------------
-- Table structure for `tbl_auditing`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_auditing`;
CREATE TABLE `tbl_auditing` (
  `auditingId` int(11) NOT NULL AUTO_INCREMENT,
  `personalInfo` varchar(1024) DEFAULT NULL,
  `identityPic` varchar(30) DEFAULT NULL,
  `teachVideo` varchar(30) DEFAULT NULL,
  `certificate` varchar(30) DEFAULT NULL,
  `checkState` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`auditingId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_auditing
-- ----------------------------
INSERT INTO `tbl_auditing` VALUES ('1', 'q', 'img/0373f8d56fa1e0032f0.jpg', null, 'img/0373f8d56fa1e0032f1.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('2', '1', 'img/0373f8d56fa1e0032f0.jpg', null, 'img/0373f8d56fa1e0032f1.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('3', '1', 'img/0373f8d56fa1e0032f0.jpg', null, 'img/0373f8d56fa1e0032f1.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('4', '1', 'img/0373f8d56fa1e0032f0.jpg', null, 'img/0824ab18972bd407911.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('5', '1', 'img/0824ab18972bd407910.jpg', null, 'img/0824ab18972bd407911.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('6', '2', 'img/9363a691e3017630.jpg', null, 'img/9363a691e3017631.jpg', '0', null, '1');

-- ----------------------------
-- Table structure for `tbl_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `catalogId` int(11) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_comment
-- ----------------------------
INSERT INTO `tbl_comment` VALUES ('1', '手机上如何操作？', '2018-12-08 00:00:00', null, '1', '1', '0');
INSERT INTO `tbl_comment` VALUES ('2', '直接输入网址登陆', '2018-12-08 00:00:00', '1', '2', '1', '0');
INSERT INTO `tbl_comment` VALUES ('3', '这个问题怎么解决？', '2018-12-08 00:00:00', null, '3', '2', '0');
INSERT INTO `tbl_comment` VALUES ('4', 'Ctrl+C试一下', '2018-12-08 00:00:00', '3', '4', '2', '0');
INSERT INTO `tbl_comment` VALUES ('41', '1234567890[]\\', '2018-12-24 15:28:18', '40', '1', null, '40');
INSERT INTO `tbl_comment` VALUES ('42', 'qwertyui', '2018-12-24 15:32:38', null, '1', null, '0');
INSERT INTO `tbl_comment` VALUES ('43', '76565', '2018-12-24 15:41:53', null, '1', null, '0');
INSERT INTO `tbl_comment` VALUES ('44', '1111111111111111111111111111', '2018-12-24 16:28:41', null, '1', '13', '0');
INSERT INTO `tbl_comment` VALUES ('45', '222222222222222222222222222222222', '2018-12-24 16:28:51', '44', '1', '13', '44');
INSERT INTO `tbl_comment` VALUES ('46', '111111', '2018-12-24 17:22:55', null, '1', '13', '0');
INSERT INTO `tbl_comment` VALUES ('47', 'aaaaaaaaaaaaaaa', '2018-12-24 17:23:04', '46', '1', '13', '46');
INSERT INTO `tbl_comment` VALUES ('48', '1', '2018-12-26 16:21:22', '46', '1', '13', '46');
INSERT INTO `tbl_comment` VALUES ('49', '我不知道', '2018-12-27 20:31:42', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('50', '咋回事儿', '2018-12-27 20:31:55', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('51', '1', '2018-12-27 20:36:29', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('52', '1', '2018-12-27 20:36:32', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('53', '2', '2018-12-27 20:36:48', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('54', '3', '2018-12-27 20:36:54', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('55', '4', '2018-12-27 20:37:01', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('56', '1', '2018-12-27 20:38:42', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('57', '1', '2018-12-27 20:38:44', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('58', '5', '2018-12-27 20:38:58', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('59', '3', '2018-12-27 20:39:09', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('60', '3', '2018-12-27 20:39:11', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('61', '3', '2018-12-27 20:39:12', null, '1', '5', '0');
INSERT INTO `tbl_comment` VALUES ('62', '3', '2018-12-27 20:39:12', null, '1', '5', '0');

-- ----------------------------
-- Table structure for `tbl_course`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `photo` varchar(30) DEFAULT NULL,
  `price` double(30,0) DEFAULT NULL,
  `courseInfo` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `grade` double(11,2) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `joinCount` int(10) unsigned zerofill DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `demandId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_course
-- ----------------------------
INSERT INTO `tbl_course` VALUES ('1', 'web', 'img/ncn1.jpg', '99', '这是一个学习如何写网页的视频', '4', '4.50', '30', '0000000003', '1', null);
INSERT INTO `tbl_course` VALUES ('2', '计算机导论', 'img/ncn1.jpg', '199', '这是一个简单python的课程', '1', '5.00', '29', '0000000003', '1', null);
INSERT INTO `tbl_course` VALUES ('3', '计算机组成原理', 'img/ncn1.jpg', '299', '这是一个学习计算机组成的课程', '2', '4.00', '29', '0000000002', '1', null);
INSERT INTO `tbl_course` VALUES ('4', '数据结构', 'img/ncn1.jpg', '99', '这是一个学习如何写网页的视频', '2', '4.00', '29', '0000000001', '1', null);
INSERT INTO `tbl_course` VALUES ('5', '操作系统', 'img/ncn1.jpg', '399', '这是一个学习如何写网页的视频', '3', '5.00', '29', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('6', 'C语言', 'img/ncn1.jpg', '299', '这是一个学习如何写网页的视频', '3', '5.00', '30', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('7', 'JavaEE', 'img/ncn1.jpg', '199', '这是一个学习如何写网页的视频', '4', '5.00', '30', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('8', '1', 'img0373f8d56fa1e0032f2.jpg', '1111', '1', '1', '0.00', '10', '0000000000', '0', null);
INSERT INTO `tbl_course` VALUES ('9', 'q', 'img0373f8d56fa1e0032f2.jpg', '1', 'q', '1', '0.00', '23', '0000000000', '0', null);
INSERT INTO `tbl_course` VALUES ('10', 'a', 'img0373f8d56fa1e0032f2.jpg', '1111', 'a', '1', '0.00', '51', '0000000000', '0', null);
INSERT INTO `tbl_course` VALUES ('11', 's', 'img0373f8d56fa1e0032f2.jpg', '2', 's', '1', '0.00', '15', '0000000000', '0', null);
INSERT INTO `tbl_course` VALUES ('12', '2', 'img9363a691e3017632.jpg', '2', '2', '1', '0.00', '15', '0000000000', '0', null);
INSERT INTO `tbl_course` VALUES ('13', 'C语言', 'img0824ab18972bd407912.jpg', '111', '1', '1', '0.00', '30', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('14', '2', 'img9363a691e3017632.jpg', '1', '2', '1', '0.00', '15', '0000000000', '0', null);

-- ----------------------------
-- Table structure for `tbl_coursecatalog`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursecatalog`;
CREATE TABLE `tbl_coursecatalog` (
  `catalogId` int(11) NOT NULL AUTO_INCREMENT,
  `catalogName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pId` int(30) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `courseFile` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`catalogId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_coursecatalog
-- ----------------------------
INSERT INTO `tbl_coursecatalog` VALUES ('1', 'C++基础', null, '1', '');
INSERT INTO `tbl_coursecatalog` VALUES ('2', 'C++初级', null, '1', '');
INSERT INTO `tbl_coursecatalog` VALUES ('3', 'C++中级', null, '1', '');
INSERT INTO `tbl_coursecatalog` VALUES ('4', '音频', '1', '1', 'resourse/r1.mp3');
INSERT INTO `tbl_coursecatalog` VALUES ('5', '视频', '1', '1', 'resourse/v1.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('6', '音频', '2', '1', 'resourse/r2.mp3');
INSERT INTO `tbl_coursecatalog` VALUES ('7', '视频', '2', '1', 'resourse/v2.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('8', '音频', '3', '1', 'resourse/r3.mp3');
INSERT INTO `tbl_coursecatalog` VALUES ('9', '视频', '3', '1', 'resourse/v3.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('10', '1', null, '1', null);
INSERT INTO `tbl_coursecatalog` VALUES ('11', 'videos\\VID_20160913_162647.mp4', '10', '1', 'videos\\VID_20160913_162647.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('12', '111', null, '1', null);
INSERT INTO `tbl_coursecatalog` VALUES ('13', 'videos\\VID_20160913_162647.mp4', '12', '1', 'videoes\\VID_20160913_162647.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('14', 'VID_20160913_16264', '10', '1', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('15', '0373f8d56fa1e0032f', '10', '1', 'videoes\\0373f8d56fa1e0032f.jpg');
INSERT INTO `tbl_coursecatalog` VALUES ('16', 'VID_20160913_16264', '10', '1', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('19', '计算机导论章节1', null, '2', null);
INSERT INTO `tbl_coursecatalog` VALUES ('20', 'VID_20160913_16264', '19', '2', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('21', 'VID_20160913_16264', '19', '2', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('22', 'VID_20160913_16264', '10', '2', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('23', 'VID_20160913_16264', '12', '2', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('24', '2', null, '2', null);
INSERT INTO `tbl_coursecatalog` VALUES ('25', 'VID_20160913_16264', '24', '2', 'videoes\\VID_20160913_16264.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('26', '111', null, '2', null);
INSERT INTO `tbl_coursecatalog` VALUES ('27', 'VID_20160913_16264', '26', '2', 'videoes\\VID_20160913_16264.mp4');

-- ----------------------------
-- Table structure for `tbl_coursecomment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursecomment`;
CREATE TABLE `tbl_coursecomment` (
  `courseCommentId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(200) DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `courseCommentPid` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseCommentId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_coursecomment
-- ----------------------------
INSERT INTO `tbl_coursecomment` VALUES ('1', '这个课程好学吗', '2018-12-03 11:59:00', null, '2', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('2', '这个课程比较好学', '2018-12-03 17:00:00', '1', '2', '1', '1');
INSERT INTO `tbl_coursecomment` VALUES ('3', '这个课程比较适合基础人群', '2018-12-03 09:51:00', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('4', '我比较喜欢这个课程', '2018-12-03 05:00:00', null, '3', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('5', '这个课程主要学习什么语言', '2018-12-03 18:00:00', null, '4', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('6', '这个课程学习的是html', '2018-12-03 22:00:00', '5', '3', '1', '5');
INSERT INTO `tbl_coursecomment` VALUES ('7', '教授这个课程的老师比较的有趣', '2018-12-04 15:15:06', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('8', '我觉得这个课程有点难学', '2018-12-04 15:16:41', '1', '2', '1', '1');
INSERT INTO `tbl_coursecomment` VALUES ('9', '我觉得这个课程的难度适合有一点基础的人', '2018-12-04 15:17:14', '1', '3', '1', '1');
INSERT INTO `tbl_coursecomment` VALUES ('10', '如果有兴趣应该就比较好学', '2018-12-04 15:17:52', '1', '4', '1', '1');
INSERT INTO `tbl_coursecomment` VALUES ('11', '我觉的这个课程还行', '2018-12-04 15:27:39', '1', '1', '1', '1');
INSERT INTO `tbl_coursecomment` VALUES ('18', '我也觉得很有趣', '2018-12-05 09:09:32', '7', '2', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('19', '12w34567', '2018-12-17 16:09:31', null, '2', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('20', '123456', '2018-12-17 16:09:38', '19', '2', '1', '19');
INSERT INTO `tbl_coursecomment` VALUES ('21', '123456', '2018-12-19 10:06:45', '19', '1', '1', '19');
INSERT INTO `tbl_coursecomment` VALUES ('22', '12345678', '2018-12-19 10:06:58', '19', '1', '1', '19');
INSERT INTO `tbl_coursecomment` VALUES ('23', 'qwreww', '2018-12-19 15:57:20', '22', '1', '1', '19');
INSERT INTO `tbl_coursecomment` VALUES ('24', '123', '2018-12-20 08:31:25', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('25', '123', '2018-12-20 08:32:34', '23', '1', '1', '19');
INSERT INTO `tbl_coursecomment` VALUES ('26', '是的呢', '2018-12-20 09:43:45', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('27', '111', '2018-12-24 09:44:06', '26', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('28', '1', '2018-12-24 09:44:16', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('29', '1', '2018-12-24 09:44:43', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('30', '去', '2018-12-24 10:21:42', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('31', '11111111111111111111111', '2018-12-24 10:27:46', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('32', '覆盖面，他云吞面 ', '2018-12-24 10:28:04', '31', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('33', '111', '2018-12-24 15:05:13', '7', '1', '1', '7');
INSERT INTO `tbl_coursecomment` VALUES ('34', 'fdghj', '2018-12-24 18:04:37', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('35', '1', '2018-12-26 11:37:25', '34', '1', '1', '34');
INSERT INTO `tbl_coursecomment` VALUES ('36', '你真傻', '2018-12-26 16:24:20', '34', '10', '1', '34');
INSERT INTO `tbl_coursecomment` VALUES ('37', '你咋知道', '2018-12-26 16:25:09', '36', '1', '1', '34');
INSERT INTO `tbl_coursecomment` VALUES ('38', '这个课程一般', '2018-12-26 16:50:41', null, '10', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('39', '差劲', '2018-12-26 18:05:40', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('40', '差劲', '2018-12-26 18:05:57', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('41', '1', '2018-12-26 18:06:20', null, '1', '1', '0');
INSERT INTO `tbl_coursecomment` VALUES ('42', '1', '2018-12-26 18:06:27', null, '1', '1', '0');

-- ----------------------------
-- Table structure for `tbl_coursetype`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursetype`;
CREATE TABLE `tbl_coursetype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_coursetype
-- ----------------------------
INSERT INTO `tbl_coursetype` VALUES ('1', '摄影技术', null);
INSERT INTO `tbl_coursetype` VALUES ('2', '创意设计', null);
INSERT INTO `tbl_coursetype` VALUES ('3', '声乐器乐', null);
INSERT INTO `tbl_coursetype` VALUES ('4', 'IT互联网', null);
INSERT INTO `tbl_coursetype` VALUES ('5', '运动健身', null);
INSERT INTO `tbl_coursetype` VALUES ('6', '语言学习', null);
INSERT INTO `tbl_coursetype` VALUES ('7', '职场技能', null);
INSERT INTO `tbl_coursetype` VALUES ('8', '生活意趣', null);
INSERT INTO `tbl_coursetype` VALUES ('9', '公开课', null);
INSERT INTO `tbl_coursetype` VALUES ('10', '人像', '1');
INSERT INTO `tbl_coursetype` VALUES ('11', '风光', '1');
INSERT INTO `tbl_coursetype` VALUES ('12', '产品', '1');
INSERT INTO `tbl_coursetype` VALUES ('13', '后期处理', '1');
INSERT INTO `tbl_coursetype` VALUES ('14', '摄影基础', '1');
INSERT INTO `tbl_coursetype` VALUES ('15', '平面设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('16', 'UI设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('17', '影视设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('18', '动漫插画', '2');
INSERT INTO `tbl_coursetype` VALUES ('19', '分支主题', '2');
INSERT INTO `tbl_coursetype` VALUES ('20', '网页设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('21', '室内设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('22', '服装设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('23', '乐理知识', '3');
INSERT INTO `tbl_coursetype` VALUES ('24', '声乐教程', '3');
INSERT INTO `tbl_coursetype` VALUES ('25', '创作软件', '3');
INSERT INTO `tbl_coursetype` VALUES ('26', '传统民族乐器', '3');
INSERT INTO `tbl_coursetype` VALUES ('27', '西洋管弦乐', '3');
INSERT INTO `tbl_coursetype` VALUES ('28', '打击乐器', '3');
INSERT INTO `tbl_coursetype` VALUES ('29', '计算机基础', '4');
INSERT INTO `tbl_coursetype` VALUES ('30', '编程语言', '4');
INSERT INTO `tbl_coursetype` VALUES ('31', '系统运维', '4');
INSERT INTO `tbl_coursetype` VALUES ('32', '移动开发', '4');
INSERT INTO `tbl_coursetype` VALUES ('33', '互联网产品', '4');
INSERT INTO `tbl_coursetype` VALUES ('34', '其他技术', '4');
INSERT INTO `tbl_coursetype` VALUES ('35', '球类运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('36', '搏击运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('37', '减肥瘦身', '5');
INSERT INTO `tbl_coursetype` VALUES ('38', '增肌塑形', '5');
INSERT INTO `tbl_coursetype` VALUES ('39', '养生保健', '5');
INSERT INTO `tbl_coursetype` VALUES ('40', '户外运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('41', '棋类运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('42', '英语', '6');
INSERT INTO `tbl_coursetype` VALUES ('43', '法语', '6');
INSERT INTO `tbl_coursetype` VALUES ('44', '西班牙语', '6');
INSERT INTO `tbl_coursetype` VALUES ('45', '葡萄牙语', '6');
INSERT INTO `tbl_coursetype` VALUES ('46', '俄语', '6');
INSERT INTO `tbl_coursetype` VALUES ('47', '日语', '6');
INSERT INTO `tbl_coursetype` VALUES ('48', '韩语', '6');
INSERT INTO `tbl_coursetype` VALUES ('49', '汉语方言', '6');
INSERT INTO `tbl_coursetype` VALUES ('50', '其他语种', '6');
INSERT INTO `tbl_coursetype` VALUES ('51', '办公软件', '7');
INSERT INTO `tbl_coursetype` VALUES ('52', '求职', '7');
INSERT INTO `tbl_coursetype` VALUES ('53', '营销', '7');
INSERT INTO `tbl_coursetype` VALUES ('54', '人际', '7');
INSERT INTO `tbl_coursetype` VALUES ('55', '财务', '7');
INSERT INTO `tbl_coursetype` VALUES ('56', '管理', '7');
INSERT INTO `tbl_coursetype` VALUES ('57', '其他', '7');
INSERT INTO `tbl_coursetype` VALUES ('58', '烹饪', '8');
INSERT INTO `tbl_coursetype` VALUES ('59', '插画', '8');
INSERT INTO `tbl_coursetype` VALUES ('60', '折纸', '8');
INSERT INTO `tbl_coursetype` VALUES ('61', '调酒', '8');
INSERT INTO `tbl_coursetype` VALUES ('62', '品茶', '8');
INSERT INTO `tbl_coursetype` VALUES ('63', '书法', '8');
INSERT INTO `tbl_coursetype` VALUES ('64', '舞蹈', '8');
INSERT INTO `tbl_coursetype` VALUES ('65', '其他', '8');
INSERT INTO `tbl_coursetype` VALUES ('66', '文学', '9');
INSERT INTO `tbl_coursetype` VALUES ('67', '理学', '9');
INSERT INTO `tbl_coursetype` VALUES ('68', '工学', '9');
INSERT INTO `tbl_coursetype` VALUES ('69', '哲学', '9');
INSERT INTO `tbl_coursetype` VALUES ('70', '历史', '9');
INSERT INTO `tbl_coursetype` VALUES ('71', '经济', '9');
INSERT INTO `tbl_coursetype` VALUES ('72', '社会', '9');
INSERT INTO `tbl_coursetype` VALUES ('73', '心理学', '9');
INSERT INTO `tbl_coursetype` VALUES ('74', '医疗健康', '9');
INSERT INTO `tbl_coursetype` VALUES ('75', '宗教', '9');
INSERT INTO `tbl_coursetype` VALUES ('76', '法律政治', '9');
INSERT INTO `tbl_coursetype` VALUES ('77', '美术建筑', '9');

-- ----------------------------
-- Table structure for `tbl_demand`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_demand`;
CREATE TABLE `tbl_demand` (
  `demandId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `proportion` double DEFAULT NULL,
  PRIMARY KEY (`demandId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_demand
-- ----------------------------
INSERT INTO `tbl_demand` VALUES ('1', 'c语言', '2', '1.5');
INSERT INTO `tbl_demand` VALUES ('2', 'java', '3', '0.3333');
INSERT INTO `tbl_demand` VALUES ('3', 'python', '11', '0.09090909090909091');
INSERT INTO `tbl_demand` VALUES ('4', '钢琴', '16', '0.0625');
INSERT INTO `tbl_demand` VALUES ('5', '小提琴', '16', '0.0625');
INSERT INTO `tbl_demand` VALUES ('6', '大数据', '1', '0');
INSERT INTO `tbl_demand` VALUES ('7', 'c++', '1', '1');
INSERT INTO `tbl_demand` VALUES ('8', '风筝', '4', '0.25');

-- ----------------------------
-- Table structure for `tbl_follow`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_follow`;
CREATE TABLE `tbl_follow` (
  `followId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `followDate` date DEFAULT NULL,
  PRIMARY KEY (`followId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_follow
-- ----------------------------
INSERT INTO `tbl_follow` VALUES ('1', '1', '3', '0', null);
INSERT INTO `tbl_follow` VALUES ('2', '2', '4', '1', null);
INSERT INTO `tbl_follow` VALUES ('3', '1', '4', '1', null);
INSERT INTO `tbl_follow` VALUES ('4', '2', '3', '1', null);
INSERT INTO `tbl_follow` VALUES ('5', '5', '6', '1', null);
INSERT INTO `tbl_follow` VALUES ('8', '6', '5', '1', '2018-12-08');
INSERT INTO `tbl_follow` VALUES ('9', '6', '3', '1', '2018-12-08');
INSERT INTO `tbl_follow` VALUES ('10', '6', '1', '1', '2018-12-10');
INSERT INTO `tbl_follow` VALUES ('14', '2', '1', '0', '2018-12-17');
INSERT INTO `tbl_follow` VALUES ('15', '1', '6', '0', '2018-12-24');

-- ----------------------------
-- Table structure for `tbl_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
INSERT INTO `tbl_grade` VALUES ('21', '1', '1', '5');
INSERT INTO `tbl_grade` VALUES ('22', '1', '5', '4');
INSERT INTO `tbl_grade` VALUES ('23', '1', '3', '4');
INSERT INTO `tbl_grade` VALUES ('24', '1', '4', '4');
INSERT INTO `tbl_grade` VALUES ('25', '10', '1', '4');

-- ----------------------------
-- Table structure for `tbl_inform`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_inform`;
CREATE TABLE `tbl_inform` (
  `informId` int(11) NOT NULL AUTO_INCREMENT,
  `informText` varchar(1024) DEFAULT NULL,
  `informTime` date DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`informId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_inform
-- ----------------------------
INSERT INTO `tbl_inform` VALUES ('1', ' 【课程更新】《C语言》新发布了课时391、392，点击进入学习', '2018-12-11', '1', '1');
INSERT INTO `tbl_inform` VALUES ('2', ' 【课程更新】《计算机导论》新发布了课时391、392，点击进入学习', '2018-12-11', '2', '1');
INSERT INTO `tbl_inform` VALUES ('3', ' 【课程更新】《计算机组成原理》新发布了课时391、392，点击进入学习', '2018-11-10', '3', '2');
INSERT INTO `tbl_inform` VALUES ('4', ' 【审核发布】申请《C语言》**场地，已通过', '2018-12-23', '1', '0');
INSERT INTO `tbl_inform` VALUES ('5', ' 【审核发布】《JavaEE》课程发布成功', '2018-10-11', '7', '0');
INSERT INTO `tbl_inform` VALUES ('6', ' 【审核发布】《JavaSE》已发布成功', '2018-10-23', '5', '0');
INSERT INTO `tbl_inform` VALUES ('7', ' 【课程更新】《PS教程-Photoshop零基础到精通》新发布了课时391、392，点击进入学习', '2018-10-23', '6', '1');

-- ----------------------------
-- Table structure for `tbl_money`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_money`;
CREATE TABLE `tbl_money` (
  `moneyId` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(11,0) DEFAULT NULL,
  `moneyTime` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`moneyId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_money
-- ----------------------------
INSERT INTO `tbl_money` VALUES ('3', '99', '2018-12-07 15:54:11', '1', '1');
INSERT INTO `tbl_money` VALUES ('4', '99', '2018-12-07 16:12:11', '1', '1');
INSERT INTO `tbl_money` VALUES ('5', '99', '2018-12-17 14:40:59', '1', '4');
INSERT INTO `tbl_money` VALUES ('6', '399', '2018-12-24 11:05:33', '5', '3');
INSERT INTO `tbl_money` VALUES ('7', '299', '2018-12-24 11:06:51', '3', '2');
INSERT INTO `tbl_money` VALUES ('8', '299', '2018-12-24 14:35:28', '6', '3');
INSERT INTO `tbl_money` VALUES ('9', '99', '2018-12-24 15:34:51', '1', '4');
INSERT INTO `tbl_money` VALUES ('10', '199', '2018-12-24 15:35:12', '2', '1');
INSERT INTO `tbl_money` VALUES ('11', '99', '2018-12-24 15:37:35', '4', '2');
INSERT INTO `tbl_money` VALUES ('12', '299', '2018-12-24 15:45:39', '3', '2');
INSERT INTO `tbl_money` VALUES ('13', '99', '2018-12-26 10:28:28', '1', '4');
INSERT INTO `tbl_money` VALUES ('14', '99', '2018-12-26 16:48:34', '1', '4');
INSERT INTO `tbl_money` VALUES ('15', '199', '2018-12-26 16:51:07', '2', '1');
INSERT INTO `tbl_money` VALUES ('16', '99', '2018-12-26 18:05:05', '1', '4');
INSERT INTO `tbl_money` VALUES ('17', '99', '2018-12-26 18:05:50', '1', '4');
INSERT INTO `tbl_money` VALUES ('18', '99', '2018-12-26 18:06:24', '1', '4');
INSERT INTO `tbl_money` VALUES ('19', '99', '2018-12-27 20:23:40', '1', '4');
INSERT INTO `tbl_money` VALUES ('20', '199', '2018-12-27 21:16:50', '2', '1');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `nativeProvince` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `nativeCity` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `phoneNumber` char(11) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `nickName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` char(10) DEFAULT NULL,
  `identityNumber` char(18) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `tag` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `school` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `major` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `introduction` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '12345@qq.com', '1', '北京', '西城区', '12345678901', '123456', 'img/userProfilePhoto/12345@qq.com.jpg', '小333333', '1998-03-24', '', '7613', '编程', '河北师范大', '软件', '');
INSERT INTO `tbl_user` VALUES ('2', '1234567@qq.com', '1', null, '', '15354576543', '123', 'img/Linux&c.png', '小2', '1998-03-24', '1', '1000', '绘画', '河北师范大学', '美术', '我的专业是美术');
INSERT INTO `tbl_user` VALUES ('3', '123@qq.com', '0', null, '', '15357895346', '123', 'img/Linux&c.png', '小3', '1999-05-21', '1', '27', '英语、西班牙语', '河北师范大学', '外国语', '我的专业是外国语');
INSERT INTO `tbl_user` VALUES ('4', '1234@qq.com', '1', null, '', '15357803456', '123', 'img/Linux&c.png', '小4', '1998-08-12', '1', '19', '篮球、乒乓球', '河北师范大学', '体育', '我的专业是体育');
INSERT INTO `tbl_user` VALUES ('5', '1@qq.com', '0', null, '', '15357803456', '1234567', 'img/Linux&c.png', '小e6', null, '1', '0', null, null, null, '我的专业是体育');
INSERT INTO `tbl_user` VALUES ('6', '13@qq.com', '1', null, '', '15357803456', '123', 'img/Linux&c.png', '111', null, '1', '10', null, null, null, '我的专业是体育');
INSERT INTO `tbl_user` VALUES ('10', '1186373310@qq.com', null, null, null, null, '1234567', 'img/Linux&c.png', '小e7', null, null, '9702', null, null, null, '我的专业是体育');
INSERT INTO `tbl_user` VALUES ('11', '1941294473@qq.com', '1', null, '', '15226538851', '123456', 'img/Linux&c.png', '小8', '1998-02-06', '1', '40000', '编程', '河北师范大学', '软件', '我的专业是软件');

-- ----------------------------
-- Table structure for `tbl_userbalance`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userbalance`;
CREATE TABLE `tbl_userbalance` (
  `userBalanceId` int(11) NOT NULL AUTO_INCREMENT,
  `balanceTime` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `totleMoney` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `balanceState` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userBalanceId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userbalance
-- ----------------------------
INSERT INTO `tbl_userbalance` VALUES ('1', '2018-11-26 11:00:00', '30', '30', '1', '0', null);
INSERT INTO `tbl_userbalance` VALUES ('2', '2018-11-26 12:12:00', '10', '20', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('9', '2018-12-04 15:16:00', '99', '1', '2', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('12', '2018-12-07 00:00:00', '99', '27', '3', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('13', '2018-12-07 00:00:00', '99', '19', '4', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('14', '2018-12-24 00:00:00', '399', '9601', '1', '1', '5');
INSERT INTO `tbl_userbalance` VALUES ('15', '2018-12-24 00:00:00', '299', '9302', '1', '1', '3');
INSERT INTO `tbl_userbalance` VALUES ('16', '2018-12-24 00:00:00', '299', '9003', '1', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('17', '2018-12-24 00:00:00', '99', '8904', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('18', '2018-12-24 00:00:00', '199', '8705', '1', '1', '2');
INSERT INTO `tbl_userbalance` VALUES ('19', '2018-12-24 00:00:00', '99', '8606', '1', '1', '4');
INSERT INTO `tbl_userbalance` VALUES ('20', '2018-12-24 00:00:00', '299', '8307', '1', '1', '3');
INSERT INTO `tbl_userbalance` VALUES ('21', '2018-12-26 00:00:00', '99', '8208', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('22', '2018-12-26 00:00:00', '1000', '9280', '1', '0', null);
INSERT INTO `tbl_userbalance` VALUES ('23', '2018-12-26 16:48:34', '99', '9901', '10', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('24', '2018-12-26 16:51:07', '199', '9702', '10', '1', '2');
INSERT INTO `tbl_userbalance` VALUES ('25', '2018-12-26 18:05:05', '99', '8109', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('26', '2018-12-26 18:05:50', '99', '8010', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('27', '2018-12-26 18:06:24', '99', '7911', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('28', '2018-12-27 20:23:40', '99', '7812', '1', '1', '1');
INSERT INTO `tbl_userbalance` VALUES ('29', '2018-12-27 21:16:50', '199', '7613', '1', '1', '2');

-- ----------------------------
-- Table structure for `tbl_usercollectioncourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usercollectioncourse`;
CREATE TABLE `tbl_usercollectioncourse` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_usercollectioncourse
-- ----------------------------
INSERT INTO `tbl_usercollectioncourse` VALUES ('1', '1', '2', '0', '2018-12-01 10:37:38');
INSERT INTO `tbl_usercollectioncourse` VALUES ('2', '1', '1', '0', '2018-12-02 10:37:43');
INSERT INTO `tbl_usercollectioncourse` VALUES ('3', '1', '3', '0', '2018-12-03 10:37:47');
INSERT INTO `tbl_usercollectioncourse` VALUES ('4', '2', '5', '1', '2018-12-04 10:37:52');
INSERT INTO `tbl_usercollectioncourse` VALUES ('5', '2', '4', '1', '2018-12-05 10:37:57');
INSERT INTO `tbl_usercollectioncourse` VALUES ('6', '3', '2', '1', '2018-12-06 10:38:03');
INSERT INTO `tbl_usercollectioncourse` VALUES ('7', '4', '6', '1', '2018-12-07 10:38:06');
INSERT INTO `tbl_usercollectioncourse` VALUES ('12', '4', '1', '1', '2018-12-07 22:29:04');
INSERT INTO `tbl_usercollectioncourse` VALUES ('17', '2', '1', '1', '2018-12-08 13:11:02');
INSERT INTO `tbl_usercollectioncourse` VALUES ('18', '4', '3', '0', '2018-12-10 16:16:57');
INSERT INTO `tbl_usercollectioncourse` VALUES ('20', '10', '1', '1', '2018-12-26 16:49:58');

-- ----------------------------
-- Table structure for `tbl_userdemand`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userdemand`;
CREATE TABLE `tbl_userdemand` (
  `userDemandId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `demandId` int(11) DEFAULT NULL,
  `demandTime` date DEFAULT NULL,
  PRIMARY KEY (`userDemandId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userdemand
-- ----------------------------
INSERT INTO `tbl_userdemand` VALUES ('11', '1', '8', '2018-12-26');
INSERT INTO `tbl_userdemand` VALUES ('12', '1', '8', '2018-12-26');
INSERT INTO `tbl_userdemand` VALUES ('13', '1', '8', '2018-12-26');
INSERT INTO `tbl_userdemand` VALUES ('14', '1', '8', '2018-12-26');

-- ----------------------------
-- Table structure for `tbl_userjoincourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userjoincourse`;
CREATE TABLE `tbl_userjoincourse` (
  `joincourseId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  PRIMARY KEY (`joincourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userjoincourse
-- ----------------------------
INSERT INTO `tbl_userjoincourse` VALUES ('2', '2', '3', '2018-12-02');
INSERT INTO `tbl_userjoincourse` VALUES ('3', '3', '4', '2018-01-01');
INSERT INTO `tbl_userjoincourse` VALUES ('4', '4', '2', '2018-01-01');
INSERT INTO `tbl_userjoincourse` VALUES ('5', '3', '2', '2018-08-08');
INSERT INTO `tbl_userjoincourse` VALUES ('6', '2', '2', '2018-09-18');
INSERT INTO `tbl_userjoincourse` VALUES ('7', '4', '3', '2018-09-21');
INSERT INTO `tbl_userjoincourse` VALUES ('8', '3', '1', '2018-06-02');
INSERT INTO `tbl_userjoincourse` VALUES ('9', '4', '1', '2018-06-01');
INSERT INTO `tbl_userjoincourse` VALUES ('18', '10', '1', '2018-12-26');
INSERT INTO `tbl_userjoincourse` VALUES ('19', '10', '2', '2018-12-26');
INSERT INTO `tbl_userjoincourse` VALUES ('23', '1', '1', '2018-12-27');
INSERT INTO `tbl_userjoincourse` VALUES ('24', '1', '2', '2018-12-27');
