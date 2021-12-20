/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : tutor

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 18/12/2021 21:26:39
*/


SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apprise
-- ----------------------------
DROP TABLE IF EXISTS `apprise`;
CREATE TABLE `apprise`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `student_id` int(12) NULL DEFAULT NULL,
  `tutor_id` int(12) NULL DEFAULT NULL,
  `score` int(2) NULL DEFAULT NULL COMMENT '评分(1-5分)',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价信息',
  `apprise_time` datetime(0) NULL DEFAULT NULL,
  `received` tinyint(1) NULL DEFAULT 0 COMMENT '收到确认',
  `completed` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apprise
-- ----------------------------
INSERT INTO `apprise` VALUES (2, NULL, NULL, NULL, '王bynt', NULL, 0, 0);

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `role_id` int(12) NULL DEFAULT NULL,
  `menu_id` int(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college_id` int(12) NULL DEFAULT NULL COMMENT '所属学院',
  `enter_year` int(11) NULL DEFAULT NULL COMMENT '入学时间',
  `class_type` int(1) NULL DEFAULT NULL COMMENT '0:专科;1:本科;2:专升本;3:中专',
  `class_id` int(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (3, 'Java', 1, 2021, 2, NULL);
INSERT INTO `clazz` VALUES (4, 'Java', 2, 2022, 3, NULL);

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学院表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '江软');
INSERT INTO `college` VALUES (7, 'woaini');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT NULL,
  `parent` int(12) NULL DEFAULT NULL,
  `sequence` int(11) NULL DEFAULT NULL COMMENT '菜单项位置',
  `address` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `platform` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'front/behind',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', 1, NULL, 1, '', 'behind', 'fa fa-wpforms');
INSERT INTO `menu` VALUES (2, '菜单管理', 2, 1, 1, '/menu/list.html', 'behind', '');
INSERT INTO `menu` VALUES (3, '用户管理', 1, NULL, 2, '/user/list.html', 'behind', '');
INSERT INTO `menu` VALUES (4, '班级管理', 2, 3, 1, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (5, '教师管理', 2, 3, 2, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (6, '辅导员管理', 2, 3, 3, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (7, '角色管理', 2, 3, 4, NULL, '', NULL);

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `class_id` int(12) NULL DEFAULT NULL,
  `tutor_id` int(12) NULL DEFAULT NULL,
  `student_id` int(12) NULL DEFAULT NULL,
  `notification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `apprise_id` int(12) NULL DEFAULT NULL COMMENT '评价表中的信息id',
  `answerer_id` int(12) NULL DEFAULT NULL,
  `answerer_type` int(1) NULL DEFAULT NULL COMMENT 'Tutor, Student',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复信息内容',
  `received` tinyint(1) NULL DEFAULT 0,
  `completed` tinyint(1) NULL DEFAULT 0,
  `reply_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, 1, 1, 1, '222233333', 1, 0, '2021-12-09 17:44:24');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `table_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联的表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', 'teacher,student,user,tutor');
INSERT INTO `role` VALUES (2, 'tutor', 'tutor');
INSERT INTO `role` VALUES (3, 'teacher', 'teacher');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `start_year` int(11) NULL DEFAULT NULL,
  `end_year` int(11) NULL DEFAULT NULL,
  `is_first` int(11) NULL DEFAULT NULL COMMENT '是否上学期(start_year下半年)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL COMMENT '1 男；0 女',
  `tutor_id` int(12) NULL DEFAULT NULL COMMENT '学生的辅导员',
  `class_id` int(12) NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT NULL,
  `delete_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 1, '小陈', 20, 1, 1, 1, 0, '2021-12-09 17:44:24');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL COMMENT '1 男；0 女',
  `college_id` int(12) NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT '1 显示 0 已删除，提醒设计者应添加定期清除数据机制以免出现数据冗余',
  `delete_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL COMMENT '1 男；0 女',
  `teacher_id` int(12) NULL DEFAULT NULL,
  `class_id` int(12) NULL DEFAULT NULL,
  `semester_id` int(12) NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL COMMENT '接手日期',
  `end_date` date NULL DEFAULT NULL COMMENT '交接日期',
  `user_id` int(12) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES (1, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'laohutu', '123456');
INSERT INTO `user` VALUES (2, 'admin', '123456');
INSERT INTO `user` VALUES (3, 'laoxu', '123456');
INSERT INTO `user` VALUES (4, 'sadf', '545454');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) NULL DEFAULT NULL,
  `user_id` int(12) NULL DEFAULT NULL COMMENT 'role关联的用户表中的ID：如果是null，那么表示该表中所有的用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 2);
INSERT INTO `user_role` VALUES (2, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
