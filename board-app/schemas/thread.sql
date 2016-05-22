DROP TABLE IF EXISTS `thread`;
CREATE TABLE `thread` (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(128) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `thread` VALUES
    (1, 'foo', 'admin', now(), now()),
    (2, 'bar', 'admin', now(), now()),
    (3, 'baz', 'admin', now(), now()),
    (4, 'qux', 'admin', now(), now()),
    (5, 'quux', 'admin', now(), now());
