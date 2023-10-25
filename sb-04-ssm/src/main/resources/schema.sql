DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `pid` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `content` text NOT NULL,
  `status` tinyint unsigned NOT NULL DEFAULT '1',
  `user_id` int unsigned NOT NULL,
  `view` int unsigned NOT NULL DEFAULT '0',
  `publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
);