CREATE DATABASE IF NOT EXISTS `demo_user` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `demo_user`;

-- 删除已存在的表（谨慎使用）
DROP TABLE IF EXISTS `user`;
-- 创建 user 表
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
                        `username` varchar(50) NOT NULL COMMENT '用户名',
                        `password` varchar(255) NOT NULL COMMENT '密码（存储加密后的密码）',
                        `score` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `idx_username` (`username`) COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';