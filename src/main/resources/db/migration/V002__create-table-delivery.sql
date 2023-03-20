CREATE TABLE deliveries (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    tax DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    order_date DATETIME NOT NULL,
    delivered_date DATETIME,

    recipient_name VARCHAR(60) NOT NULL,
    recipient_street VARCHAR(225) NOT NULL,
    recipient_number VARCHAR(30) NOT NULL,
    recipient_complement VARCHAR(60),
    recipient_neighborhood VARCHAR(30) NOT NULL
);

ALTER TABLE deliveries ADD CONSTRAINT fk_delivery_customer FOREIGN KEY (customer_id) REFERENCES customers (id);