DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    thread_id BIGINT NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    INDEX(thread_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `res` VALUES
    (1, 1, 'hoge', now(), now()),
    (2, 1, 'fuga', now(), now()),
    (3, 1, 'piyo', now(), now());

INSERT INTO `res` VALUES
    (4, 2, 'hoge', now(), now()),
    (5, 2, 'fuga', now(), now()),
    (6, 2, 'piyo', now(), now());

INSERT INTO `res` VALUES
    (7, 3, 'hoge', now(), now()),
    (8, 3, 'fuga', now(), now()),
    (9, 3, 'piyo', now(), now());

INSERT INTO `res` VALUES
    (10, 4, 'hoge', now(), now()),
    (11, 4, 'fuga', now(), now()),
    (12, 4, 'piyo', now(), now());
