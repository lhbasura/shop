CREATE TABLE type
(
    id          INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
    name       VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    created_at  TIMESTAMP                               NULL DEFAULT NULL,
    updated_at  TIMESTAMP                               NULL DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 93
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci