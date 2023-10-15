CREATE TABLE IF NOT EXISTS tb_product
(
    id                 VARCHAR(36)    NOT NULL,
    name               VARCHAR(100)   NOT NULL,
    category           VARCHAR(40)    NOT NULL,
    description        VARCHAR(250)   NOT NULL,
    images             VARCHAR(250)   NOT NULL,
    amount             DECIMAL(10, 2) NOT NULL,
    create_date        TIMESTAMP      NOT NULL,
    last_modified_date TIMESTAMP      NOT NULL,

    CONSTRAINT tb_product_pk primary key (id)
);

CREATE INDEX idx_category ON tb_product (category);