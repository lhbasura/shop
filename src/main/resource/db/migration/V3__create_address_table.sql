CREATE TABLE address
(
    id            INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
    user_id       INT(10) UNSIGNED                        NOT NULL,
    province      VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    city          VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    district      VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    address       VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    zip           INT(10) UNSIGNED                        NOT NULL,
    contact_name  VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    contact_phone VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    last_used_at  DATETIME                                     DEFAULT NULL,
    created_at    TIMESTAMP                               NULL DEFAULT NULL,
    updated_at    TIMESTAMP                               NULL DEFAULT NULL,
    PRIMARY KEY (id),
    KEY addresses_user_id_foreign (user_id),
    CONSTRAINT addresses_user_id_foreign FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci