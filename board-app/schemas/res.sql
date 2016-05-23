DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    thread_id BIGINT NOT NULL,
    name VARCHAR(128) NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    INDEX(thread_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `res` VALUES
    (1, 1, 'L', 'hoge', now(), now()),
    (2, 1, 'L', 'fuga', now(), now()),
    (3, 1, 'L', 'piyo', now(), now());

INSERT INTO `res` VALUES
    (4, 2, 'L', 'hoge', now(), now()),
    (5, 2, 'L', 'fuga', now(), now()),
    (6, 2, 'L', 'piyo', now(), now());

INSERT INTO `res` VALUES
    (7, 3, 'L', 'hoge', now(), now()),
    (8, 3, 'L', 'fuga', now(), now()),
    (9, 3, 'L', 'piyo', now(), now());

INSERT INTO `res` VALUES
    (10, 4, 'L', 'hoge', now(), now()),
    (11, 4, 'L', 'fuga', now(), now()),
    (12, 4, 'L', 'piyo', now(), now());
