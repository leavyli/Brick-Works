/*
Navicat MySQL Data Transfer

Source Server         : 虚拟机的docker
Source Server Version : 80030
Source Host           : 192.168.11.8:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-08-31 08:43:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
                         `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                         `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                         `note` tinytext ,
                         `status` int DEFAULT NULL,
                         `login_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                         `nick_name` varchar(50)  DEFAULT NULL,
                         `icon` varchar(255)  DEFAULT NULL,
                         `password` varchar(512) CHARACTER SET utf8mb4  NOT NULL,
                         `username` varchar(255)  NOT NULL,
                         `email` varchar(255)  DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
                            `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                            `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                            `name` varchar(255)  DEFAULT NULL,
                            `description` varchar(255)  DEFAULT NULL,
                            `category_id` bigint DEFAULT NULL,
                            `url` varchar(255)  DEFAULT NULL,
                            `admin_id` bigint unsigned NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `name` varchar(256)  DEFAULT NULL,
                        `description` varchar(256)  DEFAULT NULL,
                        `admin_count` int DEFAULT NULL,
                        `create_time` datetime DEFAULT NULL,
                        `status` int DEFAULT NULL,
                        `sort` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='role table';

-- ----------------------------
-- Table structure for role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_relation`;
CREATE TABLE `role_resource_relation` (
                                          `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                          `role_id` bigint NOT NULL,
                                          `resource_id` bigint NOT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
