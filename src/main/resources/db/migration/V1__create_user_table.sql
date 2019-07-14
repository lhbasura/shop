CREATE TABLE user
(
  id                INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
  username          VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  email             VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  email_verified_at TIMESTAMP                               NULL DEFAULT NULL,
  password          VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  remember_token    VARCHAR(100) COLLATE utf8mb4_unicode_ci      DEFAULT NULL,
  created_at        TIMESTAMP                               NULL DEFAULT NULL,
  updated_at        TIMESTAMP                               NULL DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY user_name_unique (username)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci 