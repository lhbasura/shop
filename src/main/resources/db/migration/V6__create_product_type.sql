CREATE TABLE product_type
(
    id          INT(10) UNSIGNED                        NOT NULL AUTO_INCREMENT,
    product_id  INT(10) UNSIGNED                        NOT NULL,
    type_id  INT(10) UNSIGNED                        NOT NULL,
    created_at  TIMESTAMP                               NULL DEFAULT NULL,
    updated_at  TIMESTAMP                               NULL DEFAULT NULL,
    PRIMARY KEY (id),
    KEY product_id_foreign (product_id),
    KEY type_id_foreign (type_id),
    CONSTRAINT product_id_foreign FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE,
    CONSTRAINT type_id_foreign FOREIGN KEY (type_id) REFERENCES type (id) ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 93
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci