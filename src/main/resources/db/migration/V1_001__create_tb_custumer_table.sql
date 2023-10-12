CREATE TABLE IF NOT EXISTS tb_customer
(
    id                 VARCHAR(36)   NOT NULL,
    name               VARCHAR(100)  NOT NULL,
    email              VARCHAR(100)  NOT NULL,
    document           VARCHAR(13)   NOT NULL,

    CONSTRAINT tb_customer_pk primary key (id)
);

ALTER TABLE tb_customer ADD CONSTRAINT unique_email_tb_customer UNIQUE (email);
ALTER TABLE tb_customer ADD CONSTRAINT unique_document_tb_customer UNIQUE (document);