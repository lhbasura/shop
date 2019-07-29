CREATE TABLE sku
(
  id          INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
  title       VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  description VARCHAR(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  price       DECIMAL(10, 2)                          NOT NULL,
  stock       INT(10) UNSIGNED                        NOT NULL,
  product_id  INT(10) UNSIGNED                        NOT NULL,
  created_at  TIMESTAMP                               NULL DEFAULT NULL,
  updated_at  TIMESTAMP                               NULL DEFAULT NULL,
  PRIMARY KEY (id),
  KEY sku_product_id_foreign (product_id),
  CONSTRAINT sku_product_id_foreign FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 93
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci 