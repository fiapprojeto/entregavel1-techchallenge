CREATE TABLE IF NOT EXISTS tb_order
(
    id                 VARCHAR(36)    NOT NULL,
    status             VARCHAR(40)    NOT NULL,
    progress           VARCHAR(40)    NOT NULL,
    total              DECIMAL(10, 2) NOT NULL,
    customer_id        VARCHAR(36)    NULL,
    create_date        TIMESTAMP      NOT NULL,
    last_modified_date TIMESTAMP      NOT NULL,

    CONSTRAINT tb_order_pk primary key (id)
);

CREATE TABLE IF NOT EXISTS tb_order_item (
    id                 VARCHAR(36)    NOT NULL,
    order_id           VARCHAR(36),
    product_id         VARCHAR(36),
    amount             DECIMAL(10, 2) NOT NULL,
    quantity           INT            NOT NULL,
    create_date        TIMESTAMP      NOT NULL,
    last_modified_date TIMESTAMP      NOT NULL,

    CONSTRAINT tb_order_item_pk primary key (id),
    FOREIGN KEY (order_id) REFERENCES tb_order(id),
    FOREIGN KEY (product_id) REFERENCES tb_product(id)
);