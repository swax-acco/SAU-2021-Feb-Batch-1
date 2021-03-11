use orderdb;
create table products(
    id integer AUTO_INCREMENT primary key,
    product_name varchar(255),
    category_name varchar(255),
    price integer
 );

INSERT INTO products (product_name, category_name, price)
VALUES ("product1", "cat1", 100),
("product2", "cat1", 100),
("product3", "cat1", 100),
("product4", "cat2", 100),
("product5", "cat2", 100),
("product6", "cat2", 100);
