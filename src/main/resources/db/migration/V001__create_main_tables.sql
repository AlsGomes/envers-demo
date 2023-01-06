CREATE TABLE products (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    price decimal(10,2) NOT NULL DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE clients (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE orders (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT FK_CLIENT FOREIGN KEY (client_id) REFERENCES clients(id),
    CONSTRAINT FK_PRODUCT FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT UN_ID_CLIENT_PRODUCT UNIQUE(id, client_id, product_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
