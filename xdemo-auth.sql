CREATE DATABASE IF NOT EXISTS xdemo DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;


-- ----------------------------
-- Table structure for demo_auth_token
-- ----------------------------
DROP TABLE IF EXISTS `xdemo`.`demo_auth_token`;
CREATE TABLE `demo_auth_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `token` (`token`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4352 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for demo_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `xdemo`.`demo_auth_user`;
CREATE TABLE `demo_auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(128) NOT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `is_superuser` (`is_superuser`) USING BTREE,
  KEY `is_active` (`is_active`) USING BTREE,
  KEY `phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for demo_path_white
-- ----------------------------
DROP TABLE IF EXISTS `xdemo`.`demo_path_white`;
CREATE TABLE `demo_path_white` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(150) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4;
