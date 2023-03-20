CREATE TABLE occurrences (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    delivery_id BIGINT NOT NULL,
    description TEXT NOT NULL,
    register_date DATETIME NOT NULL
);

ALTER TABLE occurrences ADD CONSTRAINT fk_occurrence_delivery FOREIGN KEY (delivery_id) REFERENCES deliveries (id);