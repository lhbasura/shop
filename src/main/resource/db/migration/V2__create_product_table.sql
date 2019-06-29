CREATE TABLE product
(
    id           INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
    title        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    description  TEXT COLLATE utf8mb4_unicode_ci         NOT NULL,
    image        VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    on_sale      TINYINT(1)                              NOT NULL DEFAULT '1',
    rating       DOUBLE(8, 2)                            NOT NULL DEFAULT '5.00',
    sold_count   INT(10) UNSIGNED                        NOT NULL DEFAULT '0',
    review_count INT(10) UNSIGNED                        NOT NULL DEFAULT '0',
    price        DECIMAL(10, 2)                          NOT NULL,
    created_at   TIMESTAMP                               NULL     DEFAULT NULL,
    updated_at   TIMESTAMP                               NULL     DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci