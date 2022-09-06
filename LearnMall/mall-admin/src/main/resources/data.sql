/*
Navicat MySQL Data Transfer

Source Server         : 虚拟机的docker
Source Server Version : 80029
Source Host           : 192.168.11.8:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-09-06 11:47:16
*/

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('20', null, null, null, null, null, null, 'ddd', 's2', '1233@gg.com');
INSERT INTO `admin` VALUES ('22', '2022-09-01 01:12:05', 'this is a note', '1', '2022-09-01 09:12:05', 'sillytest', 'http://localhost:8080/icon/test.png', '$2a$10$JijLCAB79j0Y/mOWnzz0jeRIBLI72oevrBohKsb25PbeC0yNLeRvS', 'fuxyifuck', '1233@gg.com');
INSERT INTO `admin` VALUES ('23', null, 'this is a note', '1', null, 'sillytest', 'http://localhost:8080/icon/test.png', '$2a$10$BYSLDI8.R6HO247VC2L.Ee/baqUsp8wtBYDzGqWxScGUwlaYX2rt6', 'fuxyifuck2', '1233@gg.com');
INSERT INTO `admin` VALUES ('24', null, 'this is a note', '1', null, 'sillytest', 'http://localhost:8080/icon/test.png', '$2a$10$./4lJeZ2Bj4Cq8/ak2a1suDfXJj4Xc1oBe5ctdX3lha8TxD3.8Mf.', 'fuxyifuck12', '1233@gg.com');
INSERT INTO `admin` VALUES ('27', '2022-09-01 09:37:13', 'this is a note', '1', null, 'sillytest', 'http://localhost:8080/icon/test.png', '$2a$10$VHoyFrafNGn2ZmFBLtCa9.M55l1ikHn0PTSY97llAJMRJ9Ulcgyau', 'zshdeye7', '1233@gg.com');
INSERT INTO `admin` VALUES ('28', '2022-09-06 03:26:46', 'this is a note', '1', '2022-09-06 11:26:46', 'sillytest', 'http://localhost:8080/icon/test.png', '$2a$10$4SEwsQjWmeUs/71oT5UUue2lZpNPnL7SiZ7uXrpIaydttd7GKAfFW', 'simi', '1233@gg.com');

-- ----------------------------
-- Records of admin_role_relation
-- ----------------------------
INSERT INTO `admin_role_relation` VALUES ('18', '20', '1');
INSERT INTO `admin_role_relation` VALUES ('19', '20', '2');
INSERT INTO `admin_role_relation` VALUES ('20', '20', '1');
INSERT INTO `admin_role_relation` VALUES ('21', '20', '2');
INSERT INTO `admin_role_relation` VALUES ('22', '20', '1');
INSERT INTO `admin_role_relation` VALUES ('23', '20', '2');
INSERT INTO `admin_role_relation` VALUES ('24', '28', '1');
INSERT INTO `admin_role_relation` VALUES ('25', '28', '2');
INSERT INTO `admin_role_relation` VALUES ('26', '28', '6');


-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('21', '2022-08-30 04:51:24', 'ROLE_ADMIN', '222', '2', '/hello', '22');
INSERT INTO `resource` VALUES ('22', '2022-09-05 10:45:30', 'ROLE_TEST', '222', '2', '/test/**', '22');


-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'role_test', 'admin', null, '2022-09-01 10:21:35', '1', null);
INSERT INTO `role` VALUES ('2', 'role_test2', '测试人员', null, null, '1', null);
INSERT INTO `role` VALUES ('6', 'role_test007a', '测试人员🐉', null, null, '0', null);

-- ----------------------------
-- Records of role_resource_relation
-- ----------------------------
INSERT INTO `role_resource_relation` VALUES ('1', '1', '21');
INSERT INTO `role_resource_relation` VALUES ('2', '28', '21');
INSERT INTO `role_resource_relation` VALUES ('4', '28', '22');
