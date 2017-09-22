/*
Navicat MySQL Data Transfer

Source Server         : jjp
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : experiment_room

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2017-09-22 18:31:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer` (
  `answer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT '0' COMMENT '层级  0:最高层回复  1:回答的回复',
  `question_id` int(11) DEFAULT NULL COMMENT '回答对应的问题',
  `user_id` int(11) DEFAULT NULL COMMENT '回答者',
  `answerer` varchar(20) DEFAULT NULL COMMENT '回复人',
  `answer_content` varchar(2048) DEFAULT NULL COMMENT '回答内容',
  `is_accept` tinyint(1) DEFAULT '0' COMMENT '是否被采纳',
  `answer_time` datetime DEFAULT NULL COMMENT '回答时间',
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES ('2', '0', '1', '1', '江建平', 'asdas', '1', '2017-07-31 13:34:17');
INSERT INTO `t_answer` VALUES ('3', '2', '1', '2', '陆海平', '非官方', '0', '2017-07-31 13:34:50');
INSERT INTO `t_answer` VALUES ('4', '0', '1', '1', '江建平', '<p>asd</p>', '0', '2017-08-02 13:33:26');
INSERT INTO `t_answer` VALUES ('5', '2', '1', '1', '江建平', 'nice', '0', '2017-08-02 18:35:06');

-- ----------------------------
-- Table structure for t_answer_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_answer_reply`;
CREATE TABLE `t_answer_reply` (
  `answer_reply_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `reply_content` varchar(2048) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `user_id` int(11) DEFAULT NULL COMMENT '对答案提出回复的人',
  PRIMARY KEY (`answer_reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_answer_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_learning_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_learning_resource`;
CREATE TABLE `t_learning_resource` (
  `resource_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学习资料id',
  `user_id` int(11) DEFAULT NULL COMMENT '上传资料的user_id',
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `resource_path` varchar(100) DEFAULT NULL COMMENT '资料存储路径',
  `download_count` int(11) DEFAULT NULL,
  `thumbup_count` int(11) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_learning_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `question_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '提问标题',
  `content` varchar(2048) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL COMMENT '类型',
  `user_id` int(11) DEFAULT NULL COMMENT '提问人',
  `user_name` varchar(20) DEFAULT NULL,
  `view_no` int(11) DEFAULT '0',
  `thumbup_no` int(11) DEFAULT '0',
  `answer_no` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL COMMENT '提问时间',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1', 'java是谁发明的', 'Java的开发者是James Goslin吗?', 'Java', '1', '江建平', '0', '1', '2', '2017-07-28 19:14:57');
INSERT INTO `t_question` VALUES ('4', 'Java基本数据类型', null, 'Java', '2', '陆海平', '0', '2', '0', '2017-07-30 11:36:12');

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `task_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `task_title` varchar(100) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '创建该任务的user_id',
  `description` varchar(200) DEFAULT NULL COMMENT '任务内容',
  `is_admin_create` tinyint(1) DEFAULT NULL COMMENT '该任务是否是管理员创建 0:不是 1:是',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '复习Java', '1', '看Java', '1', '2017-09-20 18:02:59');
INSERT INTO `t_task` VALUES ('2', '复习C++', '1', '刷题', '1', '2017-09-19 22:11:43');

-- ----------------------------
-- Table structure for t_task_accept
-- ----------------------------
DROP TABLE IF EXISTS `t_task_accept`;
CREATE TABLE `t_task_accept` (
  `accept_task_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL COMMENT '接收的任务id',
  `user_id` int(11) DEFAULT NULL COMMENT '接收该任务的user_id',
  `begin_time` date DEFAULT NULL COMMENT '接受任务时,规定的开始时间',
  `end_time` date DEFAULT NULL COMMENT '任务完成的截止日期',
  `is_finished` tinyint(1) DEFAULT '0' COMMENT '是否完成',
  `finished_time` date DEFAULT NULL COMMENT '完成任务时间',
  `task_file` varchar(100) DEFAULT NULL COMMENT '任务文件',
  `remark` varchar(2024) DEFAULT NULL COMMENT '感想',
  `accept_time` datetime DEFAULT NULL,
  PRIMARY KEY (`accept_task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task_accept
-- ----------------------------
INSERT INTO `t_task_accept` VALUES ('1', '1', '2', '2017-09-14', '2017-09-21', '0', '2017-09-20', null, 'asdas ', '2017-09-14 20:41:16');
INSERT INTO `t_task_accept` VALUES ('13', '1', '1', '2017-09-08', '2017-09-23', '0', null, null, null, '2017-09-20 10:00:41');
INSERT INTO `t_task_accept` VALUES ('14', '2', '1', '2017-09-07', '2017-09-23', '0', null, null, null, '2017-09-20 10:01:25');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `stu_no` varchar(12) DEFAULT NULL,
  `class_name` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT '123',
  `user_type` varchar(10) DEFAULT '' COMMENT 'ADMIN:管理员MEMBER:普通用户TEACHER:指导老师',
  `sex` char(2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `curriculum` varchar(100) DEFAULT NULL COMMENT '课程表',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '江建平', '3140407134', '计算机142', '123', 'ADMIN', '男', '17858936109', '810230010@qq.com', '', 'http://otncoonon.bkt.clouddn.com/curriculumn.png', null);
INSERT INTO `t_user` VALUES ('2', '陆海平', '3140407141', '计算机142', '123', 'ADMIN', '男', '17858929195', null, null, null, null);
INSERT INTO `t_user` VALUES ('23', '阮航建', '3130309192', '软件142', '123', 'ADMIN', '男', '17859275621', '', '', null, null);

-- ----------------------------
-- Table structure for t_user_question
-- ----------------------------
DROP TABLE IF EXISTS `t_user_question`;
CREATE TABLE `t_user_question` (
  `user_question_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_thumbup` tinyint(1) DEFAULT '0',
  `is_collected` tinyint(1) DEFAULT '0',
  `is_commented` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_question
-- ----------------------------
INSERT INTO `t_user_question` VALUES ('1', '4', '1', '1', '1', '0');
INSERT INTO `t_user_question` VALUES ('2', '4', '2', '1', '0', '0');
INSERT INTO `t_user_question` VALUES ('11', '1', '1', '1', '0', '0');
DROP TRIGGER IF EXISTS `addAnsNo`;
DELIMITER ;;
CREATE TRIGGER `addAnsNo` AFTER INSERT ON `t_answer` FOR EACH ROW update t_question set answer_no=answer_no+1 where question_id=new.question_id
;;
DELIMITER ;
